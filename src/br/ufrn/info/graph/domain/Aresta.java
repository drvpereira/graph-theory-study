/*
 * Sistema Integrado de Patrimônio e Administração de Contratos
 * Superintendência de Informática - UFRN
 * 
 * Criado em 02/06/2005
 *
 */
package br.ufrn.info.graph.domain;

import java.io.Serializable;

/**
 * Classe que representa uma aresta de um Grafo.
 *  
 * @author David Ricardo do Vale Pereira
 *  
 */
public class Aresta implements Serializable {
    
    /** Identificador da aresta */
    private int id;

    /** Denominação da aresta */
    private String nome;
    
    /** Vértice do qual a aresta sai */
    private Vertice inicio;
    
    /** Vértice em que a aresta chega */
    private Vertice fim;
    
    /** Custo da aresta */
    private int custo;
    
    /** Informa quando a aresta deve ser orientada */
    private boolean orientada;
    
    /** Indica se a aresta está selecionada ou não */
    private boolean selected;
    
    /**
     * Construtor da Classe
     */
    public Aresta() {
        
    }
    
    /**
     * Retorna o custo da aresta.
     * @return Retorna custo.
     */
    public int getCusto() {
        return custo;
    }
    
    /**
     * Atribui um valor ao custo da aresta.
     * @param custo Valor a ser atribuído.
     */
    public void setCusto(int custo) {
        this.custo = custo;
    }
    
    /**
     * Retorna o identificador da aresta.
     * @return Retorna id.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Atribui um valor ao identificador da aresta. 
     * @param id Valor a ser atribuído.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retorna o nome da aresta.
     * @return Retorna nome.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Atribui um nome a aresta.
     * @param nome Nome a ser atribuído.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
  
    /**
     * Retorna o vértice em que a aresta chega.
     * @return Retorna fim.
     */
    public Vertice getFim() {
        return fim;
    }
    /**
     * Atribui um vértice ao fim da aresta.
     * @param fim O vértice a ser atribuído.
     */
    public void setFim(Vertice fim) {
        this.fim = fim;
    }
    
    /**
     * Retorna o vértice do qual a aresta sai. 
     * @return Retorna inicio.
     */
    public Vertice getInicio() {
        return inicio;
    }
    
    /**
     * Atribui um vértice ao início da aresta.
     * @param inicio O vértice a ser atribuído.
     */
    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    /**
     * Retorna <b>true</b> se a aresta for orientada, <b>false</b> caso contrário.
     * @return Retorna orientada.
     */
    public boolean isOrientada() {
        return orientada;
    }
    
    /**
     * Atribui um valor a orientada.
     * @param orientada Valor a ser atribuído.
     */
    public void setOrientada(boolean orientada) {
        this.orientada = orientada;
    }

    
    /** 
     * Compara duas arestas
     * @param other Objeto a ser comparado
     * @return <b>true</b> se as arestas forem iguais, <b>false</b> se forem diferentes.
     */
    public boolean equals(Object other) {
        Aresta aresta = (Aresta) other;
        
        if (isOrientada()) {
            if (getInicio().equals(aresta.getInicio()) && getFim().equals(aresta.getFim())) {
                return true;
            }
        } else {
            if ((getInicio().equals(aresta.getInicio()) && getFim().equals(aresta.getFim())) ||
                    (getInicio().equals(aresta.getFim()) && getFim().equals(aresta.getInicio())))
                return true;
        }
        return false;
    }
    
    /** 
     * Retorna a representação em String da aresta
     */
    public String toString(){   
        return inicio + " - " + fim + " (" + custo + ")";
    }

    /**
     * @return Retorna selected.
     */
    public boolean isSelected() {
        return selected;
    }
    /**
     * @param selected The selected to set.
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
