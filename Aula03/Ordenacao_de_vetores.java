package Aula03;

public class Ordenacao_de_vetores {

    public static void main(String[] args) {

        //#region VARIÁVEIS
        int N = 10000;

        int vetAleatorio_1[] = new int[N];
        int vetMelhorCaso_1[] = new int[N];
        int vetPiorCaso_1[] = new int[N];

        inicializarVetor(vetAleatorio_1, N, 0); //0-aleatório, 1-crescente, 2-decrescente
        inicializarVetor(vetMelhorCaso_1, N, 1); //0-aleatório, 1-crescente, 2-decrescente
        inicializarVetor(vetPiorCaso_1, N, 2); //0-aleatório, 1-crescente, 2-decrescente

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

        int vetAleatorio_9[] = vetAleatorio_1.clone();
        int vetMelhorCaso_9[] = vetMelhorCaso_1.clone();
        int vetPiorCaso_9   [] = vetPiorCaso_1.clone();


        long inicio, fim, tempoS, tempoMS;
        //#endregion

        //#region ORDENAÇÃO RUIM
        //////// ORDENAÇÃO RUIM ! /////////////////
        
        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        ordenar(vetAleatorio_1, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenar(vetMelhorCaso_1, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenar(vetPiorCaso_1, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao Pior Caso: " + tempoS + "s" + tempoMS + "ms");

        //#endregion
        //#region ORDENAÇÃO MELHORADO ! 
        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhorado(vetAleatorio_2, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhorado(vetMelhorCaso_2, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhorado(vetPiorCaso_2, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado) Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        // exibirVetor(vetPiorCaso_2, N);

        //#endregion
        //#region ORDENAÇÃO insertion ! 
        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        insertion(vetAleatorio_3, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(insertion) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        insertion(vetMelhorCaso_3, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(insertion) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        insertion(vetPiorCaso_3, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(insertion) Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        // exibirVetor(vetPiorCaso_2, N);
        //#endregion

        //#region ORDENAÇÃO MAIOR MENOR ! 
        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        ordenarMaiorMenor(vetAleatorio_4, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(ordenarMaiorMenor) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenarMaiorMenor(vetMelhorCaso_4, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(ordenarMaiorMenor) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenarMaiorMenor(vetPiorCaso_4, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(ordenarMaiorMenor) Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        // exibirVetor(vetPiorCaso_2, N);
        //#endregion

        //#region ORDENAÇÃO SELECTION ! 
        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        selection_sort(vetAleatorio_5, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(SELECTION) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        selection_sort(vetMelhorCaso_5, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(SELECTION) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        selection_sort(vetPiorCaso_5, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(SELECTION) Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        // exibirVetor(vetPiorCaso_2, N);
        //#endregion

        //#region ORDENAÇÃO MERGE ! 
        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        mergeSort(vetAleatorio_6, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(MERGE) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        mergeSort(vetMelhorCaso_6, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(MERGE) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        mergeSort(vetPiorCaso_6, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(MERGE) Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        // exibirVetor(vetPiorCaso_2, N);
        //#endregion

          //#region ORDENAÇÃO Heapsort ! 
        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        heapSort(vetAleatorio_7);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(Heapsort) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        heapSort(vetMelhorCaso_7);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(Heapsort) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        heapSort(vetPiorCaso_7);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(Heapsort) Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        // exibirVetor(vetPiorCaso_2, N);
        //#endregion

        //#region ORDENAÇÃO quickSort ! 
        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        quickSort(vetAleatorio_8, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(quickSort ) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        quickSort(vetMelhorCaso_8, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(quickSort ) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        quickSort(vetPiorCaso_8, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(quickSort) Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        // exibirVetor(vetPiorCaso_2, N);
        //#endregion

        //#region ORDENAÇÃO Counting sort ! 
        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        countingSort(vetAleatorio_9,N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(Counting sort ) Aleatorio: " + tempoS + "s" + tempoMS + "ms");

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        countingSort(vetMelhorCaso_9, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(Counting sort ) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        countingSort(vetPiorCaso_9, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(Counting sort) Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        // exibirVetor(vetPiorCaso_2, N);
        //#endregion
    }

    //#region Métodos
    static void inicializarVetor(int vet[], int N, int s) {
        switch (s) {
            case 0:
                for (int i = 0; i < N; i++) {
                    vet[i] = (int) (Math.random() * (N * 2));
                }
                break;
            case 1:
                for (int i = 0; i < N; i++) {
                    vet[i] = i + 1;
                }
                break;
            case 2:
                for (int i = 0; i < N; i++) {
                    vet[i] = N - i;
                }
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
    //#endregion

    //#region Ordenação
    private static void ordenar(int[] vet, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    troca(vet, j, j + 1);
                }
            }
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

    private static void ordenarMaiorMenor(int[] vet, int N) {

        int contMenor = 0;
        int contMaior = N - 1;
        int menor = vet[0];
        int maior = vet[0];
        int posMenor = 0;
        int posMaior = 0;

        while (contMenor < contMaior) {
            for (int j = contMenor + 1; j < contMaior; j++) {
                if (vet[j] < menor) {
                    menor = vet[j];
                    posMenor = j;
                }
                if (vet[j] > maior) {
                    maior = vet[j];
                    posMaior = j;
                }

            }
            troca(vet, contMenor, posMenor);
            troca(vet, contMaior, posMaior);

            contMenor++;
            contMaior--;
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
                if (comp) {
                    break;
                }
            }
        }
    }

    private static void selection_sort(int vet[], int n) {
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

    //#region MergeSort
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

        while (i <= meio) {
            aux[k++] = vet[i++];
        }

        while (j <= fim) {
            aux[k++] = vet[j++];
        }

        // copia de volta para o vetor original
        for (int x = 0; x < tam; x++) {
            vet[inicio + x] = aux[x];
        }
    }
    //#endregion

    //heapSort
    public static void heapSort(int[] vetor) {
        int tamanho = vetor.length;
        int i = tamanho / 2, pai, filho, t;
        while (true) {
            if (i > 0) {
                i--;
                t = vetor[i];
            } else {
                tamanho--;
                if (tamanho <= 0) {
                    return;
                }
                t = vetor[tamanho];
                vetor[tamanho] = vetor[0];
            }
            pai = i;
            filho = ((i * 2) + 1);
            while (filho < tamanho) {
                if ((filho + 1 < tamanho) && (vetor[filho + 1] > vetor[filho])) {
                    filho++;
                }
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

    //Couting sort
    private static void countingSort(int[] vet, int N) {

    // 1️⃣ Encontrar o maior valor
    int maior = vet[0];
    for (int i = 1; i < N; i++) {
        if (vet[i] > maior) {
            maior = vet[i];
        }
    }

    // 2️⃣ Criar vetor de contagem
    int[] count = new int[maior + 1];

    // 3️⃣ Contar ocorrências
    for (int i = 0; i < N; i++) {
        count[vet[i]]++;
    }

    // 4️⃣ Reconstruir o vetor ordenado
    int indice = 0;

    for (int i = 0; i <= maior; i++) {
        while (count[i] > 0) {
            vet[indice] = i;
            indice++;
            count[i]--;
        }
    }
}

    //QuickSort
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

    private static int particionar(int[] vet, int inicio, int fim) {

        int pivo = vet[fim]; // escolhe o último como pivô
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
    //#endregion
}
