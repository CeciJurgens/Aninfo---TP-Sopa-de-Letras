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
        this.longitudValida= longitudEsValida(filasTablero, columnasTablero);
    }

    //TODO: revisar en refactor
    private boolean longitudEsValida(int filasTablero, int columnasTablero){
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
    public void getCoordenadaX(){
        return this.coordenadaX
    }

    public void getCoordenadaY(){
        return this.coordenadaY
    }

    public void getStatusPalabra(){
        return this.encontrada
    }

    public void getValidezLongitud(){
        return this.longitudValida
    }    
}