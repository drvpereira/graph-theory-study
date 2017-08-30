/*
 * Sistema Integrado de Patrim�nio e Administra��o de Contratos
 * Superintend�ncia de Inform�tica - UFRN
 * 
 * Criado em 19/06/2005
 *
 */
package br.ufrn.info.graph.ui;

/**
 * Representa os dados de entrada de um Input Dialog
 *  
 * @author David
 *  
 */
public class InputDialogData {
    String textResponse;
    boolean buttonResponse;
    
    public InputDialogData(){
        setTextResponse("");
        setButtonResponse(false);
    }
    
    public boolean isButtonResponse() {
        return buttonResponse;
    }
    
    public String getTextResponse() {
        return textResponse;
    }
    
    public void setButtonResponse(boolean b) {
        buttonResponse = b;
    }

    public void setTextResponse(String string) {
        textResponse = string;
    }
}
