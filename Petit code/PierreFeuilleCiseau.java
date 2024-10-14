import java.io.*;
import java.util.*;
import java.util.Random;

class PierreFeuilleCiseau {

    Scanner in = new Scanner(System.in);

    final int pierre = 1;
    final int papier = 2;
    final int ciseaux = 3;

    int scoreHumain = 0;
    int scoreOrdi = 0;
    int choixOrdi;
    int choixHumain;

    void mouvement(int choix) {
        switch (choix){
            case 1:
                System.out.print("Pierre ");
                break;
            case 2:
                System.out.print("Papier ");
                break;
            case 3:
                System.out.print("Ciseaux ");
                break;
        }
    }

    int joueurHumain() {
        do {
            System.out.print("\n1 : pierre, 2 : papier, 3 : ciseaux ? ");
            choixHumain = in.nextInt();
            if(choixHumain < 0 || choixHumain > 3) {
                System.out.println("Erreur, entrer une bonne valeur");
            }
        }
        while(choixHumain < 0 || choixHumain > 3);
        return choixHumain;
    }

    void ordiIA() {
        choixOrdi = 0;
        Random random = new Random();
        int nb = random.nextInt(1, 101);
        if(nb <= 41) {
            choixOrdi = 1;
        }
        else if(nb > 41 && nb <= 71) {
            choixOrdi = 2;
        }
        else if (nb>71){
            choixOrdi = 3;
        }
    }

    void scoreAjout() {
        if(choixOrdi == choixHumain) {
            System.out.println("Pas de point, égalité");
        }
        else if((choixOrdi == pierre && choixHumain == papier) || (choixOrdi == papier && choixHumain == ciseaux) || (choixOrdi == ciseaux && choixHumain == pierre)) {
            System.out.println("Point pour le Joueur");
            scoreHumain ++;
        }
        else {
            System.out.println("Point pour l'Ordi");
            scoreOrdi ++;
        }
    }

    void jeu() {
        System.out.println("Pierre-papier-ciseaux. Le premier à 5 a gagné !");
        scoreHumain = 0;
        scoreOrdi = 0;
        do {
            joueurHumain();
            System.out.print("Vous montrez ");
            mouvement(choixHumain);
            System.out.print("- Je montre ");
            ordiIA();
            mouvement(choixOrdi);
            scoreAjout();
            System.out.print("vous " + scoreHumain + " moi " + scoreOrdi);
        }
        while(scoreHumain < 5 && scoreOrdi < 5);

        if(scoreHumain==5){
            System.out.println("\nVous avez win");
        }
        else {
            System.out.println("\n L'IA a win");
        }
    }

    public static void main(String[] args) {  
        new ppc().jeu();
    }
}
