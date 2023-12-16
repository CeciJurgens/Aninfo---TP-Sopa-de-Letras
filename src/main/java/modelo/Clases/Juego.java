package modelo.Clases;
import java.util.List;
import java.util.Random;


public class Juego{

    private Tablero tablero;
    private String[] coleccionPalabras;
    private boolean seHaGanado;
    private Palabra[] listadoPalabras;

    //Sugiero agregar a obtenerCollecion un parametro que indique logitud max por c/palabra de la coleccion.
    public Juego(String unaCategoriaPalabras, int cantidadPalabras){
        this.tablero = new Tablero(15,20); //tablero 15x20
        this.coleccionPalabras = new CategoriaDePalabras().obtenerColeccion(unaCategoriaPalabras, cantidadPalabras);
        this.seHaGanado = false;
        this.palabras = listadoIntanciasPalabra();
        Random rd = new Random();
    }

    private List<Palabra> listadoIntanciasPalabra(){
        List<Palabra> palabras = new ArrayList<>();
        for (i=0; i<cantidadPalabras; i++){
            palabras.add(new Palabra(this.coleccionPalabras[i],rd.nextBoolean()));
        }
        return palabras;
    }

    private void colocarPalabrasEnTablero(){
        //a desarrollar
    }
}