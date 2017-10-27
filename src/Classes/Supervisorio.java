/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                for (int i = 0; i <= cadastro.getEncomendasEmTransito().size(); i++) {
                    if (serial.getProtocolo().getCasa1().equals("1") && cadastro.getEncomendasEmTransito().get(i).getDestinatario() == cadastro.getLocais().get(0)) {
                        try {
                            cadastro.finalizarEntrega(cadastro.getEncomendasEmTransito().get(i).getDrone(), logado);
                        } catch (IOException ex) {
                            Logger.getLogger(Supervisorio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (serial.getProtocolo().getCasa2().equals("2") && cadastro.getEncomendasEmTransito().get(i).getDestinatario() == cadastro.getLocais().get(1)) {
                        try {
                            cadastro.finalizarEntrega(cadastro.getEncomendasEmTransito().get(i).getDrone(), logado);
                        } catch (IOException ex) {
                            Logger.getLogger(Supervisorio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (serial.getProtocolo().getCasa3().equals("3") && cadastro.getEncomendasEmTransito().get(i).getDestinatario() == cadastro.getLocais().get(2)) {
                        try {
                            cadastro.finalizarEntrega(cadastro.getEncomendasEmTransito().get(i).getDrone(), logado);
                        } catch (IOException ex) {
                            Logger.getLogger(Supervisorio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (serial.getProtocolo().getCasa4().equals("4") && cadastro.getEncomendasEmTransito().get(i).getDestinatario() == cadastro.getLocais().get(3)) {
                        try {
                            cadastro.finalizarEntrega(cadastro.getEncomendasEmTransito().get(i).getDrone(), logado);
                        } catch (IOException ex) {
                            Logger.getLogger(Supervisorio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (serial.getProtocolo().getCasa5().equals("5") && cadastro.getEncomendasEmTransito().get(i).getDestinatario() == cadastro.getLocais().get(4)) {
                        try {
                            cadastro.finalizarEntrega(cadastro.getEncomendasEmTransito().get(i).getDrone(), logado);
                        } catch (IOException ex) {
                            Logger.getLogger(Supervisorio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (serial.getProtocolo().getCasa6().equals("6") && cadastro.getEncomendasEmTransito().get(i).getDestinatario() == cadastro.getLocais().get(5)) {
                        try {
                            cadastro.finalizarEntrega(cadastro.getEncomendasEmTransito().get(i).getDrone(), logado);
                        } catch (IOException ex) {
                            Logger.getLogger(Supervisorio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (serial.getProtocolo().getCasa7().equals("7") && cadastro.getEncomendasEmTransito().get(i).getDestinatario() == cadastro.getLocais().get(6)) {
                        try {
                            cadastro.finalizarEntrega(cadastro.getEncomendasEmTransito().get(i).getDrone(), logado);
                        } catch (IOException ex) {
                            Logger.getLogger(Supervisorio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (serial.getProtocolo().getCasa8().equals("8") && cadastro.getEncomendasEmTransito().get(i).getDestinatario() == cadastro.getLocais().get(7)) {
                        try {
                            cadastro.finalizarEntrega(cadastro.getEncomendasEmTransito().get(i).getDrone(), logado);
                        } catch (IOException ex) {
                            Logger.getLogger(Supervisorio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        } else {
            
        }
    }
    
}
