package modelo;
import modelo.Clases.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {

        Juego juego = new Juego("FRUTAS", 5);

        for (Palabra palabra : juego.getPalabrasJuego()) {
            System.out.println(palabra);
        }

        String input = "1 2\n3 4\n"; // Coordenadas simuladas
        InputStream in = new ByteArrayInputStream(input.getBytes());

        juego.pedirCoordenadasPantalla(in);
    }

}