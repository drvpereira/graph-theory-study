/*
 * Sistema Integrado de Patrimônio e Administração de Contratos
 * Superintendência de Informática - UFRN
 * 
 * Created on 03/06/2005
 *
 */
package br.ufrn.info.graph.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Cria a interface gráfica para a aplicação
 * 
 * @author David
 *  
 */
public class GrafoWindow {

    private Display display;
    
    protected Shell shell;

    protected Canvas canvas;

    protected GC gc;
    
    public GrafoWindow() {
        display = new Display();
        shell = new Shell(display);
        canvas = new Canvas(shell, SWT.BORDER);
        gc = new GC(canvas);
    }

    public void runApp() {
        shell.setSize(ConstantesUI.WINDOW_WIDTH, ConstantesUI.WINDOW_HEIGHT);
        shell.setText(ConstantesUI.APP_NAME);
        shell.setMaximized(true);
        shell.open();

        shell.addMouseMoveListener(new MouseMoveListener() {
            public void mouseMove(MouseEvent e) {
                shell.setCursor(new Cursor(display, SWT.CURSOR_ARROW));
            }
        });

        while (!shell.isDisposed())
            while (!shell.isDisposed())
                if (!display.readAndDispatch())
                    display.sleep();

        try {
            shell.dispose();
            display.dispose();
        } catch (Exception e) {

        }
    }

}