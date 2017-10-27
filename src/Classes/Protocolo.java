/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author alf_r - extraído do professor André Curvello: https://www.youtube.com/channel/UCH-yNyoZficULIjce_2OzvA
 */
public class Protocolo {
    private String casa1; //toda informação que o Arduino pode mandar e receber pode ficar aqui
    private String casa2;
    private String casa3;
    private String casa4;
    private String casa5;
    private String casa6;
    private String casa7;
    private String casa8;

    private String leituraComando;
    
    private void interpretaComando() {
        //separa a string de comando em substrings delimitadas por um caractere específico
        //$STS,40,70,180,380,1,0,2023
        String aux[] = leituraComando.split(",");
        
        if (aux.length == 8) {
            casa1 = aux[0];
            casa2 = aux[1];
            casa3 = aux[2];
            casa4 = aux[3];
            casa5 = aux[4];
            casa6 = aux[5];
            casa7 = aux[6];
            casa8 = aux[7];
        }
    }

    public String getCasa1() {
        return casa1;
    }

    public void setCasa1(String casa1) {
        this.casa1 = casa1;
    }

    public String getCasa2() {
        return casa2;
    }

    public void setCasa2(String casa2) {
        this.casa2 = casa2;
    }

    public String getCasa3() {
        return casa3;
    }

    public void setCasa3(String casa3) {
        this.casa3 = casa3;
    }

    public String getCasa4() {
        return casa4;
    }

    public void setCasa4(String casa4) {
        this.casa4 = casa4;
    }

    public String getCasa5() {
        return casa5;
    }

    public void setCasa5(String casa5) {
        this.casa5 = casa5;
    }

    public String getCasa6() {
        return casa6;
    }

    public void setCasa6(String casa6) {
        this.casa6 = casa6;
    }

    public String getCasa7() {
        return casa7;
    }

    public void setCasa7(String casa7) {
        this.casa7 = casa7;
    }

    public String getCasa8() {
        return casa8;
    }

    public void setCasa8(String casa8) {
        this.casa8 = casa8;
    }
    
    

    public String getLeituraComando() {
        return leituraComando;
    }

    public void setLeituraComando(String leituraComando) {
        this.leituraComando = leituraComando; //temos a string de dados
        this.interpretaComando(); //interpretamos a string
    }
    
}
