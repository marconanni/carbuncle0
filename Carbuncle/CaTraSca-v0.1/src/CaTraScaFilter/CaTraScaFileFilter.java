/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CaTraScaFilter;

import java.io.File;
import javax.swing.filechooser.FileFilter;


/**
 *
 * @author raimondo
 */
public class CaTraScaFileFilter  extends FileFilter {

   
    protected static String ACCEPTED_EXT;
    protected static String CONF_PROP_FILE_NAME;
    
     public CaTraScaFileFilter(String s)
     {
        ACCEPTED_EXT = s;
        CONF_PROP_FILE_NAME = "Solo file " + ACCEPTED_EXT;
    }
    
    
    
    public boolean accept(File f)
    {
        if (f.isDirectory()) {
            return true;
        }

        String extension = UtilExtension.getExtension(f);
        if (extension != null) {
            if (extension.equals(this.ACCEPTED_EXT) ) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return this.ACCEPTED_EXT;
    }
}
