import java.util.ArrayList;
import java.util.List;

public class Membre {
    private String nom;
    private String identifiant;
    private List<Livre> livresEmpruntes;

    public Membre(String nom, String identifiant) {
        this.nom = nom;
        this.identifiant = identifiant;
        this.livresEmpruntes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public List<Livre> getLivresEmpruntes() {
        return livresEmpruntes;
    }

    public void emprunterLivre(Livre livre) {
        if (!livre.estEmprunte()) {
            livre.emprunter();
            livresEmpruntes.add(livre);
            System.out.println(nom + " a emprunté le livre: " + livre.getTitre());
        } else {
            System.out.println("Le livre " + livre.getTitre() + " est déjà emprunté.");
        }
    }

    public void retournerLivre(Livre livre) {
        if (livresEmpruntes.contains(livre)) {
            livre.retourner();
            livresEmpruntes.remove(livre);
            System.out.println(nom + " a retourné le livre: " + livre.getTitre());
        } else {
            System.out.println("Ce membre n'a pas emprunté le livre: " + livre.getTitre());
        }
    }
}