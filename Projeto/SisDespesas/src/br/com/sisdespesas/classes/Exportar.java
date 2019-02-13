/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.classes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author AutoPecasLuz
 */
public class Exportar {

    public static void excel(JTable tabela, String title) {
        try {
            JFileChooser navegador = new JFileChooser();
            if (JFileChooser.APPROVE_OPTION == navegador.showSaveDialog(null) && navegador.getSelectedFile() != null) {
                String arquivo = navegador.getSelectedFile().toString() + ".xls";
                TableModel model = tabela.getModel();
                if (naoExiste(arquivo)) {
                    FileOutputStream fw = new FileOutputStream(arquivo);
                    OutputStreamWriter bw = new OutputStreamWriter(fw, "ISO-8859-1");
                    bw.write(title + "\n");
                    for (int i = 0; i < model.getColumnCount(); i++) {
                        bw.write(model.getColumnName(i) + "\t");
                    }
                    bw.write("\n");
                    int i = 0;
                    for (int r = 0; r < model.getRowCount(); r++) {
                        for (int c = 0; c < model.getColumnCount(); c++) {
                            bw.write(model.getValueAt(r, c).toString() + "\t");
                        }
                        bw.write("\n");
                    }
                    bw.close();
                    fw.close();
                    Alert.info("Arquivo salvo com sucesso! =)", "Success");
                    Runtime.getRuntime().exec("explorer.exe " + arquivo);
                }
            }
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "Error export");
        }
    }

    public static void exportHtml(JTable tabela, String title) {
        try {
            JFileChooser navegador = new JFileChooser();
            if (JFileChooser.APPROVE_OPTION == navegador.showSaveDialog(null) && navegador.getSelectedFile() != null) {
                String arquivo = navegador.getSelectedFile().toString() + ".html";
                TableModel model = tabela.getModel();
                if (naoExiste(arquivo)) {
                    StringBuilder html = new StringBuilder();
                    html.append("<html>");
                    html.append("\n"
                            + "<head>\n"
                            + "\n"
                            + "<title>" + title + "</title>\n"
                            + "<style>\n"
                            + "table, td, th {\n"
                            + "    border: 1px solid green;\n"
                            + "} \n"
                            + "th {\n"
                            + "    background-color: green;\n"
                            + "    color: white;\n"
                            + "    height: 35px;\n"
                            + "}\n"
                            + "</style>\n"
                            + "\n"
                            + "<SCRIPT LANGUAGE=\"JavaScript\">\n"
                            + "\n"
                            + "<!-- Imprimir texto-->\n"
                            + "function imprimirDoc(text){\n"
                            + "text=document\n"
                            + "print(text)\n"
                            + "}\n"
                            + "</script>\n"
                            + "\n"
                            + "</head>\n"
                            + "<body>\n");

                    html.append("<DIV ALIGN=\"Left\" >");
                    html.append("<br>");
                    html.append("</DIV>");
                    html.append("<DIV ALIGN=\"CENTER\">\n");
                    html.append("<h2>" + title + "</h2>");
                    FileOutputStream fw = new FileOutputStream(arquivo);
                    OutputStreamWriter bw = new OutputStreamWriter(fw, "ISO-8859-1");
                    html.append("<hr/>\n");
                    html.append("<table border=\"1\" width=\"100%\">");
                    html.append("<tr>");
                    html.append("\n");
                    for (int i = 0; i < model.getColumnCount(); i++) {
                        html.append("<th>" + model.getColumnName(i) + "</th>");
                        html.append("\n");
                    }
                    html.append("</tr>");
                    html.append("\n");
                    int i = 0;

                    for (int r = 0; r < model.getRowCount(); r++) {
                        html.append("<tr>");
                        html.append("\n");
                        for (int c = 0; c < model.getColumnCount(); c++) {
                            html.append("<td>" + model.getValueAt(r, c).toString() + "</td>");
                            html.append("\n");
                        }
                        html.append("</tr>");
                        html.append("\n");
                    }
                    html.append("</table>");
                    html.append("<hr/>\n"
                            + "<DIV align=\"LEFT\">\n"
                            + "<font> Data: " + new Date().toString() + " </font><br>\n"
                            + "</DIV>\n"
                            + "\n"
                            + "<BR>\n"
                            + "\n"
                            + " \n"
                            + "\n"
                            + "<FORM> \n"
                            + "<INPUT NAME=\"print\" TYPE=\"button\" VALUE=\"Imprimir\" ONCLICK=\"imprimirDoc()\"> \n"
                            + "</FORM>\n"
                            + "\n"
                            + "</DIV>\n"
                            + "\n"
                            + "\n"
                            + "</body>\n"
                            + "</html>");

                    bw.write(html.toString());
                    bw.close();
                    fw.close();
                    Alert.info("Arquivo salvo com sucesso! =)", "Success");
                    Runtime.getRuntime().exec("explorer.exe " + arquivo);
                }
            }

        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "Error export");
        }
    }

    private static boolean naoExiste(String arquivo) {
        File path = new File(arquivo);
        if (!path.exists()) {
            return true;
        } else {
            return Alert.confirm("Já existe um arquivo com este nome! \nDeseja substituir o existente?", "Atenção");
        }
    }
}
