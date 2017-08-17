package Classes;

public class Usuario {
    private String nome, login, senha;
    private boolean flag, administrador;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!flag) {
            this.nome = nome;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (!flag) {
            this.login = login;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (!flag) {
            this.senha = senha;
            flag = true;
        }
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
}
