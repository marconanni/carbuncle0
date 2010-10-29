//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;

import java.util.*;

/**
 * All GJ void visitors must implement this interface.
 */

public interface GJVoidVisitor<A> {

   //
   // GJ void Auto class visitors
   //

   public void visit(NodeList n, A argu);
   public void visit(NodeListOptional n, A argu);
   public void visit(NodeOptional n, A argu);
   public void visit(NodeSequence n, A argu);
   public void visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> <PERSONAGGIO>
    * f1 -> Azione()
    * f2 -> Bersaglio()
    */
   public void visit(S n, A argu);

   /**
    * f0 -> <ALLEATI>
    *       | <NEMICI>
    *       | <PERSONAGGIO>
    */
   public void visit(Bersaglio n, A argu);

   /**
    * f0 -> <ATTACCO>
    *       | Magia()
    *       | Oggetto()
    *       | Invocazione()
    *       | TecnicaSpeciale()
    */
   public void visit(Azione n, A argu);

   /**
    * f0 -> "lancia"
    * f1 -> ( <ELEMENTALE> | <NONELEMENTALE> | <DISTATO> | <BIANCA> )
    * f2 -> <SU>
    */
   public void visit(Magia n, A argu);

   /**
    * f0 -> "usa"
    * f1 -> <NOMEOGGETTO>
    * f2 -> <SU>
    */
   public void visit(Oggetto n, A argu);

   /**
    * f0 -> "invoca"
    * f1 -> <GF>
    * f2 -> <SU>
    */
   public void visit(Invocazione n, A argu);

   /**
    * f0 -> "esegue"
    * f1 -> <NOMETECNICA>
    * f2 -> <SU>
    */
   public void visit(TecnicaSpeciale n, A argu);

}

