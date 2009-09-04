//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "CaTraSca"
 * f1 -> "{"
 * f2 -> [ Continue() ]
 * f3 -> Magazzino()
 * f4 -> ";"
 * f5 -> ( Periodico() )+
 * f6 -> "}"
 */
public class Scope implements Node {
   public NodeToken f0;
   public NodeToken f1;
   public NodeOptional f2;
   public Magazzino f3;
   public NodeToken f4;
   public NodeList f5;
   public NodeToken f6;

   public Scope(NodeToken n0, NodeToken n1, NodeOptional n2, Magazzino n3, NodeToken n4, NodeList n5, NodeToken n6) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
      f6 = n6;
   }

   public Scope(NodeOptional n0, Magazzino n1, NodeList n2) {
      f0 = new NodeToken("CaTraSca");
      f1 = new NodeToken("{");
      f2 = n0;
      f3 = n1;
      f4 = new NodeToken(";");
      f5 = n2;
      f6 = new NodeToken("}");
   }

   @Override
   public void accept(visitor.Visitor v) {
      v.visit(this);
   }

   @Override
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }

   @Override
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }

   @Override
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}