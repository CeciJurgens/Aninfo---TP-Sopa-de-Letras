package modelo.Clases;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    public int anchoTablero;
    public int altoTablero;
    private List<List<Casillero>> tableroActual;


    public Tablero( int alto, int ancho){
        this.anchoTablero = ancho;
        this.altoTablero = alto;

        List<List<Casillero>> tablero = new ArrayList<>();
        for (int i = 0; i < ancho; i++)  {
            tablero.add(new ArrayList<Casillero>());
            for (int j = 0; j < alto; j++) {
                tablero.get(i).add(new Casillero(i,j));
            }
        }
        this.tableroActual = tablero;
    }
}
