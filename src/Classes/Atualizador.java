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
    
    public Atualizador(Cadastrados cadastro, Usuario logado) {
        this.cadastro = cadastro;
        this.logado = logado;
        Supervisorio serial = new Supervisorio(this.cadastro, this.logado);
        this.serial = serial;
    }
    public void run() {
        while(true) {
            serial.Serial();
            for(int i = 0; i < cadastro.getDrones().size(); i++) {
                cadastro.getDrones().get(i).procuraEncomenda();
            }
                
        }
    }
}
