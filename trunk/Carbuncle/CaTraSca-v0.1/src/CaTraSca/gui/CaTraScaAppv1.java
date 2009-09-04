/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CaTraScaAppv1.java
 *
 * Created on 28-dic-2008, 19.31.03
 */
package CaTraSca.gui;

import CaTraSca.Magazzino;
import CaTraSca.Prodotto;
import CaTraScaFilter.DefaultCaTraScaFileChooser;
import java.io.*;
import java.util.Iterator.*;
import java.util.*;
import javax.swing.*;
import javax.swing.tree.TreeModel;
import parser.CaTraScaParser;
import CaTraScaVisitor.*;
import Highlight.CaTraScaEditor;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import javax.swing.text.html.HTMLDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import syntaxtree.Node;

/**
 *
 * @author Davide Candeloro
 */
public class CaTraScaAppv1 extends javax.swing.JFrame {

    private final String estensione = "cts";
    private final String fileEsempioOleificio1 = "EsempioOleificio_CONTINUE_TRUE";
    private final String fileEsempioOleificio2 = "EsempioOleificio_CONTINUE_FALSE";
    private Icon OpenIcon = new ImageIcon("Immagini/openIcon.png");
    private Icon ClosedIcon = new ImageIcon("Immagini/closeIcon.png");
    private Icon LeafIcon = new ImageIcon("Immagini/leafIcon.png");

    /** Creates new form CaTraScaAppv1 */
    public CaTraScaAppv1() {
        initComponents();
    }

    private void Errore(String errore) {
        valutazioneTextArea.setForeground(Color.red);
        valutazioneTextArea.setText("ERRORE:\n" + errore);
    }

