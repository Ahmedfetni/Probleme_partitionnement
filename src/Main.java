import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
       /* int[] arr = new int[6];
        Random rand = new Random();
        for (int i = 0; i <6 ; i++) {
            arr[i] = rand.nextInt(0,100);
        }
        System.out.println(Arrays.toString(arr));*/
        int[] arr = {41, 99, 8, 3, 2,20 };//{ 5,6,12,1,3} ;

        DFS.recherche(DFS.creeRacine(arr.length),arr,arr.length,true);

    }
}