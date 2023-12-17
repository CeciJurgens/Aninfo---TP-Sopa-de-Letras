package modelo.Clases;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


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
            this.tablero.asignarCoordenadasPalabras(listaPalabras.get(i),rd.nextInt(14 - 1 + 1) + 1, rd.nextInt(14 - 1 + 1) + 1);
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
                this.tablero.cambiarEstadoCasilleros(palabra.getIsEsHorizontal(), palabra.getCoordenadasInicio(),palabra.getCoordenadasFin());
                return true;

            }
            //No importa en q orden da el jugador las coordenadas
        }
        return false;
    }

    public List<Palabra> getPalabrasJuego() {
        return palabrasJuego;
    }

    private boolean coordenadasDentroDeRango(List<Integer> coordenadas) {
        int filasMaximas = 15;
        int columnasMaximas = 15;

        return coordenadas.get(0) >= 0 && coordenadas.get(0) < filasMaximas &&
                coordenadas.get(1) >= 0 && coordenadas.get(1) < columnasMaximas;
    }


    public void pedirCoordenadasPantalla(InputStream inputStream){
        Scanner scanner = new Scanner(System.in);

        tablero.mostrarTablero();

        while (!ganoJuego()) {
            boolean coordenadasValidas = false;
            List<Integer> coordenadaInicio = null;
            List<Integer> coordenadaFin = null;

            while (!coordenadasValidas) {
                try {
                    System.out.println("Ingresa las coordenadas de inicio (fila columna):");
                    int filaInicio = scanner.nextInt();
                    int columnaInicio = scanner.nextInt();

                    System.out.println("Ingresa las coordenadas de fin (fila columna):");
                    int filaFin = scanner.nextInt();
                    int columnaFin = scanner.nextInt();

                    coordenadaInicio = List.of(filaInicio, columnaInicio);
                    coordenadaFin = List.of(filaFin, columnaFin);

                    // Verificar si las coordenadas están dentro del rango permitido
                    if (coordenadasDentroDeRango(coordenadaInicio) && coordenadasDentroDeRango(coordenadaFin)) {
                        coordenadasValidas = true;
                    } else {
                        System.out.println("¡Coordenadas fuera de rango! Ingresa nuevamente.");
                    }
                } catch (Exception e) {
                    System.out.println("Error al ingresar coordenadas. Asegúrate de ingresar números enteros.");
                    scanner.nextLine(); // Limpiar el búfer del scanner para evitar un bucle infinito
                }
            }

            boolean palabraEncontrada = encontrarPalabra(coordenadaInicio, coordenadaFin);

            tablero.mostrarTablero();

            if (palabraEncontrada) {
                System.out.println("¡Palabra encontrada!");
            } else {
                System.out.println("No se encontró ninguna palabra con esas coordenadas.");
            }

            for (Palabra palabra : getPalabrasJuego()) {
                if (!palabra.getEstadoPalabra()) {
                    System.out.print(palabra.getPalabraString() + " ");
                }
            }
        }

        System.out.println("¡Felicidades! Has encontrado todas las palabras.");
    }

}
