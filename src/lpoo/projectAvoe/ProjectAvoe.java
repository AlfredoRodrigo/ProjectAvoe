package lpoo.projectAvoe;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProjectAvoe {
    public static void main(String[] args) throws IOException {
        int opcao, menu = 0;

        Cadastrados cadastro = new Cadastrados();
        ListaDinamica.Lista encomendas = new ListaDinamica.Lista();

        Usuario logado = null;
        String login, senha;

        cadastro.administradorPadrao();

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

        do {
            if (menu == 0) {
                try {
                    System.out.print("\n  1 - Gerenciar entregas" +
                            "\n  2 - Gerenciar drones" +
                            "\n  3 - Gerenciar usuários" +
                            "\n  4 - Gerenciar locais de entrega" +
                            "\n  0 - Salvar e sair\n  ");
                    opcao = input.nextInt();
                    menu = (opcao == 1) ? 1 : (opcao == 2) ? 2 : (opcao == 3) ? 3 : (opcao == 0) ? 0 : -1;
                    if (menu == 0) {
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
                    System.out.print("\n  1 - Criar entrega" +
                            "\n  2 - Excluir entrega" +
                            "\n  3 - Ver lista de entregas" +
                            "\n  0 - Voltar\n  ");
                    opcao = input.nextInt();
                    //menu
                    if (menu == 0) {
                        break;
                    }
                    else if (menu == -1){
                        System.err.println("Opção inválida. Informe novamente.");
                        menu = 0;
//                        Runtime.getRuntime().exec("cls");
                    }
                } catch (InputMismatchException a) {
                    System.err.println("Opção inválida. Informe novamente.");
//                    Runtime.getRuntime().exec("cls");
                }
            }
            if (menu == 2) {
                try {
                    System.out.println();
                    opcao = input.nextInt();
                    //menu
                    if (menu == 0) {
                        break;
                    }
                    else if (menu == -1){
                        System.err.println("Opção inválida. Informe novamente.");
                        menu = 0;
//                        Runtime.getRuntime().exec("cls");
                    }
                } catch (InputMismatchException a) {
                    System.err.println("Opção inválida. Informe novamente.");
//                    Runtime.getRuntime().exec("cls");
                }

            }
            if (menu == 3) {
                try {
                    System.out.println();
                    opcao = input.nextInt();
                    //menu
                    if (menu == 0) {
                        break;
                    }
                    else if (menu == -1){
                        System.err.println("Opção inválida. Informe novamente.");
                        menu = 0;
//                        Runtime.getRuntime().exec("cls");
                    }
                } catch (InputMismatchException a) {
                    System.err.println("Opção inválida. Informe novamente.");
//                    Runtime.getRuntime().exec("cls");
                }
            }

        } while (true);
    }
}
