/*
 * Scarica articoli (es. vendita)
 */

package CaTraSca;


/**
 *
 * @author Davide Candeloro
 */
public class Scarico extends Movimento
{

    
    /**
     * Scarica articoli sulla base dei movimenti effettivi (devono essere gia' caricati).
     * @throws CaTraScaException
     * se l'articolo non esiste oppure 
     * se l'articolo presenta una quantita' minore di quella che si tenta di scaricare
     * @param articoli gia' presenti.
     */
    @Override
    public void Fai(ArticoloCollection<Articolo> articoli)throws CaTraScaException
    {
        for (MovimentoEffettivo movimentoEffettivo : this.getMovimentiEffettivi())
            if (articoli.contains(movimentoEffettivo.getArticolo()))
                if (articoli.get(articoli.indexOf(movimentoEffettivo.getArticolo())).getQuantita() >= movimentoEffettivo.getQuantita())
                    articoli.get(articoli.indexOf(movimentoEffettivo.getArticolo())).sub(movimentoEffettivo.getQuantita());
                else
                    throw new CaTraScaException("ERRORE:\nSi sta tentando di SCARICARE piu\' articoli (" + movimentoEffettivo.getQuantita() + " di " +
                            "" + articoli.get(articoli.indexOf(movimentoEffettivo.getArticolo())).getProdotto().getMarca() + " " +
                            articoli.get(articoli.indexOf(movimentoEffettivo.getArticolo())).getProdotto().getModello() + ") di quanti ne sono presenti" +
                            " in magazzino (" + articoli.get(articoli.indexOf(movimentoEffettivo.getArticolo())).getQuantita() + ").");
            else
                throw new CaTraScaException("ERRORE:\nSi sta tentando di SCARICARE un articolo (" + movimentoEffettivo.getArticolo().getProdotto().getMarca() + " " +
                         movimentoEffettivo.getArticolo().getProdotto().getModello() + ") non presente in magazzino.");
    }

    public Scarico(MovimentoEffettivoCollection<MovimentoEffettivo> movimentiEffettivi) throws CaTraScaException
    {
        super(movimentiEffettivi);
    }

    public Scarico(){}
}
