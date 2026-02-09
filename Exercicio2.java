
import java.util.Random;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        int n, m, aleatorio;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o valor de n: ");
        n = scan.nextInt();
        int[] vet = new int[n];
        System.out.println("Digite o valor de m: ");
        m = scan.nextInt();
        for (int i = 0; i < n; i++) {
            vet[i] = aleatorio = rand.nextInt(m - 0);
        }
         for (int i = 0; i < n; i++) {
            System.out.println(vet[i]);
        }
    }
}
