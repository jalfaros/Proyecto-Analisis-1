
package Graph;

/**
 *
 * @author warner
 */
//Clase Arco
public class Arco {

    Vertice destino;
    Arco sigA;
    int distancia;
/**
 * 
 * @param distancia
 * @param destino 
 */
    public Arco(int distancia, Vertice destino) {
        this.destino = destino;
        this.sigA = null;
        this.distancia = distancia;
    }

}
