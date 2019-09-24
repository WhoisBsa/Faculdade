/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author matheus
 */
public class Pergunta {
    private String pergunta;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private String valor;
    private int resposta;
    
    public Pergunta() {}
    
    public Pergunta(String pergunta, String alternativaA, String alternativaB, 
            String alternativaC, String alternativaD, String valor, int resposta) {
        this.pergunta     = pergunta;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
        this.valor        = valor;
        this.resposta     = resposta;
    }
    
    /**
     * @return the pergunta
     */
    public String getPergunta() {
        return pergunta;
    }

    /**
     * @param pergunta the pergunta to set
     */
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    /**
     * @return the alternativaA
     */
    public String getAlternativaA() {
        return alternativaA;
    }

    /**
     * @param alternativaA the alternativaA to set
     */
    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    /**
     * @return the alternativaB
     */
    public String getAlternativaB() {
        return alternativaB;
    }

    /**
     * @param alternativaB the alternativaB to set
     */
    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    /**
     * @return the alternativaC
     */
    public String getAlternativaC() {
        return alternativaC;
    }

    /**
     * @param alternativaC the alternativaC to set
     */
    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    /**
     * @return the alternativaD
     */
    public String getAlternativaD() {
        return alternativaD;
    }

    /**
     * @param alternativaD the alternativaD to set
     */
    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the resposta
     */
    public int getResposta() {
        return resposta;
    }

    /**
     * @param resposta the resposta to set
     */
    public void setResposta(int resposta) {
        this.resposta = resposta;
    }
}
