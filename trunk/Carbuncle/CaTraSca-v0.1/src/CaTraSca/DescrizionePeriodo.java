/*
 * Descrive le azioni che si effettuano in un periodo
 */

package CaTraSca;
import java.util.*;

/**
 *
 * @author Cartell
 */

public class DescrizionePeriodo
{
    private Calendar _dataInizio = null;
    private Calendar _dataFine = null;
    private Vector<Azione> _azioni = new Vector<Azione>();

    public DescrizionePeriodo() {}

    public Calendar getDataInizio()
    {
        return _dataInizio;
    }

    /**
     * @return giorno(numero) - mese(LETTERE) - anno(numero).
     */
    public String getDataInizioString()
    {
        return _dataInizio.get(5) + "-" + Mese.values()[_dataInizio.get(2)] + "-" + _dataInizio.get(1);
    }

    public void setDataInizio(Calendar dataInizio)
    {
        _dataInizio = dataInizio;
    }

    /**
     * Imposta la data iniziale sulla base del giorno, mese e anno.
     * @param giorno .
     * @param mese .
     * @param anno .
     */
    public void setDataInizio(int giorno, String mese, int anno)
    {
        _dataInizio = GregorianCalendar.getInstance();
        _dataInizio.set(anno, CaTraSca.Mese.valueOf(mese).ordinal(), giorno);
    }

    public Calendar getDataFine()
    {
        return _dataFine;
    }

    /**
     * @return giorno(numero) - mese(LETTERE) - anno(numero).
     */
    public String getDataFineString()
    {
        return _dataFine.get(5) + "-" + Mese.values()[_dataFine.get(2)] + "-" + _dataFine.get(1);
    }

    public void setDataFine(Calendar dataFine)
    {
        _dataFine = dataFine;
    }

    /**
     * Imposta la data finale sulla base del giorno, mese e anno.
     * @param giorno .
     * @param mese .
     * @param anno .
     */
    public void setDataFine(int giorno, String mese, int anno)
    {
        _dataFine = GregorianCalendar.getInstance();
        _dataFine.set(anno, CaTraSca.Mese.valueOf(mese).ordinal(), giorno);
    }

    public Vector<Azione> getAzioni()
    {
        return _azioni;
    }

    public void setAzioni(Vector<Azione> azioni)
    {
        _azioni = azioni;
    }
}
