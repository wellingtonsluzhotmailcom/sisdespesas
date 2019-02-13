/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.controle;

import br.com.briefdb.BriefDb;
import br.com.sisdespesas.classes.Alert;
import br.com.sisdespesas.classes.Format;
import br.com.sisdespesas.database.Conexao;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author AutoPecasLuz
 */
public class ControleGraficoPeriodo {

    public static boolean createChart(int agrupado, java.util.Date dataInicial, java.util.Date dataFinal) {
        String sql = "", titulo = "";
        switch (agrupado) {
            case 0:
                sql = "SELECT DROGARIA.DESPESA.DESCRICAO, sum(valor) as  valor FROM DROGARIA.DESPESA where pagoem  between ? and ? GROUP BY DESCRICAO";
                titulo = "despesas";
                break;
            case 1:
                sql = "SELECT  DISTINCT  DROGARIA.CENTRO_CUSTO.descricao, (SELECT sum(valor) from drogaria.DESPESA where pagoem  between ? and ? and DROGARIA.CENTRO_CUSTO.ID_CENTRO_CUSTO=DROGARIA.DESPESA.ID_CENTRO_CUSTO) as valor FROM DROGARIA.DESPESA inner join DROGARIA.CENTRO_CUSTO  on DROGARIA.CENTRO_CUSTO.ID_CENTRO_CUSTO=DROGARIA.DESPESA.ID_CENTRO_CUSTO where pagoem  between ? and ? group by DROGARIA.DESPESA.DESCRICAO";
                titulo = "centro de Custo";
                break;
            default:
                sql = "SELECT DROGARIA.CENTRO_CUSTO.ID_CENTRO_CUSTO, DROGARIA.CENTRO_CUSTO.DESCRICAO||' : '||DROGARIA.DESPESA.DESCRICAO as DESCRICAO , sum(valor)  as valor FROM DROGARIA.DESPESA inner join DROGARIA.CENTRO_CUSTO on DROGARIA.CENTRO_CUSTO.ID_CENTRO_CUSTO=DROGARIA.DESPESA.ID_CENTRO_CUSTO where pagoem  between ? and ? group by  DROGARIA.CENTRO_CUSTO.ID_CENTRO_CUSTO,DROGARIA.CENTRO_CUSTO.DESCRICAO||' : '||DROGARIA.DESPESA.DESCRICAO";
                titulo = "despesas e Centro de Custo";
                break;
        }
        java.sql.Date data1;
        java.sql.Date data2;
        if (dataInicial.getTime() >= dataFinal.getTime()) {
            data1 = new java.sql.Date(dataFinal.getTime());
            data2 = new java.sql.Date(dataInicial.getTime());
        } else {
            data1 = new java.sql.Date(dataInicial.getTime());
            data2 = new java.sql.Date(dataFinal.getTime());
        }
        double total = 0;
        try {
            // monta o dataset
            ArrayList<HashMap<Object, Object>> rst = new ArrayList<>();
            switch (agrupado) {
                case 1:
                    rst = BriefDb.query(Conexao.get(), sql, data1, data2, data1, data2);
                    break;
                default:
                    rst = BriefDb.query(Conexao.get(), sql, data1, data2);
                    break;
            }
            DefaultPieDataset dataset = new DefaultPieDataset();
            for (HashMap<Object, Object> data : rst) {
                total += Double.parseDouble(Format.get(data, "VALOR"));
                dataset.setValue(Format.get(data, "DESCRICAO"), Double.parseDouble(Format.get(data, "VALOR")));
            }
            //configura o grafico
            JFreeChart chart = ChartFactory.createPieChart3D("Agrupado por: " + titulo + " de " + Format.dateBr(data1) + " até " + Format.dateBr(data2) + " (Total de: R$ " + Format.money(total) + ")", // chart title 
                    dataset, // data    
                    true, // include legend   
                    true,
                    false);
            PiePlot plotagem = (PiePlot) chart.getPlot();
            plotagem.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}\n R$ {1} ({2})"));
            plotagem.setLabelBackgroundPaint(new Color(255, 255, 255));

            ChartFrame frame = new ChartFrame("Período", chart);
            frame.pack();
            frame.setIconImage(new javax.swing.ImageIcon(ControleGraficoAnual.class.getResource("/br/com/sisdespesas/img/icone.png")).getImage());
            RefineryUtilities.centerFrameOnScreen(frame);
            frame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height - 50);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            return true;
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "QUERY ERROR");
        }
        return false;
    }

}
