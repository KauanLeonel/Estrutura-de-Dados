
public class Joseph {

    static No inicio = null; // <- VARIÁVEL GLOBAL

    public static void main(String[] args) {

        int N = 700;
        int S = 1572;

        for (int i = 1; i <= N; i++) {
            insereFinal(i);
        }

        exibir();

        josephus(S);

        System.out.println("JOSEPHUS");
        System.out.println("N = " + N);
        System.out.println("S = " + S);
        System.out.println("Sobrevivente: " + inicio.valor);

    }

    static void insereFinal(int x) {
        No novo = new No(x);

        if (inicio == null) {
            inicio = novo;
        } else {
            No temp = inicio;

            while (temp.prox != inicio) {
                temp = temp.prox;
            }

            temp.prox = novo;
        }
        novo.prox = inicio;
    }

    static void exibir() {
        if (inicio == null) {
            System.out.println("Lista VAZIA, nada a exibir");
        } else {
            No temp = inicio;
            do {
                System.out.println(temp.valor);
                temp = temp.prox;
            } while (temp != inicio);
        }
    }

    static void josephus(int s) {

        while (inicio.prox != inicio) {
            for (int i = 1; i < s - 1; i++) {
                inicio = inicio.prox;
            }
            inicio.prox = inicio.prox.prox;
            inicio = inicio.prox;
        }
    }

}
