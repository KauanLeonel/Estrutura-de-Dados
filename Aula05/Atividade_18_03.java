
public class Atividade_18_03 {

    public static void main(String[] args) {
        Pilha p1 = new Pilha();

        p1.empilhar(8);

        p1.empilhar(12);

        p1.empilhar(13);

        System.out.println(p1.topo());

        p1.desempilhar();

        if (!p1.vazia()) {
            p1.exibir();
        }

        Fila f1 = new Fila();

        f1.enfileirar(0);

        f1.enfileirar(4);

        f1.enfileirar(5);

        f1.desenfileirar();
        

        if (!f1.vazia()) {
            f1.exibir();
        }

    }

}
