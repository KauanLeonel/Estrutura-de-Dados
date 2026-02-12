import java.util.Scanner;

public class Recursividade {

    public static void Recursividade(int i, int n){
        if(i == n){
            System.out.println(i);
        } else{
            System.out.println(i);
            Recursividade(i + 1, n);
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o valor a ser mostrado na tela de 1 até ele: ");
        n = s.nextInt();
        Recursividade(1, n);
    }
}
