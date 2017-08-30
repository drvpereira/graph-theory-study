/*
 * Sistema Integrado de Patrimônio e Administração de Contratos
 * Superintendência de Informática - UFRN
 * 
 * Criado em 19/06/2005
 *
 */
package br.ufrn.info.graph.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Simula um Input Dialog para a interface
 *  
 * @author David
 *  
 */
public class InputDialog extends Dialog {
    private Label lblQuestion;
    private Text txtResponse;
    private Button btnOkay;
    private Button btnCancel;
    private InputDialogData data;

    public InputDialog(Shell arg0) {
        super(arg0);
    }
    
    public InputDialogData open () {
        data = new InputDialogData();
        final Shell shell = new Shell(getParent(), SWT.DIALOG_TRIM |
                SWT.APPLICATION_MODAL);
        shell.setText(getText());
        shell.setSize(260,130);
        lblQuestion = new Label(shell, SWT.NONE);
        lblQuestion.setLocation(25,10);
        lblQuestion.setSize(150,20);
        lblQuestion.setText("Digite o valor da aresta:");
        txtResponse = new Text(shell, SWT.BORDER);
        txtResponse.setLocation(25,30);
        txtResponse.setSize(200,20);
        btnOkay = new Button (shell, SWT.PUSH);
        btnOkay.setText ("Ok");
        btnOkay.setLocation(65,60);
        btnOkay.setSize(55,25);
        btnCancel = new Button (shell, SWT.PUSH);
        btnCancel.setText ("Cancel");
        btnCancel.setLocation(125,60);
        btnCancel.setSize(55,25);
        Listener listener = new Listener () {
            public void handleEvent (Event event) {
                data.setButtonResponse(event.widget == btnOkay);
                data.setTextResponse(txtResponse.getText());
                shell.close ();
            }
        };
        btnOkay.addListener(SWT.Selection, listener);
        btnCancel.addListener(SWT.Selection, listener);
        shell.open();
        Display display = getParent().getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        return data;
    }
}