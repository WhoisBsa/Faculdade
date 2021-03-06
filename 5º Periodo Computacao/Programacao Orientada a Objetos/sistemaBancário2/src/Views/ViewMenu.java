/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Classes.*;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public class ViewMenu extends javax.swing.JFrame {
    private ContaCorrente[] contaCorrente = new ContaCorrente[10];
    private ContaPoupanca[] contaPoupanca = new ContaPoupanca[10];
    private Banco banco = new Banco();
    private int posCorrente = 4, posPoupanca = 0, numConta = 5;
    public ViewMenu() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public ViewMenu(Banco banco) {
        this.banco = banco;
        contaCorrente[0] = banco.procurarConta(1, contaCorrente[0]);
        contaCorrente[1] = banco.procurarConta(2, contaCorrente[1]);
        contaCorrente[2] = banco.procurarConta(3, contaCorrente[2]);
        contaCorrente[3] = banco.procurarConta(4, contaCorrente[3]);
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

        btnDepositar = new javax.swing.JToggleButton();
        btnSacar = new javax.swing.JToggleButton();
        btnTransferir = new javax.swing.JToggleButton();
        btnSelecionar = new javax.swing.JToggleButton();
        btnCriar = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        lblDados = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        btnSair = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnDepositar.setText("DEPOSITAR");
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });

        btnSacar.setText("SACAR");
        btnSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacarActionPerformed(evt);
            }
        });

        btnTransferir.setText("TRANSFERIR");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });

        btnSelecionar.setText("SELECIONAR CONTA");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnCriar.setText("CRIAR CONTA");
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("JAVA BANK");

        lblDados.setText("Dados ");
        lblDados.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblDadosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblSaldo.setText("Saldo");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDados, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSaldo)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSaldo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacar)
                    .addComponent(btnTransferir)
                    .addComponent(btnDepositar))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriar)
                    .addComponent(btnSelecionar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnSair)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacarActionPerformed
        String input = JOptionPane.showInputDialog("Digite o valor do saque");
        try {
            if(input.isBlank())
                JOptionPane.showMessageDialog(rootPane, "Digite um valor válido");
            else {
                String result = this.contaCorrente[0].sacar(Double.parseDouble(input));
                JOptionPane.showMessageDialog(rootPane, result);
                lblSaldo.setText("<html>Saldo: " + contaCorrente[0].getSaldo());
            }
        } catch(NullPointerException ex) {}
    }//GEN-LAST:event_btnSacarActionPerformed

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
        String input = JOptionPane.showInputDialog("Digite o valor do deposito");
        try {
            if(input.isBlank())
                JOptionPane.showMessageDialog(rootPane, "Digite um valor válido");
            else {
                String result = this.contaCorrente[0].depositar(Double.parseDouble(input));

                JOptionPane.showMessageDialog(rootPane, result);
                lblSaldo.setText("<html>Saldo: " + contaCorrente[0].getSaldo());
            }   
        } catch(NullPointerException ex) {}
    }//GEN-LAST:event_btnDepositarActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        String contas = "";
        String[] valores = {"Conta Corrente", "Conta Poupança"};
        Object selected = JOptionPane.showInputDialog(null, "Qual conta deseja transferir?", 
                "Selecione", JOptionPane.DEFAULT_OPTION, null, valores, "0");
        if(selected != null){ 
            String selectedString = selected.toString();
            if(selectedString.equals("Conta Corrente")){
                contas += "Contas Correntes:\n";
                for(int i = 1; i < posCorrente; i++) {
                    if(contaCorrente[i].getNumConta() != 0)
                        contas += "Conta " + (i+1) + ": " + contaCorrente[i].getNumConta() + "\n";
                }
            } else {
                contas += "\nContas Poupanca:\n";
                for(int i = 0; i < posPoupanca; i ++) {
                    if(contaPoupanca[i].getNumConta() != 0)
                        contas += "Conta " + (i+1) + ": " + contaPoupanca[i].getNumConta() + "\n";
                }
            }
            
            String input = JOptionPane.showInputDialog("Digite o valor da transferencia");
            String conta = JOptionPane.showInputDialog("Numero da conta do destinatario\n" + contas);

            try {
                String result = "Nenhuma conta encontrada";

                if(input.isBlank() || conta.isBlank())
                    JOptionPane.showMessageDialog(rootPane, "Digite um valor válido");
                else {
                    if(selectedString.equals("Conta Corrente")){
                        for(int i = 0; i < posCorrente; i++) {
                            if(contaCorrente[i].getNumConta() == Integer.parseInt(conta) && i != 0 && contaCorrente[i].getNumConta() != 0) {
                                result = this.contaCorrente[0].transferir(Double.parseDouble(input), contaCorrente[i]);
                                lblSaldo.setText("<html>Saldo: " + contaCorrente[0].getSaldo());
                                break;
                            }
                            else if(conta.equals("1"))
                                result = "Não é possivel fazer transferências para a mesma conta.";
                        }
                    } else {
                        for(int i = 0; i < posPoupanca; i++) {
                            if(contaPoupanca[i].getNumConta() == Integer.parseInt(conta) && contaPoupanca[i].getNumConta() != 0){
                                result = this.contaCorrente[0].transferir(Double.parseDouble(input), contaPoupanca[i]);
                                lblSaldo.setText("<html>Saldo: " + contaCorrente[0].getSaldo());
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(rootPane, result);
                }   
            } catch(NullPointerException ex) {}
        }                                                 
    }//GEN-LAST:event_btnTransferirActionPerformed

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        String[] valores = {"Conta Corrente", "Conta Poupança"};
        Object selected = JOptionPane.showInputDialog(null, "Qual conta deseja criar?", "Selecione", JOptionPane.DEFAULT_OPTION, null, valores, "0");
        if(selected != null){ 
            String selectedString = selected.toString();
            try {
                if(selectedString.equals("Conta Corrente")){
                    double saldo = Double.parseDouble(JOptionPane.showInputDialog("Numero da conta: " + numConta + "\nSaldo:"));
                    if(String.valueOf(saldo).isBlank())
                        JOptionPane.showMessageDialog(rootPane, "Saldo inválido!");
                    else {
                        contaCorrente[posCorrente] = new ContaCorrente(numConta, saldo);
                        banco.inserir(contaCorrente[posCorrente]);
                        posCorrente++;
                        numConta++;
                    }
                } else if(selectedString.equals("Conta Poupança")) {
                    double saldo = Double.parseDouble(JOptionPane.showInputDialog("Numero da conta: " + numConta + "\nSaldo:"));
                    if(String.valueOf(saldo).isBlank())
                        JOptionPane.showMessageDialog(rootPane, "Saldo inválido!");
                    else {
                        contaPoupanca[posPoupanca] = new ContaPoupanca(numConta, saldo);
                        banco.inserir(contaPoupanca[posPoupanca]);
                        posPoupanca++;
                        numConta++;
                    }
                }
            } catch(NullPointerException ex) {}
        }else{
            JOptionPane.showMessageDialog(rootPane, "Cacelado");
        }
    }//GEN-LAST:event_btnCriarActionPerformed

    private void lblDadosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblDadosAncestorAdded
        lblDados.setText("<html>Numero da conta: " + contaCorrente[0].getNumConta());
        lblSaldo.setText("<html>Saldo: " + contaCorrente[0].getSaldo());
    }//GEN-LAST:event_lblDadosAncestorAdded

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        boolean contaOk = false;
        int result = -1, contaC = 0, contaP = 0;
        Object[] options1 = { "Remover Conta", "Gerar Relatório", "Cancelar" };
        String input = JOptionPane.showInputDialog("Informe o numero da conta");
        try {
            if(input.isBlank())
                JOptionPane.showMessageDialog(rootPane, "Digite um numero de conta válido");
            else {
                for(int i = 0; i < posCorrente; i++) {
                    if(contaCorrente[i].getNumConta() == Integer.parseInt(input)) {
                        contaC = i;
                        result = JOptionPane.showOptionDialog(rootPane,  contaCorrente[i].mostrarDados(), 
                                "Escolha uma Opção", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                                null, options1, null);
                        contaOk = true;
                    }
                }

                for(int i = 0; i < posPoupanca; i++) {
                    if(contaPoupanca[i].getNumConta() == Integer.parseInt(input)) {
                        contaP = i;
                        result = JOptionPane.showOptionDialog(rootPane,  contaPoupanca[i].mostrarDados(), 
                                "Escolha uma Opção", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                                null, options1, null);
                        contaOk = true;
                    }
                }

                if(!contaOk)
                    JOptionPane.showMessageDialog(rootPane, "Nenhuma conta encontrada");            

                if(result == 0) {  // optou por remover
                    if(input.equals("1"))
                        JOptionPane.showMessageDialog(rootPane, "Não pode remover sua própria conta");
                    else{
                        if(contaC != 0){
                            this.contaCorrente[contaC] = banco.remove(contaCorrente[contaC].getNumConta(), contaCorrente[contaC]);
                            this.contaCorrente[contaC] = new ContaCorrente();
                            if(this.contaCorrente[contaC].getNumConta() == 0)
                                JOptionPane.showMessageDialog(rootPane, "Conta corrente removida com sucesso");
                        }
                        else if (contaP != 0){
                            this.contaPoupanca[contaP] = banco.remove(contaPoupanca[contaP].getNumConta(), contaPoupanca[contaP]);
                            this.contaPoupanca[contaP] = new ContaPoupanca();
                            if(this.contaPoupanca[contaC].getNumConta() == 0)
                                JOptionPane.showMessageDialog(rootPane, "Conta poupanca removida com sucesso");
                        }
                    }   
                } else if (result == 1) {
                    if(contaC != 0)
                        JOptionPane.showMessageDialog(rootPane, contaCorrente[contaC].mostrarDados());
                    else if (contaP != 0)
                        JOptionPane.showMessageDialog(rootPane, contaCorrente[contaC].mostrarDados());
                }
            }
        } catch(NullPointerException ex) {}
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int input = JOptionPane.showConfirmDialog(rootPane, "Deseja mesmo sair?", 
                        "Sair", JOptionPane.YES_NO_OPTION);
        if(input == 0){
            this.dispose();
        }
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCriar;
    private javax.swing.JToggleButton btnDepositar;
    private javax.swing.JToggleButton btnSacar;
    private javax.swing.JToggleButton btnSair;
    private javax.swing.JToggleButton btnSelecionar;
    private javax.swing.JToggleButton btnTransferir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDados;
    private javax.swing.JLabel lblSaldo;
    // End of variables declaration//GEN-END:variables
}
