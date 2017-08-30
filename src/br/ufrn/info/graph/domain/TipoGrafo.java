/*
 * Sistema Integrado de Patrim�nio e Administra��o de Contratos
 * Superintend�ncia de Inform�tica - UFRN
 * 
 * Criado em 02/06/2005
 *
 */
package br.ufrn.info.graph.domain;

/**
 * Classe contendo as constantes que identificam as diferentes
 * representa��es para um grafo.
 *  
 * @author David Ricardo do Vale Pereira
 *  
 */
public class TipoGrafo {

    /** Representa��o por Matriz de Adjac�ncias */
    public static final int MATRIZ_ADJACENCIAS = 1;

    /** Representa��o por Matriz de Incid�ncia */
    public static final int MATRIZ_INCIDENCIA = 2;
    
    /** Representa��o por Lista de Arestas */
    public static final int LISTA_ARESTAS = 3;
    
    /** Representa��o por Estrutura de Adjac�ncias */
    public static final int ESTRUTURA_ADJACENCIAS = 4;
    
}
