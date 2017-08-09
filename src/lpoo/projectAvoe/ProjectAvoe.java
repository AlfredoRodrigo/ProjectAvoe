package lpoo.projectAvoe;

import java.util.Scanner;

public class ProjectAvoe {
    public static void main(String[] args) {
        Cadastrados cadastro = new Cadastrados();

        Usuario logado = null;
        String login, senha;

        cadastro.administrador();

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
            }
            else {
                System.err.println("Acesso negado.\n");
            }
        } while (logado == null);

        System.out.println("\nO que você deseja fazer?" +
                           "\n\n  1 - Adicionar entregas" +
                           "\n  2 - Cancelar entregas" +
                           "\n  3 - Ver lista de prioridades" +
                           "\n  0 - Sair");

    }
}
