import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliothequeTest {
    private Bibliotheque bibliotheque;
    private Membre membre;
    private Livre livre;

    @Before
    public void setUp() {
        bibliotheque = new Bibliotheque();
        membre = new Membre("Alice", "alice123");
        livre = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", "978-3-16-148410-0");

        bibliotheque.ajouterMembre(membre);
        bibliotheque.ajouterLivre(livre);
    }

    @Test
    public void testAjouterLivre() {
        Livre nouveauLivre = new Livre("1984", "George Orwell", "978-0-452-28423-4");
        bibliotheque.ajouterLivre(nouveauLivre);
        assertTrue(bibliotheque.trouverLivreParTitre("1984") != null);
    }

    @Test
    public void testAjouterMembre() {
        Membre nouveauMembre = new Membre("Bob", "bob123");
        bibliotheque.ajouterMembre(nouveauMembre);
        assertTrue(bibliotheque.trouverLivreParTitre("Le Petit Prince") != null);
    }

    @Test
    public void testTrouverLivreParTitre() {
        Livre trouvé = bibliotheque.trouverLivreParTitre("Le Petit Prince");
        assertNotNull(trouvé);
        assertEquals("Le Petit Prince", trouvé.getTitre());
    }

    @Test
    public void testEmprunterLivre() {
        bibliotheque.emprunterLivre("Le Petit Prince", membre);
        assertTrue(membre.getLivresEmpruntes().contains(livre));
        assertTrue(livre.estEmprunte());
    }

    @Test
    public void testRetournerLivre() {
        bibliotheque.emprunterLivre("Le Petit Prince", membre);
        bibliotheque.retournerLivre("Le Petit Prince", membre);
        assertFalse(membre.getLivresEmpruntes().contains(livre));
        assertFalse(livre.estEmprunte());
    }

    @Test
    public void testAfficherLivres() {
        bibliotheque.afficherLivres();
    }

    @Test
    public void testEmprunterLivreInexistant() {
        bibliotheque.emprunterLivre("Livre Inexistant", membre);
        assertFalse(membre.getLivresEmpruntes().contains(livre));
    }

    @Test
    public void testRetournerLivreInexistant() {
        bibliotheque.retournerLivre("Livre Inexistant", membre);
        assertFalse(membre.getLivresEmpruntes().contains(livre));
    }
}