/*
 * Sistema Integrado de Patrimônio e Administração de Contratos
 * Superintendência de Informática - UFRN
 * 
 * Created on 16/06/2005
 *
 */
package br.ufrn.info.graph.algorithms;

import java.util.Iterator;
import java.util.Vector;

import br.ufrn.info.graph.domain.AbstractGrafo;
import br.ufrn.info.graph.domain.Aresta;
import br.ufrn.info.graph.domain.Vertice;

/**
 * Comente a classe aqui!!
 *
 * @author David Ricardo
 *
 */
public class Dijkstra {

    AbstractGrafo grafo;
    
    Vector listaVertices;
    
    Vector listaArestas;
    
    public Dijkstra(AbstractGrafo grafo) {
        this.grafo = grafo;
        listaVertices = (Vector) grafo.getListaVertices().clone();
        listaArestas = (Vector) grafo.getListaArestas().clone();
    }
    
    public void solve() {
        Vector s = new Vector();
        
        Iterator it = listaVertices.iterator();
        Vertice v0 = (Vertice) it.next();
        it.remove();
        
        int d[] = new int[listaVertices.size()];
        int i = 0;
        while (it.hasNext()) {
            Vertice v = (Vertice) it.next();
            d[i] = l(v0,v);
            i++;
        }
        
        while (s.containsAll(listaVertices)) {
            
        }
    }
    
    public int l(Vertice v0, Vertice v) {
        if (v0.equals(v))
            return 0;
        
        Iterator it = listaArestas.iterator();
        while(it.hasNext()) {
            Aresta a = (Aresta) it.next();
            if ((a.getInicio().equals(v0) && a.getFim().equals(v))
                    || (a.getInicio().equals(v) && a.getFim().equals(v0))){
                return a.getCusto();
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
}
