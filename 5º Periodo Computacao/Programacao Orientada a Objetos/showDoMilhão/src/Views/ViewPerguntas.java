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
public class ViewPerguntas extends javax.swing.JFrame {
    private Jogador jogador = new Jogador();
    private Pergunta[] perguntas = new Pergunta[10];
    int pos = 0, resp, pulos = 0;
    public ViewPerguntas() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public ViewPerguntas(Jogador jogador) {
        this.jogador = jogador;
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

        btnGroupEscolha = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblPergunta = new javax.swing.JLabel();
        alternativaA = new javax.swing.JRadioButton();
        alternativaB = new javax.swing.JRadioButton();
        alternativaC = new javax.swing.JRadioButton();
        alternativaD = new javax.swing.JRadioButton();
        btnResponder = new javax.swing.JButton();
        btnPular = new javax.swing.JButton();
        btnParar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblValendo = new javax.swing.JLabel();
        lblPulos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel1.setText("Show do Milhão");

        lblPergunta.setText("Pergunta 1");
        lblPergunta.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblPerguntaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        btnGroupEscolha.add(alternativaA);
        alternativaA.setText("Alternativa 1");

        btnGroupEscolha.add(alternativaB);
        alternativaB.setText("Alternativa 2");

        btnGroupEscolha.add(alternativaC);
        alternativaC.setText("Alternativa 3");

        btnGroupEscolha.add(alternativaD);
        alternativaD.setText("Alternativa 4");

        btnResponder.setText("Responder");
        btnResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
        });

        btnPular.setText("Pular");
        btnPular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPularActionPerformed(evt);
            }
        });

        btnParar.setText("Parar");
        btnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });

        lblNome.setText("Nome e pontuacao");
        lblNome.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblNomeAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblValendo.setText("Valendo R$x reais");

        lblPulos.setText("Pulos: x");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPular, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(btnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(18, 18, 18)
                                .addComponent(lblValendo)
                                .addGap(18, 18, 18)
                                .addComponent(lblPulos)
                                .addGap(37, 37, 37))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alternativaD)
                            .addComponent(alternativaC)
                            .addComponent(alternativaB)
                            .addComponent(alternativaA))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(lblValendo)
                    .addComponent(lblPulos))
                .addGap(44, 44, 44)
                .addComponent(lblPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alternativaA)
                .addGap(18, 18, 18)
                .addComponent(alternativaB)
                .addGap(18, 18, 18)
                .addComponent(alternativaC)
                .addGap(18, 18, 18)
                .addComponent(alternativaD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResponder)
                    .addComponent(btnPular)
                    .addComponent(btnParar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblNomeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblNomeAncestorAdded
        lblNome.setText(jogador.getNome()+ ": " + String.valueOf(jogador.getPontos()) + " reais");
    }//GEN-LAST:event_lblNomeAncestorAdded

    private void lblPerguntaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblPerguntaAncestorAdded
        perguntas[0] = new Pergunta("São linguagens orientadas a objeto:", 
                "Java e PHP.",        //alternativaA
                "Delphi e Natural.",  //alternativaB 
                "SQLe C++.",          //alternativaC
                "Pascal e Java.",     //alternativaD
                "1000", 1);           //valor e resposta
        
        perguntas[1] = new Pergunta("<html>Na programação orientada a objetos são utilizados "
                + "classes e métodos. Um método", 
                //alternativaA
                "<html>deve ter assinatura e corpo quando aparecer em uma interface Java e deve ser público.", 
                //alternativaB
                "<html>com determinado nome não pode aparecer mais de uma vez na mesma classe, "
                        + "mesmo que receba parâmetros de tipos diferentes.", 
                //alternativaC
                "<html>em uma superclasse pode ser sobrescrito nas subclasses de uma relação de herança.", 
                //alternativaD
                "<html>construtor em uma classe Java pode ser sobrecarregado, desde que tenha um "
                        + "tipo de retorno diferente de void.", 
                //valor e resposta
                "2500", 3);
        
        perguntas[2] = new Pergunta("<html>Em um programa orientado a objetos, verifica-se que "
                + "a classe X estende a classe Y. Ou seja, pode-se afirmar, pelos preceitos da POO, que:", 
                
                "a classe Y é subclasse de X",    //alternativaA
                "a classe X é derivada de Y",     //alternativaB
                "a classe X é superclasse de Y",  //alternativaC 
                "a classe Y é derivada de X",     //alternativaD
                "5000", 2);                       //valor e resposta
        
        perguntas[3] = new Pergunta("<html>Assinale a afirmação correta quanto aos "
                + "fundamentos da tecnologia de orientação a objetos.", 
                //alternativaA
                "<html>O conceito de herança torna possível que uma classe “herde” em sua "
                        + "definição, variáveis (dados) e métodos (código) de outra classe já existente.",
                //alternativaB
                "<html>As classes são instâncias dos objetos que elas próprias definem.", 
                //alternativaC
                "<html>O conceito de polimorfismo possibilita que um objeto seja declarado "
                        + "como pertencendo a mais de uma classe simultaneamente.", 
                //alternativaD
                "<html>A interface é um recurso da orientação a objeto utilizado em Java "
                        + "que define ações que não devem ser obrigatoriamente executadas, "
                        + "mas que cada classe pode executar de forma igual.", 
                //valor e resposta
                "10000", 1);
        
        perguntas[4] = new Pergunta("<html>Sobre orientação a objetos, é correto afirmar:",
                //alternativaA
                "<html>Os objetos têm seu estado definido pelos métodos e seu comportamento definido "
                        + "nas variáveis de instância.", 
                //alternativaB
                "<html>Uma interface é uma classe 100% abstrata, ou seja, uma classe que não pode ser "
                        + "instanciada.", 
                //alternativaC
                "<html>Um relacionamento de herança significa que a superclasse herdará as variáveis "
                        + "de instância e métodos da subclasse.", 
                //alternativaD
                "<html>A principal regra prática do encapsulamento é marcar as variáveis de instância "
                        + "como públicas e fornecer métodos de captura e configuração privados.", 
                //valor e resposta
                "25000", 2);
        
        perguntas[5] = new Pergunta("<html>A alteração do comportamento dos métodos herdados "
                + "das superclasses para um comportamento mais específico nas subclasses, de forma "
                + "que contém a mesma assinatura e o mesmo tipo de retorno, relaciona-se a",
                
                "<html>overloading.",   //alternativaA
                "<html>sobrecarga.",    //alternativaB
                "<html>portabilidade.", //alternativaC
                "<html>sobrescrita.",   //alternativaD
                "50000", 4);            //valor e resposta
        
        perguntas[6] = new Pergunta("<html>Na programação Orientada a Objetos", 
                //alternativaA
                "<html>as Classes definem os serviços que podem ser solicitados a um construtor.", 
                //alternativaB
                "<html>as Classes definem o comportamento dinâmico de uma instância.", 
                //alternativaC
                "<html>as Classes são tipos de objetos que descrevem as informações "
                        + "armazenadas e os serviços providos por um objeto.", 
                //alternativaD
                "<html>a união de todos os objetos de uma classe forma seu método construtor.", 
                //valor e resposta
                "100000", 3);
        
        perguntas[7] = new Pergunta("<html>Na orientação a objetos, o conceito de encapsulamento "
                + "corresponde à propriedade de", 
                //alternativaA
                "<html>esconder ou ocultar detalhes da implementação de uma dada classe de outras "
                        + "classes.", 
                //alternativaB
                "<html>usar variáveis e constantes do tipo inteiro nos métodos das classes "
                        + "implementadas.", 
                //alternativaC
                "<html>receber, por uma classepontos, uma mensagem sem parâmetros.", 
                //alternativaD
                "<html>ter um conjunto de objetos com a mesma classe.",
                //valor e resposta
                "250000", 1);
        
        perguntas[8] = new Pergunta("Acerca de orientação a objetos, assinale a opção correta.", 
                //alternativaA
                "<html>Os desenvolvedores de um sistema devem ter como objetivo a construção de "
                        + "classes com baixa coesão e alto acoplamento.", 
                //alternativaB
                "<html>Membros de dados podem ser acessados diretamente, mas somente podem ser "
                        + "alterados por meio de métodos específicos.", 
                //alternativaC
                "<html>O polimorfismo caracteriza-se pela possibilidade de vários métodos terem "
                        + "o mesmo nome, porém com assinaturas diferentes.", 
                //alternativaD
                "<html>NDA.", 
                //valor e resposta
                "500000", 2);
        
        perguntas[9] = new Pergunta("<html>Na linguagem Java, o método executeQuery da interface "
                + "Statement, envia uma instrução SQL select para o banco de dados e retorna, se a "
                + "consulta for válida e uma conexão estiver estabelecida, um ou mais registros em "
                + "um objeto da interface:", 
                
                "ResultSet.",           //alternativaA
                "ResultSetMetaData.",   //alternativaB
                "ResultSetQueryData.",  //alternativaC
                "PreparedStatement.",   //alternativaD
                "1000000", 1);          //valor e resposta
        
        
        setTexto(0);
