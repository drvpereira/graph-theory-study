package br.ufrn.info.graph.gleydson.trabalho;

/*
 * AGMBoruska.java
 *
 * Created on 11 de Janeiro de 2003, 10:24
 */

/**
 *
 * @author  gleydson
 */

import java.util.*;


class Floresta extends Vector {
    
    public boolean contains( Object obj ) {
     
        for ( int a = 0 ; a < this.size(); a++ ) 
            if ( ( (Vector)this.get(a) ).contains( obj ) )
                return true;
        
        return false;
    }
    
    public boolean contains( Object obj , int pos ) {
     
        if ( ( (Vector)this.get(pos) ).contains( obj ) )
                return true;
        
        return false;
    }
    
    
    public int pos ( Object obj  ) {
     
        for ( int a = 0 ; a < this.size(); a++ ) 
            if ( ( (Vector)this.get(a) ).contains( obj ) )
                return a;
        
        
        return -1;

    }
}

public class AGMBoruska extends AGM {
    
    /** Creates a new instance of AGMBoruska */
    public AGMBoruska(GraphManager graph, AreaDesenho areaDesenho) {
        super(graph,areaDesenho);
    }
    
    public static void encontrarAGM( GraphManager graph, AreaDesenho areaDesenho ) {
     
        instancia = new Thread( new AGMBoruska(graph, areaDesenho) );
        instancia.setPriority( Thread.MIN_PRIORITY );
        instancia.start();
    }

    public void run() {

        Floresta floresta = new Floresta();
        Vector nodes  = graph.getNodesVector();
        for ( int a = 0; a < nodes.size(); a++ ) {
            Vector arvore = new Vector();
            arvore.add( nodes.get(a) );
            floresta.add( arvore );
        }
        
        while ( floresta.size() > 1 ) {
            
            int origem_destino = 0;
            
            for ( int a = 0; a < floresta.size(); a++ ) {
                
                Vector origens = (Vector) floresta.get(a);
                Object[] arestas = graph.getArestas();
                Aresta menor = null;
                
                for ( int d = 0; d < origens.size(); d ++ ) {
                
                    for ( int b = 0; b < arestas.length; b++ ) {
                        Aresta ar = (Aresta) arestas[b];
             
                        if ( ar.getOrigem() == origens.get(d) && ! floresta.contains( ar.getDestino(), a ) ) {
                            if ( menor == null ) {
                                menor = ar;
                            origem_destino = 1;
                        }
                        else
                            if ( ar.getValor() < menor.getValor() ) {
                                menor = ar;
                                origem_destino = 1;
                            }
                        }
                    
                        if ( ar.getDestino() == origens.get(d) && ! floresta.contains( ar.getOrigem(), a ) ){
                        
                            if ( menor == null ) {
                                menor = ar;
                                origem_destino = 2;
                            }
                            else
                                if ( ar.getValor() < menor.getValor() ) {
                                    menor = ar;
                                    origem_destino = 2;
                                }
                        }
                
                    } // Fim do FOR das arestas
                }
                
                int pos;
                if ( origem_destino == 1 ) 
                    pos = floresta.pos ( menor.getDestino() );
                else
                    pos = floresta.pos ( menor.getOrigem() );                        
                    
                Vector nosAIncluir = (Vector) floresta.get(pos);
                for ( int c = 0; c < nosAIncluir.size(); c++ )
                        origens.add ( nosAIncluir.get(c) );
                        
                floresta.removeElement( nosAIncluir );
                
                menor.setAGM ( true );
                animaAresta ( menor, areaDesenho );

                if ( stop ) { 
                  try { 
                     synchronized ( instancia ) {
                        instancia.wait();
                     }
                    }
                    catch ( Exception e ) {
                        System.err.println ( e );
                    }
                }
                
            }
            
            
        }
        
        
    }
    
    public static void proxPasso() {
        synchronized ( instancia ) {
            instancia.notify();
        }
    }

    public static void continuar() {
        stop = false;
    }
    
    
}
