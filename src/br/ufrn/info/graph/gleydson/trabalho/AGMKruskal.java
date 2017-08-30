package br.ufrn.info.graph.gleydson.trabalho;

/*
 * AGMKruskal.java
 *
 * Created on 2 de Janeiro de 2003, 14:39
 */

/**
 *
 * @author  gleydson
 */

import java.util.*;

public class AGMKruskal extends AGM {

    public static boolean achado = false;
    
    /** Creates a new instance of AGMKruskal */
    public AGMKruskal ( GraphManager graph, AreaDesenho areaDesenho ) {
            super(graph,areaDesenho);
    }
    
    public static void encontrarAGM (GraphManager graph, AreaDesenho areaDesenho) {
        
        instancia = new Thread( new AGMKruskal(graph, areaDesenho) );
        instancia.setPriority(Thread.MIN_PRIORITY);
        instancia.start();
        
    }
    
    public void run() {
        
        // Ordenar Arestas
        
        Vector T = new Vector();
        Object[] arestaArray =  (Object[]) graph.getArestas().clone();
        Arrays.sort( arestaArray );
        
        Aresta aresta = (Aresta) arestaArray[0];
        T.add( aresta );
        aresta.setAGM( true );
        areaDesenho.repaint();
        
        for ( int a = 0; a < arestaArray.length; a++ ) {
        
            aresta = (Aresta) arestaArray[a];
            System.out.println ( "Pesquisando "  + aresta );
            if ( isAciclico ( T, aresta ) ) {
                T.add( aresta );
                aresta.setAGM( true );
                animaAresta( aresta, areaDesenho);
                System.out.println ( "Adicionado" );
                
                if ( stop ) {
                    try { 
                        synchronized ( instancia ) {
                            instancia.wait();
                        }
                    }
                    catch ( Exception e )  {} 
                }
            }

        }
        
    }


    public boolean isAciclico ( Vector T, Aresta aresta ) {
        
        graph.desvisiteTodos();
        
        for ( int a = 0 ; a < T.size(); a++ ) {
            ((Aresta) T.get(a)).getOrigem().setAGM(true);
            ((Aresta) T.get(a)).getDestino().setAGM(true);
        }
        
        aresta.getDestino().setAGM(true);
        aresta.getOrigem().setAGM(true);
        
        Node origem =  aresta.getOrigem();

        achado = false;
        
        Vector TMaisAresta = (Vector) T.clone();
        TMaisAresta.add( aresta );
        
        
        percorre(origem, null, TMaisAresta );
        
        return ! achado;
    }
    
    
    public void percorre( Node node, Node origem, Vector T ) {
     
        if ( node.isVisitado() ) achado = true;
        
        node.setVisitado ( true ) ;
        
        if ( ! achado ) {
            Vector vizinhos = (Vector) node.getVizinhos().clone();
            if (origem != null) vizinhos.remove( origem );
        
            for ( int a = 0; a < vizinhos.size(); a++)
                if ( ((Node) vizinhos.get(a)).isAGM() ) {
                    // Verifica se a aresta está em T
                    boolean estaEmT = false;
                    for ( int b = 0; b < T.size(); b++ ) {
                        Aresta ar = (Aresta) T.get(b);
                        if ( ( ar.getOrigem() == node || ar.getDestino() == node ) && ( ar.getOrigem() == (Node) vizinhos.get(a) || ar.getDestino() == (Node) vizinhos.get(a) ) ) {
                            estaEmT = true;
                            break;
                        }
                    }
                    if ( estaEmT) 
                       percorre( (Node) vizinhos.get(a), node, T);
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
