
public class CircularListInfinit {

    private No inicio; // inicio é o nó de controle da lista o "início" da implementação anterior

    public CircularListInfinit() {
        this.inicio = null;
    }

    public void insereFinal(int x) {
        No newNo = new No(x);

        if (inicio == null) {
            inicio = newNo;
            inicio.prox = inicio;
            inicio.ant = inicio;
        } else {
            newNo.ant = inicio.ant;
            inicio.ant.prox = newNo;
            newNo.prox = inicio;
            inicio.ant = newNo;
        }
    }

    public void insereInicio(int x) {
        No newNo = new No(x);

        if (inicio == null) {
            inicio = newNo;
            inicio.prox = inicio;
            inicio.ant = inicio;
        } else {
            newNo.prox = inicio;
            newNo.ant = inicio.ant;
            inicio.ant.prox = newNo;
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
                inicio.ant.prox = inicio.prox;
                inicio.prox.ant = inicio.ant;
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
                inicio.ant.ant.prox = inicio;
                inicio.ant = inicio.ant.ant;
            }
        }
    }

    public void ultimo() {
        if (inicio == null) {
            System.out.println("Vazio chapa");
        } else {
            System.out.println("Ultimo " + inicio.ant.valor);
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
        while (temp.prox != inicio) {
            temp = temp.prox;

            length++;
        }

        return length;
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("Lista Vazia");
            return;
        }
        No temp = inicio;
        System.out.println("INICIO");
        do {
            String antVal = (temp.ant != null) ? String.valueOf(temp.ant.valor) : "null";
            String proxVal = (temp.prox != null) ? String.valueOf(temp.prox.valor) : "null";

            System.out.println("Valor: " + temp.valor + " | Ant: " + antVal + " | Prox: " + proxVal);
            temp = temp.prox;
        } while (temp != inicio);
        System.out.println("FIM");

    }

    public int meio() {
        int metade;
        //int i = 0;
        No first = inicio;
        No last = inicio.ant;
        while(first.valor != last.valor && first.prox.valor != last.valor ){
            first = first.prox;
            last = last.ant;
            // System.out.println(i);
            // i++;
            System.out.println("INICIO " + first.valor + " LAST " + last.valor);
        }
        exibir();

        metade = (first.valor + last.valor)/2;

        return metade;
    }
}
