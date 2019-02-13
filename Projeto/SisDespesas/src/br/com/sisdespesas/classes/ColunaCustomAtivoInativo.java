/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.classes;

import java.awt.Color;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author AutoPecasLuz
 */
public class ColunaCustomAtivoInativo extends DefaultTableCellRenderer {

    @Override
    protected void setValue(Object o) {
        if (o == null) {
            o = "";
        }
        if (o.toString().trim().equalsIgnoreCase("0") || o.toString().trim().equalsIgnoreCase("Inativo")) {
            super.setText("Inativo");
            super.setForeground(Color.RED);
        } else if (o.toString().trim().equalsIgnoreCase("1") || o.toString().trim().equalsIgnoreCase("Ativo")) {
            super.setText("Ativo");
            super.setForeground(new Color(49,43,103));
        }
    }

}
