/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.controle;

import br.com.sisdespesas.classes.MakeReport;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author AutoPecasLuz
 */
public class ControleRelatorio {
    
    public static boolean printRelatorioGeral(int tipo, java.util.Date data1, java.util.Date data2) {
        HashMap<String, Object> p = new HashMap<>();
        
            p.put("data1", new java.sql.Date(data1.getTime()));
            p.put("data2", new java.sql.Date(data2.getTime()));
            p.put("logo", new ImageIcon(ControleRelatorio.class.getResource("/br/com/sisdespesas/img/report_logo.png")).getImage());
          return  MakeReport.print(tipo==0?"Geral":"Geral2", p, "Relátorio Geral");
    }
    
    public static boolean printRelatorioCentroCusto(int centroCusto, java.util.Date data1, java.util.Date data2) {
        HashMap<String, Object> p = new HashMap<>();
            p.put("data1", new java.sql.Date(data1.getTime()));
            p.put("data2", new java.sql.Date(data2.getTime()));
            p.put("id", centroCusto);
            p.put("logo", new ImageIcon(ControleRelatorio.class.getResource("/br/com/sisdespesas/img/report_logo.png")).getImage());
          return  MakeReport.print("CentroCusto", p, "Relátorio de Centro de Custo");
    }
    
}
