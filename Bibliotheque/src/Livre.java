public class Livre {

    private String titre;
    private String auteur;
    private String ISBN;
    private boolean estEmprunte;

    public Livre(String titre, String auteur, String ISBN) {
        this.titre = titre;
        this.auteur = auteur;
        this.ISBN = ISBN;
        this.estEmprunte = false;
    }

    public String getTitre() {
        return titre;
    }

    public boolean estEmprunte() {
        return estEmprunte;
    }

    public void emprunter() {
        if (!estEmprunte) {
            estEmprunte = true;
            System.out.println("Le livre " + titre + " a été emprunté.");
        } else {
            System.out.println("Le livre est déjà emprunté.");
        }
    }

    public void retourner() {
        if (estEmprunte) {
            estEmprunte = false;
            System.out.println("Le livre " + titre + " a été retourné.");
        } else {
            System.out.println("Le livre n'était pas emprunté.");
        }
    }
}