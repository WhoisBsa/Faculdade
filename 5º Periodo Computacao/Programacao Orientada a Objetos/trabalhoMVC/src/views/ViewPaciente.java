/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.PacienteController;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author matheus
 */
public class ViewPaciente extends javax.swing.JFrame {

    ResultSet rs = null;
    
    /**
     * Creates new form ViewPaciente
     */
    public ViewPaciente() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnDel = new javax.swing.JToggleButton();
        txtId = new javax.swing.JTextField();
        txtCadNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        txtCadIdade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCad = new javax.swing.JToggleButton();
        btnEdit = new javax.swing.JToggleButton();
        btnVizu = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        radioMasculino = new javax.swing.JRadioButton();
        radioFeminino = new javax.swing.JRadioButton();
        txtCadCPF = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnDel.setText("Excluir");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        jLabel6.setText("Id Cliente:");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("CPF:");

        jLabel3.setText("Idade:");

        btnCad.setText("Cadastrar");
        btnCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadActionPerformed(evt);
            }
        });

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnVizu.setText("Visualizar");
        btnVizu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVizuActionPerformed(evt);
            }
        });

        jLabel4.setText("Gênero:");

        buttonGroup1.add(radioMasculino);
        radioMasculino.setText("Masculino");

        buttonGroup1.add(radioFeminino);
        radioFeminino.setText("Feminino");

        try {
            txtCadCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCadNome, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCadIdade, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(txtCadCPF))
                                .addGap(89, 89, 89))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(btnCad, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                .addGap(83, 83, 83)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtId))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVizu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioMasculino)
                        .addGap(18, 18, 18)
                        .addComponent(radioFeminino)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCadNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(btnEdit)
                        .addComponent(btnDel)
                        .addComponent(btnVizu))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCadCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCadIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(radioMasculino)
                    .addComponent(radioFeminino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCad)
                    .addComponent(btnSair))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        String id = txtId.getText();
        
        PacienteController pc = new PacienteController();

        int input = JOptionPane.showConfirmDialog(rootPane, "Deseja mesmo excluir?", "Excluir", JOptionPane.YES_NO_OPTION);

        if(input == 0) {
            String result = pc.remover(Integer.parseInt(id));

            if(result != null)
            JOptionPane.showMessageDialog(rootPane, result);
            else
            JOptionPane.showMessageDialog(rootPane, "Houve algum erro de conexão, tente novamente!");
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int input = JOptionPane.showConfirmDialog(rootPane, "Deseja mesmo sair?", "Sair", JOptionPane.YES_NO_OPTION);

        if(input == 0) {
            new ViewHome().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadActionPerformed
        if(txtCadNome.getText().isBlank() || txtCadCPF.getText().isBlank() ||
            txtCadIdade.getText().isBlank() || !(radioMasculino.isSelected() ||
                radioFeminino.isSelected()))
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos!");
        else {
            String nome = txtCadNome.getText();
            String cpf = txtCadCPF.getText();
            String idade = txtCadIdade.getText();
            String genero = "";
            if(radioMasculino.isSelected())
                genero = "M";
            else
                genero = "F";
            
            try {
            PacienteController pc = new PacienteController(nome, cpf, Integer.parseInt(idade), genero);
            
            String result = pc.salvar();

            if(result != null)
            JOptionPane.showMessageDialog(rootPane, result);
            else
            JOptionPane.showMessageDialog(rootPane, "Houve algum erro de conexão, tente novamente!");
            
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Houve algum erro de conexão, tente novamente!");
            }
            

            txtCadNome.setText("");
            txtCadCPF.setText("");
            txtCadIdade.setText("");
            buttonGroup1.clearSelection();
        }
    }//GEN-LAST:event_btnCadActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String id = txtId.getText();
        
        PacienteController pc = new PacienteController();

        if(pc.checaIdouData(Integer.parseInt(id))){
            ViewEditPaciente edit = new ViewEditPaciente(Integer.parseInt(id));

            edit.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Id inexistente!");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnVizuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVizuActionPerformed
        String id = txtId.getText();
        String result = null;

        PacienteController pc = new PacienteController();

        if(pc.checaIdouData(Integer.parseInt(id))){
            rs = pc.visualizar(Integer.parseInt(id));
            
            try {
                if(rs.next())
                    result = "Nome: " + rs.getString("nome") +
                        "\nCPF: " + rs.getString("cpf") + "\nIdade: " + rs.getString("idade") +
                        "\nGênero: " + rs.getString("genero") + "\nConsultas Marcadas: \n" + 
                        rs.getString("data") + "\n";
                while(rs.next()) 
                    result += rs.getString("data") + "\n";
                
                JOptionPane.showMessageDialog(rootPane, result);
            } catch (SQLException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(rootPane, "Houve algum erro de conexão, tente novamente!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Id inexistente!");
        }
    }//GEN-LAST:event_btnVizuActionPerformed

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
            java.util.logging.Logger.getLogger(ViewPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCad;
    private javax.swing.JToggleButton btnDel;
    private javax.swing.JToggleButton btnEdit;
    private javax.swing.JButton btnSair;
    private javax.swing.JToggleButton btnVizu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton radioFeminino;
    private javax.swing.JRadioButton radioMasculino;
    private javax.swing.JFormattedTextField txtCadCPF;
    private javax.swing.JTextField txtCadIdade;
    private javax.swing.JTextField txtCadNome;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
