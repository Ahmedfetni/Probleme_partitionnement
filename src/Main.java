import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.System.*;
import static java.time.Duration.*;

public class Main {
    public static void main(String[] args) {

        //Duration.between(inst1, inst2).toString()
       /* Random rand = new Random();
        for (int i = 2; i < 24; i++) {
            int[] arr = new int[i];
            for (int l = 0; l < i; l++) {
                arr[l] = rand.nextInt(0, 100);
            }
            long start = currentTimeMillis();
            DFS.recherche(DFS.creeRacine(arr.length), arr, arr.length, false);
            long stop = currentTimeMillis();
            System.out.println("temps d'execution pour N= " + i + " est " + (stop - start)+"ms");

        }*/


        //dataset

        out.println("Data Set \n");
        int[] a = {31, 10, 20, 19, 4, 3, 6};
        int[] b = {25, 35, 45, 5, 25, 3, 2, 2};
        int[] c = {3, 4, 3, 1, 3, 2, 3, 2, 1};
        int[] d = {2, 10, 3, 8, 5, 7, 9, 5, 3, 2};
        int[] e = {484, 114, 205, 288, 506, 503, 201, 127, 410};
        int[] f = {23, 31, 29, 44, 53, 38, 63, 85, 89, 82};
        int[] g = {771, 121, 281, 854, 885, 734, 486, 1003, 83, 62};
        int[] h = {70, 73, 77, 80, 82, 87, 90, 94, 98, 106, 110, 113, 115, 118, 120};
        int[] j = {382745, 799601, 909247, 729069, 44328, 34610, 698150, 823460, 903959, 853665, 551830, 610856, 670702, 488960, 951111, 323046, 446298, 931161, 31385, 496951, 264724, 224916, 169684};
        ArrayList<int[]> dataset = new ArrayList<int[]>();
        dataset.add(a);
        dataset.add(b);
        dataset.add(c);
        dataset.add(d);
        dataset.add(e);
        dataset.add(f);
        dataset.add(g);
        dataset.add(h);
        dataset.add(j);

        for (int i = 0; i < dataset.size(); i++) {
            long start = System.currentTimeMillis();
            DFS.recherche(DFS.creeRacine(dataset.get(i).length), dataset.get(i), dataset.get(i).length, false);
            long stop = System.currentTimeMillis();
            out.println("temps d'execution est "+(stop-start)+"ms");
        }


    }
}