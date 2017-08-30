package br.ufrn.info.graph.gleydson.trabalho;

/*
 * Aresta.java
 *
 * Created on 12 de Dezembro de 2002, 23:50
 */

/**
 *
 * @author  gleydson
 */

import java.io.*;
import java.awt.Color;

public class Aresta implements Serializable, Comparable {
    
    private Node origem;
    private Node destino;
    private int valor;
    private int x;
    private int y;
    private Color cor;
    private boolean AGM;
    
    public Aresta ( Node origem, Node destino , int valor) {
        
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.cor = Color.black;
    }
    
    public Node getOrigem() {
        return origem;
    }
    
    public Node getDestino() {
        return destino;
    }
    
    public int getValor() {
        return valor;
    } 
    
    /** Getter for property x.
     * @return Value of property x.
     */
    public int getX() {
        return x;
    }    
    
    /** Setter for property x.
     * @param x New value of property x.
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /** Getter for property y.
     * @return Value of property y.
     */
    public int getY() {
        return y;
    }
    
    /** Setter for property y.
     * @param y New value of property y.
     */
    public void setY(int y) {
        this.y = y;
    }
    
    public boolean equals( Object obj ) {
        
        if ( ((Aresta)obj).getOrigem() == origem  && ((Aresta)obj).getDestino() == destino  )
            return true;
        else
            return false;
        
    }
    
    /** Getter for property cor.
     * @return Value of property cor.
     */
    public java.awt.Color getCor() {
        return cor;
    }    
    
    /** Setter for property cor.
     * @param cor New value of property cor.
     */
    public void setCor(java.awt.Color cor) {
        this.cor = cor;
    }
    
    /** Getter for property AGM.
     * @return Value of property AGM.
     */
    public boolean isAGM() {
        return AGM;
    }    
    
    /** Setter for property AGM.
     * @param AGM New value of property AGM.
     */
    public void setAGM(boolean AGM) {
        this.AGM = AGM;
        cor = Color.red;
    }
    
    public int compareTo ( Object obj ) {
     
        if ( ((Aresta)obj).getValor() == valor )
            return 0;
        else if ( valor > ((Aresta)obj).getValor() )
                return 1;
            else
                return 0;
            
    }
    
    public String toString() {
        return origem + " - " + destino;
    }
    
}    
    
