/*
 * Descrizione di un prodotto astratto, non di un reale oggetto
 */

package CaTraSca;

/**
 *
 * @author Davide Candeloro
 */
public class Prodotto
{
    private String _marca = null;
    private String _modello = null;

    public String getMarca()
    {
        return _marca;
    }

    public void setMarca(String marca)
    {
        _marca = marca;
    }

    public String getModello()
    {
        return _modello;
    }

    public void setModello(String modello)
    {
        _modello = modello;
    }

    public Prodotto(String marca, String modello)
    {
        _marca = marca;
        _modello = modello;
    }
}
