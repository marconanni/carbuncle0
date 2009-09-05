package gui;


import grammar.ParserBaseball;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

import syntaxtree.Node;
import visitor.BaseLanguageTreeVisitor;

public class Main extends JFrame{
	static{
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
			catch(ClassNotFoundException e){			
		}	catch(InstantiationException e){
		}	catch(IllegalAccessException e){
		}	catch(UnsupportedLookAndFeelException e){
		}	
	}

	private JButton Parse;
	private ParserBaseball parser;



	private static BaseLanguageTreeVisitor visitor1 = new BaseLanguageTreeVisitor();
	private DefaultTreeModel albero;
	private JMenuBar Menu;
	private JButton ParseButton;
	private JScrollPane jScrollPane2;
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane3;
	private JTree jTree;
	private JTextArea inputTextArea;
	private JScrollPane jScrollPane1;
	private JMenu File, Help;
	private JMenuItem Apri, Esci, About;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main inst = new Main();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	ParserBaseball getParser() {
		return parser;
	}
	void setJTree(JTree jTree) {
		this.jTree = jTree;
	}
	DefaultTreeModel getAlbero() {
		return albero;
	}
	JButton getParseButton() {
		return ParseButton;
	}
	public Object getApri() {
		// TODO Auto-generated method stub
		return Apri;
	}
	public Object getAbout() {
		// TODO Auto-generated method stub
		return About;
	}
	public Object getEsci() {
		// TODO Auto-generated method stub
		return Esci;
	}
	public JTextArea getInputTextArea(){
		return inputTextArea;
	}
	public JTextArea getStatisticheTextArea(){
		return jTextArea1;
	}
	public Main() {
		super();
		try {
			parser=new ParserBaseball(new StringReader(""));
		} catch (Exception e) {
			// TODO: handle exception
			//this.errorTextArea.append(e.getMessage());
			JOptionPane.showMessageDialog(this, e.getMessage(),"ERRORE", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		inizializzaGrafica();
	}
	private void inizializzaGrafica(){
		Listener listener = new Listener(this);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("BaseLang");
		setResizable(false);
		getContentPane().setLayout(null);
		{
			ParseButton = new JButton();
			getContentPane().add(ParseButton);
			ParseButton.setText("Parse");
			ParseButton.setBounds(396, 619, 59, 21);
			ParseButton.addActionListener(listener);
		}
		{
			jScrollPane3 = new JScrollPane(jTextArea1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			getContentPane().add(jScrollPane3);
			jScrollPane3.setBounds(20, 399, 746, 209);
			{
				jTextArea1 = new JTextArea();
				jScrollPane3.setViewportView(jTextArea1);
				jTextArea1.setText("statistiche");
				jTextArea1.setBounds(24, 432, 504, 156);
				jTextArea1.setEditable(false);
			}
		}
		{
			jScrollPane2 = new JScrollPane(jTree,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			getContentPane().add(jScrollPane2);
			jScrollPane2.setBounds(512, 28, 253, 343);
			{
				albero = new DefaultTreeModel(new DefaultMutableTreeNode("Ready to Parse"));
				jTree = new JTree(albero);
				jScrollPane2.setViewportView(jTree);
				jTree.setBounds(292, 40, 257, 338);
				jTree.setAutoscrolls(true);
			}
		}
		{
			jScrollPane1 = new JScrollPane(inputTextArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			getContentPane().add(jScrollPane1);
			jScrollPane1.setBounds(20, 27, 452, 345);
			{
				inputTextArea = new JTextArea();				
				jScrollPane1.setViewportView(inputTextArea);
				inputTextArea.setLineWrap(true);				
				inputTextArea.setText("input");
				inputTextArea.setBounds(25, 54, 244, 339);
			}
			
		}
		this.setSize(789, 722);

		Menu=new JMenuBar();
		File=new JMenu("File");
		Help=new JMenu("?");
		Esci=new JMenuItem("Esci");
		Esci.addActionListener(listener);
		Apri=new JMenuItem("Apri");
		Apri.addActionListener(listener);
		About=new JMenuItem("About");
		About.addActionListener(listener);
		File.add(Apri);
		File.add(Esci);
		Help.add(About);
		Menu.add(File);
		Menu.add(Help);
		setJMenuBar(Menu);
	}


}
