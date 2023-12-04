package modelo.Clases;

public class Palabra{

    private int coordenadaX;
    private int coordenadaY;
    private boolean encontrada;
    private boolean longitudValida;

    public Palabra(int x, int y) {
        this.coordenadaX = x;
        this.coordenadaY = y;
        this.encontrada = false;
        this.longitudValida= false;
    }

    //TODO: revisar en refactor
    private boolean longitudPalabraValida(int filasTablero, int columnasTablero){
        return this.coordenadaX >= 0 && this.coordenadaX <= filasTablero && this.coordenadaY >= 0 && this.coordenadaY <= columnasTablero
    }

    //TODO: revisar en refactor
    private boolean actualizacionEstadoPalabra(int coordSeleccionadaX, int coordSeleccionadaY){
        boolean estadoPalabra = this.encontrada
        if  (this.coordenadaX == coordSeleccionadaX && this.coordenadaY == coordSeleccionadaY){
            this.encontrada = true
        }
        return  estadoPalabra != this.encontrada
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