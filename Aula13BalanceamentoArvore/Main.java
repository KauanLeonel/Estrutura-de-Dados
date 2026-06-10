import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  throws FileNotFoundException  {
        // Arvore tree = new Arvore();
        // tree.Insert(11);
        // tree.Insert(8);

        // tree.Insert(37);

        // tree.Insert(9);

        // tree.Insert(18);

        // tree.Insert(29);

        // tree.Insert(27);
        // tree.insertExclusive(27);
        // tree.insertExclusive(28);

        // System.out.println("EXIBIR");
        // tree.exibir();
        // System.out.println("Menor");
        // tree.menor();
        // tree.maior();
        // System.out.println("Tamanho " +    tree.tamanho());
        

        // //tree.found(37);
        // tree.mostrarFB(tree.raiz);
        // System.out.println("É balanceada: " + tree.ehAVL(tree.raiz));
Arvore a = new Arvore();

 Scanner leitor = new Scanner(new File("entrada.txt"));

        while (leitor.hasNextInt()) {
            int numero = leitor.nextInt();
            a.insertExclusive(numero);
        }

        leitor.close();

a.exibeArvore(a.raiz, 0);

System.out.println("NOVA");
// NoA test = a.foundNoaAnt(60);
// test.dir = a.girarDireita(test.dir);

//a.rodar(50, 1);
//a.balancear();
//System.out.println(a.ehAVL(a.raiz)); // true
a.exibeArvore(a.raiz, 0);
System.out.println("Tamanho: " + a.tamanho() + 
"\nProfundidade: "     + a.profundidade(a.raiz)
 + "\nProfundidade da árvore a direita da raiz: "  + a.profundidade(a.raiz.dir)
 + "\nProfundidade da árvore a esquerda da raiz: "  + a.profundidade(a.raiz.esq));
    
 a.raiz = a.girarEsquerda(a.raiz);
 a.raiz = a.girarEsquerda(a.raiz);

System.out.println("\nProfundidade da árvore a direita da raiz: "  + a.profundidade(a.raiz.dir)
 + "\nProfundidade da árvore a esquerda da raiz: "  + a.profundidade(a.raiz.esq));
    
a.RemoverMultiplo(3);
a.RemoverMultiplo(5);
a.RemoverMultiplo(7);

System.out.println("Tamanho: " + a.tamanho() + 
"\nProfundidade: "     + a.profundidade(a.raiz)
 + "\nProfundidade da árvore a direita da raiz: "  + a.profundidade(a.raiz.dir)
 + "\nProfundidade da árvore a esquerda da raiz: "  + a.profundidade(a.raiz.esq));
    
}

    
}
