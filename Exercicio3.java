import java.util.Random;
import java.util.Scanner;

public class Exercicio3 {

    /*
    Crie um método chamado Insere_Exclusivo(int vet[], int N) que alimenta um vetor 
    de N elementos com valores aleatórios entre 1 e N sem que ocorram números repetidos. Exiba o vetor gerado.
     */
    public static void main(String[] args) {
          int n;
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o valor de N: ");
        n = scan.nextInt();
        int[] vet = new int[n];
        vet = Insere_Exclusivo(vet, n);
        LerVetor(vet);
        scan.close();
    }
    public static void LerVetor(int vet[]){
        for (int i = 0; i < vet.length; i++) {
            System.out.println(vet[i]);
        }
    }

    public static int[] Insere_Exclusivo(int vet[], int N){
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            vet[i] = rand.nextInt(N - 0) + 1;
        }
        return vet;
    }
}
