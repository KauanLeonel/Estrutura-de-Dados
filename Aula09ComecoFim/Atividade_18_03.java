
public class Atividade_18_03 {

    public static void main(String[] args) {
        int N = 11;
        CircularListInfinit p1 = new CircularListInfinit();

        for (int i = 0; i < N; i++) {
            p1.insereFinal(i);
        }


        //p1.RemoveInicio();

        //p1.RemoveFinal();


        
        

        if (!p1.vazia()) {
            p1.inicio();
            p1.exibir();
            p1.ultimo();
        }


        exibicicao(p1.primeiro(), p1.primeiro().ant);

    }

    static void exibicicao(No inicio, No fim){
        if(inicio != fim){
        System.out.println(inicio.valor + " " + fim.valor);}
        else{
            System.out.println(inicio.valor);
        }
        if(inicio.valor != fim.valor && inicio.prox.valor != fim.valor ){
        exibicicao(inicio.prox, fim.ant);
        }
    }

}
