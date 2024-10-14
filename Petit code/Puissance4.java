import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Puissance4 {

    Scanner in = new Scanner(System.in);
    public static final String ANSI_RED = "\033[0;31m";
    public static final String ANSI_YELLOW = "\033[0;33m";
    public static final String ANSI_BLUE = "\033[0;34m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    final int rouge = 1;
    final int jaune = 2;
    final int colonne = 7;
    final int ligne = 6;
    boolean win=false;
    int tour=0;

    int[][] plateau = new int[ligne][colonne];
    int joueur = rouge;

    void afficher(int[][] tab) {
        for (int[] plateau : plateau) {
            for (int s: plateau) {
                if(s==0){
                    System.out.print(ANSI_BLUE+" |  "+ANSI_RESET);
                }
                else if(s==1){
                    System.out.print(ANSI_BLUE+" | "+ANSI_RED+"O"+ANSI_RESET);
                }
                else if(s==2){
                    System.out.print(ANSI_BLUE+" | "+ANSI_YELLOW+"O"+ANSI_RESET);
                }
            }
            System.out.println(ANSI_BLUE+" | ");
        }

        for (int i=1;i<=colonne;i++){
            System.out.print(ANSI_BLUE+" | "+i);
        }
        System.out.println(" |\n"+ANSI_RESET);
    }

    void update(int joueur, int[][] tab) {
        int coup;
        if (joueur==1){
            System.out.print(ANSI_RED);
        }
        else {
            System.out.print(ANSI_YELLOW);
        }
        do{
            System.out.println("Dans quelle colonne voulez-vous mettre le pions ?");
            coup = in.nextInt();
            System.out.println("");
        }
        while (coup>colonne || coup<1);   
        System.out.print(ANSI_RESET); 
        for(int i = ligne-1; i>=0; i--) {
            if(tab[i][coup-1] == 0) {
                tab[i][coup-1] = joueur;
                break;
            }
        }
        
    }

    boolean estRempli(int[][] tab) {
        int tmp=0;
        for(int i = 0; i<colonne; i++) {
            if(tab[0][i] != 0){
                tmp=tmp+1;
            }   
        }
        if (tmp==colonne){
            System.out.println("Plateau rempli !");
            return true;
        }
        return false;
    }

    void rangee4(int[][] tab, int joueur){
        int somme=0;
        for(int i=0;i<ligne;i++){
            for(int j=0;j<colonne;j++){
                if (tab[i][j]!=joueur || tab[i][j]==0){
                    somme=0;
                }
                else if (tab[i][j]==joueur){
                    somme=somme+1;
                }
                if (somme==4) {
                    System.out.println("\nLe joueur "+joueur+" a complété une rangée, il a gagné\n");
                    win=true;
                }
            }
        }
    }

    void colonne4(int[][] tab, int joueur){
        int somme=0;
        for(int i=0;i<colonne;i++){
            for(int j=0;j<ligne;j++){
                if (tab[j][i]!=joueur || tab[j][i]==0){
                    somme=0;
                }
                else if (tab[j][i]==joueur){
                    somme=somme+1;
                }
                if (somme==4) {
                    System.out.println("\nLe joueur "+joueur+" a complété une cologne, il a gagné\n");
                    win=true;
                }
            }
        }
    }

    void diagonale4(int[][] tab, int joueur) {
        //haut gauche vers bas droite 
        for (int i = 0; i < ligne - 3; i++) {
            for (int j = 0; j < colonne - 3; j++) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    if (tab[i + k][j + k] == joueur) {
                        count++;
                    }
                }
                if (count == 4) {
                    win = true;
                    System.out.println("Diagonale de 4 pour le joueur " + joueur);
                    return;
                }
            }
        }

        //haut droite vers bas gauche
        for (int i = 0; i < ligne - 3; i++) {
            for (int j = colonne - 1; j >= 3; j--) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    if (tab[i + k][j - k] == joueur) {
                        count++;
                    }
                }
                if (count == 4) {
                    win = true;
                    System.out.println("Diagonale de 4 pour le joueur " + joueur);
                    return;
                }
            }
        }
    }

    void gagne(){
        if (joueur==1){
            System.out.print(ANSI_RED);
        }
        else {
            System.out.print(ANSI_YELLOW);
        }
        rangee4(plateau,joueur);
        colonne4(plateau, joueur);
        diagonale4(plateau,joueur);
        System.out.print(ANSI_RESET); 
    }

    void run() {
        while(!win && !estRempli(plateau)){
            if (tour%2==0){
                joueur=rouge;
            }
            else{
                joueur=jaune;
            }
            tour++;
            if (joueur==1){
                System.out.println(ANSI_RED+"\nTour du joueur " + joueur + "\n"+ANSI_RESET);
            }
            else {
                System.out.println(ANSI_YELLOW+"\nTour du joueur " + joueur + "\n"+ANSI_RESET);
            }
            afficher(plateau);
            update(joueur, plateau);
            afficher(plateau);
            gagne();
        }

        if (estRempli(plateau)){
            System.out.println("Il n'y a pas de gagnant");
        }    
        System.out.print(ANSI_RESET);            
    }

    public static void main(String[] args) {  
        new Puissance4().run();
    }
}