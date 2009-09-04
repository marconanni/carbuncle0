/*
 * Collezione di Movimento effettivi
 */

package CaTraSca;

import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author Davide Candeloro
 */
public class MovimentoEffettivoCollection<MovimentoEffettivo> extends Vector<MovimentoEffettivo>
{
    public MovimentoEffettivoCollection() { super(); }
    public MovimentoEffettivoCollection(Collection<? extends MovimentoEffettivo> c) { super (c); }
}
