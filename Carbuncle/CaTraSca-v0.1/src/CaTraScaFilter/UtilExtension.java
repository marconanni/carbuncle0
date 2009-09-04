/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CaTraScaFilter;

import java.io.File;

/**
 *
 * @author Davide Candeloro
 */
public class UtilExtension {

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}

