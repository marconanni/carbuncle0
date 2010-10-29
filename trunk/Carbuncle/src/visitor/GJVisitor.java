//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;

import java.util.*;

/**
 * All GJ visitors must implement this interface.
 */

public interface GJVisitor<R,A> {

   //
   // GJ Auto class visitors
   //

   public R visit(NodeList n, A argu);
   public R visit(NodeListOptional n, A argu);
   public R visit(NodeOptional n, A argu);
   public R visit(NodeSequence n, A argu);
   public R visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> <PERSONAGGIO>
    * f1 -> Azione()
    * f2 -> Bersaglio()
    */
   public R visit(S n, A argu);

   /**
    * f0 -> <ALLEATI>
    *       | <NEMICI>
    *       | <PERSONAGGIO>
    */
   public R visit(Bersaglio n, A argu);

   /**
    * f0 -> <ATTACCO>
    *       | Magia()
    *       | Oggetto()
    *       | Invocazione()
    *       | TecnicaSpeciale()
    */
   public R visit(Azione n, A argu);

   /**
    * f0 -> "lancia"
    * f1 -> ( <ELEMENTALE> | <NONELEMENTALE> | <DISTATO> | <BIANCA> )
    * f2 -> <SU>
    */
   public R visit(Magia n, A argu);

   /**
    * f0 -> "usa"
    * f1 -> <NOMEOGGETTO>
    * f2 -> <SU>
    */
   public R visit(Oggetto n, A argu);

   /**
    * f0 -> "invoca"
    * f1 -> <GF>
    * f2 -> <SU>
    */
   public R visit(Invocazione n, A argu);

   /**
    * f0 -> "esegue"
    * f1 -> <NOMETECNICA>
    * f2 -> <SU>
    */
   public R visit(TecnicaSpeciale n, A argu);

}
