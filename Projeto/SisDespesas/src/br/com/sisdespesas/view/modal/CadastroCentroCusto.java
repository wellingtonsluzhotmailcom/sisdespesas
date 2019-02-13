/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.view.modal;

import br.com.briefdb.BriefDb;
import br.com.sisdespesas.classes.Alert;
import br.com.sisdespesas.classes.ControleUniversal;
import br.com.sisdespesas.classes.Format;
import br.com.sisdespesas.classes.TextUpper;
import br.com.sisdespesas.controle.ControleCentroCusto;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 * @author AutoPecasLuz
 */
public class CadastroCentroCusto extends javax.swing.JDialog {

    private HashMap<Object, Object> data;
    private JButton btn;

    /**
     * Creates new form UsuarioCadastro
     */
    public CadastroCentroCusto(java.awt.Frame parent, boolean modal, JButton btn, Object id) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.btn = btn;
        TextUpper.size(120, txtDescricao);
        if (id != null) {
            this.data = ControleCentroCusto.get(id);
            txtCodigo.setText(Format.get(data, "ID_CENTRO_CUSTO"));
            txtAtualizado.setText(Format.getDateBr(data, "ATUALIZADOEM"));
            txtCadastro.setText(Format.getDateBr(data, "CADASTRADOEM"));
            cbAtivo.setSelectedIndex(Format.getInt(data, "ATIVO"));
            txtDescricao.setText(Format.get(data, "DESCRICAO"));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        cbAtivo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JLabel();
        txtCadastro = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtAtualizado = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Centro de Custo");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(49, 43, 103));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Descrição:*");
        jLabel4.setToolTipText("");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDescricao.setForeground(new java.awt.Color(49, 43, 103));
        txtDescricao.setToolTipText("Descrição");
        txtDescricao.setBorder(null);
        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(49, 43, 103));

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(49, 43, 103));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/diskette.png"))); // NOI18N
        jButton2.setText("GRAVAR");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 43, 103)));
        jButton2.setIconTextGap(8);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(49, 43, 103));

        cbAtivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbAtivo.setForeground(new java.awt.Color(49, 43, 103));
        cbAtivo.setMaximumRowCount(10);
        cbAtivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inativo", "Ativo" }));
        cbAtivo.setSelectedIndex(1);
        cbAtivo.setToolTipText("Modo de Operação");
        cbAtivo.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(49, 43, 103));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Situação:");
        jLabel5.setToolTipText("");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jSeparator3.setForeground(new java.awt.Color(49, 43, 103));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(49, 43, 103));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Código:");
        jLabel6.setToolTipText("");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(49, 43, 103));
        txtCodigo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtCodigo.setToolTipText("");

        txtCadastro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCadastro.setForeground(new java.awt.Color(49, 43, 103));
        txtCadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtCadastro.setText("    /    /            :   ");
        txtCadastro.setToolTipText("");

        jSeparator4.setForeground(new java.awt.Color(49, 43, 103));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(49, 43, 103));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Cadastrado Em:");
        jLabel10.setToolTipText("");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jSeparator5.setForeground(new java.awt.Color(49, 43, 103));

        txtAtualizado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAtualizado.setForeground(new java.awt.Color(49, 43, 103));
        txtAtualizado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtAtualizado.setText("    /    /            :   ");
        txtAtualizado.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(49, 43, 103));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Atualizado Em:");
        jLabel12.setToolTipText("");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAtualizado, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescricao)
                    .addComponent(cbAtivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtAtualizado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(cbAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbAtivo, txtCodigo, txtDescricao});

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        cbAtivo.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        salvar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbAtivo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel txtAtualizado;
    private javax.swing.JLabel txtCadastro;
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables

    //ID_USUARIO_MANUTENCAO
    private void salvar() {
        if (!ControleUniversal.obrigatorio(txtDescricao)) {
            return;
        }
        this.data = new HashMap<>();
        this.data.put("ATUALIZADOEM", Format.getCurrentDate());
        this.data.put("DESCRICAO", txtDescricao.getText().trim());
        this.data.put("ATIVO", cbAtivo.getSelectedIndex());
        if (ControleCentroCusto.crud(data, txtCodigo.getText().equals("") ? BriefDb.INSERT : BriefDb.UPDATE, txtCodigo.getText())) {
            btn.doClick();
            this.dispose();
            if (txtCodigo.getText().equals("") && Alert.confirm("Deseja cadastrar outro?")) {
                JDialog modal = new CadastroCentroCusto(null, true, btn, null);
                modal.setVisible(true);
            }
        }
    }
}
