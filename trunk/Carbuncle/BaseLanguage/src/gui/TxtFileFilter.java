package gui;

import java.io.*;

class TxtFileFilter extends javax.swing.filechooser.FileFilter {
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
    }
    
    public String getDescription() {
        return ".txt files";
    }
}