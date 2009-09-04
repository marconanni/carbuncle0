/*
 * La concretizzazione del Movimento di un Articolo
 * (il Movimento generico puo' interessare piu' Articoli)
 */

package CaTraSca;


/**
 *
 * @author Davide Candeloro
 */
public class MovimentoEffettivo
{
    private Articolo _articolo = null;
    private int _quantita = 0;

    public Articolo getArticolo()
    {
        return _articolo;
    }

    public void setArticolo(Articolo articolo)
    {
        _articolo = articolo;
    }

    public int getQuantita()
    {
        return _quantita;
    }

    public void setQuantita(int quantita)
    {
        if (quantita > 0)
            _quantita = quantita;
    }

    public MovimentoEffettivo(Articolo articolo, int quantita) throws CaTraScaException
    {
        if (quantita <= 0)
            throw new CaTraScaException("Si sta tentando di effettuare un " +
                    "movimento di quantita' minore di zero o nulla");

        _articolo = articolo;
        _quantita = quantita;
    }
}
