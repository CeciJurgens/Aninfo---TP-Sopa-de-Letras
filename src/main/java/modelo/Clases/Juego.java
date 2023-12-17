package modelo.Clases;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Juego{

    private Tablero tablero;
    private String[] coleccionPalabras;
    private List<Palabra> palabrasJuego;

    //Sugiero agregar a obtenerCollecion un parametro que indique logitud max por c/palabra de la coleccion.
    public Juego(String unaCategoriaPalabras, int cantidadPalabras){
        this.tablero = new Tablero(15,15); //tablero 15x20
        this.coleccionPalabras = new CategoriaDePalabras().obtenerColeccion(unaCategoriaPalabras, cantidadPalabras);
        this.palabrasJuego = listadoIntanciasPalabra(cantidadPalabras);
        colocarPalabrasEnTablero(this.palabrasJuego, cantidadPalabras);
    }

    private List<Palabra> listadoIntanciasPalabra(int cantidadPalabras){
        List<Palabra> palabras = new ArrayList<>();
        for (int i=0; i<cantidadPalabras; i++){
            Random rd = new Random();
            palabras.add(new Palabra(this.coleccionPalabras[i],rd.nextBoolean()));
        }
        return palabras;
    }

    private void colocarPalabrasEnTablero(List<Palabra> listaPalabras, int cantidadPalabras){
        for(int i=0; i<cantidadPalabras ; i++){
            Random rd = new Random();
            this.tablero.asignarCoordenadasPalabras(listaPalabras.get(i),rd.nextInt(),rd.nextInt());
        }
    }

    public boolean ganoJuego(){
        //Precondicion: existe al menos una palabra en juego
        boolean gano = true;
        for (Palabra palabra: this.palabrasJuego) {
            if (palabra.getEstadoPalabra() == false){gano = false;}
        }
        return gano;
    }

    public boolean perdioJuego(){
        //TODO Si agregamos condiciones para perder u tiempo aca va un if tiempo < 0 -> perdio.
        return false;
    }

    public boolean encontrarPalabra(List<Integer> coordenadaInicio, List<Integer> coordenadaFin){
        for (Palabra palabra: this.palabrasJuego) {
            if (palabra.actualizacionEstadoPalabra(coordenadaInicio,coordenadaFin) == true ||
            palabra.actualizacionEstadoPalabra(coordenadaFin,coordenadaInicio) == true){
                this.tablero.cambiarEstadoCasilleros(palabra.getCoordenadasInicio(),palabra.getCoordenadasFin());
                return true;

            }
            //No importa en q orden da el jugador las coordenadas
        }
        return false;
    }
}