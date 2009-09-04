/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CaTraScaFilter;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Davide Candeloro
 */
public class DefaultCaTraScaFileChooser extends CaTraScaFileChooser {
    
    public  DefaultCaTraScaFileChooser(String s)
    {
        this.setCurrentDirectory(new File(System.getProperty("user.dir")));
        this.catrascaFileFilter=new CaTraScaFileFilter(s);
        this.setFileSelectionMode(JFileChooser.FILES_ONLY);
        this.addChoosableFileFilter(this.catrascaFileFilter);
        this.setAcceptAllFileFilterUsed(false);
    }

}
