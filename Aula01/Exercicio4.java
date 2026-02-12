import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercicio4 {
    public static void main(String[] args) {

        /*
         * Crie um programa em JAVA que faça a leitura de um arquivo de texto contendo
         * um número inteiro em
         * cada linha onde: O número da primeira linha é o valor de N e os números
         * subsequentes são a
         * sequência numérica de interesse. Armazene os valores lidos em um vetor e
         * exiba-o. Aproveite sua
         * implementação do Exercício 1. e escreva em outro arquivo a sequência numérica
         * em ordem inversa.
         */

        try {
            int[] vet = ler();
            for (int i = 0; i < vet.length; i++) {
                System.out.println(vet[i]);
            }
            escrever(vet);
            Exercicio1 inver = new Exercicio1();
            vet = inver.Ineversos(vet);
            for (int i = 0; i < vet.length; i++) {
                System.out.println(vet[i]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    private static int[] ler() throws FileNotFoundException, IOException {

        String arqLeitura = "textoEntrada.txt";

        BufferedReader buffRead = new BufferedReader(new FileReader(arqLeitura));

        // Primeira linha = tamanho do vetor
        int n = Integer.parseInt(buffRead.readLine());

        int[] vet = new int[n];

        String linha;
        int i = 0;

        while ((linha = buffRead.readLine()) != null && i < n) {
            vet[i] = Integer.parseInt(linha);
            i++;
        }

        buffRead.close();

        return vet;
    }

    private static void escrever(int vet[]) throws IOException {
        String x = "";
        for (int i = 0; i < vet.length; i++) {
            x += vet[i] + "\n";
        }

        String arqEscrita = "textoSaida.txt";
        // ESCRITA

        System.out.println("Escrevendo no arquivo " + arqEscrita);
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(arqEscrita, false));

        buffWrite.append(x);
        buffWrite.close();
    }
}
