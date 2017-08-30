/*
 * Sistema Integrado de Patrimônio e Administração de Contratos
 * Superintendência de Informática - UFRN
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
    
    /** Número de vértices */
    protected int numVertices;
    
    /** Número de arestas */
    protected int numArestas;
    
    /** Indica se o grafo é orientado ou não */
    protected boolean orientado;
    
    /** Indica se o grafo é rotulado ou não */
    protected boolean rotulado;
    
    /**
     * Adiciona um vértice ao grafo.
     * @param v Vértice a ser adicionado.
     */
    public abstract void addVertice(Vertice v);

    /**
     * Remove um vértice do grafo.
     * @param v Vértice a ser removido.
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
     * Retorna a representação em String do Grafo 
     */
    public abstract String toString();
    
    /**
     * Retorna o número de arestas.
     * @return Retorna numArestas.
     */
    public int getNumArestas() {
        return numArestas;
    }
    
    /**
     * Atribui um valor ao número de arestas.
     * @param numArestas O valor a ser atribuído.
     */
    public void setNumArestas(int numArestas) {
        this.numArestas = numArestas;
    }
    
    /**
     * Retorma o número de vértices.
     * @return Retorna numVertices.
     */
    public int getNumVertices() {
        return numVertices;
    }
    
    /**
     * Atribui um valor ao número de vértices.
     * @param numVertices O valor a ser atribuído.
     */
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }
    
    /**
     * Retorna orientado
     * @return <b>true</b>, se o grafo for orientado, <b>false</b> caso contrário.
     */
    public boolean isOrientado() {
        return orientado;
    }
    
    /**
     * Informa se o grafo será orientado ou não.
     * @param orientado Valor a ser atribuído.
     */
    public void setOrientado(boolean orientado) {
        this.orientado = orientado;
    }
    
    public abstract Vector getListaArestas();
    
    public abstract Vector getListaVertices();
    
    /**
     * Retorna Rotulado
     * @return <b>true</b>, se o grafo for rotulado, <b>false</b> caso contrátio.
     */
    public boolean isRotulado() {
        return rotulado;
    }
    /**
     * Informa se o grafo será rotulado ou não.
     * @param rotulado Valor a ser atribuído.
     */
    public void setRotulado(boolean rotulado) {
        this.rotulado = rotulado;
    }
}
