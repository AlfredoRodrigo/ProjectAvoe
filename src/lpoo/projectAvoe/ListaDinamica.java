package lpoo.projectAvoe;

public class ListaDinamica {
    static class No{
        /*
        Objeto 'No', contêm a encomenda e o apontador para o próximo elemento da lista.
        */
        Encomenda encomenda;                   // Erro por não possuir a classe encomenda.
        No prox;

        public No(Encomenda encomenda){        // Eroo por não possuir a classe encomenda.
            encomenda = encomenda;
            prox = null;
        }
    }

    static class Lista {
        /*
        A lista de 'Nos', tendo 2 variáveis de referencia 'primeiro' e 'ultimo'.
        Possui uma variável contador 'totalNos' para facilitar a contagem de elementos na lista.
        */

        private No primeiro, ultimo; //*
        private int totalNos;

        public Lista() {
        /*
        Construtor da lista, usado para configurar os Nos primeiro e ultimo apontando para null e setando o contador para 0.
        */
            primeiro = ultimo = null;
            totalNos = 0;
        }

        public int getTotalNos() {
            return totalNos;
        }

        public boolean checkIfListaVazia() {
            if (getTotalNos() == 0) {
                return true;
            }
            return false;
        }

        public void inserirNoInicio(No n) {
        /*
        Método para adicionar um novo elemento no inicio da lista.
        */
            if (checkIfListaVazia()) {
                primeiro = ultimo = n;
            } else {
                n.prox = primeiro;
                primeiro = n;
            }
            totalNos++;
        }

        public void inserirNoFim(No n) {
        /*
        Método para adicionar um novo elemento no final da lista.
        */
            // caso não existam nós inseridos,
            // insere o primeiro nó (n) na lista
            if (checkIfListaVazia()) {
                primeiro = ultimo = n;
            } else {
                ultimo.prox = n;
                ultimo = n;
            }
            totalNos++;
        }

        public void excluirNo(No n) {
        /*
        Excluir No baseado no nome do destinatario da encomenda.
        ### Melhor achar algo mais eficiente para procura, pois um mesmo destinatário pode possuir diversas encomendas.
        */
            No noAtual;
            No noAnterior;
            noAtual = noAnterior = primeiro;
            int contador = 1;

            if (!checkIfListaVazia()) {
                while (contador <= getTotalNos() && (noAtual.encomenda.getCodigo() != n.encomenda.getCodigo())) {
                    noAnterior = noAtual;
                    noAtual = noAtual.prox;
                    contador++;
                }

                if (noAtual.encomenda.getCodigo() == n.encomenda.getCodigo()) {
                    if (getTotalNos() == 1) {
                        primeiro = ultimo = null;
                    } else {
                        if (noAtual == primeiro) {
                            primeiro = noAtual.prox;
                        } else {
                            noAnterior.prox = noAtual.prox;
                        }
                    }
                    totalNos--;
                }
            }
        }

        public void imprimirLista(){
            /*
            Método para imprimir a lista informando o destinatário peso e prioridade(Nessa sequência).
            ### Modificar função dependendo das variáveis de encomenda para especificala ao usuario de forma completa.
            */
            No x = primeiro;
            for (int i = 0; i <= totalNos; i++){
                System.out.println("Destinatário: " + x.encomenda.getDestinatario() +
                                   "\nPeso: " + x.encomenda.getPeso() +
                                   "\nPrioridade: " + x.encomenda.getPrioridade() + "\n\n");
                x = x.prox;

            }
        }
    }
}
