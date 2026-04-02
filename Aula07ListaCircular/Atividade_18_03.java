
public class Atividade_18_03 {

    public static void main(String[] args) {
        CircularList p1 = new CircularList();

        p1.insereFinal(8);

        //p1.insereFinal(12);

        //p1.insereFinal(11);

        //p1.insereInicio(13);

        p1.RemoveInicio();

        //p1.RemoveFinal();



        
        

        if (!p1.vazia()) {
            p1.inicio();
            p1.exibir();
            p1.ultimo();
        }


    }

}
