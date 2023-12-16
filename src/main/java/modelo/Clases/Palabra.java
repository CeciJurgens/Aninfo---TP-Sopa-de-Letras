package modelo.Clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palabra{

    private String palabraStr;
    private List<Integer> coordenadasInicio;
    private List<Integer> coordenadasFin;
    private boolean encontrada;
    private boolean esHorizontal;

    public Palabra(String unaPalabra, boolean isHorizontal) {
        this.palabraStr = unaPalabra;
        this.esHorizontal = isHorizontal;
        this.coordenadasInicio = Arrays.asList(0, 0);
        this.coordenadasFin = esHorizontal ? Arrays.asList(0, palabraStr.length() - 1) : Arrays.asList(palabraStr.length() - 1, 0);
        this.encontrada = false;
    }
    
    //TODO: revisar en refactor
    public boolean actualizacionEstadoPalabra(List<Integer> coordsSeleccionadasInicio, List<Integer> coordsSeleccionadasFin){
        boolean estadoPalabra = this.encontrada;

        if (this.coordenadasInicio.equals(coordsSeleccionadasInicio)  && this.coordenadasFin.equals(coordsSeleccionadasFin)){
            this.encontrada = true;
        }
        return  estadoPalabra != this.encontrada;
    }
    
    public List<Integer> getCoordenadasInicio(){
        return this.coordenadasInicio;
    }

    public List<Integer> getCoordenadasFin(){
        return this.coordenadasFin;
    }
  
    public boolean getEstadoPalabra(){
        return this.encontrada;
    }

    public String getPalabraString(){
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

    public int getLongitudPalabra(){
        return this.palabraStr.length();
    }
}