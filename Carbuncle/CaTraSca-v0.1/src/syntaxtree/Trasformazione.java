//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "TRASFORMAZIONE:"
 * f1 -> Materia()
 * f2 -> ( "+" Materia() )*
 * f3 -> "="
 * f4 -> Materia()
 * f5 -> ( "+" Materia() )*
 */
public class Trasformazione implements Node {
   public NodeToken f0;
   public Materia f1;
   public NodeListOptional f2;
   public NodeToken f3;
   public Materia f4;
   public NodeListOptional f5;

   public Trasformazione(NodeToken n0, Materia n1, NodeListOptional n2, NodeToken n3, Materia n4, NodeListOptional n5) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
   }

   public Trasformazione(Materia n0, NodeListOptional n1, Materia n2, NodeListOptional n3) {
      f0 = new NodeToken("TRASFORMAZIONE:");
      f1 = n0;
      f2 = n1;
      f3 = new NodeToken("=");
      f4 = n2;
      f5 = n3;
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

