
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
        // tree.exibir();

        while (true) {
            System.out.println("INSIRA A POSIÇÃO FIXA (EX: Palvra 'MORTE', posição 'M***E'");
            String fixa = sc.nextLine();
            fixa = fixa.replace("*", ".").toUpperCase();
            tree.fixo(fixa);
            System.out.println("INSIRA as letras que tem na palavra, mas estão no lugar errado:");
            fixa = sc.nextLine().toUpperCase();
            tree.tem(fixa);
            System.out.println("INSIRA as letras que não tem na palavra:");
            fixa = sc.nextLine().toUpperCase();
            tree.nTem(fixa);
            tree.exibir();
        }
    }

    private static String removerAcentos(String palavra) {

        for (int i = 0; i < 5; i++) {
            String troca = palavra;
            switch ((int) palavra.charAt(i)) {
                case 192:
                    troca = palavra.replace('À', 'A');
                    break;
                case 193:
                    troca = palavra.replace('Á', 'A');
                    break;
                case 194:
                    troca = palavra.replace('Â', 'A');
                    break;
                case 195:
                    troca = palavra.replace('Ã', 'A');
                    break;
                case 199:
                    troca = palavra.replace('Ç', 'C');
                    break;
                case 200:
                    troca = palavra.replace('È', 'E');
                    break;
                case 201:
                    troca = palavra.replace('É', 'E');
                    break;
                case 202:
                    troca = palavra.replace('Ê', 'E');
                    break;
                case 204:
                    troca = palavra.replace('Ì', 'I');
                    break;
                case 205:
                    troca = palavra.replace('Í', 'I');
                    break;
                case 210:
                    troca = palavra.replace('Ò', 'O');
                    break;
                case 211:
                    troca = palavra.replace('Ó', 'O');
                    break;
                case 212:
                    troca = palavra.replace('Ô', 'O');
                    break;
                case 213:
                    troca = palavra.replace('Õ', 'O');
                    break;
                case 217:
                    troca = palavra.replace('Ù', 'U');
                    break;
                case 218:
                    troca = palavra.replace('Ú', 'U');
                    break;
            }
            palavra = troca;

        }

        return palavra;
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
                // System.out.println(palavras[i]);
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
                    // System.out.println(palavras[i]);
                    palavras[i] = removerAcentos(palavras[i]);
                    tree.insertExclusive(palavras[i]);
                }
            }
            // System.out.println(linha);
            linha = buffRead.readLine();
        }

        buffRead.close();

    }

}
