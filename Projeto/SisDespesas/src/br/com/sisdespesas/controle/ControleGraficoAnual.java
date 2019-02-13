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
import java.awt.Dialog;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author AutoPecasLuz
 */
public class ControleGraficoAnual {

   
    public static void createChart(int ano) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        double totalAnual = 0;
        for (HashMap<Object, Object> row : movimentoAnual(ano)) {
            HashMap<Object, Object> valores = (HashMap<Object, Object>) row.get("valores");
            String mes = row.get("mes").toString();
            dataset.addValue(Double.parseDouble(valores.get("Despesa").toString()), "Despesas", mes);
            totalAnual += Double.parseDouble(valores.get("Despesa").toString());

        }
        String legenda = "O total de despesas em " + String.valueOf(ano) + " é de: R$ " + Format.money(totalAnual) + ".";
        String titulo = "Janeiro até Dezembro " + String.valueOf(ano);
        JFreeChart chart = ChartFactory.createBarChart3D(titulo, legenda, null, dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartFrame frame = new ChartFrame("Anual", chart);
        frame.pack();
        frame.setIconImage(new javax.swing.ImageIcon(ControleGraficoAnual.class.getResource("/br/com/sisdespesas/img/icone.png")).getImage());
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height-50);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static ArrayList<HashMap<Object, Object>> movimentoAnual(int ano) {
        try {
            String mes = "";
            ArrayList<HashMap<Object, Object>> rst = BriefDb.query(Conexao.get(), ""
                    + "select to_char(PAGOEM , 'yyyy')  as ano,to_char(PAGOEM , 'mm/yyyy')  as mes_ano, sum(VALOR)  as total, 'Despesa' as tipo from DROGARIA.DESPESA "
                    + "where to_char(PAGOEM , 'yyyy')=? group by mes_ano, tipo, ano order by mes_ano ", String.valueOf(ano));
            ArrayList<HashMap<Object, Object>> data = new ArrayList<>();

            for (int i = 1; i <= 12; i++) {
                mes = String.valueOf(i);
                mes = (mes.length() == 1 ? "0" + mes : mes) + "/" + String.valueOf(ano);
                HashMap<Object, Object> despesaReceita = new HashMap<>();
                for (HashMap<Object, Object> row : rst) {
                    if (row.get("MES_ANO").toString().equals(mes)) {
                        despesaReceita.put(row.get("TIPO"), row.get("TOTAL"));
                    }
                }
                if (despesaReceita.get("Despesa") == null) {
                    despesaReceita.put("Despesa", 0);
                }
                HashMap<Object, Object> movimento = new HashMap<Object, Object>();
                movimento.put("mes", mes);
                movimento.put("valores", despesaReceita);
                data.add(movimento);
            }
            return data;
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " ={", "QUERY ERROR DATASET");
            return null;
        }
    }

    public static void anosDisponiveis(JList lista) {
        lista.removeAll();
        try {
            ArrayList<HashMap<Object, Object>> rst = BriefDb.query(Conexao.get(), "select convert( (to_char(PAGOEM , 'yyyy')) , int)  as ano from DROGARIA.DESPESA GROUP BY ano order by ano desc");
            DefaultListModel model = new DefaultListModel();
            int n = 0;
            for (HashMap<Object, Object> row : rst) {
                model.add(n++, Format.get(row, "ANO"));
            }
            lista.setModel(model);
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "QUERY ERROR YEARLIST");
        }
    }

}
