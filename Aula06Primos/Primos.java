
import java.util.Scanner;

public class Primos {

    static No inicio = null; // <- VARIÁVEL GLOBAL

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();
        for (int i = 0; i <= N; i++) {
            inserir(i);
        }
        primos(N);

        exibir(inicio);
        System.out.println("There are " + tamanho(inicio) + " prime numbers between 0 and " + N);
    }

    private static void primos(int n) {
        No temp = inicio;
        int max = n / 2 ;
        if (inicio.valor == 0) {
            temp = inicio.prox.prox;
        }
        while (temp.valor <= max) {
            No jump = temp.prox;
            while (jump.prox != null) {
                if (jump.prox.valor % temp.valor == 0) {
                    jump.prox = jump.prox.prox;
                } else {
                    jump = jump.prox;
                }
            }
            System.out.println(temp.valor);
            temp = temp.prox;
        }
        // temp.prox = newNo;
    }

    private static int tamanho(No temp) {
        if (temp.prox == null) {
            return 0;
        } else {
            return 1 + tamanho(temp.prox);
        }

    }

    private static void inserir(int x) {
        No newNo = new No(x);
        if (inicio == null) {
            inicio = newNo;
        } else {
            No temp = inicio;
            while (temp.prox != null) {
                temp = temp.prox;
            }
            temp.prox = newNo;

        }
    }

    private static void exibir(No temp) {
        System.out.println(temp.valor);
        if (temp.prox != null) {
            exibir(temp.prox);
        }
    }

}
