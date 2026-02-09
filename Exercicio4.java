import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercicio4 {
    public static void main(String[] args) {
        try {
            int[] vet = ler();
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
        String linha = buffRead.readLine();
        int[] vet = new int[Integer.parseInt(linha)];
        int i = 1;
                    linha = buffRead.readLine();

        while (linha != null) {
            System.out.println(linha);
            linha = buffRead.readLine();
            vet[i] = Integer.parseInt(linha);
        }
        buffRead.close();
        return vet;
    }
       private static void escrever(int vet[]) throws IOException {
        String x = "";
    //------------------------------------------------------------------------------------------------
        for (int i = 0; i < vet.length; i++) {
        //    x += vet[i].toString();
        }
        String arqEscrita = "textoSaida.txt";
        // ESCRITA

        System.out.println("Escrevendo no arquivo " + arqEscrita);
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(arqEscrita,false));
        buffWrite.append(x + "\n");
        buffWrite.append("isso eh um teste" + "\n");
        buffWrite.append("isso eh OUTRO teste" + "\n");
        buffWrite.close();
    }
}
