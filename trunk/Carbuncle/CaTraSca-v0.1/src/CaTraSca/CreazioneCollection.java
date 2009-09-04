/*
 * Collezione di creazioni dovute ad una Trasformazione
 */

package CaTraSca;

import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author Davide Candeloro
 */
public class CreazioneCollection<Creazione> extends Vector<Creazione>
{
    public CreazioneCollection() { super(); }
    public CreazioneCollection(Collection<? extends Creazione> c) { super (c); }
}
