
public class LinkedList {

    public class listaLinkada {

        no inicio = null;

        public listaLinkada() {
            inicio = null;
        }

        public void insert(int newValue) {
            no novoNo = new no(newValue);
            if (inicio == null) {
                inicio = novoNo;
            } else {
                no temp = inicio;
                //System.out.println(temp.value);
                while (temp.proximo != null) {
                    temp = temp.proximo;
                }
                temp.proximo = novoNo;
            }
        }

        public void show() {
            if (inicio == null) {
                System.out.println("Lista vazia otário");
                return;
            }

            no temp = inicio;
            System.out.println("EXIBINDO: ");
            while (temp.proximo != null) {
                System.out.println(temp.value);
                temp = temp.proximo;
            }
            System.out.println(temp.value);
        }

        public void deleteLast() {
            no temp = inicio;
            System.out.println("Excluindo último valor: ");
            while (temp.proximo.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = null;
            show();
        }

    }

    public class listaLinkadaOrdered {

        no inicio = null;

        public listaLinkadaOrdered() {
            inicio = null;
        }

        public void insert(int newValue) {
            no novoNo = new no(newValue);
            if (inicio == null) {
                inicio = novoNo;
            } else if (inicio.proximo == null) {
                inicio.proximo = novoNo;
                if(inicio.value > inicio.proximo.value){
                    int temp = inicio.value;
                    inicio.value = inicio.proximo.value;
                    inicio.proximo.value = temp;
                }  
            } else{
                no temp = inicio;
                no temp2 = temp;
                //System.out.println(temp.value);
                while (novoNo.value > temp.value) {
                    temp2 = temp;
                    temp = temp.proximo;
                }
                novoNo.proximo = temp;
                temp2.proximo = novoNo;
            }
        }

        public void show() {
            if (inicio == null) {
                System.out.println("Lista vazia otário");
                return;
            }

            no temp = inicio;
            System.out.println("EXIBINDO: ");
            while (temp.proximo != null) {
                System.out.println(temp.value);
                temp = temp.proximo;
            }
            System.out.println(temp.value);
        }

        public void deleteLast() {
            no temp = inicio;
            System.out.println("Excluindo último valor: ");
            while (temp.proximo.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = null;
            show();
        }

    }

    public class no {

        int value;
        no proximo = null;

        public no(int value) {
            this.value = value;
        }

    }

    public void main(String[] args) {
        listaLinkadaOrdered inicio = new listaLinkadaOrdered();
        System.out.println("Teste");
        inicio.insert(9);
        inicio.show();

        inicio.insert(3);
        inicio.show();
        inicio.insert(8);
        inicio.show();
        inicio.insert(7);
        inicio.show();
        inicio.insert(6);
        inicio.show();
        inicio.insert(5);
        inicio.show();

        inicio.deleteLast();
    }
}
