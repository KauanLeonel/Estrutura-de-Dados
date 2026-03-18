
public class Fila {

    private No head; // cabeca é o nó de controle da lista o "início" da implementação anterior

    public Fila() {
        this.head = null;
    }

    public void enfileirar(int x) {
        No newNo = new No(x);

        if (head == null) {
            head = newNo;
        } else {
            No temp = head;
            while (temp.prox != null) {
                temp = temp.prox;
            }
            temp.prox = newNo;

        }

    }

    public void desenfileirar() {
        if (head != null) {
            head = head.prox;
        } else {
            System.out.println("Empty queue");
        }
    }

    public int cabeca() {
        
        return head.valor;
    }

    public int cauda() {

        No temp = head;
        while (temp.prox != null) {
            temp = temp.prox;
        }

        return temp.valor;
    }

    public boolean vazia() {
        boolean empty = false;
        if (head == null) {
            empty = true;
        }
        return empty;
    }

    public int tamanho() {
        if (head == null) {
            return 0;
        }
        int length = 1;
        No temp = head;
        while (temp.prox != null) {
            temp = temp.prox;

            length++;
        }

        return length;
    }

    public void exibir() {
        No temp = head;
        System.out.println("SHOWING THE QUEUE");
        if (head != null) {
            while (temp.prox != null) {
                System.out.println(temp.valor);
                temp = temp.prox;
            }
            System.out.println(temp.valor);
        } else {
            System.out.println("EMPTY QUEUE");
        }
    }

}
