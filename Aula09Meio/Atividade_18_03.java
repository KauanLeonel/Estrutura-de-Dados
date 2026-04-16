
public class Atividade_18_03 {

    public static void main(String[] args) {
        int N = 10;
        CircularListInfinit p1 = new CircularListInfinit();

        for (int i = 0; i < N; i++) {
            p1.insereFinal(i);
        }

        
        

        if (!p1.vazia()) {
            p1.inicio();
            p1.exibir();
            p1.ultimo();
        }

        System.out.println("METADE: " + p1.meio() );

    }

}
