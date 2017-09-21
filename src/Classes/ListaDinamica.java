package Classes;

import java.io.*;

public class ListaDinamica implements Serializable {
    static class No implements Serializable {
        /*
        Objeto 'No', contêm a encomenda e o apontador para o próximo elemento da lista.
        */
        Encomenda encomenda;
        No prox;

        public No(Encomenda encomenda){      
            this.encomenda = encomenda;
            prox = null;
        }
        
    }

    static class Lista implements Serializable{
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

        public boolean isEmpty() {
            if (getTotalNos() == 0) {
                return true;
            }
            return false;
        }
        
        public No retornaEncomenda() {
            return primeiro;
        }

        public void inserirNoInicio(Encomenda encomenda) {
        /*
        Método para adicionar um novo elemento no inicio da lista.
        */
            No no = new No(encomenda);
        
            if (isEmpty()) {
                primeiro = ultimo = no;
            } else {
                no.prox = primeiro;
                primeiro = no;
            }
            totalNos++;
        }

        public void inserirNoFim(Encomenda encomenda) {
        /*
        Método para adicionar um novo elemento no final da lista.
        */
            // caso não existam nós inseridos,
            // insere o primeiro nó (n) na lista
            No no = new No(encomenda);
            
            if (isEmpty()) {
                primeiro = ultimo = no;
            } else {
                ultimo.prox = no;
                ultimo = no;
            }
            totalNos++;
        }

        public void excluirNo(String codigo) {
        /*
        Excluir No baseado no nome do destinatario da encomenda.
        ### Melhor achar algo mais eficiente para procura, pois um mesmo destinatário pode possuir diversas encomendas.
        */
            No noAtual;
            No noAnterior;
            noAtual = noAnterior = primeiro;
            int contador = 1;

            if (!isEmpty()) {
                while (contador <= getTotalNos() && (!(noAtual.encomenda.getCodigo().equals(codigo))) && (noAtual != null)) {
                    noAnterior = noAtual;
                    noAtual = noAtual.prox;
                    contador++;
                }

                if (noAtual.encomenda.getCodigo().equals(codigo)) {
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
           
        public No retornarEncomenda(int i) {
            No noAtual;
            No noAnterior;
            noAtual = noAnterior = primeiro;
            int contador = 0;

            if (!isEmpty()) {
                while (contador <= getTotalNos() && (i != contador ) && (noAtual != null)) {
                    noAnterior = noAtual;
                    noAtual = noAtual.prox;
                    contador++;
                }

                if (noAtual != null) {
                    return noAtual;
                }
            }
            return null;
        }
        
        public String[] imprimirLista(){
            /*
            Método para imprimir a lista informando o destinatário peso e prioridade(Nessa sequência).
            ### Modificar função dependendo das variáveis de encomenda para especificala ao usuario de forma completa.
            */
            No x = this.primeiro;
//            if (totalNos == 0) {
//                return "Lista vazia";
//            }
            while(x != null) {
                String[] strings = new String[500];
                for (int h = 0; h < totalNos; h++) {
                    String string = "Destinatário: " + x.encomenda.getDestinatario() +
                                       "\nPeso: " + x.encomenda.getPeso() +
                                       "\nPrioridade: " + x.encomenda.getPrioridade() + "\n\n";
                    strings[h] = string;
                }
                return strings;
            }
            return null;
        }
    }
}
