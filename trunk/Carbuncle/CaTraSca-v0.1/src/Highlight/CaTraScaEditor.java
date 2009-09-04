/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Highlight;

import java.awt.Font;
import javax.swing.JEditorPane;

/**
 *
 * @author Davide Candeloro
 */
public class CaTraScaEditor extends JEditorPane{

    public CaTraScaEditor() {
        this.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
        this.setEditorKitForContentType("text/cts", new CaTraScaCodeEditorKit());
        this.setContentType("text/cts");
    }

}
