package Classes;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ProjectAvoe {
    public static void serializa(Cadastrados cadastro, String caminho) {
        //aqui acontece a serialização do arquivo. Tudo fica dentro de um bloco
        //try/catch, pois como estamos lidando com entrada e saída de arquivos,
        //tudo fica mais sucetível a erros.
        try {
            //cria o objeto serializável (o arquivo do objeto) no disco
            FileOutputStream fout = new FileOutputStream(caminho);
            
            //instancia o objeto que escreve os dados no arquivo serializável,
            //ou seja, a classe que serializa os objetos
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            
            //do objeto instanciado anteriormente, chamamos o
            //método writeObject, que realiza a escrita do objeto
            //no arquivo serializado
            oos.writeObject(cadastro);
            
            //fecha o objeto responsável pela escrita no arquivo serializável
            oos.close();
            
            //imprime uma mensagem que informa que o processo foi concluído
            System.out.println("SALVO");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static Cadastrados deserializa(String caminho) {
        Cadastrados cadastro;
        try {
            //carrega o arquivo serializado do disco para o programa
            FileInputStream fin = new FileInputStream(caminho);
            
            //lê o objeto contido no arquivo serializado
            ObjectInputStream ois = new ObjectInputStream(fin);
            
            //converte os dados lidos anteriormente em um objeto do tipo
            //Address e o instancia, alocando-o na variável address
            cadastro = (Cadastrados) ois.readObject();
            
            //fecha o objeto responsável por ler o arquivo serializado
            ois.close();
            
            //imprime o objeto "resgatado" do arquivo serializado
            return cadastro;
        } catch (Exception ex) {
//            ex.printStackTrace();
            return new Cadastrados();
        }
    }
    
    public static void main(String[] args) throws IOException {
        int opcao, menu = 0;
        
        //String fileName = "D:\\Documentos\\Documentos do Usuário\\Acadêmico\\IFPB\\E.C\\Matérias\\Laboratório de POO\\Documentos\\Programas\\ProjectAvoe\\src\\Classes\\saves\\cadastro.ser";
        String fileName = "C:\\Users\\guisi\\OneDrive\\Documentos\\Engenharia de Computação\\Programação Orientada a Objetos\\ProjectAvoe\\src\\Classes\\saves\\cadastro.ser";

        Cadastrados cadastro = deserializa(fileName);
        
//        System.out.println(cadastro.getUsuarios()[0].getNome());
//        System.out.println(cadastro.getUsuarios()[1].getNome());
        
//        Drone drone1 = new Drone();
//        drone1.setID("Drone 1");
//        drone1.setCapCarga(40);
//        drone1.setCategoria(true);
//        
//        Drone drone2 = new Drone();
//        drone2.setID("Drone 2");
//        drone2.setCapCarga(40);
//        drone2.setCategoria(true);
//        
//        Drone drone3 = new Drone();
//        drone3.setID("Drone 3");
//        drone3.setCapCarga(40);
//        drone3.setCategoria(false);
//        
//        Encomenda encomenda1 = new Encomenda();
//        Encomenda encomenda2 = new Encomenda();
//        Encomenda encomenda3 = new Encomenda();
//        
//        Casa casa1 = new Casa();
//        Casa casa2 = new Casa();
//        Casa casa3 = new Casa();
//        
//        casa1.setProprietario("Alfredo");
//        casa2.setProprietario("Guilherme");
//        casa3.setProprietario("Bryan");
//        
//        cadastro.getEncomendasPrioritarias().imprimirLista();
        
        //                      prioridade    categoria
        //                              |      |
        //                              v      v
        
//        cadastro.cadastraEncomenda(10, true, true, casa1);
//        cadastro.cadastraEncomenda(20, true, false, casa2);
//        cadastro.cadastraEncomenda(30, false, true, casa3);
        
//        System.out.println("----------------------------------------------------------------");
//                
//        cadastro.getEncomendasPrioritarias().imprimirLista();
//        
//        drone1.escolherPacote(cadastro.getEncomendasNormais(), cadastro.getEncomendasPrioritarias(), cadastro.getEncomendasEmTransito());
//        drone2.escolherPacote(cadastro.getEncomendasNormais(), cadastro.getEncomendasPrioritarias(), cadastro.getEncomendasEmTransito());
//        drone3.escolherPacote(cadastro.getEncomendasNormais(), cadastro.getEncomendasPrioritarias(), cadastro.getEncomendasEmTransito());
        
//        cadastro.getEncomendasNormais().imprimirLista();
//        cadastro.getEncomendasPrioritarias().imprimirLista();
//        cadastro.getEncomendasEmTransito().imprimirLista();
        
        Usuario logado = null;
        String login, senha;

        if (cadastro.getQtdAdm() == 0) {
            cadastro.administradorPadrao();
        }
        
        Scanner input = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);

        System.out.println("#---#--Project Avoe--#---#");

        do {
            System.out.println("\nLogin: ");
            login = inputStr.nextLine();

            System.out.println("\nSenha: ");
            senha = inputStr.nextLine();

            if (cadastro.autentica(login, senha) != null) {
                logado = cadastro.autentica(login, senha);
                System.out.println("Bem vindo, " + logado.getNome() + "!");
            } else {
                System.err.println("Acesso negado.\n");
            }
        } while (logado == null);

//        cadastro.finalizarEntrega(drone1, logado);
//        cadastro.finalizarEntrega(drone2, logado);
//        cadastro.finalizarEntrega(drone3, logado);
        
        do {
            if (menu == 0) {
                try {
                    System.out.print("\n  1 - Gerenciar entregas" +
                            "\n  2 - Gerenciar drones" +
                            "\n  3 - Gerenciar usuários" +
                            "\n  4 - Gerenciar locais de entrega" +
                            "\n  0 - Salvar e sair\n  ");
                    opcao = input.nextInt();
                    menu = (opcao == 1) ? 1 :
                            (opcao == 2) ? 2 :
                                    (opcao == 3) ? 3 :
                                            (opcao == 4) ? 4 :
                                                    (opcao == 0) ? 0 : -1;
                    if (menu == 0) {
                        try {
                            serializa(cadastro, fileName);
                            System.out.println("DEU CERTO :)");
                        } catch (Exception a){
                            System.err.println("DEU ERRADO :(");
                        }
                        break;
                    }
                    else if (menu == -1){
                        System.err.println("Opção inválida. Informe novamente.");
                        menu = 0;
//                        Runtime.getRuntime().exec("cls");
                    }

                } catch (InputMismatchException a) {
                    System.err.println("Opção inválida. Informe novamente.");
                    input.next();
//                    Runtime.getRuntime().exec("cls");
                }
            }

            if (menu == 1) {
                try {
                    System.out.print("\nGerência de entregas:\n" +
                            "\n  1 - Criar entrega" +
                            "\n  2 - Excluir entrega" +
                            "\n  3 - Ver lista de entregas" +
                            "\n  0 - Voltar\n  ");
                    opcao = input.nextInt();
                    menu = (opcao == 1) ? 5 :
                            (opcao == 2) ? 6 :
                                    (opcao == 3) ? 7 :
                                            (opcao == 0) ? 0 : -1;
                    if (menu == -1){
                        System.err.println("Opção inválida. Informe novamente.");
                        menu = 1;
//                        Runtime.getRuntime().exec("cls");
                    }
                } catch (InputMismatchException a) {
                    System.err.println("Opção inválida. Informe novamente.");
                    input.next();
//                    Runtime.getRuntime().exec("cls");
                }
            }
            if (menu == 2) {
                try {
                    System.out.println("\nGerência de drones:\n" +
                            "\n  1 - Cadastrar drone" +
                            "\n  2 - Remover drone" +
                            "\n  3 - Desabilitar drone" +
                            "\n  4 - Localizar drones" +
                            "\n  0 - Voltar\n  ");
                    opcao = input.nextInt();
                    menu = (opcao == 1) ? 8 :
                            (opcao == 2) ? 9 :
                                    (opcao == 3) ? 10 :
                                            (opcao == 4) ? 11 :
                                                    (opcao == 0) ? 0 : -1;
                    if (menu == -1){
                        System.err.println("Opção inválida. Informe novamente.");
                        menu = 2;
//                        Runtime.getRuntime().exec("cls");
                    }
                } catch (InputMismatchException a) {
                    System.err.println("Opção inválida. Informe novamente.");
                    input.next();
//                    Runtime.getRuntime().exec("cls");
                }

            }
            if (menu == 3) {
                try {
                    System.out.println("\nGerência de usuários:\n" +
                            "\n  1 - Cadastrar usuário no sistema" +
                            "\n  2 - Remover usuário do sistema" +
                            "\n  3 - Editar usuário existente" +
                            "\n  0 - Voltar\n  ");
                    opcao = input.nextInt();
                    menu = (opcao == 1) ? 12 :
                            (opcao == 2) ? 13 :
                                    (opcao == 3) ? 14 :
                                            (opcao == 0) ? 0 : -1;
                    if (menu == -1){
                        System.err.println("Opção inválida. Informe novamente.");
                        menu = 3;
//                        Runtime.getRuntime().exec("cls");
                    }
                } catch (InputMismatchException a) {
                    System.err.println("Opção inválida. Informe novamente.");
                    input.next();
//                    Runtime.getRuntime().exec("cls");
                }
            }

            if (menu == 4) {
                try {
                    System.out.println("\nGerência de locais de entrega:\n" +
                            "\n  1 - Cadastrar local de entrega" +
                            "\n  2 - Remover local de entrega" +
                            "\n  3 - Editar local de entrega" +
                            "\n  0 - Voltar\n  ");
                    opcao = input.nextInt();
                    menu = (opcao == 1) ? 15 :
                            (opcao == 2) ? 16 :
                                    (opcao == 3) ? 17 :
                                            (opcao == 0) ? 0 : -1;
                    if (menu == -1){
                        System.err.println("Opção inválida. Informe novamente.");
                        menu = 4;
//                        Runtime.getRuntime().exec("cls");
                    }
                } catch (InputMismatchException a) {
                    System.err.println("Opção inválida. Informe novamente.");
                    input.next();
//                    Runtime.getRuntime().exec("cls");
                }
            }

            if (menu == 5) {
                while(true) {

                    //cadastrar uma entrega

                    System.out.println("Deseja continuar cadastrando? 1 - sim, 2 - não: ");
                    opcao = input.nextInt();
                    if (opcao == 2) {
                        menu = 1;
                        break;
                    }
                }
            }

            if (menu == 12) {
                while(true) {
                    String n, l, s;
                    boolean adm;

                    System.out.println("Informe o nome: ");
                    n = inputStr.nextLine();

                    System.out.println("Agora informe o login: ");
                    l = inputStr.nextLine();

                    System.out.println("Por fim, informe a senha: ");
                    s = inputStr.nextLine();

                    System.out.println("O usuário é administrador? 1 - sim, 2 - não: ");
                    opcao = input.nextInt();
                    adm = (opcao == 1);

                    cadastro.cadastrarUsuario(n, l, s, adm);

                    System.out.println("Deseja continuar cadastrando? 1 - sim, 2 - não: ");
                    opcao = input.nextInt();

                    if (opcao == 2) {
                        menu = 3;
                        break;
                    }
                }
            }

            if (menu == 13) {
                while(true) {
                    String n, l;

                    System.out.println("Informe o nome do usuário: ");
                    n = inputStr.nextLine();
                    System.out.println("Agora informe o login: ");

                    cadastro.removerUsuario(n);

                    System.out.println("Deseja continuar removendo? 1 - sim, 2 - não: ");
                    opcao = input.nextInt();

                    if (opcao == 2) {
                        menu = 3;
                        break;
                    }
                }
            }

            if (menu == 14) {
                while(true) {

                    //editar usuário existente

                    System.out.println("Deseja continuar editando? 1 - sim, 2 - não: ");
                    opcao = input.nextInt();

                    if (opcao == 2) {
                        menu = 3;
                        break;
                    }
                }
            }

            if (menu == 15) {
                while(true) {
                    String p, r;
                    int n;
                    long lttd, lgtd;

                    System.out.println("Informe o nome do proprietário: ");
                    p = inputStr.nextLine();

                    System.out.println("Agora informe a rua do imóvel: ");
                    r = inputStr.nextLine();

                    System.out.println("Agora informe o número do imóvel: ");
                    n = input.nextInt();

                    System.out.println("Agora informe a latitude do local: ");
                    lttd = input.nextLong();

                    System.out.println("Por fim, informe a longitude do local: ");
                    lgtd = input.nextLong();

                    cadastro.cadastrarImovel(p, r, n, lttd, lgtd);

                    System.out.println("Deseja continuar cadastrando? 1 - sim, 2 - não: ");
                    opcao = input.nextInt();

                    if (opcao == 2) {
                        menu = 4;
                        break;
                    }
                }
            }

            if (menu == 16) {
                while(true) {
                    String p, r;
                    int n;

                    System.out.println("Informe a rua do imóvel: ");
                    r = inputStr.nextLine();

                    System.out.println("Agora informe o número do imóvel: ");
                    n = input.nextInt();

                    System.out.println("Por fim, informe o proprietário do imóvel");
                    p = inputStr.nextLine();

                    cadastro.removerImovel(r, n, p);

                    System.out.println("Deseja continuar removendo? 1 - sim, 2 - não: ");
                    opcao = input.nextInt();

                    if (opcao == 2) {
                        menu = 4;
                        break;
                    }
                }
            }

            /*
            Os menus e submenus (os marcados são os que faltam ser implementados):

            menu 1:
            menu == 5 criar entrega                        *
            menu == 6 excluir entregas                     *
            menu == 7 ver lista de entregas                *

            menu 2:
            menu == 8 cadastrar drone                      *
            menu == 9 remover drone                        *
            menu == 10 desabilitar drone                   *
            menu == 11 localizar drones                    *

            menu 3:
            menu == 12 cadastrar usuario no sistema
            menu == 13 remover usuario do sistema                 tem erro quando quer remover quem não existe
            menu == 14 editar usuario existente            *

            menu 4:
            menu == 15 cadastrar local de entrega
            menu == 16 remover local de entrega
            menu == 17 editar local de entrega             *
            */

        } while (true);
    }
}
