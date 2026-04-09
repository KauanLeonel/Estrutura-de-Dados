
public class CircularListInfinit {

    private No inicio; // inicio é o nó de controle da lista o "início" da implementação anterior

    public CircularListInfinit() {
        this.inicio = null;    }

    public void insereFinal(int x) {
        No newNo = new No(x);

        if (inicio == null) {
            inicio = newNo;
            inicio.prox = inicio;
        } else {
            newNo.ant = fim;
            fim.prox = newNo;
            fim = newNo;
        }
    }

    public void insereInicio(int x) {
        No newNo = new No(x);

        if (inicio == null) {
            inicio = newNo;
            fim = newNo;
        } else {
            newNo.prox = inicio;
            inicio.ant = newNo;
            inicio = newNo;

        }
    }

    public void RemoveInicio() {

        if (inicio == null) {
            System.out.println("IS EMPTY BRUH");
        } else {
            if (inicio.prox == null) {
                inicio = null;
            } else {
                inicio.prox.ant = null;
                inicio = inicio.prox;

            }
        }
    }

    public void RemoveFinal() {

        if (inicio == null) {
            System.out.println("IS EMPTY BRUH");
        } else {
            if (inicio.prox == null) {
                inicio = null;
            } else {
                fim.ant.prox = null;
                fim = fim.ant;
            }
        }
    }

    public void ultimo() {
        if (fim == null) {
            System.out.println("Vazio chapa");
        } else {
            System.out.println("Primeiro " + fim.valor);
        }
    }

    public void inicio() {
        if (inicio == null) {
            System.out.println("Vazio chapa");
        } else {
            System.out.println("Primeiro " + inicio.valor);
        }
    }

    public boolean vazia() {
        boolean empty = false;
        if (inicio == null) {
            empty = true;
        }
        return empty;
    }

    public int tamanho() {
        if (inicio == null) {
            return 0;
        }
        int length = 1;
        No temp = inicio;
        while (temp.prox != null) {
            temp = temp.prox;

            length++;
        }

        return length;
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("Empty queue");
        } else {
            No temp = inicio;
            System.out.println("SHOWING THE STACK");
            while (temp.prox != inicio) {
                System.out.println(temp.valor);
                temp = temp.prox;
            }
            System.out.println(temp.valor);
        }
    }

}
