package Graph;

/**
 * @author warner
 */
//Clase grafo
public class Grafo {

    //Toma la primera posicion de la lista de vertices
    public Vertice grafo;

    /**
     * Variables para realizar los conteos
     */
    public int _comparacion = 0;
    public int _asignacion = 0;
    public int _linea = 0;

    //Insertar al inicio de la lista de los vértices
    /**
     * @param nombre
     */
    public void insertarGrafo(String nombre) {
        Vertice vertice = new Vertice(nombre);
        if (grafo == null) {
            grafo = vertice;
        } else {
            vertice.sigV = grafo;
            grafo = vertice;
        }
    }

    //Buscar los vertices
    /**
     * @param nom
     * @return
     */
    public Vertice buscarVertice(String nom) {
        if (grafo == null) {
            return null;
        } else {
            Vertice temp = grafo;
            while (temp != null) {
                if (temp.nombre.equals(nom)) {
                    return temp;
                }
                temp = temp.sigV;
            }
        }
        return null;
    }

    //Insertar Arcos 
    /**
     * @param origen
     * @param destino
     * @param distancia
     */
    public void insertarArco(String origen, String destino, int distancia) {
        Vertice vOrigen = buscarVertice(origen); //Se busca el origen     <--
        Vertice vDestino = buscarVertice(destino);//Se busca el destino   <--

        Arco nnArco = new Arco(distancia, vDestino);
        nnArco.sigA = vOrigen.subListaArcos;
        vOrigen.subListaArcos = nnArco;  //Se enlaza
    }

    //Metodo de busqueda por anchura
    public void busquedaAnchura() {

        Vertice aux_1 = grafo;
        _asignacion++;
        _linea++;

        
        while (aux_1 != null) {
            _comparacion++;
            _linea++;
            
            System.out.println("\n\n--------------Vertice: " + aux_1.nombre);
            _linea++;
            
            Arco rut = aux_1.subListaArcos;
            _asignacion++;
            _linea++;

            
            while (rut != null) {
                _comparacion++;
                _linea++;
                
                System.out.println("Origen: " + aux_1.nombre + " destino" + rut.destino.nombre + " Distancia" + rut.distancia);
                _linea++;

                rut = rut.sigA;
                _linea++;
                _asignacion++;
            }
            _linea++;        //Del primer while
            _comparacion++;  //Del primer while

            aux_1 = aux_1.sigV;
            _linea++;
            _asignacion++;
        }
        _linea++;         //Del segundo while
        _comparacion++;   //Del segundo while

    }

    
    /**
     * @param g
     */
    //Por profundidad Este metodo va en recursivo
    public void busquedaProfundidad(Vertice g) {

        if ((g == null) || (g.visitado == true)) {
            _comparacion++;
            _linea++;

            _linea++;
            return;
        }
        _comparacion++; //Esta comparación es la del if
        _linea++;       //Esta linea es la del if

        g.visitado = true;
        _asignacion++;
        _linea++;

        Arco a = g.subListaArcos;
        _asignacion++;
        _linea++;

        while (a != null) {
            _comparacion++;
            _linea++;

            System.out.println("Origen: " + g.nombre + " " + "Destino: " + a.destino.nombre + " Distancia: " + a.distancia);
            _linea++;

            busquedaProfundidad(a.destino);
            _asignacion++;
            _linea++;

            a = a.sigA;
            _asignacion++;
            _linea++;

        }
        _comparacion++;
        _linea++;
    }

    //Limpiar Marcas para el método de profundidad
    public void limpiarMarcas() {

        Vertice g = grafo;
        while (g != null) {
            g.visitado = false;

            g = g.sigV;
        }

    }

    //Insertar datos
    /*
     * @param cant
     * @return
     */
    public void llenarDatos(int cant) {

        for (int i = 0; i < cant; i++) {

            insertarGrafo(Integer.toString(i));
        }

        for (int i = 0; i < cant; i++) {

            for (int j = 0; j < cant; j++) {

                insertarArco(Integer.toString(i), Integer.toString(j), 2);
            }

        }

    }

}
