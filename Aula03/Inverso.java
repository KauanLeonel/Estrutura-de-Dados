package Aula03;

public class Inverso {

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
    }

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

    private static void ordenar(int[] vet, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    troca(vet, j, j + 1);
                }
            }
        }
    }

        static void insertion(int[] vet, int N){
        
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
               if(vet[j] < menor){
                   menor = vet[j];
                   posMenor = j;
               }
               if(vet[j] > maior){
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
                  if (comp) break;
                }
            }
        }
    }
    
    
