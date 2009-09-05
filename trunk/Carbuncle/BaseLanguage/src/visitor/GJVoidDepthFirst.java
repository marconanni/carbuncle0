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
    * f0 -> SezioneA()
    * f1 -> SezioneB()
    * f2 -> "{"
    * f3 -> SezioneC()
    * f4 -> "}"
    */
   public void visit(S n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
   }

   /**
    * f0 -> Squadre()
    * f1 -> Arbitro()
    */
   public void visit(SezioneA n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> "Squadra Ospite:"
    * f1 -> <NOME>
    * f2 -> ","
    * f3 -> "Squadra Casa:"
    * f4 -> <NOME>
    * f5 -> ";"
    */
   public void visit(Squadre n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
   }

   /**
    * f0 -> "Arbitro:"
    * f1 -> <NOME>
    * f2 -> ";"
    */
   public void visit(Arbitro n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> ListaLineUp()
    */
   public void visit(SezioneB n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> "Line-Up squadra ospite:"
    * f1 -> LineUp()
    * f2 -> ";"
    * f3 -> "Line-Up squadra casa:"
    * f4 -> LineUp()
    * f5 -> ";"
    */
   public void visit(ListaLineUp n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
   }

   /**
    * f0 -> Giocatore()
    * f1 -> ","
    * f2 -> Giocatore()
    * f3 -> ","
    * f4 -> Giocatore()
    * f5 -> ","
    * f6 -> Giocatore()
    * f7 -> ","
    * f8 -> Giocatore()
    * f9 -> ","
    * f10 -> Giocatore()
    * f11 -> ","
    * f12 -> Giocatore()
    * f13 -> ","
    * f14 -> Giocatore()
    * f15 -> ","
    * f16 -> Giocatore()
    */
   public void visit(LineUp n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      n.f8.accept(this, argu);
      n.f9.accept(this, argu);
      n.f10.accept(this, argu);
      n.f11.accept(this, argu);
      n.f12.accept(this, argu);
      n.f13.accept(this, argu);
      n.f14.accept(this, argu);
      n.f15.accept(this, argu);
      n.f16.accept(this, argu);
   }

   /**
    * f0 -> <NOME>
    * f1 -> <CIFRA_NON_NULLA>
    * f2 -> <POSIZIONE_DIFESA>
    */
   public void visit(Giocatore n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> ( Inning() )+
    */
   public void visit(SezioneC n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> "Attacco squadra ospite:"
    * f1 -> Attacco()
    * f2 -> "Attacco squadra casa:"
    * f3 -> Attacco()
    */
   public void visit(Inning n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
   }

   /**
    * f0 -> ( "(" Battuta() ")" )+
    */
   public void visit(Attacco n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> ( Lancio() )+
    */
   public void visit(Battuta n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> Giocatore()
    * f1 -> ","
    * f2 -> EffettoBattuta()
    * f3 -> ";"
    */
   public void visit(Lancio n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
   }

   /**
    * f0 -> PallaBattuta()
    *       | PallaNonBattuta()
    */
   public void visit(EffettoBattuta n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> Esito()
    * f1 -> ( Avanzamento() )*
    */
   public void visit(PallaBattuta n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> <TIPO_LANCIO>
    * f1 -> ( Esito() )?
    * f2 -> ( Avanzamento() )*
    */
   public void visit(PallaNonBattuta n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> ArrivoInBase()
    *       | Eliminazione()
    */
   public void visit(Esito n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> Giocatore()
    * f1 -> Esito()
    */
   public void visit(Avanzamento n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> Base()
    *       | BaseSuBall()
    *       | Interferenza()
    *       | BaseRubata()
    *       | Errore()
    *       | Colpito()
    */
   public void visit(ArrivoInBase n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> StrikeOut()
    *       | OutVolo()
    *       | OutSuBase()
    *       | OutRubata()
    */
   public void visit(Eliminazione n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <BASE>
    */
   public void visit(Base n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <BASE_SU_BALL>
    */
   public void visit(BaseSuBall n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <COLPITO>
    */
   public void visit(Colpito n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <INTERFERENZA>
    */
   public void visit(Interferenza n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <BASE_RUBATA>
    * f1 -> <BASE>
    */
   public void visit(BaseRubata n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> <ERRORE>
    * f1 -> <CIFRA_NON_NULLA>
    * f2 -> <BASE>
    */
   public void visit(Errore n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> <K>
    */
   public void visit(StrikeOut n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <OUT_VOLO>
    * f1 -> <CIFRA_NON_NULLA>
    */
   public void visit(OutVolo n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> <CIFRA_NON_NULLA>
    * f1 -> <CIFRA_NON_NULLA>
    */
   public void visit(OutSuBase n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> <OUT_RUBATA>
    * f1 -> <CIFRA_NON_NULLA>
    */
   public void visit(OutRubata n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

}
