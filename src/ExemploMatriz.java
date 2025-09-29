import java.util.Random;

public class ExemploMatriz {
    public static void main(String[] args) {
    int[][] matriz = new int[4][4];
    Random rand = new Random();

    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            matriz[i][j] = rand.nextInt(100);
            System.out.print(matriz[i][j] + " ");
        }
        System.out.println();
    }


    }
}
