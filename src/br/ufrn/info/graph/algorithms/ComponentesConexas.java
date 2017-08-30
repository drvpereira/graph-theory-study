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

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import br.ufrn.info.graph.domain.AbstractGrafo;
import br.ufrn.info.graph.domain.Aresta;
import br.ufrn.info.graph.domain.Vertice;

/**
 * Calcula as componentes fortemente conexas de um grafo
 *
 * @author David Ricardo
 *
 */
public class ComponentesConexas {

    AbstractGrafo grafo;
    
    Vector listaVertices;
    
    Vector listaArestas;

    int mtRep[][];
    
    int r[][], q[][];
    int rq[][];
    
    Color cores[];
    
    public ComponentesConexas(AbstractGrafo grafo, Display display) {
        this.grafo = grafo;
        listaVertices = grafo.getListaVertices();
        listaArestas = grafo.getListaArestas();
        
        r = new int[listaVertices.size()][listaVertices.size()];
        q = new int[listaVertices.size()][listaVertices.size()];
        rq =  new int[listaVertices.size()][listaVertices.size()];
        mtRep = new int[listaVertices.size()][listaVertices.size()];
        cores = new Color[listaVertices.size()];
        
        for (int i = 0; i < cores.length; i++)
            cores[i] = new Color(display, (int) (255*Math.random()), (int) (255*Math.random()), (int) (255*Math.random()));
    }
    
    public void solve() {
        setRepMatriz();
        
        for (int i = 0; i < listaVertices.size(); i++) {
            buildMatrizQ(i, i);
        }
        buildMatrizR();
        buildRQ();

        printMatriz(r);
        
        for (int i = 0; i < listaVertices.size(); i++) {
            for (int j = 0; j < listaVertices.size(); j++) {
                if (rq[i][j] == 1) {
                    Iterator it = listaVertices.iterator();
                    while(it.hasNext()) {
                        Vertice v = (Vertice) it.next();
                        if (v.getId() == j)
                            v.setCor(cores[i]);
                    }
                }
            }
        }
        
    }
    
    private void setRepMatriz() {
        Iterator it;
        int i = 0;
        
        it = listaVertices.iterator();
        while(it.hasNext()) {
            Vertice v = (Vertice) it.next();
            v.setId(i++);
        }
        
        it = listaArestas.iterator();
        while(it.hasNext()) {
            Aresta a = (Aresta) it.next();
            int inicio = a.getInicio().getId();
            int fim = a.getFim().getId();
            
            if (mtRep[inicio][fim] != 0) {
                mtRep[inicio][fim] = 2;
                mtRep[fim][inicio] = 2;
            } else {
                mtRep[inicio][fim] = 1;
                if (grafo.isOrientado())
                    mtRep[fim][inicio] = -1;
                else
                    mtRep[fim][inicio] = 1;
            }
        }
        
    }
    
    private void printMatriz(int matriz[][]) {
        for (int i = 0; i < listaVertices.size(); i++) {
            for (int j = 0; j < listaVertices.size(); j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void buildMatrizQ(int i, int j) {
        for (int k = 0; k < listaVertices.size(); k++) {
            if ((mtRep[j][k] == -1 || mtRep[j][k] == 2) && q[i][k] == 0) {
                q[i][k] = 1;
                buildMatrizQ(i, k);
            }
            
        }
    }

    private void buildMatrizR() {
        for (int i = 0; i < listaVertices.size(); i++)
            q[i][i] = 1;
        for (int i = 0; i < listaVertices.size(); i++)
            for (int j = 0; j < listaVertices.size(); j++)
                r[i][j] = q[j][i];
    }
    
    private void buildRQ() {
        for (int i = 0; i < listaVertices.size(); i++) {
            for (int j = 0; j < listaVertices.size(); j++) {
                rq[i][j] = r[i][j]*q[i][j];
            }
        }
    }
}
