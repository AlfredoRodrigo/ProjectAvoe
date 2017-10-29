/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author guisi
 */
public class Atualizador implements Runnable{
    Cadastrados cadastro;
    Usuario logado;
    Supervisorio serial;
    boolean bool;
    
    public Atualizador(Cadastrados cadastro, Usuario logado, boolean bool) {
        this.cadastro = cadastro;
        this.logado = logado;
        this.bool = bool;
        Supervisorio serial = new Supervisorio(this.cadastro, this.logado);
        if (bool) {
            serial.iniciaSerial();
        } else {
            serial.encerraSerial();
        }
        this.serial = serial;
    }
    public void run() {
        while(true) {
            serial.Serial(bool);
            for(int i = 0; i < cadastro.getDrones().size(); i++) {
                cadastro.getDrones().get(i).procuraEncomenda();
            }
                
        }
    }
    
    public void encerraSerial() {
        this.serial.encerraSerial();
    }
}
