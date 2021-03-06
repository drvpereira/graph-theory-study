/*
 * Sistema Integrado de Patrimônio e Administração de Contratos
 * Superintendência de Informática - UFRN
 * 
 * Criado em 02/06/2005
 *
 */
package br.ufrn.info.graph.domain;

import java.util.Vector;

/**
 * Classe que implementa um grafo utilizando
 * uma Matriz de Incidência
 *  
 * @author David Ricardo do Vale Pereira
 *  
 */
public class GrafoMatrizIncidenciaImpl extends AbstractGrafo {

    //private int matrizIncidencia[][];
    
    /**
     * Construtor da Classe
     */
    public GrafoMatrizIncidenciaImpl() {
        //matrizIncidencia = new int[numArestas][numVertices];
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
