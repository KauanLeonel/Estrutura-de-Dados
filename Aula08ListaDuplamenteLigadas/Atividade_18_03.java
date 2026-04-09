
public class Atividade_18_03 {

    public static void main(String[] args) {
        CircularListOrden p1 = new CircularListOrden();

        p1.inserir(5);
        p1.inserir(1);
        p1.inserir(4);
        p1.inserir(2);
        p1.inserir(7);
        p1.inserir(6);
        p1.inserir(3);
        p1.Remover(2);
        p1.Remover(5);

        //p1.RemoveInicio();

        //p1.RemoveFinal();


        
        

        if (!p1.vazia()) {
            p1.inicio();
            p1.exibir();
            p1.ultimo();
        }


    }

}
