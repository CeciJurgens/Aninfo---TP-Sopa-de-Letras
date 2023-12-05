import modelo.Clases.Casillero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CasilleroTest {
    @Test
    public void Test01ElCasilleroSeCreaDesocupado(){
        Casillero casillero = new Casillero(0,0);
        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void Test02ElCasilleroSeOcupaAlPonerLetraQuePertenezcaAUnaPalabra(){
        Casillero casillero = new Casillero(0,0);
        casillero.colocarLetra('A',true);
        assertTrue(casillero.estaOcupado());
    }
    @Test
    public void Test03ElCasilleroNoSeOcupaAlPonerLetraQueNoPertenezcaAUnaPalabra(){
        Casillero casillero = new Casillero(0,0);
        casillero.colocarLetra('A',false);
        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void Test04ElCasilleroCambiaSuLetraAlIndicarlo(){
        Casillero casillero = new Casillero(0,0);
        casillero.colocarLetra('A',true);
        assertEquals(casillero.getLetra(),'A');
    }
}
