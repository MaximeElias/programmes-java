import java.io.*;

class Statistique {

    int[] tab = {1, 2, 5, 3, 8};

    void run() {
        System.out.println(somme(tab));
        System.out.println(moyenne(tab));
        System.out.println(variance(tab));
        System.out.println(ecart_type(tab));
    }

    int somme(int[] tab){
        int calcul = 0;
        for(int i =0; i<tab.length; i++) {
            calcul = calcul + tab[i];
        }
        return calcul;
    }

    float moyenne(int[] tab){
        float calcul = 0;
        calcul = somme(tab);
        return calcul/tab.length;
    }

    double variance(int[] tab){
        double calcul = 0;
        for(int i =0; i<tab.length; i++) {
            calcul = calcul + Math.pow(tab[i] - moyenne(tab), 2);
        }
        return calcul/tab.length;
    }

    double ecart_type(int[] tab){
        return Math.sqrt(variance(tab));
    }

    public static void main(String[] args) {  
        new Statistique().run();
    }
}
