/*
 * Indica la quantità di un Articolo utilizzata in una trasformazione
 */

package CaTraSca;


/**
 *
 * @author Davide Candeloro
 */
public class Utilizzo
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

    public Utilizzo(Articolo articolo, int quantita) throws CaTraScaException
    {
        if (quantita > 0)
        {
            _articolo = articolo;
            _quantita = quantita;
        }
    }

    public Utilizzo() { }
}
