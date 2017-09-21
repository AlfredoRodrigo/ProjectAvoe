package Classes;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;

public class Cadastrados implements Serializable {
    private int usuariosCadastrados = 0;
    private int imoveisCadastrados = 0;
    private int dronesCadastrados = 0;
    private int qtdAdm = 0;
    
    private Usuario[] usuarios = new Usuario[20];
    private Casa[] imoveis = new Casa[5000];
    private Drone[] drones = new Drone[100];
    private ListaDinamica.Lista encomendasNormais = new ListaDinamica.Lista();
    private ListaDinamica.Lista encomendasPrioritarias = new ListaDinamica.Lista();
    private ListaDinamica.Lista encomendasEmTransito = new ListaDinamica.Lista();
    
    public int getQtdAdm() {
        return qtdAdm;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }
    
    void administradorPadrao() {
        Usuario administrador = new Usuario();
        administrador.setAdministrador(true);
        administrador.setNome("admin");
        administrador.setLogin("admin");
        administrador.setSenha("admin");
        usuarios[achaIndice(usuarios)] = administrador;
    }

    private static <tipo> int achaIndice(tipo valor[]) {
        /*
        Obtém o primeiro índice disponível do array passado como parâmetro e o retorna.
        Return: um inteiro com o índice encontrado, ou com -1, caso não encontrado.
         */
        int j = 0;
        if (valor instanceof Usuario[]) {
            j = 20;
        }
        else if (valor instanceof Casa[]){
            j = 500;
        }
        for (int i = 0; i < j; i++) {
            if (valor[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void cadastrarUsuario(String nome, String login, String senha, boolean adm) {
        /*
        Adiciona um novo usuario ao sistema, adicionando-o ao array de usuarios no índice encontrado
        pela função achaIndice.
         */
        int i = achaIndice(usuarios);
        if (i != -1) {
            Usuario usuario = new Usuario();
            usuario.setAdministrador(adm);
            if (adm) {
                qtdAdm++;
            }
            usuario.setNome(nome);
            usuario.setLogin(login);
            usuario.setSenha(senha);
            usuarios[i] = usuario;
            usuariosCadastrados++;
            System.out.println("Usuário cadastrado.");
        }
        else {
            System.err.println("Não foi possível cadastrar o usuário.");
        }
    }

    public boolean removerUsuario(String nome) {
        /*
        Remove o usuario se o dado sobre o login corresponder com o parametro passado. A função percorre todos
        os usuarios do array usuarios. Se encontrar um cujo o login seja correspondente, ela atribui null à posição,
        caso contrário, não faz nada.
        Return: true caso tenha dado certo e false caso tenha dado errado.
         */
        for (int i = 0; i < 20; i++) {
            if (usuarios[i] != null) {
                if (usuarios[i].getNome().equals(nome)) {
                    if (usuarios[i].isAdministrador()) {
                        qtdAdm--;
                    }
                    usuarios[i] = null;
                    usuariosCadastrados--;
                    if (qtdAdm == 0) {
                        administradorPadrao();
                    }
                    System.out.println("Usuário removido.");
                    return true;
                }
            }
        }
        System.err.println("Usuário não encontrado.");
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
        Adiciona um novo imovel ao sistema, adicionando-o ao array de imoveis no índice encontrado
        pela função achaIndice.
         */
        int i = achaIndice(imoveis);
        if (i != -1) {
            Casa imovel = new Casa();
            imovel.setProprietario(proprietario);
            imovel.setRua(rua);
            imovel.setNumero(numero);
            imovel.setLatitude(latitude);
            imovel.setLongitude(longitude);
            imoveis[i] = imovel;
            imoveisCadastrados++;
            System.out.println("Imóvel cadastrado.");
        }
        else {
            System.err.println("Não foi possível cadastrar o imóvel.");
        }
    }

    public boolean removerImovel(String rua, int numero, String proprietario) {
        /*
        Remove o imovel se os dados sobre rua, numero e proprietario corresponderem com os parametros passados.
        A função percorre todos os imoveis do array imoveis. Se encontrar um cuja a rua seja correspondente, ela
        verifica se o numero é correspondente. Se for, ela verifica se o proprietário é correspontende. Se for,
        ela atribui null à posição, caso contrário, não faz nada.
        Return: true caso tenha dado certo e false caso tenha dado errado.
         */
        for (int i = 0; i < 500; i++) {
            if (imoveis[i] != null) {
                if (imoveis[i].getRua().equals(rua)) {
                    if (imoveis[i].getNumero() == numero) {
                        if (imoveis[i].getProprietario().equals(proprietario)) {
                            imoveis[i] = null;
                            imoveisCadastrados--;
                            System.out.println("Imóvel removido.");
                            return true;
                        }
                    }
                }
            }
        }
        System.err.println("Imóvel não encontrado.");
        return false;
    }

    public Casa procuraImovel(String rua, int num) {
        for (int i = 0; i < imoveisCadastrados; i++) {
            if (imoveis[i].getRua() == rua && imoveis[i].getNumero() == num) {
                return imoveis[i];
            }
        }
        return null;
    }
    
    public void editarImovel(Casa casa, long latitude, long longitude, int numero, String proprietario, String rua) {
        casa.setLatitude(latitude);
        casa.setLongitude(longitude);
        casa.setNumero(numero);
        casa.setProprietario(proprietario);
        casa.setRua(rua);
    }
    
    public Usuario autentica(String login, String senha) {
        for (int i = 0; i < 20; i++) {
            if (usuarios[i] != null){
                if (usuarios[i].getLogin().equals(login)) {
//                (i == 19 && !usuarios[i].getSenha().equals(login))
                    if (usuarios[i].getSenha().equals(senha)) {
                        return usuarios[i];
                    }
                }
            }
        }
        return null;
    }
    
    public static String createCode(){
        java.util.Date data = new Date();
        String nomedata = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(data);
        String dataFinal = "" + nomedata.charAt(0) + nomedata.charAt(1) + nomedata.charAt(3) + nomedata.charAt(4) + nomedata.charAt(8) + nomedata.charAt(9) + '-';
            
        return(dataFinal);
    }
    
    public void cadastraEncomenda(double peso, boolean prioridade, boolean categoria, Casa destinatario) {
        
        Encomenda encomenda = new Encomenda();
        encomenda.setCodigo(createCode());
        encomenda.setPeso(peso);
        encomenda.setPrioridade(prioridade);
        encomenda.setCategoria(categoria);
        encomenda.setDestinatario(destinatario);
        
        if (prioridade) {
            this.encomendasPrioritarias.inserirNoFim(encomenda);
        }
        else {
            this.encomendasNormais.inserirNoFim(encomenda);
        }
    }

    public void editarEncomenda(Encomenda encomenda, boolean prioridade, boolean categoria, double peso, Casa destinatario) {
        encomenda.setPrioridade(prioridade);
        encomenda.setCategoria(categoria);
        encomenda.setPeso(peso);
        encomenda.setDestinatario(destinatario);
    }
    
    public ListaDinamica.Lista getEncomendasNormais() {
        return encomendasNormais;
    }

    public ListaDinamica.Lista getEncomendasPrioritarias() {
        return encomendasPrioritarias;
    }

    public ListaDinamica.Lista getEncomendasEmTransito() {
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
        drones[dronesCadastrados] = drone;
        dronesCadastrados++;
    }

    public int getUsuariosCadastrados() {
        return usuariosCadastrados;
    }

    public int getImoveisCadastrados() {
        return imoveisCadastrados;
    }

    public int getDronesCadastrados() {
        return dronesCadastrados;
    }

    public Casa[] getImoveis() {
        return imoveis;
    }

    public Drone[] getDrones() {
        return drones;
    }
    
    
    
    public void finalizarEntrega(Drone drone, Usuario logado) throws IOException {
//        encomendasEmTransito.excluirNo(encomenda.getCodigo());
        SalvarEmArquivo save = new SalvarEmArquivo();
        if(drone.getPacoteAtual() == null) {
            System.err.println("O drone" + drone.getID() + " não é capaz de entregar a encomenda.");
            return;
        }
        save.save(drone.getPacoteAtual(), logado);
        drone.setDisponibilidade(true);
        drone.setPacoteAtual(null);
    }
}