//        lblPergunta.setText(perguntas[0].getPergunta());
//        alternativaA.setText(perguntas[0].getAlternativaA());
//        alternativaB.setText(perguntas[0].getAlternativaB());
//        alternativaC.setText(perguntas[0].getAlternativaC());
//        alternativaD.setText(perguntas[0].getAlternativaD());
//        lblValendo.setText("Valendo " + perguntas[0].getValor() + " reais");
    }//GEN-LAST:event_lblPerguntaAncestorAdded

    private void btnResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponderActionPerformed
        if(alternativaA.isSelected())
            resp = 1;
        else if(alternativaB.isSelected())
            resp = 2;
        else if(alternativaC.isSelected())
            resp = 3;
        else if(alternativaD.isSelected())
            resp = 4;
        
        if(!alternativaA.isSelected() && !alternativaB.isSelected() && 
                !alternativaC.isSelected() && !alternativaD.isSelected())
            JOptionPane.showMessageDialog(rootPane, "Selecione uma Alternativa!");
        else if(perguntas[pos].getResposta() == resp) {
            if(pos == 9){
                int input = JOptionPane.showConfirmDialog(rootPane, "Deseja jogar novamente?", 
                        "Voce ganhou um milhão de reais!!!", JOptionPane.YES_NO_OPTION);
                if(input == 0){
                    ViewInicial viewInicial = new ViewInicial();
                    viewInicial.setVisible(true);
                }
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(rootPane, "Resposta Certa!");
                jogador.setPontos(Integer.parseInt(perguntas[pos].getValor()));
                setTexto(1);
                pos++;
            }
        } else {
            if(pos == 9){
                JOptionPane.showMessageDialog(rootPane,"Voce perdeu tudo!!!"
                    + "\nMais sorte na próxima :)",
                    "Resposta Errada!", 2);
            } else {
                JOptionPane.showMessageDialog(rootPane,"Voce ganhou R$" 
                        + jogador.getPontos()/2
                        + "\nMais sorte na próxima :)",
                        "Resposta Errada!", 2);
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnResponderActionPerformed

    private void btnPularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPularActionPerformed
        if(pos == 9)
            JOptionPane.showMessageDialog(rootPane, "Você não pode pular na pergunta de 1 milhão!");
        
        
        if(pulos >= 2) 
            JOptionPane.showMessageDialog(rootPane, "Você não tem mais pulos!");
        else {
            /* determina o nivel de dificuldade da pergunta de acordo com o nivel dela
               quanto mais próximo da décima ela fica mais difícil */
            if(pos < 5)
                if(pulos == 0)
                    perguntas[pos] = new Pergunta("<html>Assinale a alternativa que apresenta, "
                            + "corretamente, o conceito de programação orientada a objetos que "
                            + "promove a reutilização de software.", 
                            "Abstração de dados.", "Polimorfismo.", "Herança.", 
                            "Sobrecarga de métodos.", perguntas[pos].getValor(), 3);
                else
                    perguntas[pos] = new Pergunta("<html>A capacidade de objetos de diferentes "
                            + "classes relacionadas por herança ou implementação de interface "
                            + "responderem diferentemente à mesma chamada de método é conhecida como", 
                            "polimorfismo.", "composição.","especialização.", 
                            "generalização", perguntas[pos].getValor(), 1);
            
            
            else if (pos >= 5 && pos < 7)
                if(pulos == 0)
                    perguntas[pos] = new Pergunta("<html>É, em geral, um recurso utilizado quando classes "
                            + "diferentes (não relacionadas) precisam de funcionalidades comuns (métodos) ou "
                            + "utilizam constantes comuns. O recurso citado é ", 
                            "pacote.", "subclasse.", "interface.", "encapsulamento.", perguntas[pos].getValor(), 4);
                else
                    perguntas[pos] = new Pergunta("<html>Quando um membro de uma superclasse pode ser acessado "
                            + "apenas por membros dessa superclasse, por membros de suas subclasses e por membros "
                            + "de outras classes do mesmo pacote, é possível afirmar que esse membro deve ser", 
                            "public.", "protected", "private.", "abstract.", perguntas[pos].getValor(), 2);
            
            
            else
                if(pulos == 0)
                    perguntas[pos] = new Pergunta("<html>Assinale a alternativa que apresenta um "
                            + "trecho de código Java correto para a declaração de uma classe Java "
                            + "que simula a herança múltipla.", 
                            "<html>public class Rato extends Mamifero, Roedor { /** corpo da classe */ }", 
                            "<html>public class Rato inherits Mamifero implements Roedor, Animal {/** corpo da classe */ }", 
                            "<html>public class Rato extends Mamifero, Roedor implements Animal { /** corpo da classe */ }", 
                            "<html>public class Rato extends Mamifero implements Roedor, Animal { /** corpo da classe */ }", 
                            perguntas[pos].getValor(), 4);
                else
                    perguntas[pos] = new Pergunta("<html>Em relação a projetos orientados a objetos, "
                            + "a restrição de multiplicidade", 
                            "<html>garante que uma classe seja utilizada na composição de múltiplos objetos.", 
                            "<html>descreve a quantidade de objetos que podem ser instanciados para uma determinada classe.", 
                            "<html>indica o número de instâncias de uma classe que participa da relação com as instâncias de "
                                    + "outra classe.", 
                            "<html>expressa a possibilidade de composição de múltiplos atributos e métodos para um objeto.", 
                            perguntas[pos].getValor(), 3);
            this.pulos++;
            setTexto(0);
        }
    }//GEN-LAST:event_btnPularActionPerformed

    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        if(pos == 0)
            JOptionPane.showMessageDialog(rootPane, "Você nao ganhou nada!");
        else
            JOptionPane.showMessageDialog(rootPane, "Parabéns, voce ganhou R$" + jogador.getPontos());
        this.dispose();
    }//GEN-LAST:event_btnPararActionPerformed

    private void setTexto(int i){
        lblNome.setText(jogador.getNome()+ ": " + String.valueOf(jogador.getPontos()) + " reais");
        lblPergunta.setText(perguntas[pos+i].getPergunta());
        alternativaA.setText(perguntas[pos+i].getAlternativaA());
        alternativaB.setText(perguntas[pos+i].getAlternativaB());
        alternativaC.setText(perguntas[pos+i].getAlternativaC());
        alternativaD.setText(perguntas[pos+i].getAlternativaD());
        lblPulos.setText("Pulos: " + (2 - this.pulos));
        lblValendo.setText("Valendo " + perguntas[pos+i].getValor() + " reais");
        btnGroupEscolha.clearSelection();
    }
    
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
            java.util.logging.Logger.getLogger(ViewPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPerguntas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton alternativaA;
    private javax.swing.JRadioButton alternativaB;
    private javax.swing.JRadioButton alternativaC;
    private javax.swing.JRadioButton alternativaD;
    private javax.swing.ButtonGroup btnGroupEscolha;
    private javax.swing.JButton btnParar;
    private javax.swing.JButton btnPular;
    private javax.swing.JButton btnResponder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPergunta;
    private javax.swing.JLabel lblPulos;
    private javax.swing.JLabel lblValendo;
    // End of variables declaration//GEN-END:variables
}
