import java.util.Random;

public class Main {
    public static void main(String[] args) {
       int[] arr ={ 5,6,12,1,3} ;
       DFS.recherche(DFS.creeRacine(arr.length),arr,arr.length,true);

    }
}