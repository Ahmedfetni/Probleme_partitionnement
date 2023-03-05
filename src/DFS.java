import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
    static  Noeud solutionOptimal = null;
    //TODO to optmize just use  the default size instead of taille

    private static  void successeurs(Noeud n, int index , int taille){
        if(n.getIndex() == taille-1 ){ //verifier si ce noeud n'est pas ue feuille

            // initialiser les les tableau
            Noeud[] result = new Noeud[2]; // tab des successeurs
            int[] inter = n.getSol();    // tab des solutions des successeurs

            inter[n.getIndex()+1] = 0; //premier fils aura 0
            Noeud child1 = new Noeud(inter,n.getIndex()+1 );

            inter[n.getIndex()+1] = 1; // deucime fils aura 1
            Noeud child2 =( new Noeud(inter,n.getIndex()+1 ));

            n.setChildren(result);
            return;
        }
        n.setChildren(null);
    }
    private static boolean etatFinal(Noeud n, int taille ){
            for(int i=0 ; i < taille ; i++ ){ //TODO change it to if on the index
                if(n.getSol()[i] == -1 )
                    return false;
            }
            return true;
    }


    public static Noeud creeRacine(int taille){
        int[] tab = new int[taille];
        Modele.init_Tableau(tab);
        return new Noeud(tab,0);
    }
    public static void recherche(Noeud racine,int[]arrayOriginal, int taille){
                // intialisation de la valeur optimal
                int[] arr = new int[taille];
                Modele.init_Tableau(arr);
                solutionOptimal = new Noeud(arr, 0);


                ArrayList<Noeud> ouvert = new ArrayList<Noeud>(); // la pile
                ArrayList<Noeud> ferme = new ArrayList<Noeud>();

                ouvert.add(racine);

                while (!ouvert.isEmpty()){

                    Noeud n = ouvert.get(ouvert.size() -1); //tete de la pile

                    ferme.add(n);

                    if(etatFinal(n, taille)){

                        if (Modele.validation_solution(arrayOriginal,
                                n.getSol())){

                            if(Modele.evaluation_solution(racine.getSol(),n.getSol()) <
                                    Modele.evaluation_solution(arrayOriginal,solutionOptimal.getSol())){
                                solutionOptimal =  n;
                                continue;
                            }
                            successeurs(n,n.getIndex(),taille);
                            for(int i = 0; i < n.getChildren().length;i++)
                                ouvert.add(n.getChildren()[i]);

                        }
                    }
                }
        System.out.println("La solution optimal est "+
                Arrays.toString(solutionOptimal.getSol()));

    }
}
