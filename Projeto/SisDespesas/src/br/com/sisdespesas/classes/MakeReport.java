/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.classes;

import br.com.sisdespesas.database.Conexao;
import java.util.HashMap;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;



/**
 *
 * @author AutoPecasLuz
 */
public class MakeReport {
    private static final String PATH = "/br/com/sisdespesas";

     public static  byte[] makeBytsReport(String nomeRelatorio, HashMap<String, Object> parametros) {
        byte[] bytes = null;
         try {
            //Relátorios sem detalhes, apenas com paramentros
            JasperDesign jasperDesign = JRXmlLoader.load(MakeReport.class.getResourceAsStream(MakeReport.PATH+"/relatorios/" + nomeRelatorio + ".jrxml"));
            JasperReport jasper = JasperCompileManager.compileReport(jasperDesign);
            bytes = JasperRunManager.runReportToPdf(jasper, parametros, Conexao.get());
        } catch (Exception e) {
            Alert.error(e.getMessage());
            e.printStackTrace();
        }
         return bytes;
    }
    
    
    public static boolean print(String nomeRelatorio, HashMap<String, Object> parametros, String tituloJanela) {
        try {
            //Relátorios sem detalhes, apenas com paramentros
            JasperDesign jasperDesign = JRXmlLoader.load(MakeReport.class.getResourceAsStream(MakeReport.PATH+"/relatorios/" + nomeRelatorio + ".jrxml"));
            JasperReport jasper = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, Conexao.get());
            JasperViewer jv = new JasperViewer(print, false);
            jv.setSize(900, 500);
            jv.setIconImage(new javax.swing.ImageIcon(MakeReport.class.getResource(MakeReport.PATH+"/img/icone.png")).getImage());
            jv.setTitle(tituloJanela);
            jv.setLocationRelativeTo(null);
            jv.setVisible(true);
            jv.requestFocus();
            return true;
        } catch (Exception e) {
            Alert.error(e.getMessage()+" =(", "ERROR REPORT");
        }
        return false;
    }

    public static void simplePrint(String nomeRelatorio, HashMap<String, Object> parametros, String tituloJanela) {
        try {
            //Relátorios sem detalhes, apenas com paramentros
            JasperDesign jasperDesign = JRXmlLoader.load(MakeReport.class.getResourceAsStream(MakeReport.PATH+"/relatorios/" + nomeRelatorio + ".jrxml"));
            JasperReport jasper = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros);
            JasperViewer jv = new JasperViewer(print, false);
            jv.setSize(900, 500);
            jv.setIconImage(new javax.swing.ImageIcon(MakeReport.class.getResource(MakeReport.PATH+"/img/icone.png")).getImage());
            jv.setTitle(tituloJanela);
            jv.setLocationRelativeTo(null);
            jv.setVisible(true);
        } catch (Exception e) {
            Alert.error(e.getMessage());
        }
    }

    public static void tablePrint(String nomeRelatorio, HashMap<String, Object> parametros, String tituloJanela, JTable grid) {
        try {
            //Relátorios sem detalhes, apenas com paramentros e datasource table
            JasperDesign jasperDesign = JRXmlLoader.load(MakeReport.class.getResourceAsStream(MakeReport.PATH+"/relatorios/" + nomeRelatorio + ".jrxml"));
            JasperReport jasper = JasperCompileManager.compileReport(jasperDesign);
            JRTableModelDataSource dados = new JRTableModelDataSource(grid.getModel()); //aqui eu crio um datasource usando a propria jtable
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, dados);
            JasperViewer jv = new JasperViewer(print, false);
            jv.setSize(1200, 500);
            jv.setIconImage(new javax.swing.ImageIcon(MakeReport.class.getResource(MakeReport.PATH+"/img/icone.png")).getImage());
            jv.setTitle(tituloJanela);
            jv.setLocationRelativeTo(null);
            jv.setVisible(true);
        } catch (Exception e) {
            Alert.error(e.getMessage());
        }
    }

}
