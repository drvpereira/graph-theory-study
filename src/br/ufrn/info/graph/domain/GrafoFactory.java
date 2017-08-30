/*
 * Sistema Integrado de Patrim�nio e Administra��o de Contratos
 * Superintend�ncia de Inform�tica - UFRN
 * 
 * Criado em 02/06/2005
 *
 */
package br.ufrn.info.graph.domain;

/**
 * F�brica de Grafos. Retorna uma inst�ncia de um grafo
 * cuja representa��o depender� do argumento do m�todo
 * <b>getGrafo()</b>. 
 *  
 * @author David Ricardo do Vale Pereira
 *  
 */
public class GrafoFactory {

    /** Singleton para garantir que s� existir� uma inst�ncia desta classe na mem�ria. */
    private static GrafoFactory singleton = new GrafoFactory();
    
    /** Construtor privado para implementa��o do pattern singleton. */
    private GrafoFactory() {

    }

    /** Retorna a inst�ncia da classe */
    public static GrafoFactory getInstance() {
        return singleton;
    }
    
    /** 
     * Retorna uma inst�ncia do grafo. A forma de implementa��o depender� to
     * valor informado no argumento. 
     * @param tipoGrafo Constante que indica o tipo de grafo a ser fabricado.
     * @return Inst�ncia de um Grafo 
     */
    public AbstractGrafo getGrafo(int tipoGrafo) {
        switch(tipoGrafo) {
        case TipoGrafo.MATRIZ_ADJACENCIAS:
            return new GrafoMatrizAdjacenciasImpl();
        case TipoGrafo.ESTRUTURA_ADJACENCIAS:
            return new GrafoEstruturaAdjacenciaImpl();
        case TipoGrafo.LISTA_ARESTAS:
            return new GrafoListaArestasImpl();
        case TipoGrafo.MATRIZ_INCIDENCIA:
            return new GrafoMatrizIncidenciaImpl();
        }
        return null;
    }
    
}
