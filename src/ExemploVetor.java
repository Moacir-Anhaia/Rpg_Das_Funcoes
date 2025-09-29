import java.util.Random;

public class ExemploVetor {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] vetor = new int[10];

        System.out.println("----------Números Aleatórios----------");
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(100);
            System.out.println("Posiçao vetor "+ i + ": " + vetor[i]);
        }

    }
}
