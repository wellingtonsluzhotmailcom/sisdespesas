/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * ControleUniversal.maxLength
 *
 * @author Wellington
 */
public abstract class ControleUniversal {

    public static boolean obrigatorio(JComponent... cp) {
        StringBuilder str = new StringBuilder();
        for (JComponent j : cp) {
            if (j instanceof JTextField) {
                if (((JTextField) j).getText().trim().equals("")) {
                    str.append(((JTextField) j).getToolTipText()).append("\n* ");
                    ((JTextField) j).requestFocus();
                    continue;
                }
            }

            if (j instanceof JTextArea) {
                if (((JTextArea) j).getText().trim().equals("")) {
                    str.append(((JTextArea) j).getToolTipText()).append("\n* ");
                    ((JTextArea) j).requestFocus();
                    continue;
                }
            }

            if (j instanceof JPasswordField) {
                if (new String(((JPasswordField) j).getPassword()).trim().equals("")) {
                    str.append(((JPasswordField) j).getToolTipText()).append("\n* ");
                    ((JPasswordField) j).requestFocus();
                    continue;
                }
            }

            if (j instanceof JComboBox) {
                if (((JComboBox) j).getSelectedIndex() < 0) {
                    str.append(((JComboBox) j).getToolTipText()).append("\n* ");
                    ((JComboBox) j).requestFocus();
                    continue;
                }
            }
            if (j instanceof JFormattedTextField) {
                if (Format.clear(((JFormattedTextField) j).getText()).equals("")) {
                    str.append(((JFormattedTextField) j).getToolTipText()).append("\n* ");
                    continue;
                }
            }
            if (j instanceof JDateChooser) {
                if (((JDateChooser) j).getDate() == null) {
                    str.append(((JDateChooser) j).getToolTipText()).append("\n* ");
                    continue;
                }
            }
        }
        if (!str.toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você esqueceu de preencher alguns campos! =(\n* " + str.toString().substring(0, str.toString().length() - 2), "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /// desabilita componentes em grande quantidade
    public static void setBigEnabled(JComponent cp[], boolean enabled
    ) {

        for (JComponent sw : cp) {

            if (sw instanceof JTable) {
                ((JTable) sw).setEnabled(enabled);
            } else if (sw instanceof JButton) {
                ((JButton) sw).setEnabled(enabled);
            } else if (sw instanceof JComboBox) {
                ((JComboBox) sw).setEnabled(enabled);
            } else if (sw instanceof JTextField) {
                ((JTextField) sw).setEnabled(enabled);
            } else if (sw instanceof JTextArea) {
                ((JTextArea) sw).setEnabled(enabled);
            } else if (sw instanceof JCheckBox) {
                ((JCheckBox) sw).setEnabled(enabled);
            } else if (sw instanceof JRadioButton) {
                ((JRadioButton) sw).setEnabled(enabled);
            } else if (sw instanceof JFormattedTextField) {
                ((JFormattedTextField) sw).setEnabled(enabled);
            } else if (sw instanceof JDateChooser) {
                ((JDateChooser) sw).setEnabled(enabled);
            }
        }
    }

    // uni um jtextfield com jcheckbox fazendo do jcheckbox seu administrador de edicao
    public static void concatInputCheckBox(final JTextField txt, final JCheckBox ck, final String valDefault) {
        txt.setEnabled(ck.isSelected());
        if (!txt.isEnabled()) {
            txt.setText(valDefault);
        }
        ck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txt.setEnabled(ck.isSelected());
                if (!txt.isEnabled()) {
                    txt.setText(valDefault);
                }
            }
        });
    }

    // metodo para retirar todas as linhas da tabela
    public static void limparTabela(final JTable tabela) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    //metodo para navegar na tabela enquanto digita
    public static void navegarTabela(JTable tabela, JComboBox comboBusca, JTextField txtBusca) {
        ListSelectionModel selectionModel = tabela.getSelectionModel();
        for (int i = 0; i < tabela.getRowCount(); i++) {
            if (String.valueOf(tabela.getModel().getValueAt(i, comboBusca.getSelectedIndex())).toUpperCase().startsWith(txtBusca.getText().trim().toUpperCase())) {
                selectionModel.setSelectionInterval(i, i);
                break;
            }
        }
        /* Configura o evento de seleção na tabela, para atualizar o scroll. */
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                try {
                    tabela.scrollRectToVisible(tabela.getCellRect(
                            tabela.getSelectedRow(), 0, true));
                } catch (Exception ex) {
                }
            }
            /* Finaliza o método valueChanged. */

        });
        /* Finaliza a classe interna abstrata ListSelectionListener. */

    }

    // metodo para navegar na arvore de menu
    public static void navegarArvore(JTree arvore, JTextField txtBusca) {
        for (int i = 0; i < arvore.getRowCount(); i++) {
            arvore.setSelectionRow(i);
            arvore.expandPath(arvore.getSelectionPath());
            if ((arvore.getLastSelectedPathComponent().toString().toUpperCase()).startsWith(txtBusca.getText().toUpperCase())) {
                break;
            }
        }
    }

