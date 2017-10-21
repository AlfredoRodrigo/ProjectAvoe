package Classes;

import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Cadastrados implements Serializable {
    private int usuariosCadastrados = 0;
    private int locaisCadastrados = 0;
    private int dronesCadastrados = 0;
    private int qtdAdm = 0;
    private int qtdEntregas = 0;
    
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Local> locais = new ArrayList<Local>();
    private List<Drone> drones = new ArrayList<Drone>();
    private List<Encomenda> encomendasNormais = new ArrayList<Encomenda>();
    private List<Encomenda> encomendasPrioritarias = new ArrayList<Encomenda>();
    private List<Encomenda> encomendasEmTransito = new ArrayList<Encomenda>();
    private String lastDate = "0";
    
    public int getQtdAdm() {
        return qtdAdm;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    void administradorPadrao() {
        if (qtdAdm == 0) {
            Usuario administrador = new Usuario();
            administrador.setAdministrador(true);
            administrador.setNome("admin");
            administrador.setLogin("admin");
            administrador.setSenha("admin");
            usuarios.add(administrador);
            qtdAdm++;
        }
    }

    public void cadastrarUsuario(String nome, String login, String senha, boolean adm) {
        /*
        Adiciona um novo usuario ao sistema, adicionando-o ao array de usuarios no índice encontrado
        pela função achaIndice.
         */
        Usuario usuario = new Usuario();
        usuario.setAdministrador(adm);
        if (adm) {
            qtdAdm++;
        }
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuarios.add(usuario);
        usuariosCadastrados++;
    }

    public boolean removerUsuario(String nome) {
        /*
        Remove o usuario se o dado sobre o login corresponder com o parametro passado. A função percorre todos
        os usuarios do array usuarios. Se encontrar um cujo o login seja correspondente, ela atribui null à posição,
        caso contrário, não faz nada.
        Return: true caso tenha dado certo e false caso tenha dado errado.
         */
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNome().equals(nome)) {
                if (usuarios.get(i).isAdministrador()) {
                    qtdAdm--;
                }
                usuarios.remove(i);
                usuariosCadastrados--;
                administradorPadrao();
                return true;
            }
        }
        return false;
    }

    public void editarUsuario(Usuario usuario, String nome, String login, String senha, boolean admin) {
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setAdministrador(admin);
    }
    
    public void cadastrarImovel(String proprietario, String rua, int numero, long latitude, long longitude) {
        /*
        Adiciona um novo local ao sistema, adicionando-o ao array de locais no índice encontrado
        pela função achaIndice.
         */
        Local local = new Local();
        local.setProprietario(proprietario);
        local.setRua(rua);
        local.setNumero(numero);
        local.setLatitude(latitude);
        local.setLongitude(longitude);
        locais.add(local);
        locaisCadastrados++;
    }

    public boolean removerImovel(String rua, int numero, String proprietario) {
        /*
        Remove o local se os dados sobre rua, numero e proprietario corresponderem com os parametros passados.
        A função percorre todos os locais do array locais. Se encontrar um cuja a rua seja correspondente, ela
        verifica se o numero é correspondente. Se for, ela verifica se o proprietário é correspontende. Se for,
        ela atribui null à posição, caso contrário, não faz nada.
        Return: true caso tenha dado certo e false caso tenha dado errado.
         */
        for (int i = 0; i < locais.size(); i++) {
            if (locais.get(i).getRua().equals(rua)) {
                if (locais.get(i).getNumero() == numero) {
                    if (locais.get(i).getProprietario().equals(proprietario)) {
                        locais.remove(i);
                        locaisCadastrados--;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Local procuraImovel(String rua, int num) {
        for (int i = 0; i < locais.size(); i++) {
            if (locais.get(i).getRua().equalsIgnoreCase(rua) && locais.get(i).getNumero() == num) {
                return locais.get(i);
            }
        }
        return null;
    }
    
    public void removerDrone(String ID) {
        for (int i = 0; i < drones.size(); i++) {
            if (drones.get(i).getID().equals(ID)) {
                drones.remove(i);
                dronesCadastrados--;
            }
        }
    }
    
    public void editarImovel(Local casa, long latitude, long longitude, int numero, String proprietario, String rua) {
        casa.setLatitude(latitude);
        casa.setLongitude(longitude);
        casa.setNumero(numero);
        casa.setProprietario(proprietario);
        casa.setRua(rua);
    }
    
    public Usuario autentica(String login, String senha) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getLogin().equals(login)) {
                if (usuarios.get(i).getSenha().equals(senha)) {
                    return usuarios.get(i);
                }
            }
        }
        return null;
    }
    
    public String createCode(){
        if (SalvarEmArquivo.createDate().equals(lastDate)){
            qtdEntregas++;
            java.util.Date data = new Date();
            String nomedata = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(data);
            String code = "" + nomedata.charAt(0) + nomedata.charAt(1) + nomedata.charAt(3) + nomedata.charAt(4) + nomedata.charAt(8) + nomedata.charAt(9) + '-' + qtdEntregas;
            return(code);
        }
        else {
            qtdEntregas = 1;
            lastDate = SalvarEmArquivo.createDate();
            java.util.Date data = new Date();
            String nomedata = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(data);
            String code = "" + nomedata.charAt(0) + nomedata.charAt(1) + nomedata.charAt(3) + nomedata.charAt(4) + nomedata.charAt(8) + nomedata.charAt(9) + '-' + qtdEntregas;
            return(code);
        }
    }
    
    public void cadastraEncomenda(double peso, boolean prioridade, boolean categoria, Local destinatario, String data, String hora) {
        
        Encomenda encomenda = new Encomenda();
        encomenda.setCodigo(createCode());
        encomenda.setPeso(peso);
        encomenda.setPrioridade(prioridade);
        encomenda.setCategoria(categoria);
        encomenda.setDestinatario(destinatario);
        encomenda.setData(data);
        encomenda.setHora(hora);
        
        if (prioridade) {
            this.encomendasPrioritarias.add(encomenda);
        }
        else {
            this.encomendasNormais.add(encomenda);
        }
    }

    public void editarEncomenda(Encomenda encomenda, boolean prioridade, boolean categoria, double peso, Local destinatario) {
        encomenda.setPrioridade(prioridade);
        encomenda.setCategoria(categoria);
        encomenda.setPeso(peso);
        encomenda.setDestinatario(destinatario);
    }
    
    public List<Encomenda> getEncomendasNormais() {
        return encomendasNormais;
    }

    public List<Encomenda> getEncomendasPrioritarias() {
        return encomendasPrioritarias;
    }

    public List<Encomenda> getEncomendasEmTransito() {
        return encomendasEmTransito;
    }
    
    public void cadastrarDrone(boolean categoria, String marca, String modelo, String ID, double capCarga, double velocidade) {
        Drone drone = new Drone();
        drone.setCategoria(categoria);
        drone.setMarca(marca);
        drone.setModelo(modelo);
        drone.setID(ID);
        drone.setCapCarga(capCarga);
        drone.setVelocidade(velocidade);
        drone.escolherPacote(encomendasNormais, encomendasPrioritarias, encomendasEmTransito);
        drones.add(drone);
        dronesCadastrados++;
        
        Runnable runnable = drone;
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public int getUsuariosCadastrados() {
        return usuariosCadastrados;
    }

    public int getLocaisCadastrados() {
        return locaisCadastrados;
    }

    public int getDronesCadastrados() {
        return dronesCadastrados;
    }

    public List<Local> getLocais() {
        return locais;
    }

    public List<Drone> getDrones() {
        return drones;
    }
    
    
    
    public void finalizarEntrega(Drone drone, Usuario logado) throws IOException {
        SalvarEmArquivo salvar = new SalvarEmArquivo();
        if(drone.getPacoteAtual() == null) {
            return;
        }
        salvar.save(drone.getPacoteAtual(), logado);
        drone.setDisponibilidade(true);
        drone.setPacoteAtual(null);
        Runnable runnable = drone;
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
