import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  throws FileNotFoundException  {
     
Arvore a = new Arvore();

 Scanner leitor = new Scanner(new File("entrada.txt"));

        while (leitor.hasNextInt()) {
            int numero = leitor.nextInt();
            a.insertExclusive(numero);
        }

        leitor.close();


System.out.println("Tamanho: " + a.tamanho() + 
"\nProfundidade: "     + a.profundidade(a.raiz)
 + "\nProfundidade da árvore a direita da raiz: "  + a.profundidade(a.raiz.dir)
 + "\nProfundidade da árvore a esquerda da raiz: "  + a.profundidade(a.raiz.esq));


a.exibeArvore(a.foundNoaAnt(2731), 0);

NoA troca = a.foundNoaAnt(2731) ;
System.out.println(troca.esq.valor);
troca.esq = a.girarEsquerda(troca.esq);
System.out.println(troca.esq.valor);


a.exibeArvore(a.foundNoaAnt(2731), 0);
System.out.println(a.fatorBalanceamentoInverso(a.foundNoa(2731)));



}


    
}
