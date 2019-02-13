/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.classes;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Wellington Soares da Luz
 */
public class Alert {

    public static void error(Object msg) {
        JOptionPane.showMessageDialog(null, msg, "", JOptionPane.ERROR_MESSAGE);
    }

    public static void error(Object msg, String titulo) {
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void info(Object msg) {
        JOptionPane.showMessageDialog(null, msg, "", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void info(Object msg, String titulo) {
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void warning(Object msg, String titulo) {
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.WARNING_MESSAGE);
    }

    public static void warning(Object msg) {
        JOptionPane.showMessageDialog(null, msg, "", JOptionPane.WARNING_MESSAGE);
    }

    public static boolean confirm(Object msg, String titulo) {
        return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_OPTION);
    }

    public static boolean confirm(Object msg) {
        return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, msg, "", JOptionPane.YES_NO_OPTION);
    }

    public static String prompt(Object msg, String pre) {
        return JOptionPane.showInputDialog(null, msg, pre);
    }

    public static String prompt(Object msg) {
        return JOptionPane.showInputDialog(null, msg, "", JOptionPane.QUESTION_MESSAGE);
    }

    public static String openFile() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile().getPath();
        } else {
            return null;
        }
    }

    public static String openFolder() {
        JFileChooser fc = new JFileChooser();
        File c = new File("c:/");
        if(c.exists()){
            fc.setCurrentDirectory(c);
        }
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return  fc.getSelectedFile().getPath();
        } else {
            return null;
        }
    }

    public static String saveFile() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.SAVE_DIALOG);
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile().getPath();
        } else {
            return null;
        }
    }

    public static String openFile(String... filter) {
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String sfile = fc.getSelectedFile().getPath();
            boolean ok = false;
            for (String f : filter) {
                if (sfile.toUpperCase().endsWith(f.toUpperCase())) {
                    ok = true;
                    break;
                }
            }
            if (ok) {
                return sfile;
            } else {
                Alert.warning("Selecione um aquivo com um dos seguintes formatos:\n" + String.join(", ", filter));
                return null;
            }
        } else {
            return null;
        }
    }

}
