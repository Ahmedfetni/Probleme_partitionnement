import java.util.*;
public class Modele {

    public static void  init_Tableau(int arr[]){
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = -1;
        }
    }
    public static int[] generation_solution(int nb){

        int[] S = new int [nb];

        Random r = new Random();
        for (int i=0;  i<S.length;  i++) {
            int value = r.nextInt(0,2);
            S[i] = value;
        }

        return S;
    }

    public static   int[] generation_tableau(int nb){

        int[] arr = new int [nb];

        Random r = new Random();
        for (int i=0;  i<arr.length;  i++) {
            int value = r.nextInt(100);
            arr[i] = value;
        }

        return arr;
    }

    public static void Affichage(int arr[]){
        System.out.println("le tableau genere est: ");
        System.out.println(Arrays.toString(arr));
    }

    public static Boolean validation_solution( int arr[],int sol[]){
         int i = 0;
         int count1=0, count2=0;

        // verifier qu'on a exploite tous les elements du tableau a partitionner
        if(sol.length != arr.length)
            return false;

        while (i< sol.length){
            if( sol[i]!= (1) && sol[i] != 0)
                return false;
            i++;
        }

        // verifier l'inexistance d'un ensemble vide
        for (int j=0;  j<sol.length;  j++) {
            if(sol[j]==0) count1++;
            if(sol[j]==1) count2++;
        }
        if(count1==0 || count2==0)
            return  false;

        return true;

    }



    //calculer la somme

    public static int evaluation_solution(int arr[],int sol[]){
        int diffrence= 0;
        for (int i = 0; i < arr.length ; i++) {
            if (sol[i] == 0){
                diffrence += arr[i] ;

            }
            if (sol[i] == 1){
                diffrence -= arr[i];
            }

        }
        return Math.abs(diffrence);

    }



}
