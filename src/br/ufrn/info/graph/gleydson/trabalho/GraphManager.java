package br.ufrn.info.graph.gleydson.trabalho;

/*
 * GraphManager.java
 *
 * Created on 12 de Dezembro de 2002, 23:51
 */

/**
 *
 * @author  gleydson
 */

import java.util.*;
import javax.swing.*;
import java.io.*;

class GraphManager {
    
    private Vector nodeSet;
    private Vector arestaSet;
        
    public static final int TAMANHO = 30;
    
    public GraphManager() {
        nodeSet = new Vector();
        arestaSet = new Vector();
    }

    public void addNode ( int x, int y ) {
        nodeSet.add ( new Node( x , y , false ) );
    }
    
    public boolean addAresta ( ) {
        
        Node buf[] = new Node[2];
        
        Enumeration enum = nodeSet.elements();
        int count = 0;
        while ( enum.hasMoreElements() ) {
            
            Node node = (Node) enum.nextElement();
            if ( node.isSelected() )
                buf[count++] = node;
            
        }
         
        if ( buf[0] == null || buf[1] == null ) {
            JOptionPane.showMessageDialog( ArvoreGeradoraGUI.getInstance(), "Selecione dois nós para criar uma aresta", "Criar Aresta", JOptionPane.ERROR_MESSAGE );
            return false;
        }
        
        
        // Requisita valor da aresta
        int valor = 0;
        try {
            
            String strValor = JOptionPane.showInputDialog("Valor da Aresta");
            if ( strValor != null ) {
                valor = Integer.parseInt( strValor );
            }
        }
        catch ( NumberFormatException e ) { 
            JOptionPane.showMessageDialog( ArvoreGeradoraGUI.getInstance(), "Valor inválido", "Aresta", JOptionPane.ERROR_MESSAGE );
            return false;
        }
        
        Aresta aresta = new Aresta( buf[0], buf[1], valor );
        if ( arestaSet.contains( aresta ) ) {
            JOptionPane.showMessageDialog( ArvoreGeradoraGUI.getInstance(), "Aresta já existente", "Aresta", JOptionPane.ERROR_MESSAGE );
            return false;
        }
        
        buf[0].setSelected(false);
        buf[1].setSelected(false);
                
        arestaSet.add(  aresta );
        buf[0].addVizinho ( buf[1] );
        buf[1].addVizinho ( buf[0] );
        
        return true;
        
        
    }

    public boolean isFreeToDraw ( int x, int y ) {
     
        Enumeration enum = nodeSet.elements();
        while ( enum.hasMoreElements() ) {
            
            Node node = (Node) enum.nextElement();
            if ( x > ( node.getX() - TAMANHO/2 ) && x < ( node.getX() + TAMANHO/2 ) )
                if ( y > ( node.getY() - TAMANHO/2 ) && y < ( node.getY() + TAMANHO/2 ) )
                    return false;
            
        }
        
        return true;
        
    }
    
    public void disSelectedAll (  ) {
     
        Enumeration enum = nodeSet.elements();
        while ( enum.hasMoreElements() ) {
            
            Node node = (Node) enum.nextElement();
            node.setSelected(false);
        }
        
    }
    
    
    public Node getNodeToDraw ( int x, int y ) {
     
        Enumeration enum = nodeSet.elements();
        while ( enum.hasMoreElements() ) {
            
            Node node = (Node) enum.nextElement();
            if ( x > ( node.getX() - TAMANHO/2 ) && x < ( node.getX() + TAMANHO/2 ) )
                if ( y > ( node.getY() - TAMANHO/2 ) && y < ( node.getY() + TAMANHO/2 ) )
                    return node;
            
        }
        
        return null;
    }

    public Object[] getNodes() { 
        return nodeSet.toArray();
    }
    
    public Vector getNodesVector() {
        return nodeSet;
    }
    
    public Object[] getArestas() {
        return arestaSet.toArray();
    }

    
    public void gravarEsquema()  {
     
        JFileChooser file = new JFileChooser();
        file.showSaveDialog( ArvoreGeradoraGUI.getInstance() ); 
        File arquivo = file.getSelectedFile();
        if ( arquivo == null )
            return;
        
        try {
            ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream ( arquivo ) );
            out.writeObject( nodeSet );
            out.writeObject( arestaSet );
        
            out.flush();
            out.close();
        }
        catch ( IOException e ) {
            JOptionPane.showMessageDialog( ArvoreGeradoraGUI.getInstance(), e );
        }
        
    }
    
    public void carregarEsquema ( ) {
        
        JFileChooser file = new JFileChooser();
        file.showOpenDialog( ArvoreGeradoraGUI.getInstance() ); 
        File arquivo = file.getSelectedFile();
        
        if ( arquivo == null ) 
            return;
        
        try {
            ObjectInputStream in = new ObjectInputStream( new FileInputStream ( arquivo ) );
            nodeSet = (Vector) in.readObject();
            arestaSet = (Vector) in.readObject( );
            in.close();
        }
        catch ( Exception e ) {
            JOptionPane.showMessageDialog( ArvoreGeradoraGUI.getInstance(), e );
        }
        
    }
    
    
    public void limpar() {
        nodeSet.clear();
        arestaSet.clear();
        
    }
    
    public boolean checkTwoNodesSelected() {
    
        Node buf[] = new Node[2];
        
        Enumeration enum = nodeSet.elements();
        int count = 0;
        while ( enum.hasMoreElements() ) {
            
            Node node = (Node) enum.nextElement();
            if ( node.isSelected() )
                buf[count++] = node;
            
        }
         
        if ( buf[0] == null || buf[1] == null )
            return false;
        else
            return true;
        
    }
    
    public void desvisiteTodos() {
     
        for ( int a = 0; a < nodeSet.size(); a++ ) {
            ((Node) nodeSet.get(a)).setVisitado(false);
            ((Node) nodeSet.get(a)).setAGM(false);
        }
            
    }
    
}
