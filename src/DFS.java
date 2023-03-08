import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
    static Noeud solutionOptimal = null;
    //TODO to optmize just use  the default size instead of taille

    private static void successeurs(Noeud n, int index, int taille) {
        //   index
        //[   -1,      -1,         -1,     -1,     -1]
        //   /    \
        //index+1  index+1
        if (n.getIndex() <= taille - 1) { //verifier si ce noeud n'est pas ue feuille

            // initialiser les les tableau
            Noeud[] result = new Noeud[2]; // tab des successeurs

            int[] inter1 = new int[taille];   // tab des solutions des successeurs
            System.arraycopy(n.getSol(), 0, inter1, 0, n.getSol().length);

            inter1[n.getIndex() + 1] = 0; //premier fils aura 0
            Noeud child1 = new Noeud(inter1, n.getIndex() + 1);

            int[] inter2 = new int[n.getSol().length];
            System.arraycopy(n.getSol(), 0, inter2, 0, taille);
            inter2[n.getIndex() + 1] = 1; // deucime fils aura 1
            Noeud child2 = (new Noeud(inter2, n.getIndex() + 1));

            result[0] = child1;
            result[1] = child2;

            n.setChildren(result);
            return;
        }
        n.setChildren(null);
    }


    private static boolean etatFinal(Noeud n, int taille) {
        for (int i = 0; i < taille; i++) { //TODO change it to if on the index
            if (n.getSol()[i] == -1)
                return false;
        }
        return true;
    }


    public static void initWithOne(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

    public static Noeud creeRacine(int taille) {
        int[] tab = new int[taille];
        Modele.init_Tableau(tab);
        return new Noeud(tab, -1);
    }


    public static void recherche(Noeud racine, int[] arrayOriginal, int taille, boolean afficherTousLesSolution) {
        // intialisation de la valeur optimal
        int[] arr = new int[taille];
        initWithOne(arr);

        ArrayList<Noeud> listDesSolutionOptimal = new ArrayList<Noeud>();
        listDesSolutionOptimal.add(new Noeud(arr, 0));
        long nombre_des_noeud = 0;
        long nombre_desSolution = 0;

        //init flags
        boolean solutionTrouver = false;

        ArrayList<Noeud> ouvert = new ArrayList<Noeud>(); // la pile
        ArrayList<Noeud> ferme = new ArrayList<Noeud>();

        ouvert.add(racine);

        while (!ouvert.isEmpty()) {

            Noeud n = ouvert.get(ouvert.size() - 1); //tete de la pile
            //if(ferme.contains(n))
            ouvert.remove(n);
            ferme.add(n);


            if (etatFinal(n, taille)) {


                if (Modele.validation_solution(arrayOriginal,
                        n.getSol())) {
                    nombre_desSolution++;
                    solutionTrouver = true;
                    //Si etat final alors solution
                    if (afficherTousLesSolution)
                        System.out.println(n);

                    if (Modele.evaluation_solution(arrayOriginal, n.getSol()) <
                            Modele.evaluation_solution(arrayOriginal, listDesSolutionOptimal.get(0).getSol())) {
                        for (int i = 0; i < listDesSolutionOptimal.size(); i++) {
                            listDesSolutionOptimal.remove(listDesSolutionOptimal.get(i));
                        }
                        listDesSolutionOptimal.add(n);
                    } else if (Modele.evaluation_solution(arrayOriginal, n.getSol()) ==
                            Modele.evaluation_solution(arrayOriginal, listDesSolutionOptimal.get(0).getSol())) {
                        listDesSolutionOptimal.add(n);
                    }
                }
                continue;
            }
            successeurs(n, n.getIndex(), taille);
            if (!solutionTrouver) {
                nombre_des_noeud++;
            }

            if (n.getChildren() == null)
                System.exit(-1);

            for (int i = 0; i < n.getChildren().length; i++) {
                ouvert.add(n.getChildren()[i]);
            }


        }

        System.out.println("La liste des solutions la optimal");
        for (int i = 0; i < listDesSolutionOptimal.size(); i++) {
            System.out.println(listDesSolutionOptimal.get(i));
        }
        System.out.println("nombre des noeud avant la premiere solution " + nombre_des_noeud);
        System.out.println("nombre des solution generer "+nombre_desSolution);
        System.out.println("nombre des solutions avec une diffrence minimal "
                +listDesSolutionOptimal.size()+
                " la diffrence minimale "+ Modele.evaluation_solution(arrayOriginal, listDesSolutionOptimal.get(0).getSol()));


    }
}
