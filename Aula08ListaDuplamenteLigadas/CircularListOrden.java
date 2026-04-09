
public class CircularListOrden {

    private No inicio; // inicio é o nó de controle da lista o "início" da implementação anterior
    private No fim;

    public CircularListOrden() {
        this.inicio = null;
        this.fim = null;
    }

    public void insereFinal(int x) {
        No newNo = new No(x);

        if (inicio == null) {
            inicio = newNo;
            fim = newNo;
        } else {
            newNo.ant = fim;
            fim.prox = newNo;
            fim = newNo;
        }
    }

    public void inserir(int x) {
        No newNo = new No(x);

        if (inicio == null) {
            inicio = newNo;
            fim = newNo;
        } else {
            
            if (newNo.valor <= inicio.valor ) {
                newNo.prox = inicio;
                inicio.ant = newNo;
                inicio = newNo;
            } else {
                if (newNo.valor >= fim.valor) {
                    newNo.ant = fim;
                    fim.prox = newNo;
                    fim = newNo;

                } else {
                    No temp = inicio;
                    while (newNo.valor >= temp.valor) {
                        
                        temp = temp.prox;
                    }
                    System.out.println("NewNo" + newNo.valor + "temp" + temp.valor);
                    newNo.prox = temp;
                    newNo.ant = temp.ant;
                    temp.ant.prox = newNo;
                    temp.ant = newNo;
                }
            }

        }
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("Empty queue");
        } else {
            No temp = inicio;
            System.out.println("SHOWING THE STACK");
            while (temp != fim) {
                System.out.println(temp.valor);
                temp = temp.prox;
            }
            System.out.println(fim.valor);
        }
    }

    public void Remover(int n) {

        if (inicio == null) {
            System.out.println("IS EMPTY BRUH");
        } else {
            No temp = inicio;
            while (temp.valor != n && temp.prox != null){
                temp = temp.prox;
            }
            if(temp.prox == null){
                System.out.println("NÚMERO NÃO ENCONTRADO");
            } else{
                temp.ant.prox = temp.prox;
                temp.prox.ant = temp.ant.ant;
            }
        }
    }


    public void ultimo() {
        if (fim == null) {
            System.out.println("Vazio chapa");
        } else {
            System.out.println("FIM  " + fim.valor);
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

}
