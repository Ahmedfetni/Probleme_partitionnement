import java.util.*;

public class Test1 {

    public static void main(String[] args) {

        Modele partition = new Modele();

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez entrer le nombre d'elements dans le tableau a partitionner");
        int N = sc.nextInt();

        // generation du tableau des entiers a partitionner
        int [] arr; Boolean valide;

        arr = partition.generation_tableau(N);
        partition.Affichage(arr);

        // generation d'une solution quelconque

        int [] sol;
        sol = partition.generation_solution(N);
        partition.Affichage(sol);

        // verifier la validite d'une solution
        valide= partition.validation_solution(sol,arr);

        if(valide) System.out.println("la solution que vous avez donne est valide");
        else System.out.println("la solution que vous avez propose n'est pas valide");

        // evaluation de la solution
        partition.evaluation_solution(sol,arr);

    }
}
