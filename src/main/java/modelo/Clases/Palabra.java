package modelo.Clases;

public class Palabra{

    private int coordenadaX;
    private int coordenadaY;
    private boolean encontrada;
    private boolean longitudValida;

    public Palabra(int x, int y, int filasTablero, int columnasTablero) {
        this.coordenadaX = x;
        this.coordenadaY = y;
        this.encontrada = false;
        this.longitudValida = longitudPalabraValida(filasTablero, columnasTablero);
    }

    public boolean longitudPalabraValida(int filasTablero, int columnasTablero){
        return this.coordenadaX <= filasTablero && this.coordenadaY <= columnasTablero
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

    public void mostrarValidezLongitud(){
        System.out.print(this.longitudValida )
    }    
}