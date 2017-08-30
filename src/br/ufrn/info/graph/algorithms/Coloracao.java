/*
 * Sistema Integrado de Patrimônio e Administração de Contratos
 * Superintendência de Informática - UFRN
 * 
 * Criado em 09/07/2005
 *
 */
package br.ufrn.info.graph.algorithms;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import br.ufrn.info.graph.domain.AbstractGrafo;
import br.ufrn.info.graph.domain.Vertice;

/**
 * Descrição da Classe
 *  
 * @author David
 *  
 */
public class Coloracao {

    AbstractGrafo grafo;
    
    Vector listaVertices;
    
    Vector listaArestas;

    Color cores[];
    
    TreeSet fila;
    
    
    public Coloracao(AbstractGrafo grafo, Display display) {
        this.grafo = grafo;
        listaVertices = grafo.getListaVertices();
        listaArestas = grafo.getListaArestas();
        
        cores = new Color[listaVertices.size()];
        
        for (int i = 0; i < cores.length; i++)
            cores[i] = new Color(display, (int) (255*Math.random()), (int) (255*Math.random()), (int) (255*Math.random()));
    }
    
    public void solve() {      
        fila = new TreeSet(new Comparator() {
            public int compare(Object o1, Object o2) {
                Vertice v1 = (Vertice) o1;
                Vertice v2 = (Vertice) o2;
                
                if (v1.getGrau(listaArestas) >= v2.getGrau(listaArestas))
                    return -1;

                return 1;                
            }
        });
        
        Iterator it = listaVertices.iterator();
        int i = 0;
        while(it.hasNext()) {
            Vertice v = (Vertice) it.next();
            v.setCorB(0);
            v.setCorR(0);
            v.setCorG(0);
            v.setId(i++);
            fila.add(v);
        }
        
        it = fila.iterator();
        i = 0;
        while(it.hasNext()) {
            Vertice v = (Vertice) it.next();
            
            if (v.getCorB() == 0 && v.getCorG() == 0 && v.getCorR() == 0) {
                v.setCor(cores[i]);
                
                Iterator it2 = fila.iterator();
                while(it2.hasNext()) {
                    Vertice v2 = (Vertice) it2.next();
                    if (v2.getCorB() == 0 && v2.getCorG() == 0 && v2.getCorR() == 0) {
                        if (!v2.isAdjacenteCor(cores[i],listaArestas)) {
                            v2.setCor(cores[i]);
                        }
                    }
                }
                
            }
            i++;
        }
        
    }

}
