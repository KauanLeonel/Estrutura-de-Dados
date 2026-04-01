package Aula03;

import java.util.function.BiConsumer;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ordenacao_de_vetores {

    static final int N = 10_000;

    static ArrayList<String[]> resultados = new ArrayList<>();

    // ── Registro central de algoritmos ───────────────────────────────────────
    // Para adicionar um novo algoritmo basta incluir uma linha aqui.
    static final Map<String, BiConsumer<int[], Integer>> ALGORITMOS = new LinkedHashMap<>();
    static {
        ALGORITMOS.put("Bubble Sort (basico)",    (v, n) -> ordenar(v, n));
        ALGORITMOS.put("Bubble Sort (melhorado)", (v, n) -> ordenarMelhorado(v, n));
        ALGORITMOS.put("Insertion Sort",          (v, n) -> insertion(v, n));
        ALGORITMOS.put("Maior/Menor (duplo)",     (v, n) -> ordenarMaiorMenor(v, n));
        ALGORITMOS.put("Selection Sort",          (v, n) -> selection_sort(v, n));
        ALGORITMOS.put("Merge Sort",              (v, n) -> mergeSort(v, n));
        ALGORITMOS.put("Heap Sort",               (v, n) -> heapSort(v));
        ALGORITMOS.put("Quick Sort",              (v, n) -> quickSort(v, n));
        ALGORITMOS.put("Counting Sort",           (v, n) -> countingSort(v, n));
    }

    public static void main(String[] args) {

        // FIX 2 - Aquecimento da JVM (warmup)
        // Roda todos os algoritmos em vetores pequenos antes de medir.
        // O compilador JIT assim ja otimiza troca(), loops e metodos
        // de ordenacao antes dos testes reais comecarerm, nivelando o campo.
        System.out.println("Aquecendo a JVM...");
        int[] warmup = new int[500];
        for (BiConsumer<int[], Integer> alg : ALGORITMOS.values()) {
            inicializarVetor(warmup, 500, 0);
            alg.accept(warmup, 500);
        }
        System.out.println("Pronto.\n");

        // Vetores base - clonados a cada algoritmo no loop abaixo
        int[] baseAleatorio = new int[N];
        int[] baseMelhor    = new int[N];
        int[] basePior      = new int[N];
        inicializarVetor(baseAleatorio, N, 0);
        inicializarVetor(baseMelhor,    N, 1);
        inicializarVetor(basePior,      N, 2);

        // FIX 4 - Loop unificado: sem repeticao de codigo
        // Cada algoritmo recebe um clone fresco dos vetores base.
        System.out.printf("%-28s | %-15s | %s%n", "Algoritmo", "Tipo", "Tempo");
        System.out.println("-".repeat(62));

        for (Map.Entry<String, BiConsumer<int[], Integer>> entry : ALGORITMOS.entrySet()) {
            String nome = entry.getKey();
            BiConsumer<int[], Integer> alg = entry.getValue();
            medirTempo(nome, baseAleatorio.clone(), alg);
            medirTempo(nome, baseMelhor.clone(),    alg);
            medirTempo(nome, basePior.clone(),      alg);
            System.out.println();
        }

        exportarCSV("resultados.csv");
    }

    // ─────────────────────────────────────────────
    // FIX 1 - Medicao de tempo com nanoTime
    // currentTimeMillis() arredonda para 0ms algoritmos rapidos.
    // nanoTime() captura diferencas de nanosegundos.
    // Exibicao: XXXms YYYus (milissegundos + microssegundos residuais)
    // 1 ms = 1.000.000 ns  |  1 us = 1.000 ns
    // ─────────────────────────────────────────────
    private static void medirTempo(String nome, int[] vet,
                                   BiConsumer<int[], Integer> algoritmo) {
        String tipo = inferirTipo(vet);

        long inicio  = System.nanoTime();
        algoritmo.accept(vet, N);
        long deltaNs = System.nanoTime() - inicio;

        long ms = deltaNs / 1_000_000L;
        long us = (deltaNs % 1_000_000L) / 1_000L;

        System.out.printf("%-28s | %-15s | %dms %03dus%n", nome, tipo, ms, us);

        resultados.add(new String[]{
            nome, tipo, String.valueOf(deltaNs / 1_000L)  // exporta em us
        });
    }

    private static void exportarCSV(String arquivo) {
        try (FileWriter fw = new FileWriter(arquivo)) {
            fw.write("Algoritmo,Tipo de Entrada,Tempo (us)\n");
            for (String[] linha : resultados)
                fw.write(String.join(",", linha) + "\n");
            System.out.println("Resultados exportados para: " + arquivo);
        } catch (IOException e) {
            System.err.println("Erro ao exportar CSV: " + e.getMessage());
        }
    }

    private static String inferirTipo(int[] vet) {
        boolean crescente = true, decrescente = true;
        for (int i = 0; i < vet.length - 1; i++) {
            if (vet[i] > vet[i + 1]) crescente   = false;
            if (vet[i] < vet[i + 1]) decrescente = false;
            if (!crescente && !decrescente) break;
        }
        if (crescente)   return "Melhor Caso";
        if (decrescente) return "Pior Caso";
        return "Aleatorio";
    }

    // ─────────────────────────────────────────────
    // Inicializacao e utilitarios
    // ─────────────────────────────────────────────

    static void inicializarVetor(int[] vet, int n, int modo) {
        switch (modo) {
            case 0: for (int i = 0; i < n; i++) vet[i] = (int)(Math.random() * (n * 2)); break;
            case 1: for (int i = 0; i < n; i++) vet[i] = i + 1;  break;
            case 2: for (int i = 0; i < n; i++) vet[i] = n - i;  break;
        }
    }

    private static void exibirVetor(int[] vet, int n) {
        for (int i = 0; i < n; i++) System.out.printf("%4d ", vet[i]);
        System.out.println();
    }

    private static void troca(int[] vet, int a, int b) {
        int aux = vet[a]; vet[a] = vet[b]; vet[b] = aux;
    }

    // ─────────────────────────────────────────────
    // 1. Bubble Sort basico - O(n^2)
    // ─────────────────────────────────────────────
    private static void ordenar(int[] vet, int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - 1; j++)
                if (vet[j] > vet[j + 1]) troca(vet, j, j + 1);
    }

    // ─────────────────────────────────────────────
    // 2. Bubble Sort melhorado - O(n^2) / O(n)
    // ─────────────────────────────────────────────
    private static void ordenarMelhorado(int[] vet, int n) {
        for (int i = 0; i < n; i++) {
            boolean semTroca = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (vet[j] > vet[j + 1]) { semTroca = false; troca(vet, j, j + 1); }
            }
            if (semTroca) break;
        }
    }

    // ─────────────────────────────────────────────
    // 3. Insertion Sort - O(n^2) / O(n)
    // ─────────────────────────────────────────────
    static void insertion(int[] vet, int n) {
        for (int i = 1; i < n; i++) {
            int key = vet[i], j = i - 1;
            while (j >= 0 && vet[j] > key) { vet[j + 1] = vet[j]; j--; }
            vet[j + 1] = key;
        }
    }

    // ─────────────────────────────────────────────
    // 4. Selection duplo (menor + maior) - O(n^2)
    // ─────────────────────────────────────────────
    private static void ordenarMaiorMenor(int[] vet, int n) {
        int contMenor = 0, contMaior = n - 1;
        while (contMenor < contMaior) {
            int posMenor = contMenor, posMaior = contMaior;
            for (int j = contMenor; j <= contMaior; j++) {
                if (vet[j] < vet[posMenor]) posMenor = j;
                if (vet[j] > vet[posMaior]) posMaior = j;
            }
            troca(vet, contMenor, posMenor);
            if (posMaior == contMenor) posMaior = posMenor;
            troca(vet, contMaior, posMaior);
            contMenor++; contMaior--;
        }
    }

    // ─────────────────────────────────────────────
    // 5. Selection Sort - O(n^2)
    // ─────────────────────────────────────────────
    private static void selection_sort(int[] vet, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) if (vet[j] < vet[min]) min = j;
            if (i != min) troca(vet, i, min);
        }
    }

    // ─────────────────────────────────────────────
    // 6. Merge Sort - O(n log n)
    // ─────────────────────────────────────────────
    private static void mergeSort(int[] vet, int n) { mergeSortRec(vet, 0, n - 1); }

    private static void mergeSortRec(int[] vet, int ini, int fim) {
        if (ini < fim) {
            int meio = (ini + fim) / 2;
            mergeSortRec(vet, ini, meio);
            mergeSortRec(vet, meio + 1, fim);
            intercalar(vet, ini, meio, fim);
        }
    }

    private static void intercalar(int[] vet, int ini, int meio, int fim) {
        int[] aux = new int[fim - ini + 1];
        int i = ini, j = meio + 1, k = 0;
        while (i <= meio && j <= fim)
            aux[k++] = (vet[i] <= vet[j]) ? vet[i++] : vet[j++];
        while (i <= meio) aux[k++] = vet[i++];
        while (j <= fim)  aux[k++] = vet[j++];
        for (int x = 0; x < aux.length; x++) vet[ini + x] = aux[x];
    }

    // ─────────────────────────────────────────────
    // 7. Heap Sort - O(n log n)
    // ─────────────────────────────────────────────
    public static void heapSort(int[] v) {
        int tam = v.length, i = tam / 2, pai, filho, t;
        while (true) {
            if (i > 0) { i--; t = v[i]; }
            else { if (--tam <= 0) return; t = v[tam]; v[tam] = v[0]; }
            pai = i; filho = i * 2 + 1;
            while (filho < tam) {
                if (filho + 1 < tam && v[filho + 1] > v[filho]) filho++;
                if (v[filho] > t) { v[pai] = v[filho]; pai = filho; filho = pai * 2 + 1; }
                else break;
            }
            v[pai] = t;
        }
    }

    // ─────────────────────────────────────────────
    // 8. Quick Sort - O(n log n) medio [median-of-three]
    // ─────────────────────────────────────────────
    private static void quickSort(int[] vet, int n) { quickSortRec(vet, 0, n - 1); }

    private static void quickSortRec(int[] vet, int ini, int fim) {
        if (ini < fim) {
            int pivo = particionar(vet, ini, fim);
            quickSortRec(vet, ini, pivo - 1);
            quickSortRec(vet, pivo + 1, fim);
        }
    }

    private static int particionar(int[] vet, int ini, int fim) {
        int meio = ini + (fim - ini) / 2;
        if (vet[ini]  > vet[meio]) troca(vet, ini, meio);
        if (vet[ini]  > vet[fim])  troca(vet, ini, fim);
        if (vet[meio] > vet[fim])  troca(vet, meio, fim);
        troca(vet, meio, fim);
        int pivo = vet[fim], i = ini - 1;
        for (int j = ini; j < fim; j++) if (vet[j] <= pivo) { i++; troca(vet, i, j); }
        troca(vet, i + 1, fim);
        return i + 1;
    }

    // ─────────────────────────────────────────────
    // 9. Counting Sort - O(n + k)
    //
    // FIX 3 - Protecao contra OutOfMemoryError:
    //   Calcula o intervalo (max - min) antes de alocar.
    //   Se o intervalo for maior que 10*N, lanca excecao clara
    //   em vez de travar a JVM tentando alocar gigabytes.
    //   Tambem suporta valores negativos: desloca os indices por (-min).
    // ─────────────────────────────────────────────
    private static void countingSort(int[] vet, int n) {
        int min = vet[0], max = vet[0];
        for (int i = 1; i < n; i++) {
            if (vet[i] < min) min = vet[i];
            if (vet[i] > max) max = vet[i];
        }

        long intervalo = (long) max - min + 1;
        if (intervalo > (long) n * 10) {
            throw new IllegalArgumentException(
                "Counting Sort: intervalo de valores (" + intervalo + ") e muito " +
                "grande para N=" + n + ". Use outro algoritmo."
            );
        }

        int[] count = new int[(int) intervalo];
        for (int i = 0; i < n; i++) count[vet[i] - min]++;
        int idx = 0;
        for (int i = 0; i < count.length; i++)
            while (count[i]-- > 0) vet[idx++] = i + min;
    }
}