
import java.util.Scanner;

public class AtividadeLivros {

    static NoLivro inicio = null;

    public static void main(String[] args) {
        cadastrarLivro("LORENZI, F.; MATTOS, P. N.; CARVALHO, T. P.", "Estruturas de dados", "1ª edição", "São Paulo", "Thomson Learning", 2007);
        cadastrarLivro("PEREIRA, S. L.", "Estrutura de dados fundamentais: conceitos e aplicações", "12ª edição", "São Paulo", "Érica", 2008);
        cadastrarLivro("LAFORE, R.", "Estrutura de dados & algoritmos em java", "1ª edição", "Rio de Janeiro", "Ciência Moderna", 2004);
        cadastrarLivro("SZWARCFITER, J. L.; MARKENZON, L.", "Estruturas de dados e seus algoritmos", "3ª edição", "Rio de Janeiro", "LTC", 2010);
        cadastrarLivro("PREISS, B. R.", "Estruturas de dados e algoritmos: pradrões de projetos orientados a objeto com java", "1ª edição", "Rio de Janeiro", "Elsevier", 2000);
        cadastrarLivro("WIRTH, N.", "Algoritmos e estruturas de dados", "1ª edição", "Rio de Janeiro", "LTC", 2008);
        cadastrarLivro("CELES, W. ; CERQUEIRA, R.; RANGEL, J. L.", "Introdução a estruturas de dados com técnicas de programação em C", "1ª edição", "Rio de Janeiro", "Elsevier", 2004);
        cadastrarLivro("GUIMARÃES, Â. M.; LAGES, N. A. C.", "Algoritmos e estruturas de dados", "1ª edição", "Rio de Janeiro", "LTC", 2008);

        Scanner teclado = new Scanner(System.in);

        String opcao;

        // ANTENÇÃO, EXIBA AS INFORMAÇÕES SIMPLES DO PRIMEIRO LIVRO ANTES DE ENTRAR NO MENU
        System.out.println("Livro: " + inicio.livro);
        do {
            System.out.print("\nINFORME A OPÇÃO DESEJADA\n"
                    + "\"a\" para avançar\n"
                    + "\"r\" para retroceder\n"
                    + "\"d\" para detalhar\n"
                    + "\"s\" para sair\n"
                    + "ESCOLHA:");

            opcao = teclado.nextLine();


            if (opcao.equals("a")) {
                inicio = inicio.prox;

                System.out.println("\nLIVRO ATUAL: " + inicio.livro);
            } else if (opcao.equals("r")) {
                inicio = inicio.ant;
                System.out.println("\nLIVRO ATUAL: " + inicio.livro);

            } else if (opcao.equals("d")) {
                System.out.println("\nLIVRO ATUAL DETALHADO");
                System.out.println(
                        "Livro - " + inicio.livro
                        + "\nAutor - " + inicio.autor
                        + "\nEdição - " + inicio.edicao
                        + "\nCidade - " + inicio.cidade
                        + "\nEditora - " + inicio.editora
                        + "\nAno - " + inicio.ano
                );
            }

        } while (!opcao.equals("s"));

    }

    public static class NoLivro {

        NoLivro prox = null;
        NoLivro ant = null;
        String autor;
        String livro;
        String edicao;
        String cidade;
        String editora;
        int ano;

        public NoLivro(String autor, String livro, String edicao, String cidade, String editora, int ano) {
            this.autor = autor;
            this.livro = livro;
            this.edicao = edicao;
            this.cidade = cidade;
            this.editora = editora;
            this.ano = ano;

        }

    }

     public static void exibir(){
        NoLivro temp = inicio;
        do { 
            System.out.println("AUTOR - " + temp.autor);
            temp = temp.prox;
        } while (temp == inicio);
    }
    public static void cadastrarLivro(String autor, String livro, String edicao, String cidade, String editora, int ano) {
        NoLivro temp = new NoLivro(autor, livro, edicao, cidade, editora, ano);
        if (inicio == null) {
            inicio = temp;
            inicio.ant = temp;
            inicio.prox = temp;
        } else {
            temp.prox = inicio;
            temp.ant = inicio.ant;
            inicio.ant.prox = temp;
            inicio.ant = temp;
        }

    }

   

}
