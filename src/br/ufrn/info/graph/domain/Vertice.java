/*
 * Sistema Integrado de Patrim�nio e Administra��o de Contratos
 * Superintend�ncia de Inform�tica - UFRN
 * 
 * Criado em 02/06/2005
 *
 */
package br.ufrn.info.graph.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.swt.graphics.Color;

import br.ufrn.info.graph.ui.ConstantesUI;

/**
 * Classe que representa um v�rtice de um Grafo.
 *  
 * @author David Ricardo do Vale Pereira
 *  
 */
public class Vertice implements Serializable {

    /** Identificador do v�rtice */
    private int id;
    
    /** Denomina��o do v�rtice */
    private String nome;
    
    /** Cor do v�rtice */
    private int corR;

    /** Cor do v�rtice */
    private int corG;

    /** Cor do v�rtice */
    private int corB;
    
    /** Posi��o horizontal do v�rtice na tela */
    private int x;
    
    /** Posi��o vertical do v�rtice na tela */
    private int y;
    
    /** Lista de v�rtices Adjacentes. Usado para a estrutura de adjac�ncias */
    private Vector adjacentes;
    
    private boolean visitado;
    
    public Vertice() {
        adjacentes = new Vector();
    }
    
    public Vertice(int x, int y) {
        this.x = x;
        this.y = y;
        adjacentes = new Vector();
    }
    
    public Vertice(int x, int y, Color cor) {
        this.x = x;
        this.y = y;
        this.corR = cor.getRed();
        this.corG = cor.getGreen();
        this.corB = cor.getBlue();
        adjacentes = new Vector();
    }
    
    public Vertice(Vertice v) {
        this.x = v.getX();
        this.y = v.getY();
        this.corR = v.getCorR();
        this.corG = v.getCorG();
        this.corB = v.getCorB();
        adjacentes = new Vector();
    }

    
    /**
     * Retorna o identificador do v�rtice.
     * @return Retorna id.
     */
    public int getId() {
        return id;
    }

    /**
     * Atribui um valor ao identificador do v�rtice.
     * @param id Valor a ser atribu�do.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retorna o nome do v�rtice.
     * @return Retorna nome.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Atribui um valor ao nome do v�rtice.
     * @param nome Valor a ser atribu�do.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /** 
     * Retorna a representa��o em String de um v�rtice 
     */
    public String toString(){
        return String.valueOf(id);
    }

    /** 
     * Compara dois v�rtices
     * @param other Objeto a ser comparado
     * @return <b>true</b> se os v�rtices forem iguais, <b>false</b> se forem diferentes.
     */
    public boolean equals(Object other) {
        if (other instanceof Vertice) {
            Vertice v = (Vertice) other;
//            if (getId() == v.getId())
//                return true;
            if ((this.x == v.getX()) && (this.y == v.getY()))
                return true;
        }
        return false;
    }
    
    public boolean isInside(int x, int y) {
        if ((x > (this.x - ConstantesUI.RAIO_VERTICE/2)) && (x < (this.x + ConstantesUI.RAIO_VERTICE/2)) 
                && (y > (this.y - ConstantesUI.RAIO_VERTICE/2)) && (y < (this.y + ConstantesUI.RAIO_VERTICE/2)))
                return true;
        return false;
    }
      
    /**
     * Retorna a lista de v�rtices adjacentes.
     * @return Retorna adjacentes.
     */
    public Vector getAdjacentes() {
        return adjacentes;
    }
    
    /**
     * Altera a lista de v�rtices adjacentes.
     * @param adjacentes Nova lista de v�rtices adjacentes.
     */
    public void setAdjacentes(Vector adjacentes) {
        this.adjacentes = adjacentes;
    }
    /**
     * Retorna a posi��o horizontal do v�rtice 
     * @return Retorna x.
     */
    public int getX() {
        return x;
    }
    /**
     * Atribui um valor a posi��o horizontal do v�rtice
     * @param x O valor a ser atribu�do.
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Retorna a posi��o vertical do v�rtice
     * @return Retorna y.
     */
    public int getY() {
        return y;
    }
    /**
     * Atribui um valor a posi��o vertical do v�rtice
     * @param y O valor a ser atribu�do.
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * @return Retorna visitado.
     */
    public boolean isVisitado() {
        return visitado;
    }
    /**
     * @param visitado O valor a ser atribuido a visitado.
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    /**
     * @return Retorna corB.
     */
    public int getCorB() {
        return corB;
    }
    /**
     * @param corB O valor a ser atribuido a corB.
     */
    public void setCorB(int corB) {
        this.corB = corB;
    }
    /**
     * @return Retorna corG.
     */
    public int getCorG() {
        return corG;
    }
    /**
     * @param corG O valor a ser atribuido a corG.
     */
    public void setCorG(int corG) {
        this.corG = corG;
    }
    /**
     * @return Retorna corR.
     */
    public int getCorR() {
        return corR;
    }
    /**
     * @param corR O valor a ser atribuido a corR.
     */
    public void setCorR(int corR) {
        this.corR = corR;
    }
    
    public void setCor(Color cor) {
        this.corR = cor.getRed();
        this.corG = cor.getGreen();
        this.corB = cor.getBlue();
    }
    
    public int getGrau(Collection listaArestas) {
        int grau = 0;
        Iterator it = listaArestas.iterator();
        while(it.hasNext()) {
            Aresta a = (Aresta) it.next();
            if (a.getInicio().equals(this) || a.getFim().equals(this))
                grau++;
        }
        return grau;
    }
    
    public boolean isAdjacente(Vertice v, Collection listaArestas) {
        Iterator it = listaArestas.iterator();
        while(it.hasNext()) {
            Aresta a = (Aresta) it.next();
            if ((a.getInicio().equals(this) && a.getFim().equals(v)) || (a.getInicio().equals(v) && a.getFim().equals(this))) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isAdjacenteCor(Color c, Collection listaArestas) {
        Iterator it = listaArestas.iterator();
        while(it.hasNext()) {
            Aresta a = (Aresta) it.next();
            if (a.getInicio().equals(this)) {
                if (a.getFim().getCorB() == c.getBlue() && a.getFim().getCorG() == c.getGreen() && a.getFim().getCorR() == c.getRed())
                    return true;
            }
            if (a.getFim().equals(this)) {
                if (a.getInicio().getCorB() == c.getBlue() && a.getInicio().getCorG() == c.getGreen() && a.getInicio().getCorR() == c.getRed())
                    return true;
            }
        }
        
        return false;
    }
}