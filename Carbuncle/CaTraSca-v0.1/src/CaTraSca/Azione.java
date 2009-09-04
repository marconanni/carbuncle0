/*
 * Classa astratta che ha come figli i vari tipi di azione.
 * Nel caso base ha Trasformazione e Movimento
 */

package CaTraSca;

/**
 *
 * @author Davide Candeloro
 */
public abstract class Azione
{
    /**
     * Effettua un'azione. Dev'essere implementata dalla sue sottoclassi.
     * @throws CaTraScaException
     * @param articoli e' il vettore di articoli sul quale si effettuera' l'azione.
     */
    public abstract void Fai(ArticoloCollection<Articolo> articoli)throws CaTraScaException;
}
