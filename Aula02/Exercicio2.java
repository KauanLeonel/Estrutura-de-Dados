import java.util.Scanner;

public class Exercicio2{

    //Implemente o método recursivo fatorial(x) que retorna o fatorial de x

    public static int fatorial(int i ){
        if(i == 1){
           return i;
        } 
        return i * fatorial(i -1);
        
    }
    public static void main(String[] args) {
         int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o valor: ");
        n = s.nextInt();
        System.out.println(fatorial(n));
    }
}