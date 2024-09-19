import java.io.*;
import java.util.Scanner;
import java.util.Random;

class JeuDuChameau {

    Scanner in = new Scanner(System.in);
    Random random = new Random();

    final int KM_VOYAGE = 300; // Distance à parcourir pour gagner
    final int KM_NORM_MIN = 10; // Distance min. à la vitesse normale
    final int KM_NORM_MAX = 15; // Distance max. à la vitesse normale
    final int KM_RAP_MIN = 20; // Distance min. à toute vitesse
    final int KM_RAP_MAX = 25; // Distance max. à toute vitesse
    final int AVANTAGE_VOYAGEUR = 20; // L'avantage initial du voyageur
    final int GOURDE_PLEINE = 12; // Le nombre de gorgées de la gourde
    final int MORT_SOIF = 4; // Nombre de tours pour mourir de soif
    final int MORT_FATIGUE = 4; // Nombre de tours pour mourir de fatigue
    final int DIF_AIDE = 3; // Difficulté pour trouver de l'aide
    final int AVANCE_NATIFS = 4; // Vitesse des natifs
    final int SPECIAL = 10; // Choix environnement

    int kmVoyageur; // Distance totale parcourue
    int kmNatifs; // Distance parcourue par les natifs
    int gourde; // Nombre de gorgées dans la gourde
    int soif; // Niveau de soif du voyageur
    int fatigue; // Niveau de fatigue du chameau
    int reponse;
    int environnement;
    int avance_natif;

    void initVariables() {
        kmVoyageur = 0;
        kmNatifs = kmVoyageur - AVANTAGE_VOYAGEUR;
        gourde = GOURDE_PLEINE / 2;
        soif = 0;
        fatigue = 0;
        environnement = random.nextInt(0, SPECIAL + 1);
        avance_natif = random.nextInt(0, AVANCE_NATIFS);
    }

    void run() {
        initVariables();
        System.out.println("\nLE JEU DU CHAMEAU !\n");
        System.out.println("Vous avez volé un chameau pour traverser le grand désert.");
        System.out.println("Les natifs veulent le récupérer.");
        System.out.println("Votre objectif est de survivre à la traversée de 300km sans être attrapé(e).");

        do {
            System.out.println("\n==================[ OPTIONS ]==================\n");
            System.out.println("1. Boire");
            System.out.println("2. Avancer normalement");
            System.out.println("3. Avancer à toute vitesse");
            System.out.println("4. Repos");
            System.out.println("5. Espérer de l'aide");
            System.out.println("0. Terminer la partie");
            System.out.println(" ");
            System.out.println("Qu'allez-vous faire ?\n");

            reponse = in.nextInt();

            // Augmenter la soif à chaque tour
            soif += 1;

            // Gérer les événements environnementaux
            if (environnement == 0) {
                System.out.println("\n==================[ EVENTS ]==================");
                System.out.println("Vous avez trouvé une Oasis !!");
                System.out.println("Vous avez rempli votre gourde");
                System.out.println("Les natifs n'ont pas pu avancer");
                gourde = GOURDE_PLEINE;
                avance_natif = 2;
            } else if (environnement == 1) {
                System.out.println("\n==================[ EVENTS ]==================");
                System.out.println("Une tempête de sable s’abat sur le désert !!");
                System.out.println("Vous êtes bloqué et devez attendre");
                System.out.println("Les natifs marchent malgré le temps");
                reponse = 4;
                avance_natif = 1;
            }

            System.out.println("\n===================[ CHOIX ]===================");
            switch (reponse) {
                case 1:
                    boire();
                    break;
                case 2:
                    avancerNormalement();
                    break;
                case 3:
                    avancerVitesse();
                    break;
                case 4:
                    repos();
                    break;
                case 5:
                    espererAide();
                    break;
                case 0:
                    continuerPartie();
                    break;
                default:
                    System.out.println("\nOption invalide !");
            }

            afficherEtat();
            avancerNatifs();

        } while (reponse != 0 && kmVoyageur <= KM_VOYAGE && kmVoyageur > kmNatifs && soif <= MORT_SOIF && fatigue < MORT_FATIGUE);

        finPartie();
    }

    void boire() {
        if (gourde == 0) {
            System.out.println("\nLa gourde est vide !");
        } else {
            soif = 0;
            gourde -= 1;
            System.out.println("\nVous avez bu une gorgée.");
            System.out.println("Il vous reste " + gourde + " gorgées dans votre gourde.");
        }
    }

    void avancerNormalement() {
        fatigue += 1;
        int distance_norm = random.nextInt(KM_NORM_MIN, KM_NORM_MAX + 1);
        kmVoyageur += distance_norm;
        System.out.println("\nVotre chameau a une fatigue de " + fatigue);
        System.out.println("Vous avez parcouru " + distance_norm + " km, vous êtes maintenant à " + kmVoyageur + " km.");
    }

    void avancerVitesse() {
        fatigue += 2;
        int distance_rap = random.nextInt(KM_RAP_MIN, KM_RAP_MAX + 1);
        kmVoyageur += distance_rap;
        System.out.println("\nVotre chameau a une fatigue de " + fatigue);
        System.out.println("Vous avez parcouru " + distance_rap + " km, vous êtes maintenant à " + kmVoyageur + " km.");
    }

    void repos() {
        fatigue = 0;
        System.out.println("\nVotre chameau s’est bien reposé, sa fatigue est de 0.");
    }

    void espererAide() {
        int aide = random.nextInt(0, DIF_AIDE + 1);
        if (aide == 0) {
            System.out.println("\nVous avez trouvé de l’aide !");
            gourde = Math.min(gourde + 3, GOURDE_PLEINE);
            System.out.println("Quelques gorgées ont été ajoutées à votre gourde.");
        } else {
            System.out.println("\nVous n'avez pas trouvé de l’aide !");
        }
    }

    void continuerPartie() {
        System.out.println("\nMerci d'avoir joué !");
    }

    void avancerNatifs() {
        if (avance_natif == 0) {
            kmNatifs += random.nextInt(KM_NORM_MIN, KM_NORM_MAX + 1);
        } else if (avance_natif == 1) {
            kmNatifs += random.nextInt(KM_RAP_MIN, KM_RAP_MAX + 1);
        }
    }

    void afficherEtat() {
        // Affichage de la soif
        if (soif == MORT_SOIF) {
            System.out.println("Vous êtes mort de soif !");
        } else {
            System.out.println("Soif (" + soif + "/4)");
        }

        // Affichage de la fatigue
        System.out.println("Fatigue (" + fatigue + "/4)");

        // Affichage de la gourde et distance aux natifs
        System.out.println("Gourde (" + gourde + "/" + GOURDE_PLEINE + ")");
        System.out.println("Vous êtes à " + (kmVoyageur - kmNatifs) + " km des natifs.");
    }

    void finPartie() {
        System.out.println("\n===================[ FIN ]===================");
        if (kmVoyageur >= KM_VOYAGE) {
            System.out.println("Le joueur a gagné !!");
        } else {
            System.out.println("Le joueur a fait " + kmVoyageur + " km");
        }

        if (fatigue == MORT_FATIGUE) {
            System.out.println("Votre chameau est mort de fatigue !");
        }

        if (kmVoyageur <= kmNatifs) {
            System.out.println("Vous avez été attrapé par les natifs !");
        }
    }

    public static void main(String[] args) {
        new JeuDuChameau().run();
    }
}
