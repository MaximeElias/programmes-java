import java.io.*;

class TriSelection {

    int[] tab = {4, 5, 10, 2, 5, 6};

    void run() {
        System.out.println("Index du plus petit élément : " + rechercheIndex(tab));
        afficher(tab);
        permuter(1, 3);
        System.out.println("Après permutation :");
        afficher(tab);
        triParSelection(tab);
        System.out.println("Après tri par sélection :");
        afficher(tab);
    }

    void afficher(int[] tab) {
        for(int i=0; i < tab.length-1; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.println(tab[tab.length-1]);
    }

    int rechercheIndex(int[] tab) {
        int v = 0;  // Initialise v à 0 pour trouver l'index du plus petit élément
        for(int i = 1; i < tab.length; i++) {  // Commence à l'index 1 pour comparer avec tab[0]
            if(tab[i] < tab[v]) {
                v = i;
            }
        }
        return v;  // Retourne l'index du plus petit élément
    }

    void permuter(int i1, int i2) {
        int permutation = tab[i1];
        tab[i1] = tab[i2];
        tab[i2] = permutation;
    }

    void triParSelection(int[] tab) {
        for (int i = 0; i < tab.length - 1; i++)  {
            int index = i;  
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[j] < tab[index]){ 
                    index = j;
                }
            }
            // Utilise la méthode permuter pour échanger les éléments
            permuter(i, index);
        }
    }

    public static void main(String[] args) {  
        new TriSelection().run();
    }
}
