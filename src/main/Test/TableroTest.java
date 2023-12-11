import modelo.Clases.Tablero;
import modelo.Clases.Casillero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TableroTest {

    private Tablero tablero;

    @BeforeEach
    public void setUp(){
        tablero = new Tablero(3,3);
    }

    @Test
    public void tes01ObtenercasilleroFuerDelRango(){
        assertThrows(IllegalArgumentException.class, () -> {
            tablero.getCasillero(5, 5); // Las coordenadas ingresadas se encuentra fuera del rango
        });
    }

    @Test
    public void test02GetFilas(){
        assertEquals(3,tablero.getFilas());
    }

    @Test
    public void tes03GetColumnas(){
        assertEquals(3,tablero.getColumnas());
    }

    @Test
    public void test04InicializarTableroVacio(){
        for(int x=0; x < tablero.getFilas();x++){
            for(int y=0; y < tablero.getColumnas(); y++){
                Casillero casillero = tablero.getCasillero(x,y);
                assertNotNull(casillero);
                assertFalse(casillero.estaOcupado());
            }

        }
    }

    @Test
    public void test05ObtenerCasilleroValido(){
        Casillero casillero = tablero.getCasillero(1,1);
        assertNotNull(casillero);
        assertEquals(1,casillero.getCoordenadaX());
        assertEquals(1,casillero.getCoordenadaY());
    }

}

