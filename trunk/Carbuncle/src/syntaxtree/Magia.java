//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "lancia"
 * f1 -> ( <ELEMENTALE> | <NONELEMENTALE> | <DISTATO> | <BIANCA> )
 * f2 -> <SU>
 */
public class Magia implements Node {
   public NodeToken f0;
   public NodeChoice f1;
   public NodeToken f2;

   public Magia(NodeToken n0, NodeChoice n1, NodeToken n2) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
   }

   public Magia(NodeChoice n0) {
      f0 = new NodeToken("lancia");
      f1 = n0;
      f2 = new NodeToken("su");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

