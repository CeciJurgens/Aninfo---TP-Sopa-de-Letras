import modelo.Clases.Palabra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PalabraTest {

    private Palabra palabra;

    @BeforeEach
    public void setUp(){
        palabra = new Palabra("MANGO", true);
    }

    @Test
    public void Test02GetEstadoPalabra(){
        assertFalse(palabra.getEstadoPalabra(),  "Default estadoPalabra deberia ser false");
    }

    @Test
    public void Test03actualizacionEstadoPalabra(){

        List<Integer> coordsSeleccionadasInicio = Arrays.asList(0, 0);
        List<Integer> coordsSeleccionadasFin = Arrays.asList(0, 4);

        boolean estadoAntes = palabra.getEstadoPalabra();
        boolean actualizacionResult = palabra.actualizacionEstadoPalabra(coordsSeleccionadasInicio, coordsSeleccionadasFin);
        boolean estadoDespues = palabra.getEstadoPalabra();

        assertFalse(estadoAntes, "estadoPalabra deberia ser false antes de actualizarEstadoPalabra");
        assertTrue(actualizacionResult, "actualizacionEstadoPalabra deberia devolver True");
        assertTrue(estadoDespues, "estadoPalabra deberia devolver True despues de actualizarEstadoPlabra");
    }

    @Test
    public void Test04actualizacionEstadoPalabraNoEncontrado(){

        List<Integer> coordsInicioSeleccionada = Arrays.asList(5, 0);
        List<Integer> coordsFinSeleccionada = Arrays.asList(5, 4);

        boolean estadoAntes = palabra.getEstadoPalabra();
        boolean actualizacionResult = palabra.actualizacionEstadoPalabra(coordsInicioSeleccionada, coordsFinSeleccionada);
        boolean estadoDespues = palabra.getEstadoPalabra();

        assertFalse(estadoAntes, "estadoPalabra deberia devolver false antes de actualizarEstadoDePalabra");
        assertFalse(actualizacionResult, "actualizacionEstadoPalabra deberia devolver false al actualizarEstadoPalabra");
        assertFalse(estadoDespues, "estadoPalabra deberia seguir en False ya que no se encontro la palabra");

    }

    @Test
    public void Test05GetCoordenadasInicio(){
        assertEquals(Arrays.asList(0, 0), palabra.getCoordenadasInicio(), "Coordenada de Inicio deberia ser (0, 0)");
    }

    @Test
    public void Test06GetCoordenadasFin(){
        assertEquals(Arrays.asList(0, 4), palabra.getCoordenadasFin(), "Coordenada de Fin deberia ser (0, 4)");
    }

    @Test
    public void Test07PalabraVertical(){

        palabra = new Palabra("MANGO", false);

        assertEquals(Arrays.asList(0, 0), palabra.getCoordenadasInicio(), "Coordenada de Inicio deberia ser (0, 0)");
        assertEquals(Arrays.asList(4, 0), palabra.getCoordenadasFin(), "Coordenada de Fin deberia ser (4, 0)");
    }

    @Test
    public void Test08SetCoordenadaInicio(){
        palabra.setCoordenadasInicio(2,0);

        assertEquals(Arrays.asList(2, 0), palabra.getCoordenadasInicio());
    }

    @Test
    public void Test09SetCoordenadaFin(){
        palabra.setCoordenadasFin(4,4);

        assertEquals(Arrays.asList(4, 4), palabra.getCoordenadasFin());
    }

    @Test
    public void Test10GetLongitudPalabra(){
        assertEquals(5, palabra.getLongitudPalabra());
    }

}