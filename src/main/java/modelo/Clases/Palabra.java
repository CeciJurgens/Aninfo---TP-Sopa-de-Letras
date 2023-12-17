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
    
    //TODO: revisar en refactor: cambie un poco el codigo para q no diga q se encontro una palabra si ya se la habia encontrado antes.
    public boolean actualizacionEstadoPalabra(List<Integer> coordsSeleccionadasInicio, List<Integer> coordsSeleccionadasFin){
        boolean estadoPalabra = this.encontrada;
        boolean seEncontro = false;

        if (this.coordenadasInicio.equals(coordsSeleccionadasInicio)  && this.coordenadasFin.equals(coordsSeleccionadasFin)){
            seEncontro = true;
        }
        if(seEncontro == true && estadoPalabra == false){
            this.encontrada = true;
            return true;}
        return  false;
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

    public boolean getIsEsHorizontal() {
        return esHorizontal;
    }

    public void setEncontrada(boolean encontrada) {
        this.encontrada = encontrada;
    }

    public String toString() {
        return "Palabra{" +
                "palabraStr='" + palabraStr + '\'' +
                ", coordenadasInicio=" + coordenadasInicio +
                ", coordenadasFin=" + coordenadasFin +
                ", encontrada=" + encontrada +
                ", esHorizontal=" + esHorizontal +
                '}';
    }
}

