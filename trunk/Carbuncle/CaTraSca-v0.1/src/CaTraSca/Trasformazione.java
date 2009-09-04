/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CaTraSca;

import java.util.Iterator;

/**
 *
 * @author Davide Candeloro
 */
public class Trasformazione extends Azione
{
    private CreazioneCollection<Creazione> _creazioni = new CreazioneCollection<Creazione>();
    private UtilizzoCollection<Utilizzo> _utilizzi = new UtilizzoCollection<Utilizzo>();
    
    public UtilizzoCollection<Utilizzo> getUtilizzi()
    {
        return _utilizzi;
    }

    public void setUtilizzi(UtilizzoCollection<Utilizzo> utilizzi)
    {
        _utilizzi = utilizzi;
    }

    public CreazioneCollection<Creazione> getCreazioni()
    {
        return _creazioni;
    }

    public void setCreazioni(CreazioneCollection<Creazione> creazioni)
    {
        _creazioni = creazioni;
    }

    public Trasformazione(){}

    public Trasformazione(UtilizzoCollection<Utilizzo> utilizzi, CreazioneCollection<Creazione> creazioni) throws CaTraScaException
    {
        if (utilizzi == null || utilizzi.isEmpty())
            throw new CaTraScaException("Si sta tendando di allocare una " +
                    "Trasformazione senza utilizzare materie prime.");
        
        _utilizzi = utilizzi;

        if (creazioni == null || creazioni.isEmpty())
            throw new CaTraScaException("Si sta tendando di allocare una " +
                    "Trasformazione senza creare nessun prodotto finito.");

        _creazioni = creazioni;
    }

    /**
     * Effettua un'operazione di trasformazione in base agli utilizzi e alle creazioni (già caricati).
     * @param articoli vettore contenente tutti gli articoli, compresi naturalmente quelli che devono essere utilizzati o creati.
     * @throws  CaTraScaException
     * se il vettore di articoli non contiene almeno 1 degli articoli che si vogliono utilizzare oppure lo contiene
     * ma in quantita' minore di quella necessaria
     */
    public void Fai(ArticoloCollection<Articolo> articoli) throws CaTraScaException
    {
        for (Iterator<Utilizzo> it = _utilizzi.iterator(); it.hasNext();) {
            Utilizzo utilizzo = it.next();

            if (articoli.contains(utilizzo.getArticolo()))
                if (articoli.get(articoli.indexOf(utilizzo.getArticolo())).getQuantita() >= utilizzo.getQuantita())
                    articoli.get(articoli.indexOf(utilizzo.getArticolo())).sub(utilizzo.getQuantita());
                else
                    throw new CaTraScaException("ERRORE:\nSi sta tentando di UTILIZZARE piu\' articoli (" + utilizzo.getQuantita() + " di " +
                            "" + articoli.get(articoli.indexOf(utilizzo.getArticolo())).getProdotto().getMarca() + " " +
                            articoli.get(articoli.indexOf(utilizzo.getArticolo())).getProdotto().getModello() + ") di quanti ne sono presenti" +
                            " in magazzino (" + articoli.get(articoli.indexOf(utilizzo.getArticolo())).getQuantita() + ").");
            else
                throw new CaTraScaException("ERRORE:\nSi sta tentando di UTILIZZARE un articolo (" + utilizzo.getArticolo().getProdotto().getMarca() + " " +
                         utilizzo.getArticolo().getProdotto().getModello() + ") non presente in magazzino.");
        }

        for (Iterator<Creazione> it = _creazioni.iterator(); it.hasNext();) {
            Creazione creazione = it.next();

            if (articoli.contains(creazione.getArticolo()))
                articoli.get(articoli.indexOf(creazione.getArticolo())).add(creazione.getQuantita());
            else
                articoli.add(new Articolo(new Prodotto(creazione.getArticolo().getProdotto().getMarca(),creazione.getArticolo().getProdotto().getModello()), creazione.getQuantita()));
        }
    }
}
