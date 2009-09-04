/*
 * Carica articoli (es. aquisto)
 */

package CaTraSca;


/**
 *
 * @author Davide Candeloro
 */
public class Carico extends Movimento
{
    @Override
    /**
     * Carica articoli sulla base dei movimenti effettivi (devono essere gia' caricati).
     * Se l'articolo esiste allora ne aumenta la quantita'. Se l'articolo non esiste allora lo crea.
     * @param articoli gia' presenti.
     */
    public void Fai(ArticoloCollection<Articolo> articoli)throws CaTraScaException
    {
        for (MovimentoEffettivo movimentoEffettivo : this.getMovimentiEffettivi())
            if (articoli.contains(movimentoEffettivo.getArticolo()))
                articoli.get(articoli.indexOf(movimentoEffettivo.getArticolo())).add(movimentoEffettivo.getQuantita());
            else
                articoli.add(new Articolo(movimentoEffettivo.getArticolo().getProdotto(), movimentoEffettivo.getQuantita()));
    }

    public Carico(MovimentoEffettivoCollection<MovimentoEffettivo> movimentiEffettivi) throws CaTraScaException
    {
        super(movimentiEffettivi);
    }

    public Carico(){}
}
