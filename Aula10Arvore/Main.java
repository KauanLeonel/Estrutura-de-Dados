
public class Main {

    public static void main(String[] args) {
        Arvore tree = new Arvore();
        tree.Insert(11);
        tree.Insert(8);

        tree.Insert(37);

        tree.Insert(9);

        tree.Insert(18);

        tree.Insert(29);

        tree.Insert(27);
        tree.insertExclusive(27);
        tree.insertExclusive(28);

        System.out.println("EXIBIR");
        tree.exibir();
        System.out.println("Menor");
        tree.menor();
        tree.maior();
        System.out.println("Tamanho " +    tree.tamanho());
        

        //tree.found(37);
        System.out.println(tree.countChildren(9));

    }
}
