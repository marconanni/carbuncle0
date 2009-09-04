package CaTraSca.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class YesNoDialog extends JDialog
{
    private String _nome;

    public YesNoDialog(String nome)
    {
        _nome = nome;
    }

    public int setVisible()
    {
        JOptionPane pane = new JOptionPane(
        "E' già presente un file con il nome " + _nome + ".\nSovrascriverlo?");
        Object[] options = new String[] { "Si'", "No" };
        pane.setOptions(options);
        JDialog dialog = pane.createDialog(new JFrame(), "Dilaog");
        dialog.setVisible(true);
        Object obj = pane.getValue();
        int result = -1;
        
        for (int k = 0; k < options.length; k++)
          if (options[k].equals(obj))
          {
            result = k;
            break;
          }

        return result;
    }
}

