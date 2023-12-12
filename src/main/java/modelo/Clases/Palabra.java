package modelo.Clases;
import java.util.ArrayList;
import java.util.Arrays;

public class Palabra{

    private String palabraStr;
    private ArrayList<Integer> coordenadasInicio;
    private ArrayList<Integer> coordenadasFin;
    private boolean encontrada;
    private boolean esHorizontal;

    public Palabra(String unaPalabra, boolean isHorizontal) {
        this.palabraStr = unaPalabra;
        this.esHorizontal = isHorizontal;
        this.coordenadasInicio = new ArrayList<>(Arrays.asList(0, 0));
        if (this.esHorizontal){
            this.coordenadasFin = new ArrayList<>(Arrays.asList(0, this.palabraStr.length() - 1));;
        }else{
            this.coordenadasFin = new ArrayList<>(Arrays.asList(this.palabraStr.length() - 1, 0));
        }
        this.encontrada = false;
    }
    
    //TODO: revisar en refactor
    public boolean actualizacionEstadoPalabra(ArrayList<Integer> coordsSeleccionadasInicio, ArrayList<Integer> coordsSeleccionadasFin){
        boolean estadoPalabra = this.encontrada;

        if (this.coordenadasInicio.equals(coordsSeleccionadasInicio)  && this.coordenadasFin.equals(coordsSeleccionadasFin)){
            this.encontrada = true;
        }
        return  estadoPalabra != this.encontrada;
    }
    
    public ArrayList<Integer> getCoordenadasInicio(){
        return this.coordenadasInicio;
    }

    public ArrayList<Integer> getCoordenadasFin(){
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


}