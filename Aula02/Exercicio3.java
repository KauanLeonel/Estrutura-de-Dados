
import java.util.Scanner;

public class Exercicio3 {
    //Implemente, de forma recursiva, uma função int pot(int x, int n) que, dados dois números inteiros x e n, calcula o valor de xn

    public static int pot(int x, int n) {
        if (n == 1) {
            return x;
        }
        return x * pot(x, n - 1);
    }

    public static void main(String[] args) {
        int x, n;
        Scanner s = new Scanner(System.in);

        System.out.println("Digite o numero de x:");
        x = s.nextInt();
        System.out.println("Digite o numero de n:");
        n = s.nextInt();
        System.out.println(pot(x, n));
    }
}
