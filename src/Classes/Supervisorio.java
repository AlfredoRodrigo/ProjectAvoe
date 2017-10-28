/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alf_r - extraído do professor André Curvello: https://www.youtube.com/channel/UCH-yNyoZficULIjce_2OzvA
 */
public class Supervisorio implements Runnable {
    Cadastrados cadastro;
    Usuario logado;

    public Supervisorio(Cadastrados cadastro, Usuario logado) {
        this.cadastro = cadastro;
        this.logado = logado;
    }
    public void run() {
        SerialRxTx serial = new SerialRxTx();
        if (serial.iniciaSerial()) {
            while (true) {
                for (int i = 0; i < cadastro.getEncomendasEmTransito().size(); i++) {
                    for (int j = 0; j < cadastro.getLocais().size(); j++) {
                        if (serial.getProtocolo().getCasa1() != null) {
                            if (serial.getProtocolo().getCasa((j + 1)).equals(String.valueOf((j + 1))) &&
                                    cadastro.getEncomendasEmTransito().get(i).getDestinatario() == cadastro.getLocais().get(j)) {
                                JOptionPane.showMessageDialog(null, ("ENTROU NO IF: J+1 = " + (j + 1)));
                                try {
                                    cadastro.finalizarEntrega(cadastro.getEncomendasEmTransito().get(i).getDrone(), logado);
                                } catch (IOException ex) {
                                    Logger.getLogger(Supervisorio.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            
        }
    }
    
}
