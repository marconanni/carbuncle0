/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CaTraSca;

/**
 *
 * @author Davide Candeloro
 */
public abstract class Movimento extends Azione
{
    private MovimentoEffettivoCollection<MovimentoEffettivo> _movimentiEffettivi = new MovimentoEffettivoCollection<MovimentoEffettivo>();

    public MovimentoEffettivoCollection<MovimentoEffettivo> getMovimentiEffettivi()
    {
        return _movimentiEffettivi;
    }

    public void setMovimentiEffettivi(MovimentoEffettivoCollection<MovimentoEffettivo> movimentiEffettivi) throws CaTraScaException
    {
        if (movimentiEffettivi == null)
            throw new CaTraScaException("Si sta tentando di allocare un " +
                    "movimento privo di movimenti effettivi");
        
        _movimentiEffettivi = movimentiEffettivi;
    }

    public Movimento(MovimentoEffettivoCollection<MovimentoEffettivo> movimentiEffettivi) throws CaTraScaException
    {
        if (movimentiEffettivi == null)
            throw new CaTraScaException("Si sta tentando di allocare un " +
                    "movimento privo di movimenti effettivi");

        _movimentiEffettivi = movimentiEffettivi;
    }

    public Movimento(){}
}
