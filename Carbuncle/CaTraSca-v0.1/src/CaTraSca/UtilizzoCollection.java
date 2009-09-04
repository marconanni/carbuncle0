/*
 * Collezione di Articoli utilizzati per una Trasformazione
 */

package CaTraSca;

import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author Davide Candeloro
 */
public class UtilizzoCollection<E> extends Vector<E>
{
    public UtilizzoCollection() { super(); }
    public UtilizzoCollection(Collection<? extends E> c) { super (c); }
}
