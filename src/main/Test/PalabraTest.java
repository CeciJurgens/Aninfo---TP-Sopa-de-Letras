import modelo.Clases.Palabra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PalabraTest{

    @Test
    public void Test02GetEstadoPalabra(){
        ArrayList<Integer> coordsInicio = new ArrayList<>(Arrays.asList(0, 0));
        ArrayList<Integer> coordsFin = new ArrayList<>(Arrays.asList(0, 4));
        Palabra palabra = new Palabra(coordsInicio, coordsFin);

        assertFalse(palabra.getEstadoPalabra());
    }

    @Test
    public void Test03actualizacionEstadoPalabra(){
        ArrayList<Integer> coordsInicio = new ArrayList<>(Arrays.asList(0, 0));
        ArrayList<Integer> coordsFin = new ArrayList<>(Arrays.asList(0, 4));
        Palabra palabra = new Palabra(coordsInicio, coordsFin);

        ArrayList<Integer> coordsInicioSeleccionada = new ArrayList<>(Arrays.asList(0, 0));
        ArrayList<Integer> coordsFinSeleccionada = new ArrayList<>(Arrays.asList(0, 4));

        boolean estadoAntes = palabra.getEstadoPalabra();
        boolean actualizacionResult = palabra.actualizacionEstadoPalabra(coordsInicioSeleccionada, coordsFinSeleccionada);
        boolean estadoDespues = palabra.getEstadoPalabra();


        assertFalse(estadoAntes, "estadoPalabra deberia ser false antes de actualizar");
        assertTrue(actualizacionResult, "actualizacionEstadoPalabra deberia retornar True cuando se actualiza");
        assertTrue(estadoDespues, "estadoPalabra deberia retornar True cuando se actualiza");

    }

    @Test
    public void Test04actualizacionEstadoPalabraNoEncontrado(){
        ArrayList<Integer> coordsInicio = new ArrayList<>(Arrays.asList(0, 0));
        ArrayList<Integer> coordsFin = new ArrayList<>(Arrays.asList(0, 4));
        Palabra palabra = new Palabra(coordsInicio, coordsFin);

        ArrayList<Integer> coordsInicioSeleccionada = new ArrayList<>(Arrays.asList(5, 0));
        ArrayList<Integer> coordsFinSeleccionada = new ArrayList<>(Arrays.asList(5, 4));

        boolean estadoAntes = palabra.getEstadoPalabra();
        boolean actualizacionResult = palabra.actualizacionEstadoPalabra(coordsInicioSeleccionada, coordsFinSeleccionada);
        boolean estadoDespues = palabra.getEstadoPalabra();


        assertFalse(estadoAntes, "estadoPalabra deberia ser false antes de actualizar");
        assertFalse(actualizacionResult, "actualizacionEstadoPalabra deberia retornar False cuando se actualiza");
        assertFalse(estadoDespues, "estadoPalabra deberia retornar False cuando se actualiza");

    }

    @Test
    public void Test05GetCoordenadasInicio(){
        ArrayList<Integer> coordsInicio = new ArrayList<>(Arrays.asList(0, 0));
        ArrayList<Integer> coordsFin = new ArrayList<>(Arrays.asList(0, 4));
        Palabra palabra = new Palabra(coordsInicio, coordsFin);

        assertEquals(palabra.getCoordenadasInicio(), coordsInicio);
    }

    @Test
    public void Test06GetCoordenadasFin(){
        ArrayList<Integer> coordsInicio = new ArrayList<>(Arrays.asList(0, 0));
        ArrayList<Integer> coordsFin = new ArrayList<>(Arrays.asList(0, 4));
        Palabra palabra = new Palabra(coordsInicio, coordsFin);

        assertEquals(palabra.getCoordenadaFin(), coordsFin);
    }

}
