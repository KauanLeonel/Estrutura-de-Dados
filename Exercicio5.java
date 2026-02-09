import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Exercicio5 {

    // public static int[] recursividade(int vet[], int c){
    //     for(int i = c -2; i < vet.length; i++){//Começa do 0
    //         for (int j = 0; j < c - 1; j++) {
    //             System.out.println(vet[j]);
    //         }
    //         System.out.println(vet[i]);
    //     }
    //     return vet2[];
    // }
    public static void main(String[] args) {
        int n, c;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        // System.out.println("Digite o valor de n:");
        // n = scan.nextInt();
        // int[] vet = new int[n];
        // for (int i = 0; i < n; i++) {
        //     vet[i] = rand.nextInt(n - 0) + 1;
        // }
        int[] vet = {42, 9, 71, 66, 43};
        n = vet.length;
        c = 3;
        Queue<Integer> fila = new LinkedList<>();
        for (int i = 0; i < vet.length; i++) {
            fila.add(vet[i]);
        }
        while(fila.size() != c){
        LinkedList<Integer> lista = new LinkedList<>(fila);
         for(int i = c -1; i < lista.size(); i++){//Começa do 0
            for (int j = 0; j < c - 1; j++) {
                System.out.print(lista.get(j) + ",");
            }
            System.out.println(lista.get(i));
            System.out.println("PULO");
        }
        fila.remove();
    }
            LinkedList<Integer> lista = new LinkedList<>(fila);
            for (int j = 0; j < c; j++) {
                System.out.print(lista.get(j) + " ");
            }

    }
}
