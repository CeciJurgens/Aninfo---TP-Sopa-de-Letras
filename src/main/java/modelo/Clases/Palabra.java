package modelo.Clases;
import java.util.ArrayList;

public class Palabra{

    private ArrayList<Integer> coordenadasInicio;
    private ArrayList<Integer> coordenadasFin;
    private boolean encontrada;

    public Palabra(ArrayList<Integer> coordsInicio, ArrayList<Integer> coordsFin) {
        this.coordenadasInicio = coordsInicio;
        this.coordenadasFin = coordsFin;
        this.encontrada = false;
    }
    
    //TODO: revisar en refactor
    private boolean actualizacionEstadoPalabra(ArrayList<Integer> coordsSeleccionadasInicio, ArrayList<Integer> coordsSeleccionadasFin){
        boolean estadoPalabra = this.encontrada;
        if (this.coordenadasInicio == coordsSeleccionadasInicio && this.coordenadasFin == coordsSeleccionadasFin){
            this.encontrada = true
        }
        return  estadoPalabra != this.encontrada
    }

    //TODO: borrar funciones, provisorias para chequeos.
    public ArrayList<Integer> getCoordenadasInicio(){
        return this.coordenadasInicio
    }

    public ArrayList<Integer> getCoordenadaFin(){
        return this.coordenadasFin
    }

    public ArrayList<Integer> getStatusPalabra(){
        return this.encontrada
    }

}