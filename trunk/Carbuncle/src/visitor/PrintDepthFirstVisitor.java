package visitor;
import syntaxtree.*;

import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class PrintDepthFirstVisitor implements Visitor {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public void visit(NodeList n) {
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
         e.nextElement().accept(this);
   }

   public void visit(NodeListOptional n) {
      if ( n.present() )
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
            e.nextElement().accept(this);
   }

   public void visit(NodeOptional n) {
      if ( n.present() )
         n.node.accept(this);
   }

   public void visit(NodeSequence n) {
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
         e.nextElement().accept(this);
   }

   public void visit(NodeToken n) {System.out.println("token: "+n.toString()); }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> <PERSONAGGIO>
    * f1 -> Azione()
    * f2 -> Bersaglio()
    */
   public void visit(S n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
   }

   /**
    * f0 -> <ALLEATI>
    *       | <NEMICI>
    *       | <PERSONAGGIO>
    */
   public void visit(Bersaglio n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> <ATTACCO>
    *       | Magia()
    *       | Oggetto()
    *       | Invocazione()
    *       | TecnicaSpeciale()
    */
   public void visit(Azione n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> "lancia"
    * f1 -> ( <ELEMENTALE> | <NONELEMENTALE> | <DISTATO> | <BIANCA> )
    * f2 -> <SU>
    */
   public void visit(Magia n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
   }

   /**
    * f0 -> "usa"
    * f1 -> <NOMEOGGETTO>
    * f2 -> <SU>
    */
   public void visit(Oggetto n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
   }

   /**
    * f0 -> "invoca"
    * f1 -> <GF>
    * f2 -> <SU>
    */
   public void visit(Invocazione n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
   }

   /**
    * f0 -> "esegue"
    * f1 -> <NOMETECNICA>
    * f2 -> <SU>
    */
   public void visit(TecnicaSpeciale n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
   }

}
