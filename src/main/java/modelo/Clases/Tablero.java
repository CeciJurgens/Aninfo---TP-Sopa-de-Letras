package modelo.Clases;
import java.util.List;


public class Tablero{

    private Casillero [][] tablero;
    private int filas;
    private int columnas;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";


    public Tablero(int filas, int columnas) {

        this.filas = filas;
        this.columnas = columnas;
        tablero = new Casillero[filas][columnas];
        crearTableroVacio();
    }

    private void crearTableroVacio() {
        //public static final String GUIA = "\u001B[35m";

        for (int x = 0; x < filas; x++) {
            for (int y = 0; y < columnas; y++) {
                tablero[x][y] = new Casillero(x, y);
            }
        }
    }

    //TODO: podria agregarse un metodo a palabra que devuelva su largo para mejorar lectura del codigo.
    public boolean puedeColocarse(Palabra palabra, int x, int y){
        List<Integer> coordsInicio = palabra.getCoordenadasInicio();
        List<Integer> coordsFin = palabra.getCoordenadasFin();
        //Chequeo que ninguno este ocupado
        for(int i=0; i <= (coordsFin.get(0) - coordsInicio.get(0));i++){
            for(int j = 0; j <= (coordsFin.get(1) - coordsInicio.get(1)); j++){
                if(tablero[x+i][y+j].estaOcupado()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean cambiarEstadoCasilleros( List<Integer> coordsInicio,List<Integer> coordsFin){
        for(int i= coordsInicio.get(0); i <= (coordsFin.get(0) - coordsInicio.get(0));i++){
            for(int j = coordsInicio.get(1); j <= (coordsFin.get(1) - coordsInicio.get(1)); j++){
                tablero[i][j].contieneLetraEncontrada();
            }
        }
        return true;
    }


    public boolean asignarCoordenadasPalabras(Palabra palabra, int x, int y){
        if (palabra.getLongitudPalabra() > filas || palabra.getLongitudPalabra() > columnas){
            return false;
        }

        if(!puedeColocarse(palabra,x,y)){return false;}

        List<Integer> coordsInicio = palabra.getCoordenadasInicio();
        List<Integer> coordsFin = palabra.getCoordenadasFin();
        String casillero_contenido = palabra.getPalabraString();

        for(int i=0;i <= (coordsFin.get(0) - coordsInicio.get(0));i++){
            for(int j=0; j <= (coordsFin.get(1) - coordsInicio.get(1));j++){
                if (palabra.getIsEsHorizontal()){
                    tablero[x+i][y+j].colocarLetra(casillero_contenido.charAt(i* coordsFin.get(0) + j), true);

                } else{
                    tablero[x+i][y+j].colocarLetra(casillero_contenido.charAt(i), true);
                }
            }
        }

        //TODO:Asignar las coordenadas a la palabra
        palabra.setCoordenadasInicio(x,y);
        palabra.setCoordenadasFin(x + coordsFin.get(0) - coordsInicio.get(0), y + coordsFin.get(1) - coordsInicio.get(1) );
        return true;
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

    public void mostrarTablero() {
        System.out.print("\n");

        String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.print(" "); //centra abecedario
        for (int i = 0; i < this.filas + 1; i++) {
            System.out.print(ANSI_PURPLE +   alphabet.charAt(i) + " " + ANSI_RESET);
        }

        for (int x = 0; x < filas; x++) {
            System.out.print("\n");
            if(x<10){System.out.print(ANSI_PURPLE + x + "  " + ANSI_RESET);}
            else{System.out.print(ANSI_PURPLE + x + " " + ANSI_RESET);}

            for (int y = 0; y < columnas; y++) {
                tablero[x][y].getLetra();
            }

        }
        System.out.print("\n");
    }

}

