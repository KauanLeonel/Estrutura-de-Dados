
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

    public void found(int i) {
        NoA temp = raiz;
        while (temp != null) {
            if (temp.valor == i) {
                System.out.println("ACHOU");
                break;
            } else {
                if (temp.valor > i) {
                    temp = temp.esq;
                } else {
                    temp = temp.dir;
                }

            }
        }

    }

    public void insertExclusive(int x) {
        if (!foundBoolean(x)) {
            Insert(x);
        }
    }

    public boolean foundBoolean(int i) {
        NoA temp = raiz;
        boolean found = false;
        while (temp != null) {
            if (temp.valor == i) {
                found = true;
                break;
            } else {
                if (temp.valor > i) {
                    temp = temp.esq;
                } else {
                    temp = temp.dir;
                }

            }
        }
        return found;
    }

    public NoA foundNoa(int i) {
        NoA temp = raiz;
        while (temp != null) {
            if (temp.valor == i) {
                break;
            } else {
                if (temp.valor > i) {
                    temp = temp.esq;
                } else {
                    temp = temp.dir;
                }

            }
        }
        return temp;
    }

    public NoA foundNoaAnt(int i) {
        NoA temp = raiz;
        while (temp != null) {
            if ((temp.dir != null && temp.dir.valor == i) || (temp.esq != null && temp.esq.valor == i)) {
                break;
            } else {
                if (temp.valor > i) {
                    temp = temp.esq;
                } else {
                    temp = temp.dir;
                }

            }
        }
        return temp;
    }

    public int countChildren(int x) {
        if (!foundBoolean(x)) {
            return -1;
        }
        NoA temp = foundNoa(x);
        return tamanhoNext(temp) - 1;

    }

    public void removeTwoChildren(int x) {
        NoA no = foundNoa(x);

        NoA paiSucessor = no;
        NoA sucessor = no.dir;

        while (sucessor.esq != null) {
            paiSucessor = sucessor;
            sucessor = sucessor.esq;
        }

        no.valor = sucessor.valor;

        if (paiSucessor.esq == sucessor) {
            paiSucessor.esq = sucessor.dir;
        } else {
            paiSucessor.dir = sucessor.dir;
        }
    }

    public void removeOneChildren(int x) {
        NoA noAnt = foundNoaAnt(x);

        if (noAnt.dir.valor == x) {
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

    public void removeLeaf(int x) {
        NoA noAnt = foundNoaAnt(x);
        if (noAnt.dir != null && noAnt.dir.valor == x) {
            noAnt.dir = null;
        } else {
            noAnt.esq = null;
        }

    }

    public boolean ehFolha(NoA temp) {
        if ((temp.esq == null) && (temp.dir == null)) {
            return true;
        }
        return false;
    }

    public int profundidade(NoA temp) {
        if (temp != null) {
            if (ehFolha(temp)) {
                return 0;
            } else {
                int x = profundidade(temp.esq);
                int y = profundidade(temp.dir);
                int r = (x > y) ? x : y;
                return r + 1;
            }
        }
        return -1;
    }

    public void remove(int x) {
        if (raiz.valor == x) {
            if (raiz.esq == null && raiz.dir == null) {
                raiz = null;
            } else {
                if (raiz.esq == null && raiz.dir != null) {
                    raiz = raiz.dir;
                } else if (raiz.esq != null && raiz.dir == null) {
                    raiz = raiz.esq;
                } else {
                    removeTwoChildren(x);
                }
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

    static void exibeArvore(NoA n, int x) {

        if (n.dir != null) {
            exibeArvore(n.dir, x + 1);
        } else {
            System.out.println();
        }

        for (int i = 1; i <= x; i++) {
            System.out.print("|  ");
        }

        if ((n.esq == null) && (n.dir == null)) {
            System.out.print("[" + n.valor + "]");
        } else {
            System.out.print(n.valor);
        }

        if (n.esq != null) {
            exibeArvore(n.esq, x + 1);
        } else {
            System.out.println();
        }

    }

    public int fatorBalanceamento(NoA n) {
        int fb = (profundidade(n.dir) - profundidade(n.esq));
        return fb;
    }

    public void mostrarFB(NoA temp) {
        if (temp != null) {
            mostrarFB(temp.esq);
            System.out.println(temp.valor + " -> FB = " + (profundidade(temp.dir) - profundidade(temp.esq)));

            mostrarFB(temp.dir);
        }
    }

    public boolean verificarAVL(NoA temp, boolean eh) {
        if (eh != false) {

            if (temp != null) {

                int fb = (profundidade(temp.dir) - profundidade(temp.esq));
                if (fb != 0 && fb != 1 && fb != -1) {

                    eh = false;
                }

                verificarAVL(temp.esq, eh);
                verificarAVL(temp.dir, eh);
            }
        }
        return eh;
    }

    public boolean ehAVL(NoA n) {
        if (raiz == null) {
            return false;
        }
        boolean eh = true;
        eh = verificarAVL(n, eh);
        return eh;
    }

    private NoA girarDireita(NoA x) {
        NoA y = x.esq;
        NoA aux = y.dir;

        y.dir = x;
        x.esq = aux;

        return y;
    }

    private NoA girarEsquerda(NoA x) {
        NoA y = x.dir;
        NoA aux = y.esq;

        y.esq = x;
        x.dir = aux;

        return y;
    }

    // public void duplaGirarDireita(int x) {
    //     NoA temp = foundNoa(x);
    //     girarEsquerda(temp.dir.valor);
    //     girarDireita(x);
    // }
    // public void duplaGirarEsquerda(int x) {
    //     NoA temp = foundNoa(x);
    //     girarDireita(temp.esq.valor);
    //     girarEsquerda(x);
    // }
    public void rodar(NoA valor, int direcao) {
        if (direcao == -1) {
            girarEsquerda(valor);
        } else {
            girarDireita(valor);

        }

    }

    public void balancear() {
        if (raiz == null) {
            System.out.println("ÁRVORE VAZIA");
        } else {
            while (!ehAVL(raiz)) {
                limpeza(raiz);
            }
        }
    }

    public void limpeza(NoA temp) {

        if (temp != null) {
            limpeza(temp.esq);
            limpeza(temp.dir);
            System.out.println(" Fator de Balanceamento " + temp.valor + " : " + fatorBalanceamento(temp) + " EhAvl " + ehAVL(raiz));
            if (fatorBalanceamento(temp.dir) == 2) {
                //girarEsquerda(temp.valor);
                temp.dir = girarEsquerda(temp.dir);

            } else {
                if (fatorBalanceamento(temp) == -2) {
                    girarDireita(temp);
                }
            }

        }
    }
}
