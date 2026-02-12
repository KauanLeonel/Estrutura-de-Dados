import java.util.Scanner;

public class Exercicio7 {
    //Crie uma função recursiva que receba uma string e retorne ela invertida.
    public static char[] Ineversos(char[] vet){
    char temp;
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
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Escreva uma frase: ");
        String n = s.nextLine();
        char[] letras = n.toCharArray();
        letras = Ineversos(letras);
        for (int i = 0; i < letras.length; i++) {
            System.out.print(letras[i]);
        }
    }
}
