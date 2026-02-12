
import java.util.Scanner;

public class Exercicio6 {

    public static int digitos(int n, int res){
        if(n < 9){
            return res;
        } else{
            return digitos(n/10, res + 1);
        }
        
    }

    //Faça uma função recursiva que conte quantos dígitos tem um número inteiro positivo entre 0 e 99.999.
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o valor de 0 a 99.999: ");
        n = s.nextInt();
        System.out.println(digitos(n, 1));
    }
}
