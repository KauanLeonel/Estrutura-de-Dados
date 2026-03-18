
public class Pilha {

    private No topo; // topo é o nó de controle da lista o "início" da implementação anterior

    public Pilha() {
        this.topo = null;
    }

    public void empilhar(int x) {
        No newNo = new No(x);

        if (topo == null) {
            topo = newNo;
        } else {
            No temp = topo;
            while (temp.prox != null) {
                temp = temp.prox;
            }
            temp.prox = newNo;

        }
    }

    public void desempilhar() {
        if (topo == null) {
            System.out.println("Empty stack");
        } else {
            No temp = topo;
            while (temp.prox.prox != null) {
                temp = temp.prox;
            }
            temp.prox = null;
        }
    }

    public int topo() {
        No temp = topo;

        while (temp.prox != null) {
            temp = temp.prox;
        }

        return temp.valor;
    }

    public boolean vazia() {
        boolean empty = false;
        if (topo == null) {
            empty = true;
        }
        return empty;
    }

    public int tamanho() {
        if (topo == null) {
            return 0;
        }
        int length = 1;
        No temp = topo;
        while (temp.prox != null) {
            temp = temp.prox;

            length++;
        }

        return length;
    }

    public void exibir() {
        if (topo == null) {
            System.out.println("Empty queue");
        } else {
            No temp = topo;
            System.out.println("SHOWING THE STACK");
            while (temp.prox != null) {
                System.out.println(temp.valor);
                temp = temp.prox;
            }
            System.out.println(temp.valor);
        }
    }

}
