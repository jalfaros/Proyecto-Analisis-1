
package Graph;

/**
 *
 * @author warner
 */
//Clase vertice
public class Vertice {
    
    String nombre;
    Vertice sigV;
    Arco subListaArcos;
    boolean visitado;
/**
 * 
 * @param nombre 
 */
    public Vertice(String nombre) {
        this.nombre = nombre;
        this.sigV = null;
        this.subListaArcos = null;
        this.visitado = false;
    }
    
}
