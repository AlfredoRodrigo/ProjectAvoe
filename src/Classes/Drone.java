package Classes;

public class Drone {
    private boolean disponibilidade;
    private String marca;
    private String modelo;
    private double capCarga;
    private double velocidade;
    private double durabilidadeBat;
    private Encomenda cargaAtual;

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Encomenda getCargaAtual() {
        return cargaAtual;
    }

    public void setCargaAtual(Encomenda cargaAtual) {
        this.cargaAtual = cargaAtual;
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

    public void escolherPacote(){
        /*
        Percorrer a lista procurando a próxima entrega da mesma em que this.Drone seja capaz de levar superando os requisitos mínimos
        quando encontrada passar para a variável 'cargaAtual' para que ele procure o caminho a ser entregue.
         */


    }

    public void calcularRota(long Latitude, long Longitude){
        /*
        Usar a Latitude e Longitude do sistema para gerar uma rota de entrega
        --- A entrega ainda está a ser definida ---
         */
    }
}
