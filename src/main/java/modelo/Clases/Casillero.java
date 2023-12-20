package modelo.Clases;
import java.util.Random;



public class Casillero {
    private int coordenadaX;
    private int coordenadaY;
    private boolean estaOcupado;
    private char letra;

    public static final String ENCONTRADO = "\033[32m";
    public static final String NO_ENCONTRADO = "\033[0;97m";

    public static final String ANSI_RESET = "\u001B[0m";

    private String color;

    public Casillero(int unaCoordenadaX, int unaCoordenadaY) {
        this.coordenadaX = unaCoordenadaX;
        this.coordenadaY = unaCoordenadaY;
        this.estaOcupado = false;
        this.color = NO_ENCONTRADO;

        Random r = new Random();
        this.letra = (char) (r.nextInt(26) + 'A');
    }

    public char getLetra() {
        System.out.print(this.color + this.letra + " " + ANSI_RESET);
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

    public void contieneLetraEncontrada(){
        this.color = ENCONTRADO;
    }
}
