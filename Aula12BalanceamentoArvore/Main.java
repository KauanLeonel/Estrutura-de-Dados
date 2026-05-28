
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

a.Insert(40);
a.Insert(20);
a.Insert(60);
a.Insert(10);
a.Insert(30);
a.Insert(50);
a.Insert(70);
a.Insert(5);
a.Insert(15);
a.Insert(25);
a.Insert(35);

NoA test = a.foundNoaAnt(60);
test.dir = a.girarDireita(test.dir);

//System.out.println(a.ehAVL(a.raiz)); // true
a.exibeArvore(a.raiz, 0);
    }
}
