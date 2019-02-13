/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.classes;

import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author AutoPecasLuz
 */
public class ColunaCustomYesNot extends DefaultTableCellRenderer {

    @Override
    protected void setValue(Object o) {
        if (o == null) {
            o = "";
        }
        String cor = "green";
        if (o.toString().trim().equalsIgnoreCase("t")) {
            this.setToolTipText("Sim");
            cor = "green";
        } else if (o.toString().trim().equalsIgnoreCase("f")) {
            cor = "red";
            this.setToolTipText("Não");
        }
        super.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pastoraldizimo/img/bullet_" + cor + ".png")));
        super.setHorizontalAlignment(CENTER);
    }

}
