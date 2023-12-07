package modelo.Clases;
import java.util.ArrayList;

public class Palabra{

    private ArrayList<int> coordenadasInicio;
    private ArrayList<int> coordenadasFin;
    private boolean encontrada;

    public Palabra(ArrayList<int> coordsInicio, ArrayList<int> coordsFin) {
        this.coordenadasInicio = coordsInicio;
        this.coordenadasFin = coordsFin;
        this.encontrada = false;
    }
    
    //TODO: revisar en refactor
    private boolean actualizacionEstadoPalabra(ArrayList<int> coordsSeleccionadasInicio, ArrayList<int> coordsSeleccionadasFin){
        boolean estadoPalabra = this.encontrada;
        if (this.coordenadasInicio == coordsSeleccionadasInicio && this.coordenadasFin == coordsSeleccionadasFin){
            this.encontrada = true
        }
        return  estadoPalabra != this.encontrada
    }

    //TODO: borrar funciones, provisorias para chequeos.
    public void getCoordenadasInicio(){
        return this.coordenadasInicio
    }

    public void getCoordenadaFin(){
        return this.coordenadasFin
    }

    public void getStatusPalabra(){
        return this.encontrada
    }

}