package modelo.Clases;
import java.util.ArrayList;

public class Palabra{

    private String palabraStr;
    private ArrayList<Integer> coordenadasInicio;
    private ArrayList<Integer> coordenadasFin;
    private boolean encontrada;

    public Palabra(String unaPalabra,ArrayList<Integer> coordsInicio, ArrayList<Integer> coordsFin) {
        this.palabra = unaPalabra;
        this.coordenadasInicio = coordsInicio;
        this.coordenadasFin = coordsFin;
        this.encontrada = false;
    }
    
    //TODO: revisar en refactor
    private boolean actualizacionEstadoPalabra(ArrayList<Integer> coordsSeleccionadasInicio, ArrayList<Integer> coordsSeleccionadasFin){
        boolean estadoPalabra = this.encontrada;
        if (this.coordenadasInicio == coordsSeleccionadasInicio && this.coordenadasFin == coordsSeleccionadasFin){
            this.encontrada = true;
        }
        return  estadoPalabra != this.encontrada;
    }

    //TODO: borrar funciones, provisorias para chequeos.
    public ArrayList<Integer> getCoordenadasInicio(){
        return this.coordenadasInicio;
    }

    public ArrayList<Integer> getCoordenadasFin(){
        return this.coordenadasFin;
    }

    public boolean getStatusPalabra(){
        return this.encontrada;
    }

    public boolean getPalabraString(){
        return this.palabraStr;
    }

    public void setCoordenadasInicio(int x,int y){
        this.coordenadasInicio.set(0,x);
        this.coordenadasInicio.set(1,y);
    }

    public void setCoordenadasFin(int x,int y){
        this.coordenadasFin.set(0,x);
        this.coordenadasFin.set(1,y);
    }

}