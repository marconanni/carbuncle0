package gui;

import grammar.ParserBaseball;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.filechooser.FileFilter;

import semantica.DatiGiocatoreGioco;
import syntaxtree.Node;
import visitor.BaseLanguageTreeVisitor;


public class Listener implements ActionListener{

	private Main frame;
	private JFileChooser fc;
	private static BaseLanguageTreeVisitor visitor1;
	FileFilter filter;

	public Listener(Main frame){this.frame=frame;}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==frame.getParseButton()){
			visitor1=new BaseLanguageTreeVisitor();
			ParserBaseball.ReInit(new StringReader(frame.getInputTextArea().getText()));
			try{
				Node root = frame.getParser().S();
				JOptionPane.showMessageDialog(frame, "OK!", "Controllo sintattico e semantico eseguito", JOptionPane.INFORMATION_MESSAGE);
				root.accept(visitor1);
				visitor1.printTree(visitor1.getTreeNode());
				frame.setJTree(new JTree(visitor1.getTreeNode()));
				frame.getAlbero().setRoot(visitor1.getTreeNode());
				frame.getAlbero().reload();
				
				Vector<DatiGiocatoreGioco> giocatoriCasa=frame.getParser().getStatisticheCasa();
				Vector<DatiGiocatoreGioco> giocatoriOspiti=frame.getParser().getStatisticheOspiti();
				frame.getStatisticheTextArea().setText("");
				frame.getStatisticheTextArea().append(frame.getParser().estraiStringaDaVettore(giocatoriCasa));
				frame.getStatisticheTextArea().append(frame.getParser().estraiStringaDaVettore(giocatoriOspiti));
				int puntiCasa=0;
				int puntiOspiti=0;
				String nomeCasa="";
				String nomeOspiti="";
				for(int i=0;i<giocatoriCasa.size();i++){
					puntiCasa=puntiCasa+giocatoriCasa.get(i).getPuntiSegnati();
					nomeCasa=giocatoriCasa.get(i).getSquadra();
				}
				for(int i=0;i<giocatoriOspiti.size();i++){
					puntiOspiti=puntiOspiti+giocatoriOspiti.get(i).getPuntiSegnati();
					nomeOspiti=giocatoriOspiti.get(i).getSquadra();
				}
				frame.getStatisticheTextArea().append("PUNTEGGIO FINALE:\n");
				frame.getStatisticheTextArea().append(nomeCasa+" punti: "+puntiCasa+", "+nomeOspiti+" punti: "+puntiOspiti);
				
				
			} catch (Exception exc) {
				//frame.getErrorText().append(exc.getMessage() + "\n");
				JOptionPane.showMessageDialog(frame, exc.getMessage()+"\n","ERRORE", JOptionPane.ERROR_MESSAGE);
				exc.printStackTrace();
				}
			
			}
		else{
			if(e.getSource()==frame.getApri()){
				filter = new TxtFileFilter();
				fc=new JFileChooser();
				fc.setFileFilter(filter);
				int returnVal = fc.showOpenDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					Reader fr;
					try {
						fr = new FileReader(file);
						BufferedReader in = new BufferedReader(fr);
						frame.getInputTextArea().setText("");
						String line = in.readLine();
						while (line != null) {
							frame.getInputTextArea().append(line + "\n");
							line = in.readLine();
						}
						frame.getInputTextArea().setAutoscrolls(true);
						frame.getInputTextArea().setCaretPosition(frame.getInputTextArea().getText().length());
						frame.getInputTextArea().setAutoscrolls(true);
						fr.close();
					} catch (FileNotFoundException exc) {
						JOptionPane.showMessageDialog(frame, exc.getMessage()+"\n","ERRORE", JOptionPane.ERROR_MESSAGE);
						exc.printStackTrace();
					} catch (IOException exc) {
						JOptionPane.showMessageDialog(frame, exc.getMessage()+"\n","ERRORE", JOptionPane.ERROR_MESSAGE);
						exc.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Operazione annullata dall'utente\n","ATTENZIONE", JOptionPane.INFORMATION_MESSAGE);
				}
				frame.getInputTextArea().setCaretPosition( frame.getInputTextArea().getDocument().getLength() ); 
			}
			
			else{
				if(e.getSource()==frame.getAbout()){JOptionPane.showMessageDialog(frame, "BaseLang\n Sandri Valerio", "About", JOptionPane.INFORMATION_MESSAGE);}
				else{
					if(e.getSource()==frame.getEsci()){System.exit(0);}
			}
			
		}
	}

	}
}
