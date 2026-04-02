
public class CircularList {

    private No inicio; // inicio é o nó de controle da lista o "início" da implementação anterior

    public CircularList() {
        this.inicio = null;
    }

    public void insereFinal(int x) {
        No newNo = new No(x);

        if (inicio == null) {
            inicio = newNo;
            newNo.prox = inicio;
        } else {
            No temp = inicio;
            while (temp.prox != inicio) {
                temp = temp.prox;
            }
            newNo.prox = inicio;
            temp.prox = newNo;

        }
    }

    public void insereInicio(int x) {
        No newNo = new No(x);

        if (inicio == null) {
            inicio = newNo;
            newNo.prox = inicio;
        } else {
            No temp = inicio;
            while (temp.prox != inicio) {
                temp = temp.prox;
            }
            newNo.prox = inicio;
            inicio = newNo;
            temp.prox = newNo;

        }
    }

    public void RemoveInicio() {

        if (inicio == null) {
            System.out.println("IS EMPTY BRUH");
        } else {
            if (inicio.prox == inicio) {
                inicio = null;
            } else {
                No temp = inicio;
                while (temp.prox != inicio) {
                    temp = temp.prox;
                }
                temp.prox = temp.prox.prox;
                inicio = inicio.prox;
            }
        }
    }

    public void RemoveFinal() {

        if (inicio == null) {
            System.out.println("IS EMPTY BRUH");
        } else {
            if (inicio.prox == inicio) {
                inicio = null;
            } else {
                No temp = inicio;
                while (temp.prox.prox != inicio) {
                    temp = temp.prox;
                }
                temp.prox = inicio;
            }
        }
    }

    public void ultimo() {
        if (inicio == null) {
            System.out.println("Vazio chapa");
        } else {
            No temp = inicio;

            while (temp.prox != inicio) {
                temp = temp.prox;
            }
            System.out.println("Ultimo " + temp.valor);
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
