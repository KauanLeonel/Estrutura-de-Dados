
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Termo {

    public static void main(String[] args) throws IOException {
        Arvore tree = new Arvore();
        Scanner sc = new Scanner(System.in);
        ler(tree);
        tree.exibir();

        System.out.println("INSIRA A POSIÇÃO FIXA (EX: Palvra 'MORTE', posição 'M***E'");
        String fixa = sc.nextLine();
        fixa = fixa.replace("*", ".").toUpperCase();
        tree.fixo(fixa);
         System.out.println("INSIRA as letras que tem na palavra, mas estão no lugar errado:");
        fixa = sc.nextLine().toUpperCase();
        //Tirar as que não possuem
        System.out.println("INSIRA as letras que não tem na palavra:");
        fixa = sc.nextLine().toUpperCase();        
        //Tirar as palavras que tem as letras
        tree.exibir();
    }

    private static void ler(Arvore tree) throws FileNotFoundException, IOException {

        String arqLeitura = "Entrada.txt";

        BufferedReader buffRead = new BufferedReader(new FileReader(arqLeitura));

        // Primeira linha = tamanho do vetor
        String linha = buffRead.readLine();
        String[] palavras;
        while (linha != null) {
            palavras = linha.split(" ");
            for (int i = 0; i < palavras.length; i++) {
                boolean veri = true;
                //System.out.println(palavras[i]);
                if (palavras[i].length() != 5) {
                    veri = false;
                }
                for (int j = 0; j < palavras[i].length(); j++) {
                    if (palavras[i].charAt(j) < 65 || palavras[i].charAt(j) > 122) {
                        veri = false;
                    }
                    if (palavras[i].charAt(j) < 97 && palavras[i].charAt(j) > 90) {
                        veri = false;
                    }

                    
                }
                if (veri) {
                    palavras[i] = palavras[i].toUpperCase();
                    //System.out.println(palavras[i]);
                    tree.insertExclusive(palavras[i]);
                }
            }
            //System.out.println(linha);
            linha = buffRead.readLine();
        }

        buffRead.close();

    }

}
