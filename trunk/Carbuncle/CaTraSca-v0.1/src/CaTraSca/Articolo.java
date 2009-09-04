/*
 * Un Articolo è la concretizzazione di un prodotto, ovvero e' l'oggetto
 * che puo' essere utilizzato, che puo' esistere in un Magazzino,
 * a differenza del Prodotto che rappresenta l'astrazione dell'Articolo
 */

package CaTraSca;

import CaTraSca.*;

/**
 *
 * @author Davide Candeloro
 */
public class Articolo
{
    private Prodotto _prodotto = null;
    private int _quantita = 0;

    public Prodotto getProdotto()
    {
        return _prodotto;
    }

    public void setProdotto(Prodotto prodotto)
    {
        _prodotto = prodotto;
    }

    public int getQuantita()
    {
        return _quantita;
    }

    public void setQuantita(int quantita)
    {
        if (quantita >= 0)
            _quantita = quantita;
    }

    public Articolo(Prodotto prodotto, int quantita)
    {
        _prodotto = prodotto;
        _quantita = quantita;
    }

    public Articolo(Prodotto prodotto)
    {
        _prodotto = prodotto;
    }

    /**
     * Aumenta la quantita' della giacenza dell'articolo.
     * @param quantita int che si aggiunge alla quantita' esistente dell'articolo.
     */
    public void add(int quantita)
    {
        this.setQuantita(this.getQuantita() + quantita);
    }

    /**
     * Diminuisce, se possibile, la quantita' della giacenza dell'articolo.
     * @param quantita int che si sottrae alla quantita' esistente dell'articolo.
     */
    public boolean sub(int quantita)
    {
        if (this.getQuantita() >= quantita)
        {
            this.setQuantita(this.getQuantita() - quantita);
            return true;
        }

        return false;
    }
}
