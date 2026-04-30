
public class Joseph {

    static No inicio = null; // <- VARIÁVEL GLOBAL

    public static void main(String[] args) {

        int N = 5;
        int S = 1;
        int J = 1;

        for (int i = 1; i <= N; i++) {
            insereFinal(i);
        }

        exibir();

        josephus(S, J);

        System.out.println("JOSEPHUS");
        System.out.println("N = " + N);
        System.out.println("S = " + S);
        System.out.println("J = " + J);
        System.out.println("Sobrevivente: " + inicio.valor);

    }

    static void insereFinal(int x) {
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

    static void exibir() {
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

    static void josephus(int s, int j) {

        while (inicio.prox != inicio) {

            for (int i = 0; i < s - 1; i++) {
                inicio = inicio.prox;
            }

            inicio.prox.ant = inicio.ant;
            inicio.ant.prox = inicio.prox;
            inicio = inicio.prox;

            if(inicio.prox == inicio){
                break;
            }

            for (int i = 0; i < j - 1; i++) {
                inicio = inicio.ant;
            }
            inicio.prox.ant = inicio.ant;
            inicio.ant.prox = inicio.prox;
            inicio = inicio.prox;

        }
    }

}
