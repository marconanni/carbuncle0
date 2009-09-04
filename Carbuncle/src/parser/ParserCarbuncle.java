package parser;
/* Generated By:JavaCC: Do not edit this line. ParserCarbuncle.java */
import syntaxtree.*;
import java.util.Vector;


public class ParserCarbuncle implements ParserCarbuncleConstants {

  static final public S S() throws ParseException {
   NodeToken n0;
   Token n1;
   Azione n2;
   Bersaglio n3;
    n1 = jj_consume_token(PERSONAGGIO);
                      n0 = JTBToolkit.makeNodeToken(n1);
    n2 = Azione();
    n3 = Bersaglio();
     {if (true) return new S(n0,n2,n3);}
    throw new Error("Missing return statement in function");
  }

  static final public Bersaglio Bersaglio() throws ParseException {
   NodeChoice n0;
   NodeToken n1;
   Token n2;
   NodeToken n3;
   Token n4;
   NodeToken n5;
   Token n6;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ALLEATI:
      n2 = jj_consume_token(ALLEATI);
                     n1 = JTBToolkit.makeNodeToken(n2);
        n0 = new NodeChoice(n1, 0);
      break;
    case NEMICI:
      n4 = jj_consume_token(NEMICI);
                    n3 = JTBToolkit.makeNodeToken(n4);
        n0 = new NodeChoice(n3, 1);
      break;
    case PERSONAGGIO:
      n6 = jj_consume_token(PERSONAGGIO);
                         n5 = JTBToolkit.makeNodeToken(n6);
        n0 = new NodeChoice(n5, 2);
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return new Bersaglio(n0);}
    throw new Error("Missing return statement in function");
  }

  static final public Azione Azione() throws ParseException {
   NodeChoice n0;
   NodeToken n1;
   Token n2;
   Magia n3;
   Oggetto n4;
   Invocazione n5;
   TecnicaSpeciale n6;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ATTACCO:
      n2 = jj_consume_token(ATTACCO);
                     n1 = JTBToolkit.makeNodeToken(n2);
        n0 = new NodeChoice(n1, 0);
      break;
    case 1:
      n3 = Magia();
        n0 = new NodeChoice(n3, 1);
      break;
    case 2:
      n4 = Oggetto();
        n0 = new NodeChoice(n4, 2);
      break;
    case 3:
      n5 = Invocazione();
        n0 = new NodeChoice(n5, 3);
      break;
    case 4:
      n6 = TecnicaSpeciale();
        n0 = new NodeChoice(n6, 4);
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return new Azione(n0);}
    throw new Error("Missing return statement in function");
  }

  static final public Magia Magia() throws ParseException {
   NodeToken n0;
   Token n1;
   NodeChoice n2;
   NodeToken n3;
   Token n4;
   NodeToken n5;
   Token n6;
   NodeToken n7;
   Token n8;
   NodeToken n9;
   Token n10;
   NodeToken n11;
   Token n12;
    n1 = jj_consume_token(1);
                 n0 = JTBToolkit.makeNodeToken(n1);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELEMENTALE:
      n4 = jj_consume_token(ELEMENTALE);
                           n3 = JTBToolkit.makeNodeToken(n4);
           n2 = new NodeChoice(n3, 0);
      break;
    case NONELEMENTALE:
      n6 = jj_consume_token(NONELEMENTALE);
                              n5 = JTBToolkit.makeNodeToken(n6);
           n2 = new NodeChoice(n5, 1);
      break;
    case DISTATO:
      n8 = jj_consume_token(DISTATO);
                        n7 = JTBToolkit.makeNodeToken(n8);
           n2 = new NodeChoice(n7, 2);
      break;
    case BIANCA:
      n10 = jj_consume_token(BIANCA);
                        n9 = JTBToolkit.makeNodeToken(n10);
           n2 = new NodeChoice(n9, 3);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    n12 = jj_consume_token(SU);
              n11 = JTBToolkit.makeNodeToken(n12);
     {if (true) return new Magia(n0,n2,n11);}
    throw new Error("Missing return statement in function");
  }

  static final public Oggetto Oggetto() throws ParseException {
   NodeToken n0;
   Token n1;
   NodeToken n2;
   Token n3;
   NodeToken n4;
   Token n5;
    n1 = jj_consume_token(2);
              n0 = JTBToolkit.makeNodeToken(n1);
    n3 = jj_consume_token(NOMEOGGETTO);
                      n2 = JTBToolkit.makeNodeToken(n3);
    n5 = jj_consume_token(SU);
             n4 = JTBToolkit.makeNodeToken(n5);
     {if (true) return new Oggetto(n0,n2,n4);}
    throw new Error("Missing return statement in function");
  }

  static final public Invocazione Invocazione() throws ParseException {
   NodeToken n0;
   Token n1;
   NodeToken n2;
   Token n3;
   NodeToken n4;
   Token n5;
    n1 = jj_consume_token(3);
                 n0 = JTBToolkit.makeNodeToken(n1);
    n3 = jj_consume_token(GF);
             n2 = JTBToolkit.makeNodeToken(n3);
    n5 = jj_consume_token(SU);
             n4 = JTBToolkit.makeNodeToken(n5);
     {if (true) return new Invocazione(n0,n2,n4);}
    throw new Error("Missing return statement in function");
  }

  static final public TecnicaSpeciale TecnicaSpeciale() throws ParseException {
   NodeToken n0;
   Token n1;
   NodeToken n2;
   Token n3;
   NodeToken n4;
   Token n5;
    n1 = jj_consume_token(4);
                 n0 = JTBToolkit.makeNodeToken(n1);
    n3 = jj_consume_token(NOMETECNICA);
                      n2 = JTBToolkit.makeNodeToken(n3);
    n5 = jj_consume_token(SU);
             n4 = JTBToolkit.makeNodeToken(n5);
     {if (true) return new TecnicaSpeciale(n0,n2,n4);}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ParserCarbuncleTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[3];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x160000,0x21e,0x3c00,};
   }

  /** Constructor with InputStream. */
  public ParserCarbuncle(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ParserCarbuncle(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserCarbuncleTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ParserCarbuncle(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserCarbuncleTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ParserCarbuncle(ParserCarbuncleTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserCarbuncleTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List jj_expentries = new java.util.ArrayList();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[21];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 3; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 21; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}

class JTBToolkit {
   static NodeToken makeNodeToken(Token t) {
      return new NodeToken(t.image.intern(), t.kind, t.beginLine, t.beginColumn, t.endLine, t.endColumn);
   }
}
