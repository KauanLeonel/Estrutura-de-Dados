
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
            if (temp.dir.valor == i || temp.esq.valor == i) {
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
        NoA noAnt = foundNoa(x);

        NoA temp = noAnt.dir;
        while (temp.esq.esq != null) {
            temp = temp.esq;
        }
        noAnt.valor = temp.esq.esq.valor;
        temp.esq.esq = null;

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
        NoA noAnt = foundNoa(x);
        if (noAnt.dir.valor == x) {
            noAnt.dir = null;
        } else {
            noAnt.esq = null;
        }

    }

    public void remove(int x) {
        if (raiz.valor == x) {
            if (raiz.esq == null && raiz.dir == null) {
                raiz = null;
            } else {
                if (raiz.esq == null && raiz.dir != null) {
                    raiz = raiz.dir;
                }
                if (raiz.esq != null && raiz.dir == null) {
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

        // public void Show() {
        //     Arvore exibir = this;
        //     while (exibir.raiz != null) {
        //         NoA temp = raiz;
        //         while (true) {
        //             while (temp.esq != null) {
        //                 if (temp.esq.dir == null && temp.esq.esq == null) {
        //                     System.out.println(temp.valor);
        //                     temp.esq = null;
        //                     break;
        //                 } else {
        //                     temp = temp.esq;
        //                 }
        //             }
        //             while (temp.dir != null) {
        //                 if (temp.dir.dir == null && temp.dir.esq == null) {
        //                     System.out.println(temp.valor);
        //                     temp.dir = null;
        //                     break;
        //                 } else {
        //                     temp = temp.dir;
        //                 }
        //             }
        //         }
        //     }
        // }
    }
}
