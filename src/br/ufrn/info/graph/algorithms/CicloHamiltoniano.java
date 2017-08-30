/*
 * Sistema Integrado de Patrimônio e Administração de Contratos
 * Superintendência de Informática - UFRN
 * 
 * Criado em 19/06/2005
 *
 */
package br.ufrn.info.graph.algorithms;

import java.util.Iterator;
import java.util.Vector;

import br.ufrn.info.graph.domain.AbstractGrafo;
import br.ufrn.info.graph.domain.Aresta;
import br.ufrn.info.graph.domain.Vertice;

/**
 * Calcula o ciclo hamiltoniano mínimo para um grafo
 *  
 * @author David
 *  
 */
public class CicloHamiltoniano {

    //private AbstractGrafo grafo;
    
    private Vector listaVertices;
    
    private Vector listaArestas;
    
    private Vector tour;
    
    private int custo;
    
    //private Vertice v;

    int mtRep[][], q[][];
    
    /**
     * Inicializa variáveis necessárias a resolução do problema
     * @param grafo
     */
    public CicloHamiltoniano(AbstractGrafo grafo) {
        //this.grafo = grafo;
        this.listaArestas = grafo.getListaArestas();
        this.listaVertices = grafo.getListaVertices();
        q =  new int[listaVertices.size()][listaVertices.size()];
        mtRep = new int[listaVertices.size()][listaVertices.size()];

        tour = new Vector();
        //custo = 0;
    }
    
    public void solve() {
        Iterator it = listaVertices.iterator();
        
        while(it.hasNext()) {
            Vertice v = (Vertice) it.next();
            System.out.println(v);
            Iterator itAr = listaArestas.iterator();
            Aresta menorAresta = new Aresta();
            menorAresta.setCusto(Integer.MAX_VALUE);
            v.setVisitado(true);
            
            while(itAr.hasNext()) {
                Aresta a = (Aresta) itAr.next();
                if (a.getInicio().equals(v)) {
                    if ((a.getCusto() < menorAresta.getCusto()) && !a.getFim().isVisitado()) {
                        menorAresta = a;
                    }
                }
            }
            if (menorAresta.getFim() != null)
                menorAresta.getFim().setVisitado(true);
            menorAresta.setSelected(true);
            tour.add(menorAresta);
            custo += menorAresta.getCusto();
        }
       
        printSol();
    }
    
    private void printSol() {
        Iterator it = tour.iterator();
        while(it.hasNext()) {
            Aresta a = (Aresta) it.next();
            System.out.println(a);
        }
    }
    
}
