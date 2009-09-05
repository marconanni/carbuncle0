package visitor;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import syntaxtree.Arbitro;
import syntaxtree.ArrivoInBase;
import syntaxtree.Attacco;
import syntaxtree.Avanzamento;
import syntaxtree.Base;
import syntaxtree.BaseRubata;
import syntaxtree.BaseSuBall;
import syntaxtree.Battuta;
import syntaxtree.Colpito;
import syntaxtree.EffettoBattuta;
import syntaxtree.Eliminazione;
import syntaxtree.Errore;
import syntaxtree.Esito;
import syntaxtree.Giocatore;
import syntaxtree.Inning;
import syntaxtree.Interferenza;
import syntaxtree.Lancio;
import syntaxtree.LineUp;
import syntaxtree.ListaLineUp;
import syntaxtree.Node;
import syntaxtree.NodeList;
import syntaxtree.NodeListOptional;
import syntaxtree.NodeOptional;
import syntaxtree.NodeSequence;
import syntaxtree.NodeToken;
import syntaxtree.OutRubata;
import syntaxtree.OutSuBase;
import syntaxtree.OutVolo;
import syntaxtree.PallaBattuta;
import syntaxtree.PallaNonBattuta;
import syntaxtree.S;
import syntaxtree.SezioneA;
import syntaxtree.SezioneB;
import syntaxtree.SezioneC;
import syntaxtree.Squadre;
import syntaxtree.StrikeOut;

import syntaxtree.NodeChoice;

public class BaseLanguageTreeVisitor implements Visitor{
	
	private DefaultMutableTreeNode albero;

	public void visit(NodeList n) {
		// TODO Auto-generated method stub
		for (Enumeration<Node> e = n.elements(); e.hasMoreElements();) {
			e.nextElement().accept(this);
		}
	}

	public void visit(NodeListOptional n) {
		// TODO Auto-generated method stub
		if (n.present()) {
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Optional");
			for (Enumeration<Node> e = n.elements(); e.hasMoreElements();) {
				e.nextElement().accept(this);
				nodo.add(albero);
			}
			this.albero = nodo;
		}
	}

	public void visit(NodeOptional n) {
		// TODO Auto-generated method stub
		if (n.present())
			n.node.accept(this);		
	}

	public void visit(NodeSequence n) {
		// TODO Auto-generated method stub
		for (Enumeration<Node> e = n.elements(); e.hasMoreElements();)
			e.nextElement().accept(this);		
	}

	public void visit(NodeToken n) {
		// TODO Auto-generated method stub
		
	}

	//non è stato auto generato il metodo printTree
	public void printTree(TreeNode node) {
		System.out.println(node.toString());
		for (int i = 0; i < node.getChildCount(); i++) {
			TreeNode child = (TreeNode) node.getChildAt(i);
			printTree(child);
		}
	}

	/**
	    * f0 -> SezioneA()
	    * f1 -> SezioneB()
	    * f2 -> <AGRAFFA>
	    * f3 -> SezioneC()
	    * f4 -> <CGRAFFA>
	    */
	public void visit(S n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("S");
		n.f0.accept(this);
		nodo.add(albero);
		n.f1.accept(this);
		nodo.add(albero);
		n.f2.accept(this);
		n.f3.accept(this);
		nodo.add(albero);
		n.f4.accept(this);
		this.albero = nodo;
	}

	/**
	    * f0 -> Squadre()
	    * f1 -> Arbitro()
	    */
	public void visit(SezioneA n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("SezioneA");
		n.f0.accept(this);
		nodo.add(albero);
		n.f1.accept(this);
		nodo.add(albero);
		this.albero = nodo;
	}

