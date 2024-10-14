import java.util.ArrayList;

public class Bibliotheque {
    private ArrayList<Livre> livres;
    private ArrayList<Membre> membres;

    public Bibliotheque() {
        livres = new ArrayList<>();
        membres = new ArrayList<>();
    }

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
        System.out.println("Livre ajouté : " + livre.getTitre());
    }

    public void ajouterMembre(Membre membre) {
        membres.add(membre);
        System.out.println("Membre ajouté : " + membre.getNom());
    }

    public Livre trouverLivreParTitre(String titre) {
        for (Livre livre : livres) {
            if (livre.getTitre().equalsIgnoreCase(titre)) {
                return livre;
            }
        }
        return null;
    }

    public void emprunterLivre(String titre, Membre membre) {
        Livre livre = trouverLivreParTitre(titre);
        if (livre != null) {
            membre.emprunterLivre(livre);
        } else {
            System.out.println("Livre non trouvé : " + titre);
        }
    }

    public void retournerLivre(String titre, Membre membre) {
        Livre livre = trouverLivreParTitre(titre);
        if (livre != null) {
            membre.retournerLivre(livre);
        } else {
            System.out.println("Livre non trouvé : " + titre);
        }
    }

    public void afficherLivres() {
        System.out.println("Livres disponibles :");
        for (Livre livre : livres) {
            System.out.println(" - " + livre.getTitre() + (livre.estEmprunte() ? " (Emprunté)" : " (Disponible)"));
        }
    }
}