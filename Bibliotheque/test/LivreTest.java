import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LivreTest {
    private Livre livre;

    @Before
    public void setUp() {
        // Créer un livre avant chaque test
        livre = new Livre("Harry Potter à l'École des Sorciers", "J.K. Rowling", "9780747532743");
    }

    @Test
    public void testGetTitre() {
        assertEquals("Harry Potter à l'École des Sorciers", livre.getTitre());
    }

    @Test
    public void testEstEmprunteInitialement() {
        assertFalse(livre.estEmprunte());
    }

    @Test
    public void testEmprunter() {
        livre.emprunter();
        assertTrue(livre.estEmprunte());
    }

    @Test
    public void testEmprunterDeNouveau() {
        livre.emprunter();
        livre.emprunter();
        assertTrue(livre.estEmprunte());
    }

    @Test
    public void testRetourner() {
        livre.emprunter();
        livre.retourner();
        assertFalse(livre.estEmprunte());
    }

    @Test
    public void testRetournerSansEmprunt() {
        livre.retourner();
        assertFalse(livre.estEmprunte());
    }
}