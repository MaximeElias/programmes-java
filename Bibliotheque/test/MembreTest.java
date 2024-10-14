import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MembreTest {
    private Membre membre;
    private Livre livre;

    @Before
    public void setUp() {
        // Créer un membre et un livre avant chaque test
        membre = new Membre("Alice", "A123");
        livre = new Livre("Harry Potter à l'École des Sorciers", "J.K. Rowling", "9780747532743");
    }

    @Test
    public void testEmprunterLivre() {
        membre.emprunterLivre(livre);
        assertTrue(livre.estEmprunte());
        assertTrue(membre.getLivresEmpruntes().contains(livre));
    }

    @Test
    public void testEmprunterLivreDejaEmprunte() {
        membre.emprunterLivre(livre);
        membre.emprunterLivre(livre);
        assertEquals(true, membre.getLivresEmpruntes().contains(livre));
    }

    @Test
    public void testRetournerLivre() {
        membre.emprunterLivre(livre);
        membre.retournerLivre(livre);
        assertFalse(livre.estEmprunte());
        assertFalse(membre.getLivresEmpruntes().contains(livre));
    }

    @Test
    public void testRetournerLivreNonEmprunte() {
        membre.retournerLivre(livre);
        assertFalse(livre.estEmprunte());
        assertFalse(membre.getLivresEmpruntes().contains(livre));
    }

    @Test
    public void testGetNom() {
        assertEquals("Alice", membre.getNom());
    }

    @Test
    public void testGetIdentifiant() {
        assertEquals("A123", membre.getIdentifiant());
    }

    @Test
    public void testGetLivresEmpruntesInitialement() {
        assertTrue(membre.getLivresEmpruntes().isEmpty());
    }
}