/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Ignacio
 */
public class Arbol {
    /* Estas variables las usamos para el método recursivo, ya que si las declaramos locales se pierde el conteo
     cuando se hace la nueva llamada recursiva*/

    public int _comparaciones = 0;
    public int _asignaciones = 0;
    public int _lineas = 0;

    public Nodo raiz;
    int hmax;
    int cantNodos;

    public Arbol() {
        this.raiz = null;
        hmax = 0;
        cantNodos = 0;
    }

    private Nodo insertarNodo(Nodo arbol, int num) {
        
        /*
        Método para la inserción de un nodo dentro del árbol binario
        genera un número random y lo asigna al nodo antes de ser ingresado
        
        fecha creación: 30/04/2020
        fecha de finalización: 03/05/2020
        */

        int numero = (int) (Math.random() * 1000000) + 1;
        Nodo nuevoNodo = new Nodo(numero);

        if (arbol == null) { //Al estar vacío este se convierte en padre
            arbol = nuevoNodo;
        } else {
            Nodo temp = arbol;

            while (true) {
                if (num <= temp.num) { //Si entra se va por la izquierda del nodo
                    if (temp.izq == null) {
                        temp.izq = nuevoNodo;
                        break;
                    } else {
                        temp = temp.izq;
                    }
                } else { //Va por la parte de la derecha
                    if (temp.der == null) {
                        temp.der = nuevoNodo;
                        break;
                    } else {
                        temp = temp.der;
                    }
                }
            }
        }

        return arbol;
    }

    /*
     Implementación del algoritmo de impresión a profundidad
     En este caso se implementará la impresión enOrden
     Imprime de manera: izquierda - raiz - derecha
     */
    public void enOrden(Nodo raiz) {
        
        /*
        Algoritmo de búsqueda por profundidad(recursivo) imprime el árbol 
        de manera enOrden
        
        fecha creación: 30/04/2020
        fecha de finalización: 05/05/2020
        
        
        */

        _lineas++; //Linea de if
        if (raiz == null) {
            _comparaciones++; //Comparacion true del if
            _lineas++; //Linea del return
            return;
        }
        _comparaciones++; //Comparación false del if

        enOrden(raiz.izq);
        _lineas++;
        _asignaciones++;  
        System.out.println(raiz.num);
        _lineas++;
        enOrden(raiz.der);
        _lineas++;
        _asignaciones++; 
    }

    public Nodo llenarArbol(Nodo nodo, int num) {
        
        /*
        Recibe el dato del comboBox en la interfaz y se encarga de llamar la
        cantidad N veces a la función del árbol, para así llenarlo.
        
        fecha creación: 30/04/2020
        fecha de finalización: 03/05/2020
        
        */
        
        

        for (int i = 1; i <= num; i++) {
            nodo = insertarNodo(nodo, i);
        }

        return nodo;
    }

    public void busquedaAnchura(Nodo raiz, int c) {
        
        /*
        Algoritmo de búsqueda por anchura (iterativo) se ejecuta de manera lineal 
        
        fecha creación: 07/04/2020
        fecha de finalización: 12/05/2020
        */

        int _linea = 0;
        int _comparacion = 0;
        int _asignacion = 0;

        double tInicio = System.currentTimeMillis();

        Queue<Nodo> colaAux = new LinkedList<>();
        _linea++;
        _asignacion++;
        colaAux.add(raiz);
        _linea++;
        _asignacion++; //Preguntar si es una asignación *agregar a la cola*
        
        while (colaAux.size() != 0) {
            _linea++;
            _comparacion++;
            Nodo nodo = colaAux.poll();
            _linea++;
            _asignacion++;
            System.out.println("VALOR DEL NODO =>" + nodo.num);
            _linea++;

            if (nodo.num == c) {
                _linea++;
                _comparacion++;
                System.out.println("Encontrado: " + nodo.num);
                _linea++;
                System.out.println("Cantidad de comparaciones => " + _comparacion + "\n"
                        + "Cantidad de asignaciones => " + _asignacion + "\n"
                        + "Cantidad de lineas ejecutadas =>" + _linea + "\n\n\n\n");
                _linea++; //La del retorno
                return;
            }
            _comparacion++; //Comparacion false del if nodo.num;

            _linea++;
            if (nodo.izq != null) {
                _comparacion++; //Comparacion true del if 
                colaAux.add(nodo.izq);
                _linea++;
                _asignacion++;
            }
            _comparacion++; //Comparacion false del if  nodo.izq != null

            _linea++;
            if (nodo.der != null) {
                _comparacion++; //Comparacion true del if 
                colaAux.add(nodo.der);
                _linea++;
                _asignacion++;
            }
            _comparacion++; //Comparacion false del if nodo.der != null

        }
        _linea++; 
        _comparacion++; //Comparación false del while

        double tFinal = (System.currentTimeMillis() - tInicio) / 1000;
        System.out.println("\"---DATOS DE LA PRUEBA DE ANCHURA: " + "---\n" );
        System.out.println("Cantidad de comparacicones => " + _comparacion + "\n"
                + "Cantidad de asignaciones => " + _asignacion + "\n"
                + "Cantidad de lineas ejecutadas =>" + _linea + "\n"
                + "Tiempo de ejecución en milisegundos =>" + tFinal + "\n\n");

    }

}
