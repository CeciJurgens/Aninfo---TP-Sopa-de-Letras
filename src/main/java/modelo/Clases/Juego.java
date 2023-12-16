package modelo.Clases;
import java.util.List;


public class Juego{

    private Tablero tablero;
    private CategoriaDePalabras categoriaPalabras;

    public Juego() {
        this.tablero = new Tablero(15,20); //tablero 15x20
        this.categoriaPalabras = new CategoriaDePalabras();
    }
}