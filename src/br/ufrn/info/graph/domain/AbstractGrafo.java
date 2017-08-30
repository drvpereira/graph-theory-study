/*
 * Sistema Integrado de Patrim�nio e Administra��o de Contratos
 * Superintend�ncia de Inform�tica - UFRN
 * 
 * Criado em 02/06/2005
 *
 */
package br.ufrn.info.graph.domain;

import java.io.Serializable;
import java.util.Vector;

/**
 * Classe que representa um grafo abstrato. 
 *  
 * @author David Ricardo do Vale Pereira
 *  
 */
public abstract class AbstractGrafo implements Serializable {
    
    /** N�mero de v�rtices */
    protected int numVertices;
    
    /** N�mero de arestas */
    protected int numArestas;
    
    /** Indica se o grafo � orientado ou n�o */
    protected boolean orientado;
    
    /** Indica se o grafo � rotulado ou n�o */
    protected boolean rotulado;
    
    /**
     * Adiciona um v�rtice ao grafo.
     * @param v V�rtice a ser adicionado.
     */
    public abstract void addVertice(Vertice v);

    /**
     * Remove um v�rtice do grafo.
     * @param v V�rtice a ser removido.
     */
    public abstract void remVertice(Vertice v);

    /**
     * Adiciona uma aresta ao grafo.
     * @param a Aresta a ser adicionada.
     */
    public abstract void addAresta(Aresta a);
    
    /**
     * Remove uma aresta do grafo.
     * @param a Aresta a ser removida.
     */
    public abstract void remAresta(Aresta a);
    
    /** 
     * Retorna a representa��o em String do Grafo 
     */
    public abstract String toString();
    
    /**
     * Retorna o n�mero de arestas.
     * @return Retorna numArestas.
     */
    public int getNumArestas() {
        return numArestas;
    }
    
    /**
     * Atribui um valor ao n�mero de arestas.
     * @param numArestas O valor a ser atribu�do.
     */
    public void setNumArestas(int numArestas) {
        this.numArestas = numArestas;
    }
    
    /**
     * Retorma o n�mero de v�rtices.
     * @return Retorna numVertices.
     */
    public int getNumVertices() {
        return numVertices;
    }
    
    /**
     * Atribui um valor ao n�mero de v�rtices.
     * @param numVertices O valor a ser atribu�do.
     */
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }
    
    /**
     * Retorna orientado
     * @return <b>true</b>, se o grafo for orientado, <b>false</b> caso contr�rio.
     */
    public boolean isOrientado() {
        return orientado;
    }
    
    /**
     * Informa se o grafo ser� orientado ou n�o.
     * @param orientado Valor a ser atribu�do.
     */
    public void setOrientado(boolean orientado) {
        this.orientado = orientado;
    }
    
    public abstract Vector getListaArestas();
    
    public abstract Vector getListaVertices();
    
    /**
     * Retorna Rotulado
     * @return <b>true</b>, se o grafo for rotulado, <b>false</b> caso contr�tio.
     */
    public boolean isRotulado() {
        return rotulado;
    }
    /**
     * Informa se o grafo ser� rotulado ou n�o.
     * @param rotulado Valor a ser atribu�do.
     */
    public void setRotulado(boolean rotulado) {
        this.rotulado = rotulado;
    }
}
