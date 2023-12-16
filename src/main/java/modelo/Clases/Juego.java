package modelo.Clases;
import java.util.List;


public class Juego{

    private Tablero tablero;
    private String[] coleccionPalabras;
    private boolean seHaGanado;

    //Sugiero agregar a obtenerCollecion un parametro que indique logitud max por c/palabra de la coleccion.
    public Juego(String unaCategoriaPalabras, int cantidadPalabras) {
        this.tablero = new Tablero(15,20); //tablero 15x20
        this.coleccionPalabras = new CategoriaDePalabras().obtenerColeccion(unaCategoriaPalabras, cantidadPalabras);
        this.seHaGanado = false;
    }
}