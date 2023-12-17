import modelo.Clases.Casillero;
import modelo.Clases.Palabra;
import modelo.Clases.Tablero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

    private Tablero tablero;

    @BeforeEach
    public void setUp(){

        tablero = new Tablero(3,3);
    }

    @Test
    public void Test01ObtenercasilleroFuerDelRango(){
        assertThrows(IllegalArgumentException.class, () -> {
            tablero.getCasillero(5, 5); // Las coordenadas ingresadas se encuentra fuera del rango
        });
    }

    @Test
    public void Test02GetFilas(){

        assertEquals(3,tablero.getFilas());
    }

    @Test
    public void Test03GetColumnas(){

        assertEquals(3,tablero.getColumnas());
    }

    @Test
    public void Test04InicializarTableroVacio(){
        for(int x=0; x < tablero.getFilas();x++){
            for(int y=0; y < tablero.getColumnas(); y++){
                Casillero casillero = tablero.getCasillero(x,y);
                assertNotNull(casillero);
                assertFalse(casillero.estaOcupado());
            }

        }
    }

    @Test
    public void Test05ObtenerCasilleroValido(){
        Casillero casillero = tablero.getCasillero(1,1);
        assertNotNull(casillero);
        assertEquals(1,casillero.getCoordenadaX());
        assertEquals(1,casillero.getCoordenadaY());
    }

    @Test
    public void Test06SePuedeColocarUnaPalabraEnCasillerosVacios(){
        Tablero tablero = new Tablero(15,15);
        Palabra palabra = new Palabra("MANGO",true);

        assertTrue(tablero.puedeColocarse(palabra,0,0));
    }

    @Test
    public void Test07NoSePuedeColocarUnaPalabraEnCasillerosOcupados(){
        Tablero tablero = new Tablero(5,5);
        tablero.getCasillero(0,0).colocarLetra('A',true); //al pertenecer a una palabra el caracter cambia

        Palabra palabra = new Palabra("MANGO",true);

        assertFalse(tablero.puedeColocarse(palabra,0,0));
    }

    @Test
    public void Test08ColocarUnaPalabraEnCasillerosVacios(){
        Tablero tablero = new Tablero(15,15);
        Palabra palabra = new Palabra("MANGO",true);

        tablero.asignarCoordenadasPalabras(palabra,0,0);

        boolean colocadas = true;
        String palabraColocada = "MANGO";

        for (int i = 0; i <= 4; i++) {
            String letraCasillero = Character.toString(tablero.getCasillero(0,i).getLetra());
            if(!letraCasillero.equals(palabraColocada.substring(i,i+1))){
                colocadas = false;
            }
        }
        assertTrue(colocadas);
    }

    @Test
    public void Test09NoPuedoColocarUnaPalabraEnCasillerosOcupados(){
        Tablero tablero = new Tablero(15,15);
        Palabra palabra = new Palabra("MANGO",true);
        tablero.getCasillero(0,0).colocarLetra('A',true);


        tablero.asignarCoordenadasPalabras(palabra,0,0);
        boolean colocadas = true;
        String palabraColocada = "MANGO";

        for (int i = 0; i <= 4; i++) {
            String letraCasillero = Character.toString(tablero.getCasillero(0,i).getLetra());
            if(!letraCasillero.equals(palabraColocada.substring(i,i+1))){
                colocadas = false;
            }
        }
        assertFalse(colocadas);
    }

    @Test
    public void Test10NoPuedoColocarPalabraFueraDeLimites(){
        Tablero tablero = new Tablero(5, 5);
        Palabra palabra = new Palabra("PALABRA", true);

        assertFalse(tablero.asignarCoordenadasPalabras(palabra, 0, 5));
    }

    @Test
    public void Test11CambiarColorDeCasilleroAEncontrado(){
        Tablero tablero = new Tablero(15,15);
        Palabra palabra = new Palabra("MANGO",true);

        tablero.asignarCoordenadasPalabras(palabra,0,0);
        boolean colocadas = tablero.cambiarEstadoCasilleros(palabra.getCoordenadasInicio(),palabra.getCoordenadasFin());

        tablero.mostrarTablero();
        assertTrue(colocadas);
    }

}