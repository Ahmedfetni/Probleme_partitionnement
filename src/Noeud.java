public class Noeud{
        private int index ;
        private int[] sol;
        private Noeud[] children ;
        public Noeud(int sol[], int index){
                this.sol = sol;
                this.index = index;

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
}
