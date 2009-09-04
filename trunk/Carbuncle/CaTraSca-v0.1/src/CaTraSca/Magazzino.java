/*
 * Descrizione del Magazzino
 */

package CaTraSca;

import java.util.Iterator;

/**
 *
 * @author Davide Candeloro
 */
public class Magazzino
{
    private String _nome;
    private Indirizzo _indirizzo = null;
    private ArticoloCollection<Articolo> _articoli = new ArticoloCollection<Articolo>();

    public String getNome()
    {
        return (_nome != null)? _nome : "non inserito";
    }

    public void setNome(String nome)
    {
        _nome = nome;
    }

    public Indirizzo getIndirizzo()
    {
        return (_indirizzo != null)? _indirizzo : new Indirizzo(null,0,null);
    }

    public void setIndirizzo(Indirizzo indirizzo)
    {
        _indirizzo = indirizzo;
    }

    public Magazzino(String nome, Indirizzo indirizzo, ArticoloCollection<Articolo> articoli)
    {
        _nome = nome;
        _indirizzo = indirizzo;
        _articoli = articoli;
    }

    public Magazzino(String nome, Indirizzo indirizzo)
    {
        _nome = nome;
        _indirizzo = indirizzo;
    }

    public ArticoloCollection<Articolo> getArticoli()
    {
        return _articoli;
    }

    public void setArticoli(ArticoloCollection<Articolo> articoli)
    {
        _articoli = articoli;
    }

    public Magazzino(String nome)
    {
        _nome = nome;
    }

    /**
     * Effettua una copia degli articoli presenti in magazzino.
     * @return la copia del vettore di articoli.
     */
    public ArticoloCollection<Articolo> copiaArticoli()
    {
        ArticoloCollection<Articolo> articoli = new ArticoloCollection<Articolo>();

        for (Iterator<Articolo> it = _articoli.iterator(); it.hasNext();)
        {
            Articolo articolo = it.next();
            articoli.add(new Articolo(articolo.getProdotto(), articolo.getQuantita()));
        }

        return articoli;
    }
}
