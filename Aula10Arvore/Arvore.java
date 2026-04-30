
public class Arvore {

    NoA raiz = null;

    public void Insert(int x) {
        NoA novo = new NoA(x);

        if (raiz == null) {
            raiz = novo;
        } else {

            NoA temp = raiz;
            while (true) {
                if (x <= temp.valor) {
                    if (temp.esq == null) {
                        temp.esq = novo;
                        break;
                    } else {
                        temp = temp.esq;
                    }
                } else {
                    if (temp.dir == null) {
                        temp.dir = novo;
                        break;
                    } else {
                        temp = temp.dir;
                    }
                }
            }
        }
    }

    public int exibirNext(NoA temp) {
        int i = 0;
        if (temp != null) {
            if (temp.valor <= temp.esq.valor)
            return exibirNext(temp.esq);
            System.out.println(temp.valor);
            exibirNext(temp.dir);
        }
        return i;
    }

    public void exibir() {
        exibirNext(raiz);
    }

     public void menorNext(NoA temp) {
        if (temp != null) {
            if(temp.dir)
            menorNext(temp.esq);
            System.out.println(temp.valor);
            menorNext(temp.dir);
        }
    }

    public void menor() {
        exibirNext(raiz);
    }

    public void folhasNext(NoA temp) {
        if (temp != null) {
            folhasNext(temp.esq);
            if ((temp.esq == null) && (temp.dir == null)) {
                System.out.print("[" + temp.valor + "]");
            }
            folhasNext(temp.dir);
        }
    }

    public void folhas() {
        folhasNext(raiz);
    }

      public int tamanhoNext(NoA temp) {
        int i = 1;
        if (temp != null) {
            i = i + tamanhoNext(temp.esq);
            i = i + tamanhoNext(temp.dir);  
            return i;
        } else{
            return 0;
        }
    }

    public int tamanho() {
        return tamanhoNext(raiz);
    }
    

    public void Show() {

        Arvore exibir = this;

        while (exibir.raiz != null) {
            NoA temp = raiz;
            while (true) {
                while (temp.esq != null) {
                    if (temp.esq.dir == null && temp.esq.esq == null) {
                        System.out.println(temp.valor);
                        temp.esq = null;
                        break;
                    } else {
                        temp = temp.esq;
                    }
                }
                while (temp.dir != null) {
                    if (temp.dir.dir == null && temp.dir.esq == null) {
                        System.out.println(temp.valor);
                        temp.dir = null;
                        break;
                    } else {
                        temp = temp.dir;
                    }
                }

            }
        }
    }
}
