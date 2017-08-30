package br.ufrn.info.graph.gleydson.trabalho;

/*
 * Node.java
 *
 * Created on 12 de Dezembro de 2002, 23:51
 */

/**
 *
 * @author  gleydson
 */

import java.util.*;
import java.io.*;
import java.awt.Color;

public class Node implements Serializable {
    
    public static int sequence = 1;     // Sequencia dos nós
    
    private int numero;         // Número do nó
    private int x;              // Coordenadas
    private int y;              
    private boolean selected;   // Selecionado no VIEW
    private Vector vizinhos;    // Vetor de vizinhos
    private Color cor;          // Cor do nó no VIEW
    private boolean visitado;   // Usado para determinar se o grafo é aciclico
    private boolean AGM;        // Usado para determinar se o grafo é aciclico
    
    public Node ( int x, int y, boolean selected ) {
        
        this.x = x;
        this.y = y;
        this.selected = selected;
        vizinhos = new Vector();
        cor = Color.blue;
        numero = sequence++;
        
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
    
    /** Getter for property selected.
     * @return Value of property selected.
     */
    public boolean isSelected() {
        return selected;
    }    
    
    /** Setter for property selected.
     * @param selected New value of property selected.
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public boolean equals ( Node obj ) {
        if ( x == obj.getX() && y == obj.getY() )
            return true;
        else
            return false;
    }

    public void addVizinho ( Node vizinho ) {
        vizinhos.add ( vizinho ) ;
    }

    public Vector getVizinhos ( ) {
        return vizinhos;
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

    public int getNumero() {
        return numero;
    }
    
    public String toString() {
        return String.valueOf(numero);
    }
    
    /** Getter for property visitado.
     * @return Value of property visitado.
     */
    public boolean isVisitado() {
        return visitado;
    }    
   
    /** Setter for property visitado.
     * @param visitado New value of property visitado.
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
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
    }    
    
    public static void clearSequence() {
        sequence = 1;
    }
    
}

