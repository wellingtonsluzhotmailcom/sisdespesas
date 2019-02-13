/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.classes;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;

/**
 *
 * @author AutoPecasLuz
 */
public class Decimal extends PlainDocument {

    public static void size(int lenght, JTextField... txts) {
        for (JTextField txt : txts) {
            txt.setDocument(new Decimal(lenght));
        }
    }

    public static void size(int lenght, JPasswordField... txts) {
        for (JPasswordField txt : txts) {
            txt.setDocument(new Decimal(lenght));
        }
    }

    public static void size(int lenght, JTextArea... txts) {
        for (JTextArea txt : txts) {
            txt.setDocument(new Decimal(lenght));
        }
    }

    private int tamanhoMax = 10;

    public Decimal(int tamanhoMax) {
        this.tamanhoMax = tamanhoMax;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) {
        try {
            if (str == null) {
                return;
            }

            String stringAntiga = getText(0, getLength());
            int tamanhoNovo = stringAntiga.length() + str.length();

            if (tamanhoNovo <= tamanhoMax) {
                super.insertString(offset, str.replaceAll("[^0-9|^.]", ""), attr);
            } else {
                super.insertString(offset, "", attr);
            }
        } catch (Exception ex) {
            Alert.error(ex.getMessage(), "Erro ao limitar texto");
        }
    }
}
