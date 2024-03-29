//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;

import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJVoidDepthFirst<A> implements GJVoidVisitor<A> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public void visit(NodeList n, A argu) {
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
   }

   public void visit(NodeListOptional n, A argu) {
      if ( n.present() ) {
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
         }
      }
   }

   public void visit(NodeOptional n, A argu) {
      if ( n.present() )
         n.node.accept(this,argu);
   }

   public void visit(NodeSequence n, A argu) {
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
   }

   public void visit(NodeToken n, A argu) {}

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> <PERSONAGGIO>
    * f1 -> Azione()
    * f2 -> Bersaglio()
    */
   public void visit(S n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> <ALLEATI>
    *       | <NEMICI>
    *       | <PERSONAGGIO>
    */
   public void visit(Bersaglio n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <ATTACCO>
    *       | Magia()
    *       | Oggetto()
    *       | Invocazione()
    *       | TecnicaSpeciale()
    */
   public void visit(Azione n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> "lancia"
    * f1 -> ( <ELEMENTALE> | <NONELEMENTALE> | <DISTATO> | <BIANCA> )
    * f2 -> <SU>
    */
   public void visit(Magia n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> "usa"
    * f1 -> <NOMEOGGETTO>
    * f2 -> <SU>
    */
   public void visit(Oggetto n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> "invoca"
    * f1 -> <GF>
    * f2 -> <SU>
    */
   public void visit(Invocazione n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> "esegue"
    * f1 -> <NOMETECNICA>
    * f2 -> <SU>
    */
   public void visit(TecnicaSpeciale n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

}
