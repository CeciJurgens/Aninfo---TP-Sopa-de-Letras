package modelo;
import modelo.Clases.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;



public class Main {


    public static void main(String[] args) {

        System.out.println("BIENVENIDO A LA SOPA DE LETRAS");
        Juego juego = new Juego("FRUTAS", 5);

        for (Palabra palabra : juego.getPalabrasJuego()) {
            System.out.println(palabra);
        }

        String input = "1 2\n3 4\n"; // Coordenadas simuladas
        InputStream in = new ByteArrayInputStream(input.getBytes());

        juego.pedirCoordenadasPantalla(in);

        // Esperar unos segundos para mostrar el tiempo actualizado antes de que el programa finalice
        try{
            Thread.sleep(5000); // Espera 5 segundos
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}