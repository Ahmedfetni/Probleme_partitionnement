

public class DFS {
    Noeud[] graphe;


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


    private static Noeud creeRacine(int nb){
        return new Noeud(Modele.generation_solution(nb),0);
    }
    static public void recherche(Noeud racine){

    }
}
