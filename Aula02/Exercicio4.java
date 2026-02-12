public class Exercicio4 {

    //Crie uma função recursiva que retorne a soma dos elementos de um vetor de N inteiros

    public static int soma(int[] vet, int i){
        int res = 0;
        if(i == vet.length - 1){
            return res + vet[i];
        }else{
            return vet[i] + soma(vet, i + 1);
        }
        
    }
    public static void main(String[] args) {
    //int[] vet = new int[6];
    int[] vet = {1,2,3,4, 5};
    int res = 0;
    System.out.println(soma(vet, res));
    }
}
