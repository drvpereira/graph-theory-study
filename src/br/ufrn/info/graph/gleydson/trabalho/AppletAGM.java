package br.ufrn.info.graph.gleydson.trabalho;

/*
 * AppletAGM.java
 *
 * Created on 3 de Janeiro de 2003, 10:33
 */

/**
 *
 * @author  gleydson
 */
public class AppletAGM extends javax.swing.JApplet {
    
    /** Creates new form AppletAGM */
    public AppletAGM() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridLayout(4, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("\u00c1rvore Geradora M\u00ednima");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Algoritmos e Estruturas de Dados II -  Prof. Elizabeth Golveia");
        getContentPane().add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 18));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Gleydson Lima / Peterson Melo");
        getContentPane().add(jLabel3);

        jButton1.setText("Clique Aqui para Abrir ...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton1);

    }//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Add your handling code here:
        ArvoreGeradoraGUI.main( null );
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
}
