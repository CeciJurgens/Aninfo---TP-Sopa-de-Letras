import modelo.Clases.CategoriaDePalabras;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoriaDePalabrasTest {
    @Test
    public void test01LaColeccionObtenidaEsDeLargoN() {
        // Arrange (preparación)
        CategoriaDePalabras cat = new CategoriaDePalabras();
        // Act (acción)
        String[] coleccion = cat.obtenerColeccion("FRUTAS", 8);
        for (int x=0; x<8; x++){
            System.out.println(coleccion[x]);
        }
        // Assert (verificación)
        assertEquals(8, coleccion.length);
    }
}
