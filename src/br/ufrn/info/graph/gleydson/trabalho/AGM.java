package br.ufrn.info.graph.gleydson.trabalho;

/*
 * AGM.java
 *
 * Created on 2 de Janeiro de 2003, 14:42
 */

/**
 *
 * @author  gleydson
 */



public abstract class AGM implements Runnable {
    
    protected  static boolean stop = true;
    public  static int numeroPiscadas = 4;
    public  static long intervaloPiscada = 300;
    protected static Thread instancia;
    protected GraphManager graph;
    protected AreaDesenho areaDesenho;

    public static final int PRIM = 0;
    public static final int KRUSKAL = 1;
    public static final int BORUVKA = 2;
    
    public AGM ( GraphManager graph, AreaDesenho areaDesenho ) {
            this.graph = graph;
            this.areaDesenho = areaDesenho;
            stop = true;
    }
    
    
    protected void animaAresta ( Aresta aresta, AreaDesenho areaDesenho ) {
        
         for ( int b = 0; b < numeroPiscadas; b++ ) {
                 aresta.setCor( java.awt.Color.red );
                 areaDesenho.repaint();
                 try {
                     Thread.sleep(intervaloPiscada/2);
                 }
                 catch ( Exception e ) { }
                 aresta.setCor( java.awt.Color.black );
                 areaDesenho.repaint();
                 try {
                     Thread.sleep(intervaloPiscada/2);
                 }
                 catch ( Exception e ) { }
                 
         }
         aresta.setCor ( java.awt.Color.red );
         areaDesenho.repaint();
         
    }
}
