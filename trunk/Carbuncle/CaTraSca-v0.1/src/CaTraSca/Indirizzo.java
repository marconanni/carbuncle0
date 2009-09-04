/*
 * Descrizione di un indirizzo
 */

package CaTraSca;

/**
 *
 * @author Davide Candeloro
 */
public class Indirizzo
{
    private String _via = null;
    private int _ncivico = 0;
    private int _cap = 0;
    private String _citta = null;

    public String getVia()
    {
        return (_via != null)? _via : "non inserita";
    }

    public void setVia(String via)
    {
        _via = via;
    }

    public int getNcivico()
    {
        return _ncivico;
    }

    public void setNcivico(int ncivico)
    {
        _ncivico = ncivico;
    }

    public int getCap()
    {
        return _cap;
    }

    public void setCap(int cap)
    {
        _cap = cap;
    }

    public String getCitta()
    {
        return (_citta != null)? _citta : "non inserita";
    }

    public void setCitta(String citta)
    {
        _citta = citta;
    }

    public Indirizzo(String via, int ncivico, int cap, String citta)
    {
        _via = via;
        _ncivico = ncivico;
        _cap = cap;
        _citta = citta;
    }

    public Indirizzo(String via, int cap, String citta)
    {
        _via = via;
        _ncivico = 0;
        _cap = cap;
        _citta = citta;
    }
}
