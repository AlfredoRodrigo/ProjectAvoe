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
public class Supervisorio {
    Cadastrados cadastro;
    Usuario logado;
    SerialRxTx serial;
    boolean iniciouSerial;

    public Supervisorio(Cadastrados cadastro, Usuario logado) {
        this.cadastro = cadastro;
        this.logado = logado;
    }
    public void iniciaSerial() {
        this.serial = new SerialRxTx();
        this.iniciouSerial = this.serial.iniciaSerial();
    }
    
    
    public void Serial(boolean bool) {
        SerialRxTx serial = new SerialRxTx();
        if (bool) {
            if (iniciouSerial) {
                for (int i = 0; i < cadastro.getEncomendasEmTransito().size(); i++) {
                    for (int j = 0; j < cadastro.getLocais().size(); j++) {
                        if (serial.getProtocolo().getCasa1() != null) {
                            if (serial.getProtocolo().getCasa((j + 1)).equals(String.valueOf((j + 1))) && cadastro.getEncomendasEmTransito().get(i).getDestinatario() == cadastro.getLocais().get(j)) {
                                serial.getProtocolo().setCasa(j + 1);
                                try {
                                    cadastro.finalizarEntrega(cadastro.getEncomendasEmTransito().get(i).getDrone(), logado);
                                    JOptionPane.showMessageDialog(null, ("Encomenda entregue com sucesso!"));
                                } catch (IOException ex) {
                                    Logger.getLogger(Supervisorio.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            serial.close();
        }
    }
}
