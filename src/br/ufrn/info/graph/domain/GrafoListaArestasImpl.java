/*
 * Sistema Integrado de Patrimônio e Administração de Contratos
 * Superintendência de Informática - UFRN
 * 
 * Criado em 02/06/2005
 *
 */
package br.ufrn.info.graph.domain;

import java.util.Iterator;
import java.util.Vector;

/**
 * Classe que implementa um grafo utilizando
 * uma Lista de Arestas
 *  
 * @author David Ricardo do Vale Pereira
 *  
 */
public class GrafoListaArestasImpl extends AbstractGrafo {

    private Vector listaArestas;
    
    private Vector listaVertices;
    
    /**
     * Construtor da Classe
     */
    public GrafoListaArestasImpl() {
        listaArestas = new Vector();
        listaVertices = new Vector();
    }
    
    /**
     * @see br.ufrn.info.graph.domain.AbstractGrafo#addVertice(br.ufrn.info.graph.Vertice)
     */
    public void addVertice(Vertice v) {
        if (!listaVertices.contains(v))
            listaVertices.add(v);
    }

    /**
     * @see br.ufrn.info.graph.domain.AbstractGrafo#remVertice(br.ufrn.info.graph.Vertice)
     */
    public void remVertice(Vertice v) {
        if (listaVertices.contains(v)) {
            Iterator it = getListaArestas().iterator();
            while (it.hasNext()) {
                Aresta a = (Aresta) it.next();
                if (a.getInicio().equals(v) || a.getFim().equals(v))
                    it.remove();
            }
        
            listaVertices.remove(v);
        }
    }

    /**
     * @see br.ufrn.info.graph.domain.AbstractGrafo#addAresta(br.ufrn.info.graph.Aresta)
     */
    public void addAresta(Aresta a) {
        if (!listaArestas.contains(a))
            listaArestas.add(a);
    }

    /**
     * @see br.ufrn.info.graph.domain.AbstractGrafo#remAresta(br.ufrn.info.graph.Aresta)
     */
    public void remAresta(Aresta a) {
        if (listaArestas.contains(a))
            listaArestas.remove(a);
    }

    /**
     * 
     */
    public void addAresta(Vertice inicio, Vertice fim) {
        Aresta a = new Aresta();
        a.setInicio(inicio);
        a.setFim(fim);
        listaArestas.add(a);
    }

    /**
     * @see br.ufrn.info.graph.domain.AbstractGrafo#toString()
     */
    public String toString() {
        return null;
    }

    /**
     * Retorna a lista de arestas.
     * @return Retorna listaArestas.
     */
    public Vector getListaArestas() {
        return listaArestas;
    }
    
    /**
     * Altera a lista de arestas.
     * @param listaArestas Nova lista de arestas.
     */
    public void setListaArestas(Vector listaArestas) {
        this.listaArestas = listaArestas;
    }
    /**
     * @return Retorna listaVertices.
     */
    public Vector getListaVertices() {
        return listaVertices;
    }
    /**
     * @param listaVertices The listaVertices to set.
     */
    public void setListaVertices(Vector listaVertices) {
        this.listaVertices = listaVertices;
    }

}
