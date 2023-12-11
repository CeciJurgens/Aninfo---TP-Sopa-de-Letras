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
    //TODO: FALTA PLANTEAR Debe verificar si los casilleros para las palabras esten disponibles
    // antes de colocarla. En el caso que algún casillero este ocupado, retornar false.
    public boolean puedeColocarse(Palabra palabra, int x, int y){
        return true;
    }

    // TODO: El método verifica la disponibilidad de los casilleros para la palabra y en caso, de estar
    // TODO: disponibles, coloca la palabra en el tablero y actualiza las coordenadas.
    public void asignarCoordenadasPalabras(Palabra palabra, int x, int y){
        List<Integer> coordsInicio = palabra.getCoordenadasInicio();
        List<Integer> coordsFin = palabra.getCoordenadasFin();
        String casillero_contenido = palabra.palabra;

        for(int i=0;i <coordsFin.get(0) - coordsInicio.get(0);i++){
            for(int j=0; j < coordsFin.get(1) - coordsInicio.get(1);j++){
                tablero[x+i][y+j].colocarLetra(casillero_contenido.charAt(i* coordsFin.get(0) + j), true);
            }
        }
        //TODO:Asignar las coordenadas a la palabra
        palabra.setCoordenadasInicio(x,y);
        palabra.setCoordenadasFin(x + coordsFin.get(0) - coordsInicio.get(0), y + coordsFin.get(1) - coordsInicio.get(1) );

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

