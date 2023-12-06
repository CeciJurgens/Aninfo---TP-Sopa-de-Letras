package modelo.Clases;
import java.util.List;


public class Tablero{

    private Casillero [][] tablero;
    private int filas;
    private int columnas;

    public Tablero(int filas, int columnas) {

        this.filas = filas;
        this.columnas = columnas;
        tablero = new Casillero[filas][columnas];
        crearTableroVacio();
    }

    private void crearTableroVacio() {
        for (int x = 0; x < filas; x++) {
            for (int y = 0; y < columnas; y++) {
                tablero[x][y] = new Casillero(x, y);
            }
        }
    }

    public int getFilas(){
        return filas;
    }

    public int getColumnas(){
        return columnas;
    }

    public Casillero getCasillero(int fila,int columna){
        if(fila >= 0 && fila < filas && columna >=0 && columna < columnas){
            return tablero[fila][columna];
        }else{
            throw new IllegalArgumentException("Las coordenadas ingresadas se encuentran fuera del rango del tablero");
        }
    }

    // TODO: borrar función provisorio para chequeos
    public void mostrarTablero() {
        for (int x = 0; x < filas; x++) {
            for (int y = 0; y < columnas; y++) {
                tablero[x][y].getLetra();
            }
        }
    }

}

