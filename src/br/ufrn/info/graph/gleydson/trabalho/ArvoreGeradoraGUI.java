package br.ufrn.info.graph.gleydson.trabalho;

/*
 * ArvoreGeradoraGUI.java
 *
 * Created on 11 de Dezembro de 2002, 20:48
 */

/**
 *
 * @author  gleydson
 */

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class ArvoreGeradoraGUI extends javax.swing.JFrame {
    
    private int algoritmo;  // 0 - PRIM
                            // 1 - Kruskal
                            // 2 - Boruska
    
    private AreaDesenho areaDesenho;
    private static ArvoreGeradoraGUI instance;
    
    /** Creates new form ArvoreGeradoraGUI */
    public ArvoreGeradoraGUI() {
        initComponents();
        areaDesenho = new AreaDesenho( this );
        getContentPane().add( areaDesenho, java.awt.BorderLayout.CENTER);
        setSize(600,400);
        proxPasso.setVisible(false);
        continuar.setVisible(false);
        instance = this;
    }
        
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        menu = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnuModificarAresta = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        cmbCriarNo = new javax.swing.JToggleButton();
        cmbCriarAresta = new javax.swing.JButton();
        cmbAGM = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        boruvka = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        proxPasso = new javax.swing.JButton();
        continuar = new javax.swing.JButton();

        jMenuItem3.setText("Criar Aresta");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });

        menu.add(jMenuItem3);
        mnuModificarAresta.setText("Modificar Aresta");
        menu.add(mnuModificarAresta);
        menu.add(jSeparator2);
        jMenuItem4.setText("Prim");
        menu.add(jMenuItem4);
        jMenuItem5.setText("Kruskal");
        menu.add(jMenuItem5);
        jMenuItem6.setText("Boruska");
        menu.add(jMenuItem6);
        menu.add(jSeparator1);
        jMenuItem1.setText("Gravar Esquema ...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });

        menu.add(jMenuItem1);
        jMenuItem2.setText("Carregar Esquema ...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });

        menu.add(jMenuItem2);
        menu.add(jSeparator3);
        jMenuItem7.setText("Limpar tudo");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });

        menu.add(jMenuItem7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u00c1rvore Geradora M\u00ednima");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 3));

        cmbCriarNo.setFont(new java.awt.Font("Verdana", 2, 12));
        cmbCriarNo.setText("Criar N\u00f3");
        cmbCriarNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCriarNoActionPerformed(evt);
            }
        });

        jPanel1.add(cmbCriarNo);

        cmbCriarAresta.setFont(new java.awt.Font("Verdana", 2, 12));
        cmbCriarAresta.setText("Criar Aresta");
        cmbCriarAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCriarArestaActionPerformed(evt);
            }
        });

        jPanel1.add(cmbCriarAresta);

        cmbAGM.setFont(new java.awt.Font("Verdana", 2, 12));
        cmbAGM.setText("PRIM");
        cmbAGM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAGMActionPerformed(evt);
            }
        });

        jPanel1.add(cmbAGM);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Verdana", 2, 12));
        jButton1.setText("Kruskal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.add(jButton1);

        boruvka.setFont(new java.awt.Font("Verdana", 2, 12));
        boruvka.setText("Boruvka");
        boruvka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boruvkaActionPerformed(evt);
            }
        });

        jPanel1.add(boruvka);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBorder(new javax.swing.border.EtchedBorder());
        jPanel3.setLayout(new java.awt.GridLayout(1, 3));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 10));
        jLabel1.setText("Gleydson Lima / Peterson Melo");
        jPanel3.add(jLabel1);

        proxPasso.setFont(new java.awt.Font("Dialog", 0, 10));
        proxPasso.setText("Prox. Passo >>");
        proxPasso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proxPassoActionPerformed(evt);
            }
        });

        jPanel3.add(proxPasso);

        continuar.setFont(new java.awt.Font("Dialog", 0, 10));
        continuar.setText("Continuar >>>");
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });

        jPanel3.add(continuar);

        jPanel2.add(jPanel3);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    private void boruvkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boruvkaActionPerformed
        // Add your handling code here:
        
        algoritmo = AGM.BORUVKA;
        AGMBoruska.encontrarAGM( areaDesenho.getGraphManager(), areaDesenho);
        continuar.setVisible(true);
        proxPasso.setVisible(true);
        
    }//GEN-LAST:event_boruvkaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Add your handling code here:
        algoritmo = AGM.KRUSKAL;
        AGMKruskal.encontrarAGM( areaDesenho.getGraphManager(), areaDesenho);
        continuar.setVisible(true);
        proxPasso.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        // Add your handling code here:
        
        switch ( algoritmo ) {
            case AGM.PRIM :
                AGMPrim.continuar();
                AGMPrim.proxPasso();
                break;
            case AGM.KRUSKAL:
                AGMKruskal.continuar();
                AGMKruskal.proxPasso();
                break;
            case AGM.BORUVKA:
                AGMBoruska.continuar();
                AGMBoruska.proxPasso();
                break;
        }

        continuar.setVisible(false);
        proxPasso.setVisible(false);
    }//GEN-LAST:event_continuarActionPerformed

    private void proxPassoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proxPassoActionPerformed
        // Add your handling code here:
        switch ( algoritmo ) {
            case AGM.PRIM :
                AGMPrim.proxPasso();
                break;
            case AGM.KRUSKAL:
                AGMKruskal.proxPasso();
                break;
            case AGM.BORUVKA:
                AGMBoruska.proxPasso();
                break;
        }
    }//GEN-LAST:event_proxPassoActionPerformed

    private void cmbAGMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAGMActionPerformed
        // Add your handling code here:
        algoritmo = AGM.PRIM;
        AGMPrim.encontarAGM( areaDesenho.getGraphManager(), areaDesenho );
        proxPasso.setVisible(true);
        continuar.setVisible(true);
    }//GEN-LAST:event_cmbAGMActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // Add your handling code here:
        areaDesenho.limpar();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // Add your handling code here:
        areaDesenho.carregarEsquema();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Add your handling code here:
        areaDesenho.gravarEsquema();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // Add your handling code here:
        cmbCriarArestaActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // Add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    private void cmbCriarArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCriarArestaActionPerformed
        // Add your handling code here:
        
        areaDesenho.criarAresta( );
        
    }//GEN-LAST:event_cmbCriarArestaActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // Add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // Add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged
    
    private void areaDesenhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areaDesenhoMouseClicked
        // Add your handling code here:
        
    }//GEN-LAST:event_areaDesenhoMouseClicked

    private void cmbCriarNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCriarNoActionPerformed
        // Add your handling code here:
        
    }//GEN-LAST:event_cmbCriarNoActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new ArvoreGeradoraGUI().show();
    }
    
    /** Getter for property cmbCriarNo.
     * @return Value of property cmbCriarNo.
     */
    public javax.swing.JToggleButton getCmbCriarNo() {
        return cmbCriarNo;
    }    
    
    /** Setter for property cmbCriarNo.
     * @param cmbCriarNo New value of property cmbCriarNo.
     */
    public void setCmbCriarNo(javax.swing.JToggleButton cmbCriarNo) {
        this.cmbCriarNo = cmbCriarNo;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boruvka;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton continuar;
    private javax.swing.JButton cmbAGM;
    private javax.swing.JButton cmbCriarAresta;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JToggleButton cmbCriarNo;
    private javax.swing.JButton proxPasso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem mnuModificarAresta;
    // End of variables declaration//GEN-END:variables
    
    public static ArvoreGeradoraGUI getInstance() {
        return instance;
    }
    
    public JPopupMenu getMenu() {
        return menu;
    }
    public JMenuItem getMenuModificarAresta () {
        return mnuModificarAresta;
    }
}


    
class AreaDesenho extends JPanel { 
    
