/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.classes;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author AutoPecasLuz
 */
public class Lista {
    
    
    public static void nvgLista(JList lista, JTextField... txts) {
        for (JTextField txt : txts) {
            txt.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent ke) {
                    for (int i = 0; i <= lista.getModel().getSize(); i++) {
                        lista.setSelectedIndex(i);
                        try {
                            if (lista.getSelectedValue().toString().toUpperCase().contains(txt.getText().toUpperCase().trim())) {
                                break;
                            }
                        } catch (Exception ex) {
                            break;
                        }
                        if (i + 1 == lista.getVisibleRowCount()) {
                            lista.clearSelection();
                        }
                    }
                    lista.ensureIndexIsVisible(lista.getSelectedIndex());
                }
            });
        }
    }
    
    
    
}
