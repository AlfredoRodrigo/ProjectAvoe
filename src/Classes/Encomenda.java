package Classes;

import java.io.*;

public class Encomenda implements Serializable {
    private boolean prioridade;
    private boolean categoria;
    private String codigo;
    private double peso;
    private Casa destinatario;

    public Casa getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Casa destinatario) {
        this.destinatario = destinatario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isCategoria() {
        return categoria;
    }

    public void setCategoria(boolean categoria) {
        this.categoria = categoria;
    }
}
