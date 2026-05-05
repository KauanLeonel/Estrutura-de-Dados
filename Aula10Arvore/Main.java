
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
        System.out.println("EXIBIR");
        System.out.println(tree.tamanho());
        System.out.println("Menor");
        tree.menor();
        tree.maior();
        System.out.println("Tamanho " +    tree.tamanho());
     

    }
}
