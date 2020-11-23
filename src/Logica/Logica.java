/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Tree.Arbol;
import static java.lang.Math.abs;

/**
 *
 * @author Ignacio
 */
public class Logica {

    public int transformar(Object num) {

        try {
            int numero = Integer.parseInt((String) num);
            return numero;
        } catch (Exception ex) {
            return -1;
        }

    }
    
    
    public long prueba(  ) throws InterruptedException{
        System.out.println("Inicio algorimo");
        long tInicio = System.currentTimeMillis();
        Thread.sleep(500);
        System.out.println("Final");
        long  tFinal = System.currentTimeMillis();
        
        return (tFinal - tInicio) ;
    }
    
    
    public int eliminarClientesPorEdad( int edad ){
        
        int cont = 0;
        
        if ( inicio == null ){
            return -1;
        }else{
            
            persona aux = inicio;
            
            while ( aux != null ){
                
                if( aux.edad == inicio.edad ){ // No sé si esas son sus variables de la clase, jaja
                    inicio = inicio.sig;
                    cont ++;
                    aux = aux.sig;
                }else {
                    persona temp = incio.sig;
                    
                    while( temp != null ){
                        if( temp.edad == edad ){
                            aux.sig = temp.sig; //Nos brincamos al nodo actual...
                            temp = temp.sig;
                            cont ++;
                        }
                        
                    }
                    
                           
                }
                     
            }
            return cont;
        }
               
        
    } 
    
    
public int eliminarClientesPorEdad( int edad ){

int cont = 0;

if ( inicio == null ){
return -1;
}else{

persona aux = inicio;

while ( aux != null ){

if( aux.edad == inicio.edad ){ // No sé si esas son sus variables de la clase, jaja
inicio = inicio.sig;
cont ++;
aux = aux.sig;
}else {
persona temp = incio.sig;

while( temp != null ){
if( temp.edad == edad ){
aux.sig = temp.sig; //Nos brincamos al nodo actual...
temp = temp.sig;
cont ++;
}

}


}

}
   

}
