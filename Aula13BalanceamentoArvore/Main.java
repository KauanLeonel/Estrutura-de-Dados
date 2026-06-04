
public class Main {

    public static void main(String[] args) {
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

a.Insert(1);
a.Insert(2);
a.Insert(3);
a.Insert(4);
a.Insert(5);
a.Insert(6);
a.Insert(7);
a.Insert(8);
a.Insert(9);
a.Insert(10);


a.exibeArvore(a.raiz, 0);

System.out.println("NOVA");
// NoA test = a.foundNoaAnt(60);
// test.dir = a.girarDireita(test.dir);

//a.rodar(50, 1);

//System.out.println(a.ehAVL(a.raiz)); // true
a.exibeArvore(a.raiz, 0);
a.balancear();
    }
}
