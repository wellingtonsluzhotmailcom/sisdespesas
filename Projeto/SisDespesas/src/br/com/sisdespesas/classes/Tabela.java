/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.classes;

import br.com.briefdb.BriefDb;
import br.com.sisdespesas.database.Conexao;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author AutoPecasLuz
 */
public class Tabela {

    public static void set(JTable tabela, JTextField txtBusca, String colunas[], String parametros[], JButton btn, String sql, JSpinner limite) {

        // auto ordem
        tabela.setAutoCreateRowSorter(true);

        // configura a estruta da Tabela
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, colunas) {
            boolean[] canEdit = new boolean[]{
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                try {
                    return canEdit[columnIndex];
                } catch (Exception ex) {
                    return false;
                }
            }
        });
        // order por selação da combo
        // navegação enquanto digita
        txtBusca.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                Tabela.navegarTabela(tabela, txtBusca);
            }
        });
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        try {
            ArrayList<HashMap<Object, Object>> rst = BriefDb.query(Conexao.get(), sql.replaceAll("_%_", " limit ?"), limite.getValue());
            for (HashMap<Object, Object> mapa : rst) {
                ArrayList<Object> aux = new ArrayList<>();
                for (String p : parametros) {
                    aux.add(mapa.get(p.toUpperCase()));
                }
                modelo.addRow(aux.toArray());
            }
            txtBusca.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    while (modelo.getRowCount() > 0) {
                        modelo.removeRow(0);
                    }
                    if (txtBusca.getText().trim().length() > 0) {
                        try {

                            String filtro = " where ";
                            for (int p = 0; p < parametros.length; p++) {
                                if (p > 0) {
                                    filtro += " or ";
                                }
                                filtro += " upper(" + parametros[p] + ") like upper(CONCAT('%', CONCAT(convert(?, character), '%'))) ";
                            }
                            filtro += " limit ?";

                            String fSql = sql.replaceAll("_%_", filtro);

                            ArrayList<HashMap<Object, Object>> rst = getRst(parametros.length, fSql, txtBusca, limite);
                            for (HashMap<Object, Object> mapa : rst) {
                                ArrayList<Object> aux = new ArrayList<>();
                                for (String p : parametros) {
                                    aux.add(mapa.get(p.toUpperCase()));
                                }
                                modelo.addRow(aux.toArray());
                            }
                        } catch (Exception ex) {
                            Alert.error(ex.getMessage() + " =(", "ERROR QUERY");
                        }

                    } else {
                        try {
                            String fSql = sql.replaceAll("_%_", "  limit ?");
                            ArrayList<HashMap<Object, Object>> rst = BriefDb.query(Conexao.get(), fSql, limite.getValue());
                            for (HashMap<Object, Object> mapa : rst) {
                                ArrayList<Object> aux = new ArrayList<>();
                                for (String p : parametros) {
                                    aux.add(mapa.get(p.toUpperCase()));
                                }
                                modelo.addRow(aux.toArray());
                            }
                        } catch (Exception ex) {
                            Alert.error(ex.getMessage() + " =(", "ERROR QUERY");

                        }
                    }
                }
            });
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    while (modelo.getRowCount() > 0) {
                        modelo.removeRow(0);
                    }
                    if (txtBusca.getText().trim().length() > 0) {
                        try {

                            String filtro = " where ";
                            for (int p = 0; p < parametros.length; p++) {
                                if (p > 0) {
                                    filtro += " or ";
                                }
                                filtro += " upper(" + parametros[p] + ") like upper(CONCAT('%', CONCAT(convert(?, character), '%'))) ";
                            }
                            filtro += " limit ?";

                            String fSql = sql.replaceAll("_%_", filtro);

                            ArrayList<HashMap<Object, Object>> rst = getRst(parametros.length, fSql, txtBusca, limite);

                            for (HashMap<Object, Object> mapa : rst) {
                                ArrayList<Object> aux = new ArrayList<>();
                                for (String p : parametros) {
                                    aux.add(mapa.get(p.toUpperCase()));
                                }
                                modelo.addRow(aux.toArray());
                            }
                        } catch (Exception ex) {
                            Alert.error(ex.getMessage() + " =(", "ERROR QUERY");
                        }
                    } else {
                        try {
                            String fSql = sql.replaceAll("_%_", "  limit ?");
                            ArrayList<HashMap<Object, Object>> rst = BriefDb.query(Conexao.get(), fSql, limite.getValue());
                            for (HashMap<Object, Object> mapa : rst) {
                                ArrayList<Object> aux = new ArrayList<>();
                                for (String p : parametros) {
                                    aux.add(mapa.get(p.toUpperCase()));
                                }
                                modelo.addRow(aux.toArray());
                            }
                        } catch (Exception ex) {
                            Alert.error(ex.getMessage() + " =(", "ERROR QUERY");
                        }
                    }
                }
            });
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "ERROR QUERY");
        }

        tabela.getColumnModel().getColumn(0).setMaxWidth(70);
    }

    //metodo para navegar na Tabela enquanto digita
    public static void navegarTabela(JTable tabela, JTextField txtBusca) {
        ListSelectionModel selectionModel = tabela.getSelectionModel();
        int coluna = 0;
        boolean stop = false;
        while (coluna < tabela.getModel().getColumnCount()) {
            if (stop) {
                break;
            }
            for (int i = 0; i < tabela.getRowCount(); i++) {
                if (String.valueOf(tabela.getModel().getValueAt(i, coluna)).toUpperCase().startsWith(txtBusca.getText().trim().toUpperCase())
                        || String.valueOf(tabela.getModel().getValueAt(i, coluna)).toUpperCase().contains(txtBusca.getText().trim().toUpperCase())
                        || String.valueOf(tabela.getModel().getValueAt(i, coluna)).toUpperCase().endsWith(txtBusca.getText().trim().toUpperCase())) {
                    selectionModel.setSelectionInterval(i, i);
                    stop = true;
                    break;
                }
            }
            coluna++;
        }
        /* Configura o evento de seleção na Tabela, para atualizar o scroll. */
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
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

    // metodo para customizar uma coluna como status
    public static void collStatus(JTable table, int index) {
        table.getColumnModel().getColumn(index).setCellRenderer(new ColunaCustomStatus());
        table.getColumnModel().getColumn(index).setMaxWidth(100);
    }

    // metodo para customizar uma coluna como status
    public static void collDocumento(JTable table, int index) {
        table.getColumnModel().getColumn(index).setCellRenderer(new ColunaCustomDocumento());
        table.getColumnModel().getColumn(index).setMaxWidth(150);
        table.getColumnModel().getColumn(index).setMinWidth(150);
    }

    // metodo para customizar a largura de uma coluna
    public static void collWith(JTable table, int index, int width) {
        table.getColumnModel().getColumn(index).setMaxWidth(width);
    }

    // metodo para customizar a largura de uma coluna
    public static void collWithMin(JTable table, int index, int width) {
        table.getColumnModel().getColumn(index).setMinWidth(width);
    }

    // metodo para customizar uma coluna como status
    public static void collWithFix(JTable table, int index, int width) {
        table.getColumnModel().getColumn(index).setMaxWidth(100);
        table.getColumnModel().getColumn(index).setMinWidth(100);
    }

    public static void limparTabela(JTable... tabelas) {
        for (JTable table : tabelas) {
            DefaultTableModel modelo = (DefaultTableModel) table.getModel();
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
        }
    }

    public static DefaultTableModel getModel(JTable tabela) {
        return (DefaultTableModel) tabela.getModel();
    }

    public static void collYesNot(JTable table, int... index) {
        for (int i : index) {
            table.getColumnModel().getColumn(i).setCellRenderer(new ColunaCustomYesNot());
            table.getColumnModel().getColumn(i).setMaxWidth(100);
        }
    }

    public static void collYesNotLivre(JTable table, int... index) {
        for (int i : index) {
            table.getColumnModel().getColumn(i).setCellRenderer(new ColunaCustomYesNot());
        }
    }

    public static void collAtivoInativo(JTable table, int... index) {
        for (int i : index) {
            table.getColumnModel().getColumn(i).setCellRenderer(new ColunaCustomAtivoInativo());
        }
    }

    public static boolean is(JTable tabela) {
        return tabela.getSelectedRowCount() == 1;
    }

    public static Object get(JTable tabela) {
        try {
            return tabela.getValueAt(tabela.getSelectedRow(), 0);
        } catch (Exception ex) {
            Alert.info("Não há nenhum registro selecionado! =(", "SELECT ERROR");
            return 0;
        }
    }

    public static Object get(JTable tabela, int indexColuna) {
        return tabela.getValueAt(tabela.getSelectedRow(), indexColuna);
    }

    public static void ajustarColunas(JTable tabela) {
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            String columnName = tabela.getColumnName(i);
            configurarColunas(tabela, i, 10);
        }
    }

    public static void configurarColunas(JTable tabela, int coluna, int margin) {
        DefaultTableColumnModel colModel = (DefaultTableColumnModel) tabela.getColumnModel();
        TableColumn col = colModel.getColumn(coluna);
        int width = 0;
        // Obtém a largura do cabeçalho da coluna
        TableCellRenderer renderer = col.getHeaderRenderer();
        if (renderer == null) {
            renderer = tabela.getTableHeader().getDefaultRenderer();
        }
        Component comp = renderer.getTableCellRendererComponent(tabela, col.getHeaderValue(), false, false, 0, 0);
        width = comp.getPreferredSize().width;
        // Obtém a largura maxima da coluna de dados
        for (int r = 0; r < tabela.getRowCount(); r++) {
            renderer = tabela.getCellRenderer(r, coluna);
            comp = renderer.getTableCellRendererComponent(tabela, tabela.getValueAt(r, coluna), false, false, r, coluna);
            width = Math.max(width, comp.getPreferredSize().width);
        }
        width += 2 * margin;
        // Configura a largura
        col.setPreferredWidth(width);
    }

    private static ArrayList<HashMap<Object, Object>> getRst(int parametros, String fSql, JTextField txtBusca, JSpinner limite) throws Exception {
        ArrayList<HashMap<Object, Object>> rst;
        switch (parametros) {
            case 1:
                rst = BriefDb.query(Conexao.get(), fSql, txtBusca.getText().trim(), limite.getValue());
                break;

            case 2:
                rst = BriefDb.query(Conexao.get(), fSql, txtBusca.getText().trim(), txtBusca.getText().trim(), limite.getValue());
                break;
            case 3:
                rst = BriefDb.query(Conexao.get(), fSql, txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), limite.getValue());
                break;
            case 4:
                rst = BriefDb.query(Conexao.get(), fSql, txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), limite.getValue());
                break;
            case 5:
                rst = BriefDb.query(Conexao.get(), fSql, txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), limite.getValue());
                break;
            case 6:
                rst = BriefDb.query(Conexao.get(), fSql, txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), limite.getValue());
                break;
            case 7:
                rst = BriefDb.query(Conexao.get(), fSql, txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), limite.getValue());
                break;
            case 8:
                rst = BriefDb.query(Conexao.get(), fSql, txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), limite.getValue());
                break;
            case 9:
                rst = BriefDb.query(Conexao.get(), fSql, txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), limite.getValue());
                break;
            default:
                rst = BriefDb.query(Conexao.get(), fSql, txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), txtBusca.getText().trim(), limite.getValue());
                break;

        }
        return rst;
    }

}
