package categoria_de_palabras;
//El usuario de la clase obtiene un arreglo de n strings de la categoria que indique, garantizando que son todos distintos.
//Se devuelve una excepcion si la categoria no existe, o si n es mayor que la cantidad de palabras por listas

import org.junit.Test;
import static org.junit.Assert.*;
public class CategoriaDePalabras {
    public static final int PALABRAS_POR_LISTA = 40;
    public static final int CANT_LISTAS = 2;
    private final String[][] listasDePalabras = {
        {   "ANANA", "BANANA", "CEREZA", "DURAZNO", "FRUTILLA",
            "KIWI", "LIMON", "MANDARINA", "NARANJA", "PALTA",
            "PERA", "MANZANA", "FRAMBUESA", "CIRUELA", "UVA",
            "SANDIA", "COCO", "DAMASCO", "MELON", "POMELO",
            "PAPAYA", "ARANDANO", "TOMATE", "GRANADA", "HIGO",
            "MANGO", "MORRON", "GUAYABA", "FRESA",
            "CALAFATE", "MEMBRILLO", "LIMA", "ZARZAMORA", "NISPERO",
            "PIÑA", "DATIL", "PEPINO", "CACAO", "MARACUYA",
        },
        {   "ARISTOTELES", "PLATON", "SOFOCLES", "HERACLITO", "DEMOSTENES",
            "HIPARCO", "ANAXIMANDRO", "EUCLIDES", "PTOLOMEO", "ARQUIMEDES",
            "HERODOTO", "TESEOMAQUIA", "ANAXAGORAS", "PITAGORAS", "PERICLES",
            "SOCRATES", "XENOFANES", "EMPEDOCLES", "PROTAGORAS", "DIODORO",
            "HIPATIA", "ERATOSTENES", "GALILEO", "EPICTETO", "ISOCRATES",
            "HIPOCRATES", "NICOMACO", "ARQUELAO", "AXIARCO", "CLEANTES",
            "PARMENIDES", "ALCIBIADES", "HIPOLITO", "SOLON", "ARISTOFANES",
            "ANAXIMENES", "CALLIAS", "MELISO", "TEOFRASTO", "XENOCRATES"
        }
    };
    private String[] categorias = {
            "FRUTAS", "FILOSOFOS"
    };

    public String[] obtenerCategorias(){
        return this.categorias;
    }
    public String[] obtenerColeccion(String categoria, int n){
        if (n>PALABRAS_POR_LISTA){
            throw new IllegalArgumentException(String.format("La cantidad de elementos" +
                    "debe ser menor que %d palabras", PALABRAS_POR_LISTA));
        }
        for(int x=0; x<this.categorias.length; x++){
            if(categoria.equals(this.categorias[x])){
                String[] listaDeLargoN = new String[n];
                boolean repeat;
                for(int y=0; y<n; y++){
                    do{
                        int indiceRandom = (int)(Math.random()*(float)PALABRAS_POR_LISTA);
                        repeat = false;
                        for(int z=0; z<listaDeLargoN.length; z++){
                            if(this.listasDePalabras[x][indiceRandom].equals(listaDeLargoN[z])){
                                repeat=true;
                                break;
                            }
                        }
                        if(repeat==false){
                            listaDeLargoN[y] = this.listasDePalabras[x][indiceRandom];
                        }
                    }while (repeat);
                }
                return(listaDeLargoN);
            }
        }
        throw new IllegalArgumentException("No se encontro la coleccion indicada");
    }

    @Test
    public void test01LaColeccionObtenidaEsDeLargoN() {
        // Arrange (preparación)
        CategoriaDePalabras cat = new CategoriaDePalabras();
        // Act (acción)
        String[] coleccion = cat.obtenerColeccion("FRUTAS", 8);
        for (int x=0; x<8; x++){
            System.out.println(coleccion[x]);
        }
        // Assert (verificación)
        assertEquals(8, coleccion.length);
    }
}

