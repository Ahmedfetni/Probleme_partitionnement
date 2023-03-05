import java.util.Arrays;

public class Noeud{
        private int index ;
        private int[] sol;//tab des 1 et 0 map
        private Noeud[] children ;


        public Noeud(int sol[], int index){
                this.sol = sol;
                this.index = index;
                this.children = null;

        }



        public int[] getSol(){
                return sol;
        }
        public int getIndex(){
                return index;
        }

        public Noeud[] getChildren() {
                return children;
        }

        public void setChildren(Noeud[] children) {
                this.children = children;
        }

        //for prints
        @Override
        public String toString(){
                return Arrays.toString(sol);
        }
}
