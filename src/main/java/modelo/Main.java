package modelo;
import modelo.Clases.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;


public class Main {


    public static void main(String[] args) {

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_PURPLE = "\u001B[35m";

        System.out.println(ANSI_PURPLE + "\t \t \t \t \t \t \t  BIENVENIDO A LA SOPA DE LETRAS \n" + ANSI_RESET);

        CategoriaDePalabras categoriaDePalabras = new CategoriaDePalabras();
        Juego juego = new Juego(categoriaDePalabras.obtenerCategoriaAleatoria(), 5);

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
