package Aula03;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ordenacao_de_vetores {


    // ── Configuração ──────────────────────────────────────────────────────────
    static final int[] TAMANHOS = {5_000, 10_000, 30_000, 50_000};
    static final boolean EXPORTAR_CSV = true; // mude para false para desativar
    // ─────────────────────────────────────────────────────────────────────────

    static ArrayList<String[]> resultados = new ArrayList<>();

    public static void main(String[] args) {

        // Aquecimento da JVM: roda algoritmos em vetores pequenos antes de medir,
        // para o compilador JIT otimizar os metodos antes dos testes reais.
        System.out.println("Aquecendo a JVM...");
        int[] warmup = new int[500];
        inicializarVetor(warmup, 500, 0); ordenar(warmup, 500);
        inicializarVetor(warmup, 500, 0); ordenarMelhorado(warmup, 500);
        inicializarVetor(warmup, 500, 0); insertion(warmup, 500);
        inicializarVetor(warmup, 500, 0); selection_sort(warmup, 500);
        inicializarVetor(warmup, 500, 0); mergeSort(warmup, 500);
        inicializarVetor(warmup, 500, 0); heapSort(warmup);
        inicializarVetor(warmup, 500, 0); quickSort(warmup, 500);
        inicializarVetor(warmup, 500, 0); countingSort(warmup, 500);
        System.out.println("Pronto.\n");

        for (int N : TAMANHOS) {

            System.out.println("========================================");
            System.out.println("  N = " + N);
            System.out.println("========================================");

            int vetAleatorio_1[] = new int[N];
            int vetMelhorCaso_1[] = new int[N];
            int vetPiorCaso_1[] = new int[N];

            inicializarVetor(vetAleatorio_1, N, 0); // 0-aleatório, 1-crescente, 2-decrescente
            inicializarVetor(vetMelhorCaso_1, N, 1);
            inicializarVetor(vetPiorCaso_1, N, 2);

            int vetAleatorio_2[] = vetAleatorio_1.clone();
            int vetMelhorCaso_2[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_2[] = vetPiorCaso_1.clone();

            int vetAleatorio_3[] = vetAleatorio_1.clone();
            int vetMelhorCaso_3[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_3[] = vetPiorCaso_1.clone();

            int vetAleatorio_4[] = vetAleatorio_1.clone();
            int vetMelhorCaso_4[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_4[] = vetPiorCaso_1.clone();

            int vetAleatorio_5[] = vetAleatorio_1.clone();
            int vetMelhorCaso_5[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_5[] = vetPiorCaso_1.clone();

            int vetAleatorio_6[] = vetAleatorio_1.clone();
            int vetMelhorCaso_6[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_6[] = vetPiorCaso_1.clone();

            int vetAleatorio_7[] = vetAleatorio_1.clone();
            int vetMelhorCaso_7[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_7[] = vetPiorCaso_1.clone();

            int vetAleatorio_8[] = vetAleatorio_1.clone();
            int vetMelhorCaso_8[] = vetMelhorCaso_1.clone();
            int vetPiorCaso_8[] = vetPiorCaso_1.clone();

            long inicio, deltaNs, ms, us;

            // ── ORDENACAO RUIM (Bubble Sort basico) ──────────────────────────

            inicio = System.nanoTime();
            ordenar(vetAleatorio_1, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao Aleatorio: " + ms + "ms " + us + "us");
            salvar(N, "Bubble Sort (basico)", "Aleatorio", deltaNs / 1_000L);

            inicio = System.nanoTime();
            ordenar(vetMelhorCaso_1, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao Melhor Caso: " + ms + "ms " + us + "us");
            salvar(N, "Bubble Sort (basico)", "Melhor Caso", deltaNs / 1_000L);

            inicio = System.nanoTime();
            ordenar(vetPiorCaso_1, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao Pior Caso: " + ms + "ms " + us + "us");
            salvar(N, "Bubble Sort (basico)", "Pior Caso", deltaNs / 1_000L);
            System.out.println("--------------------------------------");

            // ── ORDENACAO MELHORADO (Bubble Sort melhorado) ──────────────────

            inicio = System.nanoTime();
            ordenarMelhorado(vetAleatorio_2, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(melhorado) Aleatorio: " + ms + "ms " + us + "us");
            salvar(N, "Bubble Sort (melhorado)", "Aleatorio", deltaNs / 1_000L);

            inicio = System.nanoTime();
            ordenarMelhorado(vetMelhorCaso_2, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(melhorado) Melhor Caso: " + ms + "ms " + us + "us");
            salvar(N, "Bubble Sort (melhorado)", "Melhor Caso", deltaNs / 1_000L);

            inicio = System.nanoTime();
            ordenarMelhorado(vetPiorCaso_2, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(melhorado) Pior Caso: " + ms + "ms " + us + "us");
            salvar(N, "Bubble Sort (melhorado)", "Pior Caso", deltaNs / 1_000L);
            System.out.println("--------------------------------------");

            // ── INSERTION SORT ────────────────────────────────────────────────

            inicio = System.nanoTime();
            insertion(vetAleatorio_3, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(insertion) Aleatorio: " + ms + "ms " + us + "us");
            salvar(N, "Insertion Sort", "Aleatorio", deltaNs / 1_000L);

            inicio = System.nanoTime();
            insertion(vetMelhorCaso_3, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(insertion) Melhor Caso: " + ms + "ms " + us + "us");
            salvar(N, "Insertion Sort", "Melhor Caso", deltaNs / 1_000L);

            inicio = System.nanoTime();
            insertion(vetPiorCaso_3, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(insertion) Pior Caso: " + ms + "ms " + us + "us");
            salvar(N, "Insertion Sort", "Pior Caso", deltaNs / 1_000L);
            System.out.println("--------------------------------------");

            // ── SELECTION SORT ────────────────────────────────────────────────

            inicio = System.nanoTime();
            selection_sort(vetAleatorio_4, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(selection) Aleatorio: " + ms + "ms " + us + "us");
            salvar(N, "Selection Sort", "Aleatorio", deltaNs / 1_000L);

            inicio = System.nanoTime();
            selection_sort(vetMelhorCaso_4, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(selection) Melhor Caso: " + ms + "ms " + us + "us");
            salvar(N, "Selection Sort", "Melhor Caso", deltaNs / 1_000L);

            inicio = System.nanoTime();
            selection_sort(vetPiorCaso_4, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(selection) Pior Caso: " + ms + "ms " + us + "us");
            salvar(N, "Selection Sort", "Pior Caso", deltaNs / 1_000L);
            System.out.println("--------------------------------------");

            // ── MERGE SORT ────────────────────────────────────────────────────

            inicio = System.nanoTime();
            mergeSort(vetAleatorio_5, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(merge) Aleatorio: " + ms + "ms " + us + "us");
            salvar(N, "Merge Sort", "Aleatorio", deltaNs / 1_000L);

            inicio = System.nanoTime();
            mergeSort(vetMelhorCaso_5, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(merge) Melhor Caso: " + ms + "ms " + us + "us");
            salvar(N, "Merge Sort", "Melhor Caso", deltaNs / 1_000L);

            inicio = System.nanoTime();
            mergeSort(vetPiorCaso_5, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(merge) Pior Caso: " + ms + "ms " + us + "us");
            salvar(N, "Merge Sort", "Pior Caso", deltaNs / 1_000L);
            System.out.println("--------------------------------------");

            // ── HEAP SORT ─────────────────────────────────────────────────────

            inicio = System.nanoTime();
            heapSort(vetAleatorio_6);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(heap) Aleatorio: " + ms + "ms " + us + "us");
            salvar(N, "Heap Sort", "Aleatorio", deltaNs / 1_000L);

            inicio = System.nanoTime();
            heapSort(vetMelhorCaso_6);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(heap) Melhor Caso: " + ms + "ms " + us + "us");
            salvar(N, "Heap Sort", "Melhor Caso", deltaNs / 1_000L);

            inicio = System.nanoTime();
            heapSort(vetPiorCaso_6);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(heap) Pior Caso: " + ms + "ms " + us + "us");
            salvar(N, "Heap Sort", "Pior Caso", deltaNs / 1_000L);
            System.out.println("--------------------------------------");

            // ── QUICK SORT ────────────────────────────────────────────────────

            inicio = System.nanoTime();
            quickSort(vetAleatorio_7, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(quick) Aleatorio: " + ms + "ms " + us + "us");
            salvar(N, "Quick Sort", "Aleatorio", deltaNs / 1_000L);

            inicio = System.nanoTime();
            quickSort(vetMelhorCaso_7, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(quick) Melhor Caso: " + ms + "ms " + us + "us");
            salvar(N, "Quick Sort", "Melhor Caso", deltaNs / 1_000L);

            inicio = System.nanoTime();
            quickSort(vetPiorCaso_7, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(quick) Pior Caso: " + ms + "ms " + us + "us");
            salvar(N, "Quick Sort", "Pior Caso", deltaNs / 1_000L);
            System.out.println("--------------------------------------");

            // ── COUNTING SORT ─────────────────────────────────────────────────

            inicio = System.nanoTime();
            countingSort(vetAleatorio_8, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(counting) Aleatorio: " + ms + "ms " + us + "us");
            salvar(N, "Counting Sort", "Aleatorio", deltaNs / 1_000L);

            inicio = System.nanoTime();
            countingSort(vetMelhorCaso_8, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(counting) Melhor Caso: " + ms + "ms " + us + "us");
            salvar(N, "Counting Sort", "Melhor Caso", deltaNs / 1_000L);

            inicio = System.nanoTime();
            countingSort(vetPiorCaso_8, N);
            deltaNs = System.nanoTime() - inicio;
            ms = deltaNs / 1_000_000L; us = (deltaNs % 1_000_000L) / 1_000L;
            System.out.println("Tempo de ordenacao(counting) Pior Caso: " + ms + "ms " + us + "us");
            salvar(N, "Counting Sort", "Pior Caso", deltaNs / 1_000L);
            System.out.println();
        }

        if (EXPORTAR_CSV) exportarCSV("resultados.csv");
    }

    // ── Coleta e exportação ───────────────────────────────────────────────────

    private static void salvar(int N, String algoritmo, String tipo, long us) {
        resultados.add(new String[]{ String.valueOf(N), algoritmo, tipo, String.valueOf(us) });
    }

    private static void exportarCSV(String arquivo) {
        try (FileWriter fw = new FileWriter(arquivo)) {
            fw.write("N,Algoritmo,Tipo de Entrada,Tempo (us)\n");
            for (String[] linha : resultados)
                fw.write(String.join(",", linha) + "\n");
            System.out.println("Resultados exportados para: " + arquivo);
        } catch (IOException e) {
            System.err.println("Erro ao exportar CSV: " + e.getMessage());
        }
    }

    // ── Utilitários ───────────────────────────────────────────────────────────

    static void inicializarVetor(int[] vet, int N, int s) {
        switch (s) {
            case 0:
                for (int i = 0; i < N; i++)
                    vet[i] = (int) (Math.random() * (N * 2));
                break;
            case 1:
                for (int i = 0; i < N; i++)
                    vet[i] = i + 1;
                break;
            case 2:
                for (int i = 0; i < N; i++)
                    vet[i] = N - i;
                break;
        }
    }

    private static void exibirVetor(int[] vet, int N) {
        for (int i = 0; i < N; i++) {
            if (vet[i] < 10) {
                System.out.print("0" + vet[i] + " ");
            } else {
                System.out.print(vet[i] + " ");
            }
        }
        System.out.println("");
    }

    private static void troca(int[] vet, int a, int b) {
        int aux = vet[a];
        vet[a] = vet[b];
        vet[b] = aux;
    }

    // ── Algoritmos ────────────────────────────────────────────────────────────

    private static void ordenar(int[] vet, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (vet[j] > vet[j + 1])
                    troca(vet, j, j + 1);
            }
        }
    }

    private static void ordenarMelhorado(int[] vet, int N) {
        for (int i = 0; i < N; i++) {
            boolean comp = true;
            for (int j = 0; j < N - i - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    comp = false;
                    troca(vet, j, j + 1);
                }
            }
            if (comp) break;
        }
    }

    static void insertion(int[] vet, int N) {
        for (int i = 1; i < N; ++i) {
            int key = vet[i];
            int j = i - 1;
            while (j >= 0 && vet[j] > key) {
                vet[j + 1] = vet[j];
                j = j - 1;
            }
            vet[j + 1] = key;
        }
    }

    private static void selection_sort(int[] vet, int n) {
        int i, j, min, aux;
        for (i = 0; i < (n - 1); i++) {
            min = i;
            for (j = (i + 1); j < n; j++) {
                if (vet[j] < vet[min]) {
                    min = j;
                }
            }
            if (i != min) {
                aux = vet[i];
                vet[i] = vet[min];
                vet[min] = aux;
            }
        }
    }

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
        int tam = fim - inicio + 1;
        int[] aux = new int[tam];
        int i = inicio;
        int j = meio + 1;
        int k = 0;
        while (i <= meio && j <= fim) {
            if (vet[i] <= vet[j]) {
                aux[k++] = vet[i++];
            } else {
                aux[k++] = vet[j++];
            }
        }
        while (i <= meio) aux[k++] = vet[i++];
        while (j <= fim)  aux[k++] = vet[j++];
        for (int x = 0; x < tam; x++)
            vet[inicio + x] = aux[x];
    }

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
            pai = i;
            filho = (i * 2) + 1;
            while (filho < tamanho) {
                if ((filho + 1 < tamanho) && (vetor[filho + 1] > vetor[filho]))
                    filho++;
                if (vetor[filho] > t) {
                    vetor[pai] = vetor[filho];
                    pai = filho;
                    filho = pai * 2 + 1;
                } else {
                    break;
                }
            }
            vetor[pai] = t;
        }
    }

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

    // Median-of-three: evita O(n^2) e StackOverflow em vetores ja ordenados
    private static int particionar(int[] vet, int inicio, int fim) {
        int meio = inicio + (fim - inicio) / 2;
        if (vet[inicio] > vet[meio]) troca(vet, inicio, meio);
        if (vet[inicio] > vet[fim])  troca(vet, inicio, fim);
        if (vet[meio]   > vet[fim])  troca(vet, meio, fim);
        troca(vet, meio, fim);

        int pivo = vet[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (vet[j] <= pivo) {
                i++;
                troca(vet, i, j);
            }
        }
        troca(vet, i + 1, fim);
        return i + 1;
    }

    // Protecao contra OutOfMemoryError: verifica o intervalo antes de alocar.
    // Suporta valores negativos via deslocamento por (-min).
    private static void countingSort(int[] vet, int N) {
        int min = vet[0], max = vet[0];
        for (int i = 1; i < N; i++) {
            if (vet[i] < min) min = vet[i];
            if (vet[i] > max) max = vet[i];
        }

        long intervalo = (long) max - min + 1;
        if (intervalo > (long) N * 10) {
            throw new IllegalArgumentException(
                "Counting Sort: intervalo (" + intervalo + ") muito grande para N=" + N
            );
        }

        int[] count = new int[(int) intervalo];
        for (int i = 0; i < N; i++) count[vet[i] - min]++;
        int indice = 0;
        for (int i = 0; i <= max - min; i++)
            while (count[i]-- > 0) vet[indice++] = i + min;
    }
}
