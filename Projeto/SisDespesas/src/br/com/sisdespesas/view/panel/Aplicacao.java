/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.view.panel;

import br.com.sisdespesas.view.internal.CentroCustoLista;
import br.com.sisdespesas.view.internal.DespesasLista;
import br.com.sisdespesas.view.internal.UsuarioLista;
import br.com.sisdespesas.view.modal.CadastroConexao;
import br.com.sisdespesas.view.modal.CadastroEmpresa;
import br.com.sisdespesas.view.modal.GraficoAnual;
import br.com.sisdespesas.view.modal.GraficoPeriodo;
import br.com.sisdespesas.view.modal.RealizarBackup;
import br.com.sisdespesas.view.modal.RealizarUpload;
import br.com.sisdespesas.view.modal.RelatorioCentroCusto;
import br.com.sisdespesas.view.modal.RelatorioGeral;
import br.com.sisdespesas.view.modal.Sobre;
import br.com.sisdespesas.view.window.Janela;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JInternalFrame;

/**
 *
 * @author AutoPecasLuz
 */
public class Aplicacao extends javax.swing.JPanel {
    
    private Janela janela;

    /**
     * Creates new form Aplicacao
     */
    public Aplicacao(Janela janela) {
        this.janela = janela;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JDesktopPane(){
            @Override
            protected void paintComponent(Graphics grphcs) {
                Image image = new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/BK.png")).getImage();
                grphcs.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, null);

                int gutter = 27;
                Image logo = new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/logo.png")).getImage();
                grphcs.drawImage(logo, this.getSize().width-logo.getWidth(null)-gutter, this.getSize().height-logo.getHeight(null)-gutter, null);

                grphcs.drawString("Developed by Wellington Soares da Luz - 2019", gutter, this.getSize().height-gutter);
            }

        };
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        jLabel4 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(49, 43, 103));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setForeground(new java.awt.Color(49, 43, 103));
        jToolBar1.setBorderPainted(false);
        jToolBar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("       ");
        jToolBar1.add(jLabel1);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(49, 43, 103));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/icone_categoria_purple.png"))); // NOI18N
        jButton5.setText("Centro de Custo");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setIconTextGap(8);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("       ");
        jToolBar1.add(jLabel5);

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(49, 43, 103));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/icone_despesas_purple.png"))); // NOI18N
        jButton10.setText("Despesas");
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setIconTextGap(8);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton10);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("       ");
        jToolBar1.add(jLabel6);

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(49, 43, 103));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/icone_usuario_purple.png"))); // NOI18N
        jButton11.setText("Usuários");
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setIconTextGap(8);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton11);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("       ");
        jToolBar1.add(jLabel7);

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(49, 43, 103));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/company.png"))); // NOI18N
        jButton12.setText("Empresa");
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setIconTextGap(8);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton12);

        jTabbedPane1.addTab("CADASTROS", jToolBar1);

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setBorder(null);
        jToolBar2.setFloatable(false);
        jToolBar2.setForeground(new java.awt.Color(49, 43, 103));
        jToolBar2.setBorderPainted(false);
        jToolBar2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("       ");
        jToolBar2.add(jLabel3);

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(49, 43, 103));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/hosting.png"))); // NOI18N
        jButton8.setText("Conexão");
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setIconTextGap(8);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton8);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("       ");
        jToolBar2.add(jLabel8);

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(49, 43, 103));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/download.png"))); // NOI18N
        jButton13.setText("Backup");
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setIconTextGap(8);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton13);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("       ");
        jToolBar2.add(jLabel9);

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(49, 43, 103));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/upload.png"))); // NOI18N
        jButton14.setText("Restaurar");
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setIconTextGap(8);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton14);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("       ");
        jToolBar2.add(jLabel10);

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(49, 43, 103));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/help.png"))); // NOI18N
        jButton15.setText("Sobre");
        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setIconTextGap(8);
        jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton15);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("       ");
        jToolBar2.add(jLabel11);

        jButton16.setBackground(new java.awt.Color(255, 255, 255));
        jButton16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(49, 43, 103));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/logout.png"))); // NOI18N
        jButton16.setText("Sair");
        jButton16.setBorderPainted(false);
        jButton16.setContentAreaFilled(false);
        jButton16.setFocusable(false);
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setIconTextGap(8);
        jButton16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton16);

        jTabbedPane1.addTab("SISTEMA", jToolBar2);

        jToolBar3.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar3.setBorder(null);
        jToolBar3.setFloatable(false);
        jToolBar3.setForeground(new java.awt.Color(49, 43, 103));
        jToolBar3.setBorderPainted(false);
        jToolBar3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("       ");
        jToolBar3.add(jLabel4);

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(49, 43, 103));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/grafico.png"))); // NOI18N
        jButton9.setText("Anual");
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setIconTextGap(8);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton9);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("       ");
        jToolBar3.add(jLabel12);

        jButton17.setBackground(new java.awt.Color(255, 255, 255));
        jButton17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton17.setForeground(new java.awt.Color(49, 43, 103));
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/relatorio.png"))); // NOI18N
        jButton17.setText("Geral");
        jButton17.setBorderPainted(false);
        jButton17.setContentAreaFilled(false);
        jButton17.setFocusable(false);
        jButton17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton17.setIconTextGap(8);
        jButton17.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton17);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("       ");
        jToolBar3.add(jLabel13);

        jButton18.setBackground(new java.awt.Color(255, 255, 255));
        jButton18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton18.setForeground(new java.awt.Color(49, 43, 103));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/pie.png"))); // NOI18N
        jButton18.setText("Período");
        jButton18.setBorderPainted(false);
        jButton18.setContentAreaFilled(false);
        jButton18.setFocusable(false);
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton18.setIconTextGap(8);
        jButton18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton18);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("       ");
        jToolBar3.add(jLabel14);

        jButton19.setBackground(new java.awt.Color(255, 255, 255));
        jButton19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton19.setForeground(new java.awt.Color(49, 43, 103));
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisdespesas/img/centro_custo.png"))); // NOI18N
        jButton19.setText("Centro de Custo");
        jButton19.setBorderPainted(false);
        jButton19.setContentAreaFilled(false);
        jButton19.setFocusable(false);
        jButton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton19.setIconTextGap(8);
        jButton19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton19);

        jTabbedPane1.addTab("RELATÓRIOS", jToolBar3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        janela.desconectar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        CadastroConexao.open(janela);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.openInternal(new CentroCustoLista());        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.openInternal(new DespesasLista());        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        this.openInternal(new UsuarioLista()); // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        CadastroEmpresa.open(janela);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        RealizarBackup.open(janela);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        RealizarUpload.open(janela);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        Sobre.open(janela);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        GraficoAnual.open(janela);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        GraficoPeriodo.open(janela);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        RelatorioGeral.open(janela);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        RelatorioCentroCusto.open(janela);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JDesktopPane panel;
    // End of variables declaration//GEN-END:variables

    public void openInternal(JInternalFrame internal) {
        JInternalFrame jf[] = panel.getAllFrames();
        boolean exists = false;
        for (JInternalFrame f : jf) {
            if (f.getTitle().equals(internal.getTitle())) {
                exists = true;
                f.getDesktopPane().getDesktopManager().deiconifyFrame(f);
                f.getDesktopPane().getDesktopManager().maximizeFrame(f);
                f.getDesktopPane().getDesktopManager().minimizeFrame(f);
                f.setSize(panel.getSize().width, panel.getSize().height);
                f.setLocation(0, 0);
                f.moveToFront();
                f.requestFocusInWindow();
                break;
            }
        }
        if (!exists) {
            internal.setSize(panel.getSize().width, panel.getSize().height);
            internal.setLocation(0, 0);
            panel.add(internal);
            internal.setVisible(true);
            internal.requestFocusInWindow();
        }
    }
    
}