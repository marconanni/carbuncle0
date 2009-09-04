/*
 * Articoli contenuti all'interno di un Magazzino
 */

package CaTraSca;

import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author Davide Candeloro
 */
public class ArticoloCollection<Articolo> extends Vector<Articolo>
{
    public ArticoloCollection() { super(); }
    public ArticoloCollection(Collection<? extends Articolo> c) { super (c); }
}
