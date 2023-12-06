package modelo.Clases;
import java.util.Random;

public class Casillero {
    private int coordenadaX;
    private int coordenadaY;
    public boolean estaOcupado;
    public char letra;


    public Casillero(int unaCoordenadaX, int unaCoordenadaY) {
        this.coordenadaX = unaCoordenadaX;
        this.coordenadaY = unaCoordenadaY;
        this.estaOcupado = false;

        Random r = new Random();
        this.letra = (char) (r.nextInt(26) + 'A');
    }

    //TODO: borrar funcion, es provisorio para chequeos.
    public char getLetra() {
        System.out.print(this.letra);
        return this.letra;
    }

    public boolean estaOcupado() {
        return this.estaOcupado;
    }

    //Recibe una letra y si pertenece a una palabra. Devuelve true si cambia su letra
    //false en caso de no poder
    public boolean colocarLetra(char letra, boolean perteneceAPalabra) {
        if (this.estaOcupado) {
            return false;
        }

        if (perteneceAPalabra) {
            this.estaOcupado = true;
        }
        this.letra = letra;
        return true;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY(){
        return coordenadaY;
    }
}
