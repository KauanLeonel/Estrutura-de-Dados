
public class Exercicio5 {
    //Escreva uma função recursiva que retorne o menor elemento de um vetor

    public static int menor(int[] vet, int indice) {
        int menor = vet[indice];
        if(indice == vet.length - 2){
            if(vet[indice] > vet[indice + 1]){
                return vet[indice + 1];
            } else{
                return vet[indice];
            }
        }
        return menor(vet, indice + 1);
    }

    public static void main(String[] args) {
        int[] vet = {2, 1, 3, 0, 5, -1};
        System.out.println(menor(vet, 0));
    }
}
