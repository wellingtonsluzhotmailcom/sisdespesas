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
public class ColunaCustomDocumento extends DefaultTableCellRenderer {

    @Override
    protected void setValue(Object o) {
        if (o == null) {
            o = "";
        }
        if (o != null || o != "") {
            switch (o.toString().length()) {
                case 14:
                    setText(Format.CNPJ(o));
                    setToolTipText("Pessoa jurídica (CNPJ)");
                    break;
                case 11:
                    setText(Format.CPF(o));
                    setToolTipText("Pessoa física (CPF)");
                    break;
                default:
                    setText("-");
                    setToolTipText("Documento não informado");
                    break;
            }
        }
    }

}
