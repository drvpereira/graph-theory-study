/*
 * Sistema Integrado de Patrimônio e Administração de Contratos
 * Superintendência de Informática - UFRN
 * 
 * Criado em 02/06/2005
 *
 */
package br.ufrn.info.graph.domain;

/**
 * Classe contendo as constantes que identificam as diferentes
 * representações para um grafo.
 *  
 * @author David Ricardo do Vale Pereira
 *  
 */
public class TipoGrafo {

    /** Representação por Matriz de Adjacências */
    public static final int MATRIZ_ADJACENCIAS = 1;

    /** Representação por Matriz de Incidência */
    public static final int MATRIZ_INCIDENCIA = 2;
    
    /** Representação por Lista de Arestas */
    public static final int LISTA_ARESTAS = 3;
    
    /** Representação por Estrutura de Adjacências */
    public static final int ESTRUTURA_ADJACENCIAS = 4;
    
}
