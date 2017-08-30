/*
 * Sistema Integrado de Patrimônio e Administração de Contratos
 * Superintendência de Informática - UFRN
 * 
 * Criado em 02/06/2005
 *
 */
package br.ufrn.info.graph.domain;

/**
 * Fábrica de Grafos. Retorna uma instância de um grafo
 * cuja representação dependerá do argumento do método
 * <b>getGrafo()</b>. 
 *  
 * @author David Ricardo do Vale Pereira
 *  
 */
public class GrafoFactory {

    /** Singleton para garantir que só existirá uma instância desta classe na memória. */
    private static GrafoFactory singleton = new GrafoFactory();
    
    /** Construtor privado para implementação do pattern singleton. */
    private GrafoFactory() {

    }

    /** Retorna a instância da classe */
    public static GrafoFactory getInstance() {
        return singleton;
    }
    
    /** 
     * Retorna uma instância do grafo. A forma de implementação dependerá to
     * valor informado no argumento. 
     * @param tipoGrafo Constante que indica o tipo de grafo a ser fabricado.
     * @return Instância de um Grafo 
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
