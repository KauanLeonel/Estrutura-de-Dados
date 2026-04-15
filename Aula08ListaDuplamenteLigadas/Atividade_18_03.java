
public class Atividade_18_03 {

    public static void main(String[] args) {
        CircularList p1 = new CircularList();

        p1.insereFinal(5);
        p1.insereFinal(1);
        p1.insereFinal(4);
        p1.insereFinal(2);
        p1.insereInicio(7);
        p1.insereInicio(6);
        p1.insereInicio(3);
        p1.RemoveInicio();
        p1.RemoveFinal();

        //p1.RemoveInicio();

        //p1.RemoveFinal();


        
        

        if (!p1.vazia()) {
            p1.inicio();
            p1.exibir();
            p1.ultimo();
        }


    }

}
