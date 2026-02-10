import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Exercicio5 {

    // public static int[] recursividade(int vet[], int c){
    // for(int i = c -2; i < vet.length; i++){//Começa do 0
    // for (int j = 0; j < c - 1; j++) {
    // System.out.println(vet[j]);
    // }
    // System.out.println(vet[i]);
    // }
    // return vet2[];
    // }
    public static void main(String[] args) {
        int n, c;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        // System.out.println("Digite o valor de n:");
        // n = scan.nextInt();
        // int[] vet = new int[n];
        // for (int i = 0; i < n; i++) {
        // vet[i] = rand.nextInt(n - 0) + 1;
        // }
        int[] vet = { 42, 9, 71, 66, 43 };
        n = vet.length;
        c = 4;

        //Caso seja um
        if (c == 1) {
            for (int i = 0; i < vet.length; i++) {
                System.out.println(vet[i]);
            }
        } else {
            // Adiciona o vetor na fila
            LinkedList<Integer> fila = new LinkedList<>();
            ArrayList<Integer> numeros = new ArrayList<>();

            for (int i = 0; i < vet.length; i++) {
                fila.add(vet[i]);
            }

            while (fila.size() != c - 1) {
                for (int i = 0; i < fila.size(); i++) {
                    numeros.add(fila.get(i));
                    // System.out.println(fila.get(i));
                }

                // Não mexer
                while (numeros.size() != c) {
                    for (int i = c - 1; i < numeros.size(); i++) {// Começa do 0
                        for (int j = 0; j < c - 1; j++) {
                            System.out.print(numeros.get(j) + ",");
                        }
                        System.out.println(numeros.get(i));
                        // System.out.println("PULO");
                    }
                    numeros.remove(1);
                    // Até aqui
                }
                for (int j = 0; j < c; j++) {
                    System.out.print(numeros.get(j) + " ");
                }
                System.out.println("");

                numeros.clear();
                fila.poll();
            }
        }
        // while (fila.size() != c) {
        // ArrayList<Integer> lista = new ArrayList<>(fila);

        // for (int i = c - 1; i < lista.size(); i++) {// Começa do 0
        // for (int j = 0; j < c - 1; j++) {
        // System.out.print(lista.get(j) + ",");
        // }
        // System.out.println(lista.get(i));
        // System.out.println("PULO");
        // }
        // fila.remove();
        // System.out.println("Teste");
        // }
        // Mostrar o último
        // for (int j = 0; j < c; j++) {
        // System.out.print(fila.get(j) + " ");
        // }
    }
}


// Lógica do GEMINI, o seu conceito está certo

// import java.util.ArrayList;
// import java.util.Collections; // Para ordenar a lista (fica mais bonito)
// import java.util.HashSet;
// import java.util.List;
// import java.util.Random;
// import java.util.Scanner;
// import java.util.Set;

// public class Exercicio5 {

//     public static void main(String[] args) {
//         Scanner scan = new Scanner(System.in);
//         Random rand = new Random();

//         // 1. Solicitar N
//         System.out.print("Digite a quantidade de números (N): ");
//         int n = scan.nextInt();

//         // Validação simples para evitar erro
//         if (n > 99) {
//             System.out.println("N não pode ser maior que 99 (limite dos números disponíveis).");
//             return;
//         }

//         // 2. Gerar N números aleatórios sem repetição entre 1 e 99
//         Set<Integer> numerosUnicos = new HashSet<>();
//         while (numerosUnicos.size() < n) {
//             int numero = rand.nextInt(99) + 1; // 1 a 99
//             numerosUnicos.add(numero);
//         }

//         // Converter para Lista para poder manipular índices
//         List<Integer> listaNumeros = new ArrayList<>(numerosUnicos);
        
//         // Opcional: Ordenar para que as combinações fiquem mais organizadas visualmente
//         // Se quiser a ordem puramente aleatória, remova a linha abaixo.
//         // Collections.sort(listaNumeros); 

//         System.out.println("Números gerados: " + listaNumeros);

//         // 3. Solicitar C
//         System.out.print("Digite o tamanho da combinação (C): ");
//         int c = scan.nextInt();

//         if (c > n) {
//             System.out.println("Erro: C não pode ser maior que N.");
//         } else {
//             System.out.println("\n--- Combinações Possíveis ---");
//             // Vetor temporário para armazenar a combinação atual
//             int[] combinacaoAtual = new int[c];
//             gerarCombinacoes(listaNumeros, combinacaoAtual, 0, n, 0, c);
//         }
        
//         scan.close();
//     }

//     /**
//      * Método Recursivo para gerar combinações
//      * * @param lista A lista original de números (N)
//      * @param dados O array temporário que guarda a combinação atual
//      * @param inicio O índice na lista original para começar a procurar
//      * @param fim O tamanho da lista original (n)
//      * @param index O índice atual no array 'dados' que estamos preenchendo
//      * @param r O tamanho desejado da combinação (c)
//      */
//     public static void gerarCombinacoes(List<Integer> lista, int[] dados, int inicio, int fim, int index, int r) {
//         // Caso base: Se o índice atual for igual a r, a combinação está completa
//         if (index == r) {
//             System.out.print("(");
//             for (int j = 0; j < r; j++) {
//                 System.out.print(dados[j]);
//                 if (j < r - 1) System.out.print(", ");
//             }
//             System.out.println(")");
//             return;
//         }

//         // Substitui o índice com todos os elementos possíveis da lista
//         // A condição "i <= fim - (r - index)" é uma otimização: 
//         // ela para o loop se não houver elementos suficientes restantes para completar a combinação.
//         for (int i = inicio; i < fim && fim - i + 1 >= r - index; i++) {
//             dados[index] = lista.get(i);
//             // Chama a recursão para o próximo índice
//             gerarCombinacoes(lista, dados, i + 1, fim, index + 1, r);
//         }
//     }
// }