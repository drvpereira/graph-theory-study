package br.ufrn.info.graph.gleydson.trabalho;

/*
 * AGMPrim.java
 *
 * Created on 24 de Dezembro de 2002, 14:17
 */

/**
 *
 * @author  gleydson
 */

import java.util.*;

public class AGMPrim extends AGM {
    
    public AGMPrim ( GraphManager graph, AreaDesenho areaDesenho ) {
            super(graph,areaDesenho);
    }
        
    public static void encontarAGM( GraphManager graph, AreaDesenho areaDesenho ) {
    
        instancia = new Thread( new AGMPrim(graph, areaDesenho) );
        instancia.setPriority( Thread.MIN_PRIORITY );
        instancia.start();
        
    }
    
    public void run ( ) {
        
         Object[] nodes = graph.getNodes();
         Object[] arestas = graph.getArestas();
         
         Vector T = new Vector();
         Vector V = (Vector) graph.getNodesVector().clone();
         Vector N = (Vector) graph.getNodesVector();
         
         T.add( nodes[0] );
         V.remove( nodes[0] );
         
         while ( true ) {
             
             Aresta menor = null;
             byte origem_destino = 0;
             
             // Encontrar menor aresta (j,k) tal que j e T, k e V
             for ( int a = 0; a < arestas.length; a++ ) {
                 
                 if ( ! ( (Aresta) arestas[a]).isAGM() ) {
                     
                    if ( T.contains(  ( (Aresta) arestas[a] ).getOrigem() ) && V.contains(  ((Aresta) arestas[a]).getDestino() ) ) {
                      
                        Aresta aresta = (Aresta) arestas[a];
                        System.out.print ( "Pesquisando " + aresta.getValor() );
                        System.out.println( " ->  " + aresta.getOrigem() + " - " + aresta.getDestino() );
                        
                        if ( menor == null ) {
                            menor = (Aresta) arestas[a];
                            origem_destino = 1;
                        }
                        else {
                            
                            if ( ((Aresta) arestas[a]).getValor() < menor.getValor() )  {
                                menor = (Aresta) arestas[a];
                                origem_destino = 1;
                            }
                        }
                        
                    } else if ( T.contains(  ( (Aresta) arestas[a] ).getDestino() ) && V.contains(  ((Aresta) arestas[a]).getOrigem() ) ) {
                 
                        Aresta aresta = (Aresta) arestas[a];
                        System.out.print ( "Pesquisando " + aresta.getValor() );
                        System.out.println( " ->  " + aresta.getOrigem() + " - " + aresta.getDestino() );
                        
                         if ( menor == null ) {
                            menor = (Aresta) arestas[a];
                            origem_destino = 2;
                         }
                        else
                            if ( ((Aresta) arestas[a]).getValor() < menor.getValor() ) {
                                menor = (Aresta) arestas[a];
                                origem_destino = 2;
                            }
                        
                        
                    }
             
                 }
             }
             
             if ( menor == null ) break;
             
             System.out.print ( "Menor: " + menor.getValor() );
             System.out.println( " " +  menor.getOrigem() + " - " + menor.getDestino() + "\n" );
             
                          
             animaAresta ( menor, areaDesenho );
             
             menor.setCor( java.awt.Color.red );
             menor.setAGM ( true );
             areaDesenho.repaint();
             
             if ( origem_destino == 1 )  {
                T.add ( menor.getDestino() );
                V.remove ( menor.getDestino() );
             } else {
                T.add ( menor.getOrigem() );
                V.remove ( menor.getOrigem() );
             }
             
             System.out.print ("T: ");
        
             for ( int a = 0; a < T.size(); a++  ) 
                 System.out.print ( T.get(a) + "," );
             
             System.out.print ("\nV: " );
             
             for ( int a = 0; a < V.size(); a++  ) 
                 System.out.print ( V.get(a) + "," );
             
             System.out.println ( "Origem: " + origem_destino );
             
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
    
    public static void proxPasso() {
        synchronized ( instancia ) {
            instancia.notify();
        }
    }

    public static void continuar() {
        stop = false;
    }
    
}
