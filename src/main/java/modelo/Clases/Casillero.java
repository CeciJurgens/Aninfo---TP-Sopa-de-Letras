package modelo.Clases;
import java.util.Random;

public class Casillero {
    private int coordenadaX;
    private int coordenadaY;
    private boolean estaOcupado;
    public char letra;


    public Casillero(int unaCoordenadaX, int unaCoordenadaY) {
        this.coordenadaX = unaCoordenadaX;
        this.coordenadaY = unaCoordenadaY;
        this.estaOcupado = false;

        Random r = new Random();
        this.letra = (char)(r.nextInt(26) + 'A');
    }

    
}
