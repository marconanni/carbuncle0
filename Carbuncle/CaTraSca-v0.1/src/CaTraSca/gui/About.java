/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * About.java
 *
 * Created on 30-dic-2008, 10.55.45
 */

package CaTraSca.gui;

import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.text.Caret;

/**
 *
 * @author Cartell
 */
public class About extends javax.swing.JFrame {

    /** Creates new form About */
    public About() {
        initComponents();
    }

    public void setTesto(String nomeApplicazione, String versione, String autore)
    {
        this.jLabelDx1.setText(nomeApplicazione);
        this.jLabelDx2.setText(versione);
        this.jLabelDx3.setText(autore);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabelSx1 = new javax.swing.JLabel();
        jLabelSx2 = new javax.swing.JLabel();
        jLabelSx3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabelDx1 = new javax.swing.JLabel();
        jLabelDx2 = new javax.swing.JLabel();
        jLabelDx3 = new javax.swing.JLabel();

        setBounds(new java.awt.Rectangle(400, 200, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 3, true));
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(About.class);
        jLabel1.setIcon(resourceMap.getIcon("jLabel1.icon")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setName("aboutPanel"); // NOI18N

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/CaTraSca.png"))); // NOI18N
        labelImage.setMinimumSize(new java.awt.Dimension(0, 0));
        labelImage.setName("labelImage"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.gray, java.awt.Color.blue, java.awt.Color.gray));
        jPanel4.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel4.setName("jPanel4"); // NOI18N

        jPanel5.setName("jPanel5"); // NOI18N

        jLabelSx1.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabelSx1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSx1.setText("Nome Applicazione:");
        jLabelSx1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabelSx1.setName("jLabelSx1"); // NOI18N

        jLabelSx2.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabelSx2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSx2.setText("Versione:");
        jLabelSx2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabelSx2.setName("jLabelSx2"); // NOI18N

        jLabelSx3.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabelSx3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSx3.setText("Autore:");
        jLabelSx3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabelSx3.setName("jLabelSx3"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSx1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
            .addComponent(jLabelSx2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
            .addComponent(jLabelSx3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabelSx1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSx2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSx3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setName("jPanel6"); // NOI18N

        jLabelDx1.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabelDx1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelDx1.setText("Dx1");
        jLabelDx1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabelDx1.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabelDx1.setName("jLabelDx1"); // NOI18N

        jLabelDx2.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabelDx2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelDx2.setText("Dx2");
        jLabelDx2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabelDx2.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabelDx2.setName("jLabelDx2"); // NOI18N

        jLabelDx3.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabelDx3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelDx3.setText("Dx3");
        jLabelDx3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabelDx3.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabelDx3.setName("jLabelDx3"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDx1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
            .addComponent(jLabelDx2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
            .addComponent(jLabelDx3, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabelDx1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDx2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDx3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDx1;
    private javax.swing.JLabel jLabelDx2;
    private javax.swing.JLabel jLabelDx3;
    private javax.swing.JLabel jLabelSx1;
    private javax.swing.JLabel jLabelSx2;
    private javax.swing.JLabel jLabelSx3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel labelImage;
    // End of variables declaration//GEN-END:variables

}
