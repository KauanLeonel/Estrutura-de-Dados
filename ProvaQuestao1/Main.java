import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Arvore a = new Arvore();

        Scanner leitor = new Scanner(new File("entrada.txt"));

        while (leitor.hasNextInt()) {
            int numero = leitor.nextInt();
            a.Insert(numero);
        }

        leitor.close();

        a.RemoverMultiplo(3, 5, 7);

        System.out.println(a.folhas());
    }
}