//  metodo para limpar todos os campos
    public static void limparCampos(JComponent... jc) {
        for (JComponent sw : jc) {
            if (sw instanceof JComboBox) {
                ((JComboBox) sw).setSelectedIndex(0);
            } else if (sw instanceof JTextField) {
                ((JTextField) sw).setText("");
            } else if (sw instanceof JTextArea) {
                ((JTextArea) sw).setText("");
            } else if (sw instanceof JCheckBox) {
                ((JCheckBox) sw).setSelected(false);
            } else if (sw instanceof JRadioButton) {
                ((JRadioButton) sw).setSelected(false);
            } else if (sw instanceof JFormattedTextField) {
                ((JFormattedTextField) sw).setText("");
            } else if (sw instanceof JDateChooser) {
                ((JDateChooser) sw).setDate(null);
            }
        }
    }

    // coloca uma marcação indicando que o campo e obrigatorio
    public static void setStyleObr(JComponent... cp) {
        for (JComponent label : cp) {
            if (label instanceof JLabel) {
                ((JLabel) label).setText("<html><head><meta charset='utf-8'></head><body><b style='color:red;'>*</b>" + ((JLabel) label).getText() + "</body></html>");
            }
        }
    }

    // metodo de verificação de ratualização de registro
    public static boolean autroizadoUpdate() {
        return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja atualizar esse registro?", "Atenção", JOptionPane.YES_NO_OPTION);
    }

    // metodo usado para confirar um novo registro nas telas de cadastros.
    public static boolean continuar() {
        try {
            return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Deseja efetuar um novo cadastro?", "Atenção", JOptionPane.YES_NO_OPTION);
        } catch (Exception ex) {
            return false;
        }
    }

    // metodo de verificação de autoriazação para remoção do registro selecionada nas telas de listagem
    public static boolean removerRegistro() {
        try {
            return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Deseja apagar o registro selecionado", "Atenção", JOptionPane.YES_NO_OPTION);
        } catch (Exception ex) {
            return false;
        }
    }

    public static void exportExcel(JTable tabela, String title) {
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
                    JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                    Runtime.getRuntime().exec("explorer.exe " + arquivo);
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao exportar para o excel!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void quebraLinhaLabel(JLabel... lbls) {
        for (JLabel lbl : lbls) {
            lbl.setText("<html><head><meta charset='utf-8' /></head><body><p style='text-align:justify;'>" + lbl.getText() + "<p/></body></html>");
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

                    File img = new File(arquivo);

                    img = new File(img.getParent().toString() + "\\" + "logo.png");
                    if (img.exists()) {
                        html.append("<img src=\"logo.png\" alt=\"logo tipo\" width=\"60\" height=\"50\"/>\n");
                    }

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
                    JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                    Runtime.getRuntime().exec("explorer.exe " + arquivo);
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao exportar página html!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean naoExiste(String arquivo) {
        File path = new File(arquivo);
        if (!path.exists()) {
            return true;
        } else {
            return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Já existe um arquivo com este nome! \nDeseja substituir o existente?", "Atenção", JOptionPane.YES_NO_OPTION);
        }
    }

    public static void click(JTable tabela, JComboBox combo) {
        tabela.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent me) {
                try {
                    // selecionar campo de pesquisa conforme a coluna clicada, trabalhar neste metodo  
                    combo.setSelectedIndex(tabela.getTableHeader().getColumnModel().getColumnIndexAtX(me.getX()));
                    super.mouseReleased(me); //To change body of generated methods, choose Tools | Templates.
                } catch (Exception ex) {
                }
            }

        });

    }

}
