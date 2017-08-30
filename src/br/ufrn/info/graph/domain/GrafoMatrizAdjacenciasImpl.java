/*
 * Sistema Integrado de Patrim�nio e Administra��o de Contratos
 * Superintend�ncia de Inform�tica - UFRN
 * 
 * Criado em 02/06/2005
 *
 */
package br.ufrn.info.graph.domain;

import java.util.Vector;

/**
 * Classe que implementa um grafo utilizando
 * uma Matriz de Adjac�ncias
 *  
 * @author David Ricardo do Vale Pereira
 *  
 */
public class GrafoMatrizAdjacenciasImpl extends AbstractGrafo {

    //private int matrizAdjacencias[][];
    
    /**
     * Construtor da Classe
     */
    public GrafoMatrizAdjacenciasImpl() {
       // matrizAdjacencias = new int[numVertices][numVertices];
    }
    
    /**
     * @see br.ufrn.info.graph.domain.AbstractGrafo#addVertice(br.ufrn.info.graph.Vertice)
     */
    public void addVertice(Vertice v) {

    }

    /**
     * @see br.ufrn.info.graph.domain.AbstractGrafo#remVertice(br.ufrn.info.graph.Vertice)
     */
    public void remVertice(Vertice v) {

    }

    /**
     * @see br.ufrn.info.graph.domain.AbstractGrafo#addAresta(br.ufrn.info.graph.Aresta)
     */
    public void addAresta(Aresta a) {

    }

    /**
     * @see br.ufrn.info.graph.domain.AbstractGrafo#remAresta(br.ufrn.info.graph.Aresta)
     */
    public void remAresta(Aresta a) {

    }

    /**
     * @see br.ufrn.info.graph.domain.AbstractGrafo#toString()
     */
    public String toString() {
        return null;
    }

    public Vector getListaArestas() {
        return null;
    }

    public Vector getListaVertices() {
        return null;
    }

}
