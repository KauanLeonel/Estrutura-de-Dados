
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o valor de N: ");
        n = scan.nextInt();
        int[] vet = new int[n];
        for (int i = 0; i < n; i++) {
            vet[i] = scan.nextInt();
        }

        System.out.println("Vetor na ordem de digitação");
        for (int i = 0; i < n; i++) {
            System.out.println(vet[i]);
        }
        System.out.println("Vetor na ordem inversa de digitação");
        for (int i = n - 1; -1 < i; i--) {
            System.out.println(vet[i]);
        }
    }
}