    private TreeModel GetTree() {
        return new DefaultTreeModel(dmtn);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jLabelAlbero = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButtonStart = new javax.swing.JButton();
        jButtonMagazzino = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButtonMovimento = new javax.swing.JButton();
        jButtonTrasformazione = new javax.swing.JButton();
        jButtonGiacenza = new javax.swing.JButton();
        jButtonPeriodo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jSplitPane3 = new javax.swing.JSplitPane();
        jLabelCodice = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        codiceTextArea = new CaTraScaEditor();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        valutazioneTextArea = new javax.swing.JTextArea();
        jButtonParse = new javax.swing.JButton();
        jLabelValutazione = new javax.swing.JLabel();
        jButtonRimanenze = new javax.swing.JButton();
        jMenuBarTool = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNuovo = new javax.swing.JMenuItem();
        jMenuItemApri = new javax.swing.JMenuItem();
        jMenuItemSalva = new javax.swing.JMenuItem();
        jMenuItemSaveXml = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItemChiudi = new javax.swing.JMenuItem();
        javax.swing.JMenu jMenuTool = new javax.swing.JMenu();
        jMenuItemToolModeOn = new javax.swing.JMenuItem();
        jMenuItemToolModeOff = new javax.swing.JMenuItem();
        jMenuPuntoInterrogativo = new javax.swing.JMenu();
        jMenuItemGrammatica = new javax.swing.JMenuItem();
        jMenuEsempio = new javax.swing.JMenu();
        jMenuItemEsempio1 = new javax.swing.JMenuItem();
        jMenuItemEsempio2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(200, 100, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setName("jPanel1"); // NOI18N

        jSplitPane4.setDividerLocation(375);
        jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane4.setName("jSplitPane4"); // NOI18N

        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setName("jSplitPane1"); // NOI18N

        jSplitPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.setName("jSplitPane2"); // NOI18N

        jLabelAlbero.setFont(new java.awt.Font("Calibri", 1, 14));
        jLabelAlbero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAlbero.setText("Albero");
        jLabelAlbero.setName("jLabelAlbero"); // NOI18N
        jSplitPane2.setTopComponent(jLabelAlbero);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTree.setModel(null);
        jTree.setName("sintactTree"); // NOI18N
        jScrollPane1.setViewportView(jTree);

        jSplitPane2.setRightComponent(jScrollPane1);

        jSplitPane1.setLeftComponent(jSplitPane2);

        jPanel4.setName("jPanel4"); // NOI18N

        jPanel3.setName("jPanel3"); // NOI18N

        jButtonStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/StartIco.png"))); // NOI18N
        jButtonStart.setToolTipText("Start");
        jButtonStart.setEnabled(false);
        jButtonStart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonStart.setName("jButtonStart"); // NOI18N
        jButtonStart.setPreferredSize(new java.awt.Dimension(63, 39));
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonMagazzino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/MagazzinoIco.png"))); // NOI18N
        jButtonMagazzino.setToolTipText("Magazzino");
        jButtonMagazzino.setEnabled(false);
        jButtonMagazzino.setName("jButtonMagazzino"); // NOI18N
        jButtonMagazzino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMagazzinoActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setName("jPanel6"); // NOI18N

        jButtonMovimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/MovimentoIco.png"))); // NOI18N
        jButtonMovimento.setToolTipText("Movimento");
        jButtonMovimento.setEnabled(false);
        jButtonMovimento.setName("jButtonMovimento"); // NOI18N
        jButtonMovimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMovimentoActionPerformed(evt);
            }
        });

        jButtonTrasformazione.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/TrasformazioneIco.png"))); // NOI18N
        jButtonTrasformazione.setToolTipText("Trasformazione");
        jButtonTrasformazione.setEnabled(false);
        jButtonTrasformazione.setName("jButtonTrasformazione"); // NOI18N
        jButtonTrasformazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTrasformazioneActionPerformed(evt);
            }
        });

        jButtonGiacenza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/GiacenzaIco.png"))); // NOI18N
        jButtonGiacenza.setToolTipText("Giacenza");
        jButtonGiacenza.setEnabled(false);
        jButtonGiacenza.setName("jButtonGiacenza"); // NOI18N
        jButtonGiacenza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGiacenzaActionPerformed(evt);
            }
        });

        jButtonPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/PeriodoIco.png"))); // NOI18N
        jButtonPeriodo.setToolTipText("Periodo");
        jButtonPeriodo.setEnabled(false);
        jButtonPeriodo.setName("jButtonPeriodo"); // NOI18N
        jButtonPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPeriodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGiacenza, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTrasformazione, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGiacenza, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTrasformazione, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonMagazzino, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonMagazzino, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setName("jPanel5"); // NOI18N

        jSplitPane3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane3.setName("jSplitPane3"); // NOI18N

        jLabelCodice.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabelCodice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCodice.setText("Codice");
        jLabelCodice.setName("jLabelCodice"); // NOI18N
        jSplitPane3.setTopComponent(jLabelCodice);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        codiceTextArea.setFont(new java.awt.Font("Arial Unicode MS", 0, 13));
        codiceTextArea.setName("codiceTextArea"); // NOI18N
        codiceTextArea.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codiceTextAreaKeyPressed(evt);
            }
        });

        jScrollPane2.setViewportView(codiceTextArea);

        jSplitPane3.setRightComponent(jScrollPane2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel4);

        jSplitPane4.setLeftComponent(jSplitPane1);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setName("jPanel2"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        valutazioneTextArea.setColumns(20);
        valutazioneTextArea.setEditable(false);
        valutazioneTextArea.setRows(5);
        valutazioneTextArea.setName("valutazioneTextArea"); // NOI18N
        jScrollPane3.setViewportView(valutazioneTextArea);

        jButtonParse.setToolTipText("Valuta");
        jButtonParse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/ParseIcon.png"))); // NOI18N
        jButtonParse.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonParse.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonParse.setName("parseButton"); // NOI18N
        jButtonParse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parseButtonActionPerformed(evt);
            }
        });

        jLabelValutazione.setFont(new java.awt.Font("Calibri", 1, 14));
        jLabelValutazione.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValutazione.setText("Valutazione");
        jLabelValutazione.setName("jLabelValutazione"); // NOI18N

        jButtonRimanenze.setToolTipText("Rimanenze di fine periodi");
        jButtonRimanenze.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/RimanenzeIcon.png"))); // NOI18N
        jButtonRimanenze.setName("jButtonRimanenze"); // NOI18N
        jButtonRimanenze.setEnabled(false);
        jButtonRimanenze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRimanenzeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelValutazione, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRimanenze)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonParse, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonParse)
                            .addComponent(jLabelValutazione))
                        .addGap(7, 7, 7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonRimanenze, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane4.setRightComponent(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );

        jMenuBarTool.setName("jMenuBar1"); // NOI18N

        jMenuFile.setText("File");
        jMenuFile.setName("jMenuFile"); // NOI18N

        jMenuItemNuovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNuovo.setText("Nuovo");
        jMenuItemNuovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/NewIco.png"))); // NOI18N
        jMenuItemNuovo.setName("jMenuItemNuovo"); // NOI18N
        jMenuItemNuovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuovoActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemNuovo);

        jMenuItemApri.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemApri.setText("Apri");
        jMenuItemApri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/OpenIco.png"))); // NOI18N
        jMenuItemApri.setName("jMenuItemApri"); // NOI18N
        jMenuItemApri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemApriActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemApri);

        jMenuItemSalva.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSalva.setText("Salva");
        jMenuItemSalva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/SaveIco.png"))); // NOI18N
        jMenuItemSalva.setName("jMenuItemSalva"); // NOI18N
        jMenuItemSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalvaActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSalva);

        jMenuItemSaveXml.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSaveXml.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/SaveXmlIco.png"))); // NOI18N
        jMenuItemSaveXml.setText("Salva XML");
        jMenuItemSaveXml.setEnabled(false);
        jMenuItemSaveXml.setName("jMenuItemSaveXml"); // NOI18N
        jMenuItemSaveXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveXmlActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSaveXml);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jMenuFile.add(jSeparator1);

        jMenuItemChiudi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemChiudi.setText("Chiudi");
        jMenuItemChiudi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/EsciIco.png"))); // NOI18N
        jMenuItemChiudi.setName("jMenuItemEsci"); // NOI18N
        jMenuItemChiudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemChiudiActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemChiudi);

        jMenuBarTool.add(jMenuFile);

        jMenuTool.setText("Tool");
        jMenuTool.setName("jMenuTool"); // NOI18N

        jMenuItemToolModeOn.setText("Graphic mode ON");
        jMenuItemToolModeOn.setName("jMenuItemToolModeOn"); // NOI18N
        jMenuItemToolModeOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemToolModeOnActionPerformed(evt);
            }
        });
        jMenuTool.add(jMenuItemToolModeOn);

        jMenuItemToolModeOff.setText("Graphic mode OFF");
        jMenuItemToolModeOff.setEnabled(false);
        jMenuItemToolModeOff.setName("jMenuItemToolModeOff"); // NOI18N
        jMenuItemToolModeOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemToolModeOffActionPerformed(evt);
            }
        });
        jMenuTool.add(jMenuItemToolModeOff);

        jMenuBarTool.add(jMenuTool);

        jMenuPuntoInterrogativo.setText("?");
        jMenuPuntoInterrogativo.setName("jMenu2"); // NOI18N

        jMenuItemGrammatica.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemGrammatica.setText("Grammatica");
        jMenuItemGrammatica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/GraIco.png"))); // NOI18N
        jMenuItemGrammatica.setName("jMenuItemGrammatica"); // NOI18N
        jMenuItemGrammatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGrammaticaActionPerformed(evt);
            }
        });
        jMenuPuntoInterrogativo.add(jMenuItemGrammatica);

        jMenuEsempio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/EseIco.png"))); // NOI18N
        jMenuEsempio.setText("Esempio");
        jMenuEsempio.setName("jMenuEsempio"); // NOI18N

        jMenuItemEsempio1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemEsempio1.setText("Oleificio (CONTINUE)");
        jMenuItemEsempio1.setName("jMenuItemEsempio1"); // NOI18N
        jMenuItemEsempio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEsempio1ActionPerformed(evt);
            }
        });
        jMenuEsempio.add(jMenuItemEsempio1);

        jMenuItemEsempio2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemEsempio2.setText("Oleificio (!CONTINUE)");
        jMenuItemEsempio2.setName("jMenuItemEsempio2"); // NOI18N
        jMenuItemEsempio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEsempio2ActionPerformed(evt);
            }
        });
        jMenuEsempio.add(jMenuItemEsempio2);

        jMenuPuntoInterrogativo.add(jMenuEsempio);

        jSeparator2.setName("jSeparator2"); // NOI18N
        jMenuPuntoInterrogativo.add(jSeparator2);

        jMenuItemAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAbout.setText("About");
        jMenuItemAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CaTraSca/gui/resources/AbtIco.png"))); // NOI18N
        jMenuItemAbout.setName("jMenuItemAbout"); // NOI18N
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuPuntoInterrogativo.add(jMenuItemAbout);

        jMenuBarTool.add(jMenuPuntoInterrogativo);

        setJMenuBar(jMenuBarTool);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }


    private void jButtonRimanenzeActionPerformed(java.awt.event.ActionEvent evt)
    {
        for (Iterator<RimanenzeForm> it = rimanenzeForm.iterator(); it.hasNext();)
        {
            RimanenzeForm rf = it.next();
            rf.setVisible(true);
            rf.validate();
        }
    }

    private void parseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        valutazioneTextArea.setText("");
        jTree.setModel(null);

        try {
            if (parser == null) {
                parser = new CaTraScaParser(new StringReader(codiceTextArea.getText()));
            } else {
                CaTraScaParser.ReInit(new StringReader(codiceTextArea.getText()));
            }

            CaTraScaVisitor visitor = new CaTraScaVisitor(valutazioneTextArea);
            _catrasca = CaTraScaParser.Scope();
            _catrasca.accept(visitor);

            if (!visitor.isErrore()) {
                jMenuItemSaveXml.setEnabled(true);
                valutazioneTextArea.setForeground(Color.gray);
                valutazioneTextArea.setText(" -  TESTO ACCETTATO DAL PARSER");
                CaTraScaTreeVisitor treeVisitor = new CaTraScaTreeVisitor();
                _catrasca.accept(treeVisitor);
                dmtn = treeVisitor.getTree();

                DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
                renderer.setOpenIcon(OpenIcon);
                renderer.setClosedIcon(ClosedIcon);
                renderer.setLeafIcon(LeafIcon);
                jTree.setCellRenderer(renderer);
                jTree.setModel(GetTree());
                printRisultato(visitor.getRisultato(), visitor.getPeriodici());
                jButtonRimanenze.setEnabled(true);
            } else {
                Errore(visitor.getErrore());
            }
        } catch (Exception e) {
            Errore(e.toString());
        }
    }

    private void jMenuItemGrammaticaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        File f = new File("CaTraSca.html");
        JFrame grammaticaFrame = new JFrame("Grammatica di CaTraSca");
        JEditorPane page = new JEditorPane();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        URL baseUrl = null;
        try {
            baseUrl = f.toURI().toURL();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        page.setContentType("text/html");
        Container gc = grammaticaFrame.getContentPane();
        gc.add(panel);
        try {
            FileInputStream fis1 = new FileInputStream(f);
            page.read(fis1, null);
        } catch (FileNotFoundException a) {
            a.printStackTrace();
        } catch (IOException a) {
            a.printStackTrace();
        }
        HTMLDocument htmlDoc = (HTMLDocument) page.getDocument();
        htmlDoc.setBase(baseUrl);
        page.setEditable(false);
        JScrollPane st = new JScrollPane(page);
        st.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        st.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        st.setPreferredSize(new Dimension(800, 600));
        panel.add(st, BorderLayout.PAGE_START);
        grammaticaFrame.pack();
        grammaticaFrame.setResizable(false);
        grammaticaFrame.setVisible(true);
    }

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        About about = new About();
        about.setTitle("About CaTraSca");

        try {
            File aboutFile = new File("About.txt");
            char[] testoChar = new char[(int) aboutFile.length()];
            FileReader fr = new FileReader(aboutFile);
            fr.read(testoChar);
            String aboutString = "";

            for (int i = 0; i < testoChar.length; ++i) {
                aboutString += testoChar[i];
            }

            String nomeApplicazione = aboutString.substring(aboutString.indexOf(":") + 1, aboutString.indexOf('\n'));
            aboutString = aboutString.substring(aboutString.indexOf('\n') + 1);
            String versione = aboutString.substring(aboutString.indexOf(":") + 1, aboutString.indexOf('\n'));
            aboutString = aboutString.substring(aboutString.indexOf('\n') + 1);
            String autore = aboutString.substring(aboutString.indexOf(":") + 1, aboutString.indexOf('\n'));

            about.setTesto(nomeApplicazione, versione, autore);
        } catch (FileNotFoundException e) {
            Errore(e.toString());
            return;
        } catch (IOException e) {
            Errore(e.toString());
            return;
        }

        about.setVisible(true);
    }

    private void jMenuItemNuovoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jMenuItemSaveXml.setEnabled(false);
        valutazioneTextArea.setText("");
        codiceTextArea.setText("");
        jButtonRimanenze.setEnabled(false);
        jTree.setModel(null);
        if (toolMode) {
            setToolModeOff();
            setToolModeOn();
            setForStart();
        }
    }

    private void jMenuItemApriActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        if (estensione == null) {
            Errore("Estensione non settata.");
            return;
        } else {
            codiceTextArea.setForeground(Color.black);
        }



        DefaultCaTraScaFileChooser dc = new DefaultCaTraScaFileChooser(estensione);
        File file = null;

        if (dc.showOpenDialog(this) == DefaultCaTraScaFileChooser.APPROVE_OPTION) {
            file = dc.getSelectedFile();
        } else {
            return;
        }

        if (file == null) {
            return;
        }

        try {
            int c;
            String str = "";
            InputStreamReader reader = new FileReader(file);

            while ((c = reader.read()) > 0) {
                str += (char) c;
            }

            reader.close();
            codiceTextArea.setText(str);
            jButtonRimanenze.setEnabled(false);
        } catch (IOException e) {
            Errore(e.toString());
        }

        setToolModeOff();
    }

    private void codiceTextAreaKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        codiceTextArea.setForeground(Color.black);
    }

    private void jMenuItemSalvaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (estensione == null) {
            Errore("Estensione non settata.");
            return;
        } else {
            codiceTextArea.setForeground(Color.black);
        }

        File file = null;

        try {
            DefaultCaTraScaFileChooser dc = new DefaultCaTraScaFileChooser(estensione);
            YesNoDialog yed = null;

            if (dc.showSaveDialog(this) == DefaultCaTraScaFileChooser.APPROVE_OPTION) {
                file = new File(dc.getSelectedFile().toString() + ".cts");
                if (file.exists()) {
                    yed = new YesNoDialog(file.getName());
                    if (yed.setVisible() != 0) {
                        jMenuItemSalvaActionPerformed(null);
                        return;
                    }
                }
            } else {
                return;
            }

            if (file == null) {
                return;
            }
        } catch (Exception e) {
            return;
        }

        try {
            OutputStreamWriter writer = new FileWriter(file);
            String str = codiceTextArea.getText();
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            Errore(e.toString());
        }
    }

    private void jMenuItemChiudiActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
    }

    private void jMenuItemEsempio1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.jMenuItemNuovoActionPerformed(evt);
        try {
            File esempioFile = new File(fileEsempioOleificio1 + "." + estensione);
            char[] testoChar = new char[(int) esempioFile.length()];
            FileReader fr = new FileReader(esempioFile);
            fr.read(testoChar);
            String esempioString = "";

            for (int i = 0; i < testoChar.length; ++i) {
                esempioString += testoChar[i];
            }

            codiceTextArea.setForeground(Color.black);
            codiceTextArea.setText(esempioString);
        } catch (FileNotFoundException e) {
            Errore(e.toString());
        } catch (IOException e) {
            Errore(e.toString());
        }
    }

    private void jMenuItemEsempio2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.jMenuItemNuovoActionPerformed(evt);
        try {
            File esempioFile = new File(fileEsempioOleificio2 + "." + estensione);
            char[] testoChar = new char[(int) esempioFile.length()];
            FileReader fr = new FileReader(esempioFile);
            fr.read(testoChar);
            String esempioString = "";

            for (int i = 0; i < testoChar.length; ++i) {
                esempioString += testoChar[i];
            }

            codiceTextArea.setForeground(Color.black);
            codiceTextArea.setText(esempioString);
        } catch (FileNotFoundException e) {
            Errore(e.toString());
        } catch (IOException e) {
            Errore(e.toString());
        }
    }

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        StartTrueOrFalse stof = new StartTrueOrFalse(this, true);
        stof.setLocationRelativeTo(this);
        stof.setTitle("Continue");

        stof.setVisible(true);

        if (stof.isRisultatoOk()) {
            prima = "CaTraSca\n{\n\tCONTINUE=" + String.valueOf(stof.getContinua()).toUpperCase() + "\n";
            dopo = "\n}";
            codiceTextArea.setText(prima + dopo);
            setForMagazzino();
        }
    }

    private void jButtonMagazzinoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        InsertMagazzino im = new InsertMagazzino(this, true);
        im.setTitle("Magazzino");
        im.setLocationRelativeTo(this);
        im.setVisible(true);

        if (im.isRisultatoOk())
        {
            Magazzino m = im.magazzino;
            prima += "\tMAGAZZINO " + m.getNome();

            if (!m.getIndirizzo().getVia().isEmpty())
            {
                prima += ", VIA " + m.getIndirizzo().getVia();

                if (m.getIndirizzo().getNcivico() != 0) {
                    prima += ", N." + m.getIndirizzo().getNcivico();
                }

                prima += ", " + m.getIndirizzo().getCap();
                prima += " " + m.getIndirizzo().getCitta();
            }

            prima += ";\n";
            codiceTextArea.setText(prima + dopo);

            setForTheOthers();
            jButtonGiacenza.setEnabled(false);
            jButtonMovimento.setEnabled(false);
            jButtonTrasformazione.setEnabled(false);
        }
    }

    private void jMenuItemToolModeOnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        if (!codiceTextArea.getText().equals("")) {
            OkCandelDialog oc = new OkCandelDialog(this, true);
            oc.setText("Attivando il tool mode il testo scritto verra' cancellato. Proseguire?");
            oc.setTitle("Tool mode ON?");
            oc.setLocationRelativeTo(this);
            oc.setVisible(true);

            if (oc.risultato) {
                codiceTextArea.setText("");
                setToolModeOn();
                setForStart();
                valutazioneTextArea.setText("");
                jTree.setModel(null);
            }

            oc.dispose();
        } else {
            setToolModeOn();
            setForStart();
            valutazioneTextArea.setText("");
            jTree.setModel(null);
        }
    }

    private void jMenuItemToolModeOffActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        prima = "";
        dopo = "";
        setToolModeOff();
    }

    private void jButtonPeriodoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        SelectPeriod sp = new SelectPeriod(this, true);
        sp.setTitle("Periodo");
        sp.setVisible(true);

        if (!dopo.equals("\n}")) {
            prima += "\t\t}\n\t}\n";
            String subStr = dopo.substring(dopo.indexOf("}") + 1, dopo.length());
            dopo = subStr.substring(subStr.indexOf("}") + 1, subStr.length());
        }

        if (sp.isRisultatoOk()) {
            Calendar dataInizio = sp.getDataInizio();
            Calendar dataFine = sp.getDataFine();

            prima += "\t{\n\t\t DA ";
            prima += dataInizio.get(5) + "-" + CaTraSca.Mese.values()[dataInizio.get(2)] + "-" + dataInizio.get(1);
            prima += " A ";
            prima += dataFine.get(5) + "-" + CaTraSca.Mese.values()[dataFine.get(2)] + "-" + dataFine.get(1);
            prima += ";\n";
            dopo = "\n\t}" + dopo;
            codiceTextArea.setText(prima + dopo);

            setForTheOthers();
            jButtonPeriodo.setEnabled(false);
            firstTime = true;
        }
    }

    private void jButtonGiacenzaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        InsertGiacenza ig = new InsertGiacenza(this, true, prodotti);
        ig.setTitle("Giacenza");
        ig.setVisible(true);

        if (ig.isRisultatoOk()) {
            prima += "\n\t\tGIACENZA INIZIALE:\n";
            boolean isTheFirst = true;
            Hashtable<Prodotto, Integer> ht = ig.getGiacenza();
            Enumeration<Prodotto> p = ht.keys();
            Prodotto pro = null;
            for (Iterator<Integer> it = ht.values().iterator(); it.hasNext();) {
                Integer quantita = it.next();
                pro = p.nextElement();

                if (!isTheFirst) {
                    prima += ",\n";
                }

                prima += "\t\t\tMARCA " + pro.getMarca() + " MODELLO " + pro.getModello() + " QUANTITA " + quantita;

                isTheFirst = false;
            }

            prima += ";\n";

            codiceTextArea.setText(prima + dopo);
            setForTheOthers();
            jButtonGiacenza.setEnabled(false);
            jButtonPeriodo.setEnabled(false);
        }
    }

    private void jButtonMovimentoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        InsertMovimento im = new InsertMovimento(this, true, prodotti);
        im.setTitle("Movimenti");
        im.setVisible(true);

        if (im.isRisultatoOk()) {
            if (firstTime) {
                prima += "\t\t{\n";
                dopo = "\t\t}" + dopo;
                firstTime = false;
            }

            prima += "\t\t\t" + im.getTipoMovimento() + ":";

            Hashtable<Prodotto, Integer> ht = im.getMovimenti();
            Enumeration<Prodotto> p = ht.keys();
            Prodotto pro = null;
            for (Iterator<Integer> it = ht.values().iterator(); it.hasNext();) {
                Integer quantita = it.next();
                pro = p.nextElement();

                prima += "\n\t\t\t\tMARCA " + pro.getMarca() + " MODELLO " + pro.getModello() + " QUANTITA " + quantita;
            }

            prima += ";\n";
            codiceTextArea.setText(prima + dopo);
            setForTheOthers();
            jButtonGiacenza.setEnabled(false);
        }
    }

    private void jButtonTrasformazioneActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        InsertTrasformazione itr = new InsertTrasformazione(this, true, prodotti);
        itr.setTitle("Trasformazione");
        itr.setVisible(true);

        if (itr.isRisultatoOk()) {
            if (firstTime) {
                prima += "\t\t{\n";
                dopo = "\t\t}" + dopo;
                firstTime = false;
            }

            prima += "\t\t\tTRASFORMAZIONE:";
            trasformazione(itr.getIngressi());

            prima += "=";

            trasformazione(itr.getUscite());
            prima += ";\n";

            codiceTextArea.setText(prima + dopo);
            setForTheOthers();
            jButtonGiacenza.setEnabled(false);
        }
    }

    private void jMenuItemSaveXmlActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        File file = null;

        try {
            DefaultCaTraScaFileChooser dc = new DefaultCaTraScaFileChooser("xml");
            YesNoDialog yed = null;

            if (dc.showSaveDialog(this) == DefaultCaTraScaFileChooser.APPROVE_OPTION) {
                file = new File(dc.getSelectedFile().toString() + ".xml");
                if (file.exists()) {
                    yed = new YesNoDialog(file.getName());
                    if (yed.setVisible() != 0) {
                        jMenuItemSalvaActionPerformed(null);
                        return;
                    }
                }
            } else {
                return;
            }

            if (file == null) {
                return;
            }
        } catch (Exception e) {
            return;
        }

        CaTraScaXmlVisitor xmlVisitor = new CaTraScaXmlVisitor(file);
        _catrasca.accept(xmlVisitor);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                CaTraScaAppv1 applicazione = new CaTraScaAppv1();
                applicazione.setTitle("CaTraSca");
                applicazione.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private CaTraScaEditor codiceTextArea;
    private javax.swing.JButton jButtonRimanenze;
    private javax.swing.JButton jButtonParse;
    private javax.swing.JButton jButtonGiacenza;
    private javax.swing.JButton jButtonMagazzino;
    private javax.swing.JButton jButtonMovimento;
    private javax.swing.JButton jButtonPeriodo;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonTrasformazione;
    private javax.swing.JLabel jLabelAlbero;
    private javax.swing.JLabel jLabelCodice;
    private javax.swing.JLabel jLabelValutazione;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuPuntoInterrogativo;
    private javax.swing.JMenu jMenuEsempio;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBarTool;
    private javax.swing.JMenuItem jMenuItemApri;
    private javax.swing.JMenuItem jMenuItemNuovo;
    private javax.swing.JMenuItem jMenuItemSalva;
    private javax.swing.JMenuItem jMenuItemChiudi;
    private javax.swing.JMenuItem jMenuItemGrammatica;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemEsempio1;
    private javax.swing.JMenuItem jMenuItemEsempio2;
    private javax.swing.JMenuItem jMenuItemSaveXml;
    private javax.swing.JMenuItem jMenuItemToolModeOff;
    private javax.swing.JMenuItem jMenuItemToolModeOn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JTree jTree;
    private javax.swing.JTextArea valutazioneTextArea;
    // End of variables declaration
    private CaTraScaParser parser;
    private Node _catrasca = null;
    private DefaultMutableTreeNode dmtn;
    private String prima = "";
    private String dopo = "";
    private Vector<CaTraSca.Prodotto> prodotti = new Vector<CaTraSca.Prodotto>();
    private Vector<RimanenzeForm> rimanenzeForm;
    private boolean firstTime = false;
    private boolean toolMode = false;

    private void printRisultato(java.util.Vector<CaTraSca.Magazzino> magazzini, java.util.Vector<CaTraSca.DescrizionePeriodo> periodici)
    {
        rimanenzeForm = new Vector<RimanenzeForm>();

        int j = -1;
        Vector<Prodotto> products;
        Vector<Integer> quantita;

        for (Iterator<Magazzino> itMag = magazzini.iterator(); itMag.hasNext();)
        {
            products = new Vector<Prodotto>();
            quantita = new Vector<Integer>();
            String giacenza = "\n";

            for (int k = 0; k < 150; k++) {
                giacenza += "-";
            }

            giacenza += "\n\nGiacenza al " + periodici.get(++j).getDataFineString() + ":\n\t";

            for (int k = 0; k < 100; k++) {
                giacenza += "-";
            }

            giacenza += "\n\tMarca\t\tModello\t\tQuantita\'\n\t";

            for (int k = 0; k < 100; k++) {
                giacenza += "-";
            }

            giacenza += "\n";
            Magazzino magazzino = itMag.next();

            for (Iterator it = magazzino.getArticoli().iterator(); it.hasNext();) {
                CaTraSca.Articolo articolo = (CaTraSca.Articolo) it.next();

                if (articolo.getQuantita() > 0) {
                    products.add(articolo.getProdotto());
                    quantita.add(articolo.getQuantita());
                    giacenza += "\t" + articolo.getProdotto().getMarca();
                    for (int i = 0; i < 2 - articolo.getProdotto().getMarca().length() / 15; i++) {
                        giacenza += "\t";
                    }
                    giacenza += articolo.getProdotto().getModello();
                    for (int i = 0; i < 2 - articolo.getProdotto().getModello().length() / 15; i++) {
                        giacenza += "\t";
                    }
                    giacenza += articolo.getQuantita() + "\n";
                }
            }
            if (products.size() > 0)
            {
                RimanenzeForm rf = new RimanenzeForm(periodici.get(j).getDataFineString());
                rf.setTitle("Rimanenze");
                rf.caricaRimanenze(products, quantita);
                rf.setLocationRelativeTo(this);
                rf.setLocation(50 + this.getLocation().x + 50*j, 50 + this.getLocation().y + 50*j);
                rimanenzeForm.add(rf);
            }

            valutazioneTextArea.setText(valutazioneTextArea.getText() + giacenza);
        }
    }

    private void setForStart() {
        setOffButtons();
        jButtonStart.setEnabled(true);
    }

    private void setForMagazzino() {
        setOffButtons();
        jButtonMagazzino.setEnabled(true);
    }

    private void setForTheOthers() {
        setOffButtons();
        jButtonPeriodo.setEnabled(true);
        jButtonGiacenza.setEnabled(true);
        jButtonMovimento.setEnabled(true);
        jButtonTrasformazione.setEnabled(true);
    }

    private void setToolModeOff() {
        codiceTextArea.setEditable(true);
        setOffButtons();
        jMenuItemToolModeOn.setEnabled(true);
        jMenuItemToolModeOff.setEnabled(false);
        toolMode = false;
    }

    private void setToolModeOn() {
        codiceTextArea.setText("");
        codiceTextArea.setEditable(false);
        setOnButtons();
        jMenuItemToolModeOff.setEnabled(true);
        jMenuItemToolModeOn.setEnabled(false);
        toolMode = true;
    }

    private void setOffButtons() {
        jButtonStart.setEnabled(false);
        jButtonMagazzino.setEnabled(false);
        jButtonPeriodo.setEnabled(false);
        jButtonGiacenza.setEnabled(false);
        jButtonMovimento.setEnabled(false);
        jButtonTrasformazione.setEnabled(false);
    }

    private void setOnButtons() {
        jButtonStart.setEnabled(true);
        jButtonMagazzino.setEnabled(true);
        jButtonPeriodo.setEnabled(true);
        jButtonGiacenza.setEnabled(true);
        jButtonMovimento.setEnabled(true);
        jButtonTrasformazione.setEnabled(true);
    }

    private void trasformazione(Hashtable<Prodotto, Integer> movimento) {
        Enumeration<Prodotto> pi = movimento.keys();
        Prodotto pro = null;
        boolean isTheFirst = true;

        for (Iterator<Integer> it = movimento.values().iterator(); it.hasNext();) {
            if (!isTheFirst) {
                prima += "+";
            }

            Integer quantita = it.next();
            pro = pi.nextElement();
            prima += "\n\t\t\t\t(" + quantita + " MARCA " + pro.getMarca() + " MODELLO " + pro.getModello() + ")";
            isTheFirst = false;
        }
    }
}
