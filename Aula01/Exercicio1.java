
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        /*
        Crie um programa em que solicita ao usuário o valor de N e, 
        posteriormente os N números que devem ser armazenados em um vetor. 
        Em um segundo momento, exiba o vetor na ordem em que os elementos 
        foram digitados e em ordem inversa.
        */
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o valor de N: ");
        n = scan.nextInt();
        int[] vet = new int[n];
        System.out.println("Digite os números: ");
        for (int i = 0; i < n; i++) {
            vet[i] = scan.nextInt();
        }

        //just the display
        System.out.println("Vetor na ordem de digitação");
        for (int i = 0; i < n; i++) {
            System.out.println(vet[i]);
        }
        // System.out.println("Vetor na ordem inversa de digitação");
        // for (int i = n - 1; -1 < i; i--) {
        //     System.out.println(vet[i]);
        // }

        //Invertendo o vetor

       vet = Ineversos(vet);
        for (int i = 0; i < n; i++) {
            System.out.println(vet[i]);
        }
        scan.close();
    }

    public static int[] Ineversos(int[] vet){
    int temp;
    int numInverso = vet.length -1;
        for (int i = 0; i < vet.length/2; i++) {
            // System.out.println("Vetor na ordem inversa de digitação");
            temp = vet[i];
            vet[i] = vet[numInverso];
            vet[numInverso] = temp;
            numInverso--;
        }
        return vet;
    }
}
