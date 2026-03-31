    package Aula03;

    import java.util.function.Consumer;

    public class Ordenacao_de_vetores {

        public static void main(String[] args) {

            //#region VARIÁVEIS
            int N = 10000;

            int vetAleatorio_1[]  = new int[N];
            int vetMelhorCaso_1[] = new int[N];
            int vetPiorCaso_1[]   = new int[N];

            inicializarVetor(vetAleatorio_1,  N, 0); // 0-aleatório, 1-crescente, 2-decrescente
            inicializarVetor(vetMelhorCaso_1, N, 1);
            inicializarVetor(vetPiorCaso_1,   N, 2);

            int vetAleatorio_2[]  = vetAleatorio_1.clone();
            int vetMelhorCaso_2[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_2[]   = vetPiorCaso_1.clone();

            int vetAleatorio_3[]  = vetAleatorio_1.clone();
            int vetMelhorCaso_3[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_3[]   = vetPiorCaso_1.clone();

            int vetAleatorio_4[]  = vetAleatorio_1.clone();
            int vetMelhorCaso_4[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_4[]   = vetPiorCaso_1.clone();

            int vetAleatorio_5[]  = vetAleatorio_1.clone();
            int vetMelhorCaso_5[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_5[]   = vetPiorCaso_1.clone();

            int vetAleatorio_6[]  = vetAleatorio_1.clone();
            int vetMelhorCaso_6[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_6[]   = vetPiorCaso_1.clone();

            int vetAleatorio_7[]  = vetAleatorio_1.clone();
            int vetMelhorCaso_7[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_7[]   = vetPiorCaso_1.clone();

            int vetAleatorio_8[]  = vetAleatorio_1.clone();
            int vetMelhorCaso_8[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_8[]   = vetPiorCaso_1.clone();

            int vetAleatorio_9[]  = vetAleatorio_1.clone();
            int vetMelhorCaso_9[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_9[]   = vetPiorCaso_1.clone();
            //#endregion

            //#region BENCHMARK

            // ---- Bubble Sort (básico) ----
            medirTempo("Bubble Sort (básico)     ", vetAleatorio_1,  v -> ordenar(v, N));
            medirTempo("Bubble Sort (básico)     ", vetMelhorCaso_1, v -> ordenar(v, N));
            medirTempo("Bubble Sort (básico)     ", vetPiorCaso_1,   v -> ordenar(v, N));
            System.out.println();

            // ---- Bubble Sort (melhorado) ----
            medirTempo("Bubble Sort (melhorado)  ", vetAleatorio_2,  v -> ordenarMelhorado(v, N));
            medirTempo("Bubble Sort (melhorado)  ", vetMelhorCaso_2, v -> ordenarMelhorado(v, N));
            medirTempo("Bubble Sort (melhorado)  ", vetPiorCaso_2,   v -> ordenarMelhorado(v, N));
            System.out.println();

            // ---- Insertion Sort ----
            medirTempo("Insertion Sort           ", vetAleatorio_3,  v -> insertion(v, N));
            medirTempo("Insertion Sort           ", vetMelhorCaso_3, v -> insertion(v, N));
            medirTempo("Insertion Sort           ", vetPiorCaso_3,   v -> insertion(v, N));
            System.out.println();

            // ---- Maior/Menor (Selection duplo) ----
            medirTempo("Maior/Menor (duplo)      ", vetAleatorio_4,  v -> ordenarMaiorMenor(v, N));
            medirTempo("Maior/Menor (duplo)      ", vetMelhorCaso_4, v -> ordenarMaiorMenor(v, N));
            medirTempo("Maior/Menor (duplo)      ", vetPiorCaso_4,   v -> ordenarMaiorMenor(v, N));
            System.out.println();

            // ---- Selection Sort ----
            medirTempo("Selection Sort           ", vetAleatorio_5,  v -> selection_sort(v, N));
            medirTempo("Selection Sort           ", vetMelhorCaso_5, v -> selection_sort(v, N));
            medirTempo("Selection Sort           ", vetPiorCaso_5,   v -> selection_sort(v, N));
            System.out.println();

            // ---- Merge Sort ----
            medirTempo("Merge Sort               ", vetAleatorio_6,  v -> mergeSort(v, N));
            medirTempo("Merge Sort               ", vetMelhorCaso_6, v -> mergeSort(v, N));
            medirTempo("Merge Sort               ", vetPiorCaso_6,   v -> mergeSort(v, N));
            System.out.println();

            // ---- Heap Sort ----
            medirTempo("Heap Sort                ", vetAleatorio_7,  v -> heapSort(v));
            medirTempo("Heap Sort                ", vetMelhorCaso_7, v -> heapSort(v));
            medirTempo("Heap Sort                ", vetPiorCaso_7,   v -> heapSort(v));
            System.out.println();

            // ---- Quick Sort ----
            medirTempo("Quick Sort               ", vetAleatorio_8,  v -> quickSort(v, N));
            medirTempo("Quick Sort               ", vetMelhorCaso_8, v -> quickSort(v, N));
            medirTempo("Quick Sort               ", vetPiorCaso_8,   v -> quickSort(v, N));
            System.out.println();

            // ---- Counting Sort ----
            medirTempo("Counting Sort            ", vetAleatorio_9,  v -> countingSort(v, N));
            medirTempo("Counting Sort            ", vetMelhorCaso_9, v -> countingSort(v, N));
            medirTempo("Counting Sort            ", vetPiorCaso_9,   v -> countingSort(v, N));

            //#endregion
        }

        // ─────────────────────────────────────────────
        // Utilitário de medição de tempo
        // ─────────────────────────────────────────────

        /**
         * Executa o algoritmo recebido, mede o tempo e imprime o resultado.
         * O tipo de entrada é inferido automaticamente a partir do vetor.
         */
        private static void medirTempo(String nomeAlgoritmo, int[] vet, Consumer<int[]> algoritmo) {
            String tipoEntrada = inferirTipo(vet);
            long inicio = System.currentTimeMillis();
            algoritmo.accept(vet);
            long delta = System.currentTimeMillis() - inicio;
            System.out.printf("%-28s | %-15s | %ds %03dms%n",
                    nomeAlgoritmo, tipoEntrada, delta / 1000, delta % 1000);
        }

        /** Detecta se o vetor é aleatório, crescente ou decrescente. */
        private static String inferirTipo(int[] vet) {
            boolean crescente  = true;
            boolean decrescente = true;
            for (int i = 0; i < vet.length - 1; i++) {
                if (vet[i] > vet[i + 1]) crescente  = false;
                if (vet[i] < vet[i + 1]) decrescente = false;
                if (!crescente && !decrescente) break;
            }
            if (crescente)  return "Melhor Caso";
            if (decrescente) return "Pior Caso";
            return "Aleatório";
        }

        // ─────────────────────────────────────────────
        // Inicialização e utilitários
        // ─────────────────────────────────────────────

        static void inicializarVetor(int[] vet, int N, int s) {
            switch (s) {
                case 0: // aleatório
                    for (int i = 0; i < N; i++)
                        vet[i] = (int) (Math.random() * (N * 2));
                    break;
                case 1: // crescente (melhor caso para a maioria)
                    for (int i = 0; i < N; i++)
                        vet[i] = i + 1;
                    break;
                case 2: // decrescente (pior caso para a maioria)
                    for (int i = 0; i < N; i++)
                        vet[i] = N - i;
                    break;
            }
        }

        private static void exibirVetor(int[] vet, int N) {
            for (int i = 0; i < N; i++)
                System.out.printf("%4d ", vet[i]);
            System.out.println();
        }

        private static void troca(int[] vet, int a, int b) {
            int aux = vet[a];
            vet[a]  = vet[b];
            vet[b]  = aux;
        }

        // ─────────────────────────────────────────────
        // 1. Bubble Sort básico — O(n²)
        // ─────────────────────────────────────────────

        private static void ordenar(int[] vet, int N) {
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N - 1; j++)
                    if (vet[j] > vet[j + 1])
                        troca(vet, j, j + 1);
        }

        // ─────────────────────────────────────────────
        // 2. Bubble Sort melhorado (com flag de parada) — O(n²) / O(n)
        //
        // CORREÇÃO: o "break" estava dentro do loop interno, fazendo com que
        // o algoritmo parasse na primeira iteração sem troca — ou seja, após
        // comparar apenas vet[0] e vet[1]. Movido para fora do loop interno.
        // ─────────────────────────────────────────────

        private static void ordenarMelhorado(int[] vet, int N) {
            for (int i = 0; i < N; i++) {
                boolean semTroca = true;
                for (int j = 0; j < N - i - 1; j++) {
                    if (vet[j] > vet[j + 1]) {
                        semTroca = false;
                        troca(vet, j, j + 1);
                    }
                }
                // ✅ break FORA do loop interno: só encerra quando a passagem
                //    inteira terminou sem nenhuma troca (vetor já ordenado).
                if (semTroca) break;
            }
        }

        // ─────────────────────────────────────────────
        // 3. Insertion Sort — O(n²) / O(n)
        // ─────────────────────────────────────────────

        static void insertion(int[] vet, int N) {
            for (int i = 1; i < N; i++) {
                int key = vet[i];
                int j   = i - 1;
                while (j >= 0 && vet[j] > key) {
                    vet[j + 1] = vet[j];
                    j--;
                }
                vet[j + 1] = key;
            }
        }

        // ─────────────────────────────────────────────
        // 4. Selection duplo (menor + maior simultâneos) — O(n²)
        //
        // CORREÇÃO 1: menor, maior, posMenor e posMaior não eram reinicializados
        //   a cada volta do loop externo, causando trocas com posições obsoletas.
        //
        // CORREÇÃO 2: após trocar o menor para contMenor, se posMaior apontava
        //   para contMenor (o elemento máximo estava lá), ele foi movido para
        //   posMenor — atualizar posMaior antes da segunda troca.
        // ─────────────────────────────────────────────

        private static void ordenarMaiorMenor(int[] vet, int N) {
            int contMenor = 0;
            int contMaior = N - 1;

            while (contMenor < contMaior) {

                // ✅ Reinicialização a cada iteração
                int posMenor = contMenor;
                int posMaior = contMaior;

                for (int j = contMenor; j <= contMaior; j++) {
                    if (vet[j] < vet[posMenor]) posMenor = j;
                    if (vet[j] > vet[posMaior]) posMaior = j;
                }

                // ✅ Coloca o menor no início
                troca(vet, contMenor, posMenor);

                // ✅ Se o maior estava em contMenor, ele foi para posMenor
                if (posMaior == contMenor) posMaior = posMenor;

                // Coloca o maior no fim
                troca(vet, contMaior, posMaior);

                contMenor++;
                contMaior--;
            }
        }

        // ─────────────────────────────────────────────
        // 5. Selection Sort — O(n²)
        // ─────────────────────────────────────────────

        private static void selection_sort(int[] vet, int n) {
            for (int i = 0; i < n - 1; i++) {
                int min = i;
                for (int j = i + 1; j < n; j++)
                    if (vet[j] < vet[min]) min = j;
                if (i != min) troca(vet, i, min);
            }
        }

        // ─────────────────────────────────────────────
        // 6. Merge Sort — O(n log n)
        // ─────────────────────────────────────────────

        private static void mergeSort(int[] vet, int N) {
            mergeSortRec(vet, 0, N - 1);
        }

        private static void mergeSortRec(int[] vet, int inicio, int fim) {
            if (inicio < fim) {
                int meio = (inicio + fim) / 2;
                mergeSortRec(vet, inicio, meio);
                mergeSortRec(vet, meio + 1, fim);
                intercalar(vet, inicio, meio, fim);
            }
        }

        private static void intercalar(int[] vet, int inicio, int meio, int fim) {
            int tam  = fim - inicio + 1;
            int[] aux = new int[tam];
            int i = inicio, j = meio + 1, k = 0;

            while (i <= meio && j <= fim)
                aux[k++] = (vet[i] <= vet[j]) ? vet[i++] : vet[j++];

            while (i <= meio) aux[k++] = vet[i++];
            while (j <= fim)  aux[k++] = vet[j++];

            for (int x = 0; x < tam; x++)
                vet[inicio + x] = aux[x];
        }

        // ─────────────────────────────────────────────
        // 7. Heap Sort — O(n log n)
        // ─────────────────────────────────────────────

        public static void heapSort(int[] vetor) {
            int tamanho = vetor.length;
            int i = tamanho / 2, pai, filho, t;
            while (true) {
                if (i > 0) {
                    i--;
                    t = vetor[i];
                } else {
                    tamanho--;
                    if (tamanho <= 0) return;
                    t = vetor[tamanho];
                    vetor[tamanho] = vetor[0];
                }
                pai    = i;
                filho  = i * 2 + 1;
                while (filho < tamanho) {
                    if (filho + 1 < tamanho && vetor[filho + 1] > vetor[filho])
                        filho++;
                    if (vetor[filho] > t) {
                        vetor[pai] = vetor[filho];
                        pai        = filho;
                        filho      = pai * 2 + 1;
                    } else {
                        break;
                    }
                }
                vetor[pai] = t;
            }
        }

        // ─────────────────────────────────────────────
        // 8. Quick Sort — O(n log n) médio
        //
        // CORREÇÃO: o pivô era sempre o último elemento, causando O(n²) e
        //   StackOverflowError em vetores já ordenados (crescente/decrescente)
        //   com N=10.000. Agora usa a estratégia "median-of-three": compara o
        //   primeiro, o meio e o último elemento e usa a mediana como pivô,
        //   colocando-o na penúltima posição antes de particionar.
        // ─────────────────────────────────────────────

        private static void quickSort(int[] vet, int N) {
            quickSortRec(vet, 0, N - 1);
        }

        private static void quickSortRec(int[] vet, int inicio, int fim) {
            if (inicio < fim) {
                int pivoIndex = particionar(vet, inicio, fim);
                quickSortRec(vet, inicio, pivoIndex - 1);
                quickSortRec(vet, pivoIndex + 1, fim);
            }
        }

        /**
         * Escolhe o pivô usando median-of-three (primeiro, meio, último),
         * posiciona o pivô em vet[fim] e particiona o subarray.
         */
        private static int particionar(int[] vet, int inicio, int fim) {
            // ✅ Median-of-three: evita O(n²) em vetores ordenados
            int meio = inicio + (fim - inicio) / 2;
            if (vet[inicio] > vet[meio]) troca(vet, inicio, meio);
            if (vet[inicio] > vet[fim])  troca(vet, inicio, fim);
            if (vet[meio]   > vet[fim])  troca(vet, meio,   fim);
            // Agora vet[meio] é a mediana; usamos ela como pivô
            troca(vet, meio, fim);

            int pivo = vet[fim];
            int i    = inicio - 1;

            for (int j = inicio; j < fim; j++) {
                if (vet[j] <= pivo) {
                    i++;
                    troca(vet, i, j);
                }
            }
            troca(vet, i + 1, fim);
            return i + 1;
        }

        // ─────────────────────────────────────────────
        // 9. Counting Sort — O(n + k)
        //    Nota: funciona apenas com valores >= 0.
        // ─────────────────────────────────────────────

        private static void countingSort(int[] vet, int N) {
            // Encontrar o maior valor
            int maior = vet[0];
            for (int i = 1; i < N; i++)
                if (vet[i] > maior) maior = vet[i];

            // Criar vetor de contagem e contar ocorrências
            int[] count = new int[maior + 1];
            for (int i = 0; i < N; i++)
                count[vet[i]]++;

            // Reconstruir o vetor ordenado
            int indice = 0;
            for (int i = 0; i <= maior; i++)
                while (count[i]-- > 0)
                    vet[indice++] = i;
        }
    }