package Classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Cadastrados {
    private int usuariosCadastrados = 0;
    private int imoveisCadastrados = 0;
    private int qtdAdm = 0;
    private int qtdLinhasHistory = 2;
    
    private static Usuario[] usuarios = new Usuario[20];
    private static Casa[] imoveis = new Casa[500];
    private ListaDinamica.Lista encomendasNormais = new ListaDinamica.Lista();
    private ListaDinamica.Lista encomendasPrioritarias = new ListaDinamica.Lista();
    private ListaDinamica.Lista encomendasEmTransito = new ListaDinamica.Lista();
    
    public int getQtdAdm() {
        return qtdAdm;
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
    
    public void cadastraEncomenda(int codigo, double peso, boolean p, long latitude,
            long longitude, boolean categoria, Casa destinatario) {
        
        Encomenda encomenda = new Encomenda();
        encomenda.setCodigo(codigo);
        encomenda.setPeso(peso);
        encomenda.setPrioridade(p);
        encomenda.setLatitude(latitude);
        encomenda.setLongitude(longitude);
        encomenda.setCategoria(categoria);
        encomenda.setDestinatario(destinatario);
        
        if (p) {
            this.encomendasPrioritarias.inserirNoFim(encomenda);
        }
        else {
            this.encomendasNormais.inserirNoFim(encomenda);
        }
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
    
    public void finalizarEntrega(Drone drone, Usuario logado) {
//        encomendasEmTransito.excluirNo(encomenda.getCodigo());
        System.out.println(drone.getPacoteAtual().getCodigo());
        salvarEmArquivo(drone.getPacoteAtual(), logado);
        drone.setDisponibilidade(true);
        drone.setPacoteAtual(null);
    }

    
    public void salvarEmArquivo(Encomenda encomenda, Usuario logado) {
        try {
            HSSFWorkbook planilha = new HSSFWorkbook(new FileInputStream("D:\\Documentos\\Documentos do Usuário\\Acadêmico\\IFPB\\E.C\\Matérias\\Laboratório de POO\\Documentos\\Programas\\ProjectAvoe\\src\\Classes\\saves\\history.xls"));
            FileOutputStream historyOut = new FileOutputStream("D:\\Documentos\\Documentos do Usuário\\Acadêmico\\IFPB\\E.C\\Matérias\\Laboratório de POO\\Documentos\\Programas\\ProjectAvoe\\src\\Classes\\saves\\history.xls", true);
            //ERRO, creio eu que seja por causa do tipo. Resolva!
            Sheet folha = planilha.createSheet("history2");
            Row linha = folha.createRow(qtdLinhasHistory);
            Cell celulas[] = new Cell[9];
            for (int x = 0; x < 9; x++) {
                Cell celula = linha.createCell(x);
                switch (x) {
                    case 0:
                        celula.setCellValue(qtdLinhasHistory - 1);
                        break;
                    case 1:
                        celula.setCellValue(encomenda.getCodigo());
                        break;
                    case 2:
                        celula.setCellValue(encomenda.getDestinatario().getProprietario());
                        break;
                    case 3:
                        celula.setCellValue(encomenda.getPeso());
                        break;
                    case 4:
                        if (encomenda.isCategoria()) {
                            celula.setCellValue("Carta");
                        }
                        else {
                            celula.setCellValue("Pacote");
                        }
                        break;
                    case 5:
                        celula.setCellValue(logado.getNome() + "(" + logado.getLogin() + ")");

                        break;
                    case 6:
                        //colocar data de cadastro da encomenda
                        break;
                    case 7:
                        //colocar hora de cadastro da encomenda
                        break;
                    case 8:
                        //colocar data de entrega da encomenda
                        break;
                    case 9:
                        //colocar hora de entrega da encomenda
                        break;
                }
                celulas[x] = celula;
            }
            planilha.write(historyOut);
            planilha.close();
            qtdLinhasHistory++;
        } catch (FileNotFoundException a) {
            a.printStackTrace();
        } catch (IOException b) {
            b.printStackTrace();  
        }
    }
    
    //public void salvarEmArquivo() {
        
        
    //}
    
}
