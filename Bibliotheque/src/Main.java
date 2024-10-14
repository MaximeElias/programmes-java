public class Main {
    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque();

        Livre livre1 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", "123456789");
        Livre livre2 = new Livre("1984", "George Orwell", "987654321");
        bibliotheque.ajouterLivre(livre1);
        bibliotheque.ajouterLivre(livre2);

        Membre membre1 = new Membre("Alice", "M001");
        Membre membre2 = new Membre("Bob", "M002");
        bibliotheque.ajouterMembre(membre1);
        bibliotheque.ajouterMembre(membre2);

        bibliotheque.afficherLivres();

        bibliotheque.emprunterLivre("Le Petit Prince", membre1);
        bibliotheque.emprunterLivre("1984", membre2);
        bibliotheque.afficherLivres();

        bibliotheque.retournerLivre("Le Petit Prince", membre1);
        bibliotheque.afficherLivres();
    }
}
