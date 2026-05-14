import java.util.ArrayList;

public class Arvore {

    NoA raiz = null;

    public void Insert(String x) {
        NoA novo = new NoA(x);

        if (raiz == null) {
            raiz = novo;
        } else {

            NoA temp = raiz;
            while (true) {
                int comparar = novo.valor.compareTo(temp.valor);
                if (comparar < 0) {
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

    public void fixoNext(NoA temp, String fixa, ArrayList remover) {
        if (temp != null) {
            fixoNext(temp.esq, fixa, remover);
            if (!temp.valor.matches(fixa)) {
                remover.add(temp.valor);
            }
            fixoNext(temp.dir, fixa, remover);
        }
    }

    public void fixo(String fixa) {
        ArrayList<String> remover = new ArrayList<>();
        fixoNext(raiz, fixa, remover);
        while (!remover.isEmpty()) {
            remove(remover.get(0));
            remover.remove(0);
        }

    }

    public void temNext(NoA temp, String fixa, ArrayList remover) {
        if (temp != null) {
            temNext(temp.esq, fixa, remover);
            for (int i = 0; i < fixa.length(); i++) {
                if (temp.valor.indexOf(fixa.charAt(i)) == -1) {
                    remover.add(temp.valor);
                    break;
                }
            }
            temNext(temp.dir, fixa, remover);
        }

    }

    public void tem(String fixa) {
        ArrayList<String> remover = new ArrayList<>();
        temNext(raiz, fixa, remover);
        while (!remover.isEmpty()) {
            remove(remover.get(0));
            remover.remove(0);
        }

    }

    public void nTemNext(NoA temp, String fixa, ArrayList remover) {
        if (temp != null) {
            nTemNext(temp.esq, fixa, remover);
            for (int i = 0; i < fixa.length(); i++) {
                if (temp.valor.indexOf(fixa.charAt(i)) != -1) {
                    remover.add(temp.valor);
                    break;
                }
            }
            nTemNext(temp.dir, fixa, remover);
        }

    }

    public void nTem(String fixa) {
        ArrayList<String> remover = new ArrayList<>();
        nTemNext(raiz, fixa, remover);
        while (!remover.isEmpty()) {
            remove(remover.get(0));
            remover.remove(0);
        }

    }

    public void exibirNext(NoA temp) {
        if (temp != null) {
            exibirNext(temp.esq);
            System.out.println(temp.valor);
            exibirNext(temp.dir);
        }
    }

    public void exibir() {
        exibirNext(raiz);
    }

    public void menor() {
        NoA temp = raiz;
        while (temp.esq != null) {
            temp = temp.esq;
        }
        System.out.println(temp.valor);
    }

    public void maior() {
        NoA temp = raiz;
        while (temp.dir != null) {
            temp = temp.dir;
        }
        System.out.println(temp.valor);
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
        } else {
            return 0;
        }
    }

    public int tamanho() {
        return tamanhoNext(raiz);
    }

    public void found(String i) {
        NoA temp = raiz;
        while (temp != null) {
            if (temp.valor.equals(i)) {
                System.out.println("ACHOU");
                break;
            } else {
                int comparar = temp.valor.compareTo(i);
                if (comparar > 0) {
                    temp = temp.esq;
                } else {
                    temp = temp.dir;
                }

            }
        }

    }

    public void insertExclusive(String x) {
        if (!foundBoolean(x)) {
            Insert(x);
        }
    }

    public boolean foundBoolean(String i) {
        NoA temp = raiz;
        boolean found = false;
        while (temp != null) {
            if (temp.valor.equals(i)) {
                found = true;
                break;
            } else {
                int comparar = temp.valor.compareTo(i);
                if (comparar > 0) {
                    temp = temp.esq;
                } else {
                    temp = temp.dir;
                }

            }
        }
        return found;
    }

    public NoA foundNoa(String i) {
        NoA temp = raiz;
        while (temp != null) {
            if (temp.valor.equals(i)) {
                break;
            } else {
                int comparar = temp.valor.compareTo(i);
                if (comparar > 0) {
                    temp = temp.esq;
                } else {
                    temp = temp.dir;
                }

            }
        }
        return temp;
    }

    public NoA foundNoaAnt(String i) {
        NoA temp = raiz;
        while (temp != null) {
            if ((temp.dir != null && temp.dir.valor.equals(i)) ||
                    (temp.esq != null && temp.esq.valor.equals(i))) {
                break;
            } else {
                int comparar = temp.valor.compareTo(i);
                if (comparar > 0) {
                    temp = temp.esq;
                } else {
                    temp = temp.dir;
                }

            }
        }
        return temp;
    }

    public int countChildren(String x) {
        NoA temp = foundNoa(x);

        if (temp == null) {
            return -1;
        }

        int filhos = 0;

        if (temp.esq != null) {
            filhos++;
        }

        if (temp.dir != null) {
            filhos++;
        }

        return filhos;
    }

    public void removeTwoChildren(String x) {
        NoA no = foundNoa(x);

        if (no == null) {
            return;
        }

        if (no.esq == null || no.dir == null) {
            return;
        }

        NoA paiMenor = no;
        NoA menor = no.dir;

        while (menor.esq != null) {
            paiMenor = menor;
            menor = menor.esq;
        }

        no.valor = menor.valor;

        if (paiMenor.esq == menor) {
            paiMenor.esq = menor.dir;
        } else {
            paiMenor.dir = menor.dir;
        }
    }

    public void removeOneChildren(String x) {
        NoA noAnt = foundNoaAnt(x);

        if (noAnt == null) {
            return;
        }

        if (noAnt.dir != null && noAnt.dir.valor.equals(x)) {
            if (noAnt.dir.dir == null) {
                noAnt.dir = noAnt.dir.esq;
            } else {
                noAnt.dir = noAnt.dir.dir;
            }

        } else {

            if (noAnt.esq.dir == null) {
                noAnt.esq = noAnt.esq.esq;
            } else {
                noAnt.esq = noAnt.esq.dir;
            }
        }

    }

    public void removeLeaf(String x) {
        NoA noAnt = foundNoaAnt(x);
        if (noAnt.dir != null && noAnt.dir.valor.equals(x)) {
            noAnt.dir = null;
        } else if (noAnt.esq != null && noAnt.esq.valor.equals(x)) {
            noAnt.esq = null;
        }

    }

    public void remove(String x) {
        if (raiz == null) {
            return;
        }

        if (raiz.valor.equals(x)) {
            if (raiz.esq == null && raiz.dir == null) {
                raiz = null;
            } else if (raiz.esq == null) {
                raiz = raiz.dir;
            } else if (raiz.dir == null) {
                raiz = raiz.esq;
            } else {
                removeTwoChildren(x);
            }
        } else {
            int f = countChildren(x);
            switch (f) {
                case -1:
                    System.out.println("O nó não existe na árvore");
                    break;
                case 0:
                    removeLeaf(x);
                    break;
                case 1:
                    removeOneChildren(x);
                    break;
                default:
                    removeTwoChildren(x);
                    break;

            }
        }
    }
}
