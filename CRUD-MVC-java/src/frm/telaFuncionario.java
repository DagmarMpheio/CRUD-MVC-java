/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frm;

import model.dao.FuncionarioDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Funcionario;

/**
 *
 * @author dagma
 */
public class telaFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form ListaDados
     */
    public telaFuncionario() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tbFuncionarios.getModel();
        tbFuncionarios.setRowSorter(new TableRowSorter(modelo));
        lerTabela();
        btnAlterar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    public void lerTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbFuncionarios.getModel();
        modelo.setNumRows(0);
        FuncionarioDAO dao = new FuncionarioDAO();

        for (Funcionario f : dao.getLista()) {
            modelo.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getUsuario(),
                f.getSenha()
            });
        }
    }
    
     public void lerTabelaPesquisa(String pes) {
        DefaultTableModel modelo = (DefaultTableModel) tbFuncionarios.getModel();
        modelo.setNumRows(0);
        FuncionarioDAO dao = new FuncionarioDAO();

        for (Funcionario f : dao.pesquisar(pes)) {
            modelo.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getUsuario(),
                f.getSenha()
            });
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

        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFuncionarios = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Funcionários");
        setResizable(false);

        txtNome.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel2.setText("Usuário");

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel3.setText("Senha");

        btnAlterar.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N

        btnPesquisar.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tbFuncionarios.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        tbFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Usuario", "Senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFuncionariosMouseClicked(evt);
            }
        });
        tbFuncionarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbFuncionariosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbFuncionarios);

        btnGuardar.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtSenha.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 205, Short.MAX_VALUE))
                            .addComponent(txtNome))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar)
                        .addComponent(btnAlterar)))
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            Funcionario f = new Funcionario();
            FuncionarioDAO dao = new FuncionarioDAO();
            if (!"".equals(txtNome.getText()) && !"".equals(txtUsuario.getText()) && !"".equals(txtSenha.getPassword())) {
                f.setNome(txtNome.getText());
                f.setUsuario(txtUsuario.getText());
                f.setSenha(new String(txtSenha.getPassword()));

                dao.adiciona(f);

                txtNome.setText("");
                txtUsuario.setText("");
                txtSenha.setText("");

                lerTabela();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campo!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tbFuncionariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbFuncionariosKeyReleased
        if (tbFuncionarios.getSelectedRow() != -1) {
            txtNome.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 1).toString());
            txtUsuario.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 2).toString());
            txtSenha.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 3).toString());
        }

    }//GEN-LAST:event_tbFuncionariosKeyReleased

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (tbFuncionarios.getSelectedRow() != -1) {
            Funcionario f = new Funcionario();
            FuncionarioDAO dao = new FuncionarioDAO();
            try {
                f.setNome(txtNome.getText());
                f.setUsuario(txtUsuario.getText());
                f.setSenha(new String(txtSenha.getPassword()));
                f.setId((long) tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 0));

                dao.alterar(f);

                txtNome.setText("");
                txtUsuario.setText("");
                txtSenha.setText("");
                btnGuardar.setEnabled(true);;
                btnAlterar.setEnabled(false);
                btnEliminar.setEnabled(false);

                lerTabela();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tbFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFuncionariosMouseClicked
        if (tbFuncionarios.getSelectedRow() != -1) {
            txtNome.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 1).toString());
            txtUsuario.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 2).toString());
            txtSenha.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 3).toString());
            btnAlterar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_tbFuncionariosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tbFuncionarios.getSelectedRow() != -1) {
            Funcionario f = new Funcionario();
            FuncionarioDAO dao = new FuncionarioDAO();
            try {
                f.setNome(txtNome.getText());
                f.setUsuario(txtUsuario.getText());
                f.setSenha(new String(txtSenha.getPassword()));
                f.setId((long) tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 0));

                dao.apagar(f);

                txtNome.setText("");
                txtUsuario.setText("");
                txtSenha.setText("");
                btnGuardar.setEnabled(true);
                btnAlterar.setEnabled(false);
                btnEliminar.setEnabled(false);

                lerTabela();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item para excluir");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        lerTabelaPesquisa(txtPesquisa.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFuncionarios;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
