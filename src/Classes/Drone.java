package Classes;

import java.io.*;

public class Drone implements Serializable {
    private boolean disponibilidade = true;
    private boolean bateriaCritica = false;
    private boolean categoria = false;
    private String marca;
    private String modelo;
    private String ID;
    private double capCarga;
    private double velocidade;
    private double durabilidadeBat = 100;
    private Encomenda pacoteAtual;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public boolean isBateriaCritica() {
        return bateriaCritica;
    }

    public void setBateriaCritica(boolean bateriaCritica) {
        this.bateriaCritica = bateriaCritica;
    }
    
    public Encomenda getPacoteAtual() {
        return pacoteAtual;
    }

    public void setPacoteAtual(Encomenda pacoteAtual) {
        this.pacoteAtual = pacoteAtual;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCapCarga() {
        return capCarga;
    }

    public void setCapCarga(double capCarga) {
        this.capCarga = capCarga;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getDurabilidadeBat() {
        return durabilidadeBat;
    }

    public void setDurabilidadeBat(double durabilidadeBat) {
        this.durabilidadeBat = durabilidadeBat;
    }

    public boolean isCategoria() {
        return categoria;
    }

    public void setCategoria(boolean categoria) {
        this.categoria = categoria;
    }

    public void escolherPacote(ListaDinamica.Lista lstN, ListaDinamica.Lista lstP, ListaDinamica.Lista lstT){
        if (this.disponibilidade) {
            if (!lstP.isEmpty()) {
                ListaDinamica.No tempNo = lstP.retornaEncomenda();
                for (int x = 0; x < lstP.getTotalNos(); x++) {
                    if (isApto(tempNo.encomenda)) {
                        disponibilidade = false;
                        setPacoteAtual(tempNo.encomenda);
                        lstT.inserirNoInicio(pacoteAtual);
                        lstP.excluirNo(pacoteAtual.getCodigo());
                        break;
                    } else {
                        tempNo = tempNo.prox;
                    }
                }
            } 
            if (!lstN.isEmpty() && this.disponibilidade) {
                ListaDinamica.No tempNo = lstN.retornaEncomenda();
                for (int x = 0; x < lstN.getTotalNos(); x++) {
                    if (isApto(tempNo.encomenda)) {
                        disponibilidade = false;
                        setPacoteAtual(tempNo.encomenda);
                        lstT.inserirNoInicio(pacoteAtual);
                        lstN.excluirNo(pacoteAtual.getCodigo());
                        break;
                    } else {
                        tempNo = tempNo.prox;
                    }
                }
            } else {
                System.err.println("Sem encomendas");
            }
        }
    }
    
    public boolean isApto(Encomenda encomenda) {
        if ((this.capCarga >= encomenda.getPeso()) && (this.categoria ^! encomenda.isCategoria())) {
            return true;
        }
        return false;
    }

    public double calcularDistancia(double lat1, double lgtd1, double lat2, double lgtd2){
        int raioTerrestreKm = 6371;
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        
        double deltaLgtdRad = Math.toRadians(lgtd2 - lgtd1);
       
        return (Math.acos(Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                Math.cos(deltaLgtdRad) + Math.sin(lat1Rad) * 
                        Math.sin(lat2Rad)) * raioTerrestreKm);
        
    }
}