    private ArvoreGeradoraGUI gui;
    private GraphManager nodeManager;
    private int selecionados; // numero de n�s selecionados, para so aceitar 2
    private Node nodeToMove;
    private Color backColor;
    
    public AreaDesenho( ArvoreGeradoraGUI gui ) {
        super();
        
        nodeManager = new GraphManager();
        this.gui = gui;
        
        float[] cores = Color.RGBtoHSB( 255, 254, 240, null );
        backColor = Color.getHSBColor( cores[0], cores[1], cores[2] );
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelMouseReleased(evt);
            }

        });
        
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelMouseDragged(evt);
            }
        });


    
    }
    
    public void paintComponent( java.awt.Graphics g ) {

         super.paintComponent(g);
        
         g.setColor ( backColor );
         g.fillRect(0,0, getWidth(),  getHeight() );
         
         Object[] arestas = nodeManager.getArestas();
         
         for ( int a = 0; a < arestas.length; a++ ) {
             
             Aresta aresta = (Aresta) arestas[a];
             Node origem = aresta.getOrigem();
             Node destino = aresta.getDestino();
             
             g.setColor ( aresta.getCor() );
             g.drawLine( origem.getX(), origem.getY(), destino.getX(), destino.getY() );
             g.drawLine( origem.getX() + 1 , origem.getY() + 1, destino.getX() + 1, destino.getY() + 1);
                       
             g.setFont ( new Font ( "Arial", Font.BOLD, 12 ) );
             g.drawString ( String.valueOf ( aresta.getValor() ),  origem.getX() + ( destino.getX() - origem.getX() ) / 2 - 15 , origem.getY() + ( destino.getY() - origem.getY() ) / 2 - 15 );
             
             aresta.setX(  origem.getX() + ( destino.getX() - origem.getX() ) / 2 - 15  );
             aresta.setY(  origem.getY() + ( destino.getY() - origem.getY() ) / 2 - 15  );
             
         }
         
         
         Object[] nodes = nodeManager.getNodes();
         
         for ( int a = 0; a < nodes.length; a ++ ) {
             
            Node node = (Node) nodes[a];
            g.setColor( node.getCor() );
            g.fillOval( node.getX() - nodeManager.TAMANHO/2, node.getY()-  nodeManager.TAMANHO/2, nodeManager.TAMANHO, nodeManager.TAMANHO );    
            if ( node.isSelected() ) {
                g.setColor ( java.awt.Color.red );
                g.drawOval( node.getX() - nodeManager.TAMANHO/2, node.getY()-  nodeManager.TAMANHO/2, nodeManager.TAMANHO, nodeManager.TAMANHO );    
                g.drawOval( node.getX() - nodeManager.TAMANHO/2, node.getY()-  nodeManager.TAMANHO/2, nodeManager.TAMANHO, nodeManager.TAMANHO + 1 );    
                // g.drawRect( node.getX() - nodeManager.TAMANHO/2 - 2 , node.getY() - nodeManager.TAMANHO/2 - 2, nodeManager.TAMANHO + 4 , nodeManager.TAMANHO  + 4 );
            }
            g.setColor( java.awt.Color.white );
            g.setFont ( new java.awt.Font( "Arial", Font.BOLD, 18 ) );
            if ( a < 9 ) 
                g.drawString( String.valueOf ( a + 1 ), node.getX() - 5, node.getY() +  7 );
            else
                g.drawString( String.valueOf ( a + 1 ), node.getX() - 10, node.getY() +  7 );
            
          
         }
         
    }
   
      private void panelMouseClicked(java.awt.event.MouseEvent evt) {
 
         if ( evt.getModifiers() == 4 ) {
             if ( nodeManager.checkTwoNodesSelected() ) 
                 ArvoreGeradoraGUI.getInstance().getMenuModificarAresta().setEnabled(true);
             else
                 ArvoreGeradoraGUI.getInstance().getMenuModificarAresta().setEnabled(false);
             
             ArvoreGeradoraGUI.getInstance().getMenu().show( ArvoreGeradoraGUI.getInstance(), evt.getX(), evt.getY() + 50 );
             return;
         }
         
         if ( gui.getCmbCriarNo().isSelected() ) { 
           
            if ( nodeManager.isFreeToDraw( evt.getX(), evt.getY() ) ) { 
                nodeManager.addNode( evt.getX(), evt.getY() );
                // gui.getCmbCriarNo().setSelected(false);
            } else
                JOptionPane.showMessageDialog(this, "Regi�o j� ocupada por outro n�", "N�o foi poss�vel criar n�", JOptionPane.ERROR_MESSAGE );
        }    
         else {
          
             Node node = nodeManager.getNodeToDraw( evt.getX(), evt.getY() );
             if (  node != null ) {
                 if ( selecionados <= 2 ) {
                    
                    if ( node.isSelected() ) {
                        selecionados--;
                        node.setSelected( false );
                    }
                    else {
                        if ( ! ( selecionados == 2 ) ) {
                            selecionados++;
                            node.setSelected( true );
                        }
                    }
                }
             } else {
                 selecionados = 0;
                 nodeManager.disSelectedAll();
                 repaint();
             }
                 
         }
          
          this.repaint();
    }
      
      
      private void panelMouseDragged(java.awt.event.MouseEvent evt) {
          
          if ( nodeToMove == null ) {
            nodeToMove = nodeManager.getNodeToDraw( evt.getX(), evt.getY() );
          } else {
            if ( nodeToMove.isSelected() ) {
                  nodeToMove.setX( evt.getX() );
                  nodeToMove.setY( evt.getY() );
            }
            repaint();
          }
      
      }

      private void panelMouseReleased(java.awt.event.MouseEvent evt) {
            nodeToMove = null;
      }
      
      
    public void criarAresta( ) {
        if ( nodeManager.addAresta( ) ) {
            selecionados = 0;
            repaint();
        }
            
    }
    
    public void gravarEsquema ( ) {
        
        nodeManager.gravarEsquema();
        
    }
    
    public void carregarEsquema() {
        
        nodeManager.carregarEsquema();
        repaint();
    }
    
    public void limpar() {
        
        nodeManager.limpar();
        Node.clearSequence();
        repaint();
        
    }
 
    public GraphManager getGraphManager() {
        return nodeManager;
    }
}
    


      