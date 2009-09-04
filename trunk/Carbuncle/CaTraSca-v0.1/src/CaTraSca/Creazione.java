/*
 * Indica la quantita' di un Articolo creata a fronte di una Trasformazione
 */

package CaTraSca;


/**
 *
 * @author Davide Candeloro
 */
public class Creazione
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

    public Creazione(Articolo articolo, int quantita) throws CaTraScaException
    {
        if (quantita <= 0)
            throw new CaTraScaException("Si sta tentando di creare una " +
                    "quantita\' di un articolo minore o nullo.");
        _articolo = articolo;
        _quantita = quantita;

    }

    public Creazione() { }
}