	/**
	    * f0 -> "Squadra Ospite:"
	    * f1 -> <NOME>
	    * f2 -> <VIRGOLA>
	    * f3 -> "Squadra Casa:"
	    * f4 -> <NOME>
	    * f5 -> <PVIRGOLA>
	    */
	public void visit(Squadre n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Squadre");
		n.f0.accept(this);
		n.f1.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f1.toString()));
		n.f2.accept(this);
		n.f3.accept(this);
		n.f4.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f4.toString()));
		n.f5.accept(this);
		this.albero = nodo;
	}

	/**
	    * f0 -> "Arbitro:"
	    * f1 -> <NOME>
	    * f2 -> <PVIRGOLA>
	    */
	public void visit(Arbitro n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Arbitro");
		n.f0.accept(this);
		n.f1.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f1.toString()));
		n.f2.accept(this);
		this.albero = nodo;
	}

	/**
	    * f0 -> ListaLineUp()
	    */
	public void visit(SezioneB n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("SezioneB");
		n.f0.accept(this);
		nodo.add(albero);
		this.albero = nodo;
	}

	   /**
	    * f0 -> "Line-Up squadra ospite:"
	    * f1 -> LineUp()
	    * f2 -> ";"
	    * f3 -> "Line-Up squadra casa:"
	    * f4 -> LineUp()
	    * f5 -> ";"
	    */
	public void visit(ListaLineUp n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("ListaLineUp");
		n.f0.accept(this);
		n.f1.accept(this);
		nodo.add(albero);
		n.f2.accept(this);
		n.f3.accept(this);
		n.f4.accept(this);
		nodo.add(albero);
		n.f5.accept(this);
		this.albero = nodo;
	}

	/**
	    * f0 -> Giocatore()
	    * f1 -> <VIRGOLA>
	    * f2 -> Giocatore()
	    * f3 -> <VIRGOLA>
	    * f4 -> Giocatore()
	    * f5 -> <VIRGOLA>
	    * f6 -> Giocatore()
	    * f7 -> <VIRGOLA>
	    * f8 -> Giocatore()
	    * f9 -> <VIRGOLA>
	    * f10 -> Giocatore()
	    * f11 -> <VIRGOLA>
	    * f12 -> Giocatore()
	    * f13 -> <VIRGOLA>
	    * f14 -> Giocatore()
	    * f15 -> <VIRGOLA>
	    * f16 -> Giocatore()
	    */
	public void visit(LineUp n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("LineUp");
		n.f0.accept(this);
		nodo.add(albero);
		n.f1.accept(this);
		n.f2.accept(this);
		nodo.add(albero);
		n.f3.accept(this);
		n.f4.accept(this);
		nodo.add(albero);
		n.f5.accept(this);
		n.f6.accept(this);
		nodo.add(albero);
		n.f7.accept(this);
		n.f8.accept(this);
		nodo.add(albero);
		n.f9.accept(this);
		n.f10.accept(this);
		nodo.add(albero);
		n.f11.accept(this);
		n.f12.accept(this);
		nodo.add(albero);
		n.f13.accept(this);
		n.f14.accept(this);
		nodo.add(albero);
		this.albero = nodo;
	}

	/**
	    * f0 -> <CIFRA_NON_NULLA>
	    * f1 -> <NOME>
	    * f2 -> <POSIZIONE_DIFESA>
	    */
	public void visit(Giocatore n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Giocatore");
		n.f0.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f0.toString()));
		n.f1.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f1.toString()));
		n.f2.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f2.toString()));
		this.albero = nodo;
	}


	   /**
	    * f0 -> ( Inning() )+
	    */
	public void visit(SezioneC n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("SezioneC");
		for(Enumeration<Node> nodi = n.f0.elements(); nodi.hasMoreElements();){
			nodi.nextElement().accept(this);
			nodo.add(albero);}
		this.albero = nodo;
	}

	/**
	    * f0 -> "Attacco squadra ospite:"
	    * f1 -> Attacco()
	    * f2 -> "Attacco squadra casa:"
	    * f3 -> Attacco()
	    */
	public void visit(Inning n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Inning");
		n.f0.accept(this);
		n.f1.accept(this);
		nodo.add(albero);
		n.f2.accept(this);
		n.f3.accept(this);
		nodo.add(albero);
		this.albero = nodo;
	}

	 /**
	    * f0 -> ( Battuta() )+
	    */
	public void visit(Attacco n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Attacco");
		for(Enumeration<Node> nodi = n.f0.elements(); nodi.hasMoreElements();){
			nodi.nextElement().accept(this);
			nodo.add(albero);}
		this.albero = nodo;
	}

	 /**
	    * f0 -> ( Lancio() )+
	    */
	public void visit(Battuta n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Battuta");
		for(Enumeration<Node> nodi = n.f0.elements(); nodi.hasMoreElements();){
			nodi.nextElement().accept(this);
			nodo.add(albero);}
		this.albero = nodo;
	}

	/**
	    * f0 -> Giocatore()
	    * f1 -> <VIRGOLA>
	    * f2 -> EffettoBattuta()
	    * f3 -> <PVIRGOLA>
	    */
	public void visit(Lancio n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Lancio");
		n.f0.accept(this);
		nodo.add(albero);
		n.f1.accept(this);
		n.f2.accept(this);
		nodo.add(albero);
		n.f3.accept(this);
		this.albero = nodo;
	}

	/**
	    * f0 -> PallaBattuta()
	    *       | PallaNonBattuta()
	    */
	public void visit(EffettoBattuta n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("EffettoBattuta");
		n.f0.accept(this);
		nodo.add(albero);
		this.albero = nodo;
	}

	   /**
	    * f0 -> Esito()
	    * f1 -> ( Avanzamento() )*
	    */
	public void visit(PallaBattuta n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("PallaBattuta");
		n.f0.accept(this);
		nodo.add(albero);
		if (n.f1.present()){
			for(Enumeration<Node> nodi = n.f1.elements(); nodi.hasMoreElements();){
                nodi.nextElement().accept(this);
                nodo.add(albero);}
        }
        this.albero = nodo;
	}

	   /**
	    * f0 -> <TIPO_LANCIO>
	    * f1 -> ( Esito() )?
	    * f2 -> ( Avanzamento() )*
	    */
	public void visit(PallaNonBattuta n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("PallaNonBattuta");
		n.f0.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f0.toString()));//<----- boh!! da vedere
		if(n.f1.present()){
            n.f1.accept(this);
            nodo.add(albero);}
		if (n.f2.present()){
			for(Enumeration<Node> nodi = n.f2.elements(); nodi.hasMoreElements();){
                nodi.nextElement().accept(this);
                nodo.add(albero);}
        }
        this.albero = nodo;
	}

	 /**
	    * f0 -> ArrivoInBase()
	    *       | Eliminazione()
	    */
	public void visit(Esito n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Esito");
		n.f0.accept(this);
		nodo.add(albero);
		this.albero = nodo;
	}

	/**
	    * f0 -> Giocatore()
	    * f1 -> Esito()
	    */
	public void visit(Avanzamento n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Avanzamento");
		n.f0.accept(this);
		nodo.add(albero);
		n.f1.accept(this);
		nodo.add(albero);
		this.albero = nodo;
	}

	/**
	    * f0 -> Base()
	    *       | BaseSuBall()
	    *       | Interferenza()
	    *       | BaseRubata()
	    *       | Errore()
	    */
	public void visit(ArrivoInBase n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Arrivo In Base");
		n.f0.accept(this);
		nodo.add(albero);
		this.albero = nodo;		
	}

	 /**
	    * f0 -> StrikeOut()
	    *       | OutVolo()
	    *       | OutSuBase()
	    *       | OutRubata()
	    */
	public void visit(Eliminazione n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Eliminazione");
		n.f0.accept(this);
		nodo.add(albero);
		this.albero = nodo;
	}

	


	public TreeNode getTreeNode() {
		return this.albero;
	}
	/**
	    * f0 -> <BASE>
	    */
	public void visit(Base n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Base");
		n.f0.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f0.toString()));
		this.albero = nodo;
	}
	/**
	    * f0 -> <BASE_SU_BALL>
	    */
	public void visit(BaseSuBall n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Base su Ball");
		n.f0.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f0.toString()));
		this.albero = nodo;
	}
	 /**
	    * f0 -> <INTERFERENZA>
	    */
	public void visit(Interferenza n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Interferenza");
		n.f0.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f0.toString()));
		this.albero = nodo;
	}
	/**
	    * f0 -> <BASE_RUBATA>
	    */
	public void visit(BaseRubata n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Base Rubata");
		n.f0.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f0.toString()));
		this.albero = nodo;
	}
	/**
	    * f0 -> <ERRORE>
	    * f1 -> <CIFRA_NON_NULLA>
	    * f2 -> <BASE>
	    */
	public void visit(Errore n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Errore");
		n.f0.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f0.toString()));
		n.f1.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f1.toString()));
		n.f2.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f2.toString()));
		this.albero = nodo;
	}
	/**
	    * f0 -> <K>
	    */
	public void visit(StrikeOut n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Strike Out");
		n.f0.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f0.toString()));
		this.albero = nodo;
	}
	/**
	    * f0 -> <OUT_VOLO>
	    * f1 -> <CIFRA_NON_NULLA>
	    */
	public void visit(OutVolo n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Out al volo");
		n.f0.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f0.toString()));
		n.f1.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f1.toString()));
		this.albero = nodo;
	}
	/**
	    * f0 -> <CIFRA_NON_NULLA>
	    * f1 -> <CIFRA_NON_NULLA>
	    */
	public void visit(OutSuBase n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Out sulla base");
		n.f0.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f0.toString()));
		n.f1.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f1.toString()));
		this.albero = nodo;
	}
	/**
	    * f0 -> <OUT_RUBATA>
	    * f1 -> <CIFRA_NON_NULLA>
	    */
	public void visit(OutRubata n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Out su rubata");
		n.f0.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f0.toString()));
		n.f1.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f1.toString()));
		this.albero = nodo;
	}
	   /**
	    * f0 -> <COLPITO>
	    */
	public void visit(Colpito n) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Colpito");
		n.f0.accept(this);
		nodo.add(new DefaultMutableTreeNode(n.f0.toString()));
		this.albero = nodo;
	}
}
