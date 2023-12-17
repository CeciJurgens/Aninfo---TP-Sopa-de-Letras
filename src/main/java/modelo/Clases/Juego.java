package modelo.Clases;

import java.io.InputStream;
import java.util.*;


public class Juego{

    private Tablero tablero;
    private String[] coleccionPalabras;
    private List<Palabra> palabrasJuego;

    private static final int TIEMPO_MAXIMO = 180;// Tiempo máximo basado en segundos (3 minutos)
    private  int tiempoRestante;
    private long tiempoInicio; // Inicio del jeugo en milisegundos

    //Sugiero agregar a obtenerCollecion un parametro que indique logitud max por c/palabra de la coleccion.
    public Juego(String unaCategoriaPalabras, int cantidadPalabras){
        this.tablero = new Tablero(15,15); //tablero 15x20
        this.coleccionPalabras = new CategoriaDePalabras().obtenerColeccion(unaCategoriaPalabras, cantidadPalabras);
        this.palabrasJuego = listadoIntanciasPalabra(cantidadPalabras);
        colocarPalabrasEnTablero(this.palabrasJuego, cantidadPalabras);
        this.tiempoRestante = TIEMPO_MAXIMO;
        this.tiempoInicio = System.currentTimeMillis(); // Almacena el tiempo de inicio
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

            boolean asignacionExitosa = false;
            while (!asignacionExitosa) {
                int x = rd.nextInt(14 - 1 + 1) + 1;
                int y = rd.nextInt(14 - 1 + 1) + 1;
                asignacionExitosa = this.tablero.asignarCoordenadasPalabras(listaPalabras.get(i), x, y);
            }
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


    public void actualizarTiempo(){
        tiempoRestante--;
    }


    public void pedirCoordenadasPantalla(InputStream inputStream){
        Scanner scanner = new Scanner(System.in);

        long tiempoInicio = System.currentTimeMillis();
        final int[] tiempoRestante = {TIEMPO_MAXIMO};
        boolean[] tiempoTerminado = {false};

        Thread tiempoThread = new Thread(() ->{
            while(!ganoJuego() && tiempoRestante[0] > 0){
                long tiempoTranscurrido = (System.currentTimeMillis() - tiempoInicio) / 1000;
                tiempoRestante[0] = TIEMPO_MAXIMO - (int) tiempoTranscurrido;

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            tiempoTerminado[0] = true;
        });
        tiempoThread.start();

        tablero.mostrarTablero(); // Mostrar el tablero

        while (!ganoJuego() && !tiempoTerminado[0]) {
            mostrarPalabrasRestantes(); // Mostrar palabras restantes antes del input

            System.out.println("\nTiempo restante: " + String.format("%02d:%02d", tiempoRestante[0] / 60, tiempoRestante[0] % 60));

            boolean coordenadasValidas = false;
            List<Integer> coordenadaInicio = null;
            List<Integer> coordenadaFin = null;

            while (!coordenadasValidas) {
                try {
                    System.out.println("Ingresa las coordenadas de inicio (fila columna):");
                    int filaInicio = scanner.nextInt();
                    String letraInicio = scanner.next().toUpperCase();
                    int columnaInicio = letraInicio.charAt(0) - 'A';

                    coordenadaInicio = Arrays.asList(filaInicio, columnaInicio);

                    System.out.println("Ingresa las coordenadas de fin (fila columna):");
                    int filaFin = scanner.nextInt();
                    String letraFin = scanner.next().toUpperCase();
                    int columnaFin = letraFin.charAt(0) - 'A';

                    coordenadaFin = Arrays.asList(filaFin, columnaFin);

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

            tablero.mostrarTablero(); // Mostrar el tablero

            if (palabraEncontrada) {
                System.out.println("¡Palabra encontrada!");
            } else {
                System.out.println("No se encontró ninguna palabra con esas coordenadas.");
            }
            actualizarTiempo();

        }
        if (tiempoTerminado[0]){
            System.out.println("\n¡Se acabó el tiempo! Has agotado el tiempo límite.");
        } else {
            System.out.println("\n¡Felicidades! Has encontrado todas las palabras.");
        }

        if (!tiempoTerminado[0]) {
            mostrarPalabrasRestantes();
        }
    }

    private void mostrarPalabrasRestantes() {
        List<Palabra> palabrasRestantes = getPalabrasRestantes();

        if (palabrasRestantes.isEmpty()) {
            System.out.println("\n¡Ya se encontraron todas las palabras!");
        } else {
            System.out.println("\nPalabras restantes:");
            for (Palabra palabra : palabrasRestantes) {
                System.out.print(palabra.getPalabraString() + " ");
            }
        }
    }

    private List<Palabra> getPalabrasRestantes() {
        List<Palabra> palabrasRestantes = new ArrayList<>();
        for (Palabra palabra : getPalabrasJuego()) {
            if (!palabra.getEstadoPalabra()) {
                palabrasRestantes.add(palabra);
            }
        }
        return palabrasRestantes;
    }
}
