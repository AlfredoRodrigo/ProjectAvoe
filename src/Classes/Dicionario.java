package Classes;

public class Dicionario {
    public Dicionario(int tamanho) {
        this.tamanho = tamanho;
    }

    private int tamanho;
    private int qtdElementos = 0;
    private String[] chaves = new String[tamanho];
    private String[] valores = new String[tamanho];

    public void adicionaValor(String chave, String valor) {
        /*
        Adiciona no dicionário de Strings a chave e o valor informado pelo usuário nas listas chaves e valores,
        respectivamente, com o mesmo índice, enquando as duas listas não estiverem cheias. Se estiverem cheias,
        ela informa uma mensagem de erro, e não faz mais nada.
         */
        if (qtdElementos < 100) {
            this.chaves[qtdElementos] = chave;
            this.valores[qtdElementos] = valor;
            this.qtdElementos++;
        }
        else {
            System.err.print("Impossível adicionar. Dicionario cheio.");
        }
    }

    public boolean retiraValor(String chave) {
        /*
        Procura na lista de chaves a chave que o usuário deseja remover. Quando encontrada, ele remove
        a chave a lista de chaves e o valor da lista de valores, ambos com o mesmo índice.
        Return: true, se encontrado e removido. Caso contrário, false.
         */
        for (int i = 0; i < qtdElementos; i++) {
            if (chaves[i].equals(chave)) {
                //REMOVA
                return true;
            }
        }
        return false;
    }

    public String encontraValor(String chave) {
        /*
        Procura no dicionário a chave solicitada pelo usuário.
        Return: se encontrada a chave, retorna uma string com a chave e o valor, no seguinte formato: 'chave': 'valor'
        caso contrário, retorna uma string com a palavra "null";
         */
        for (int i = 0; i < qtdElementos; i++) {
            if (chaves[i].equals(chave)) {
                return ("'" + chaves[i] + ": '" + valores[i]);
            }
        }
        return "null";
    }

    public int getTamanho() {
        /*
        Informa o tamanho do dicionário.
        Return: um inteiro com o tamanho do dicionário.
         */
        return this.tamanho;
    }
}
