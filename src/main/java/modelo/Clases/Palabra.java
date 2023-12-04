package modelo.Clases;

public class Palabra{

    private int coordenadaX;
    private int coordenadaY;
    private boolean encontrada;

    public Palabra(int x, int y) {
        this.coordenadaX = x;
        this.coordenadaY = y;
        this.encontrada = false;
    }

    //TODO: borrar funciones, provisorias para chequeos.
    public void mostrarCoordenadaXPalabra(){
        System.out.print(this.coordenadaX );
    }

    public void mostrarCoordenadaYPalabra(){
        System.out.print(this.coordenadaY );
    }

    public void mostrarStatusPalabra(){
        System.out.print(this.encontrada );
    }
}