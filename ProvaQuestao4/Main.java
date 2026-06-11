import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  throws FileNotFoundException  {
     
Arvore a = new Arvore();

 Scanner leitor = new Scanner(new File("entrada.txt"));

        while (leitor.hasNextInt()) {
            int numero = leitor.nextInt();
            a.Insert(numero);
        }

        leitor.close();


System.out.println("Tamanho: " + a.tamanho() + 
"\nProfundidade: "     + a.profundidade(a.raiz)
 + "\nProfundidade da árvore a direita da raiz: "  + a.profundidade(a.raiz.dir)
 + "\nProfundidade da árvore a esquerda da raiz: "  + a.profundidade(a.raiz.esq));

 a.filhosDeUm();




}


    
}
