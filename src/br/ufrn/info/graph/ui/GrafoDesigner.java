/*
 * Sistema Integrado de Patrimônio e Administração de Contratos
 * Superintendência de Informática - UFRN
 * 
 * Created on 16/06/2005
 *
 */
package br.ufrn.info.graph.ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import br.ufrn.info.graph.algorithms.Coloracao;
import br.ufrn.info.graph.algorithms.ComponentesConexas;
import br.ufrn.info.graph.domain.AbstractGrafo;
import br.ufrn.info.graph.domain.Aresta;
import br.ufrn.info.graph.domain.GrafoFactory;
import br.ufrn.info.graph.domain.TipoGrafo;
import br.ufrn.info.graph.domain.Vertice;

/**
 * Desenha a área de trabalho da interface gráfica
 * 
 * @author David Ricardo
 *  
 */
public class GrafoDesigner extends GrafoWindow {

    /**
     * Representa a ação atual de acordo com o selecionado na barra de
     * ferramentas
     */
    private int actualAction;

    private int cliqueAresta = 0;

    private Vertice selectedVertice;

    private AbstractGrafo grafo;

    public GrafoDesigner() {
        super();
        grafo = GrafoFactory.getInstance().getGrafo(TipoGrafo.LISTA_ARESTAS);

        createMenu();
        createToolBar();
        createCanvas();
    }

    /**
     * Cria o menu da aplicação
     */
    public void createMenu() {

        Menu menu = new Menu(shell, SWT.BAR);
        shell.setMenuBar(menu);

        MenuItem arquivo = new MenuItem(menu, SWT.CASCADE);
        arquivo.setText("Arquivo");

        MenuItem opcoes = new MenuItem(menu, SWT.CASCADE);
        opcoes.setText("Opções");

        Menu opMenu = new Menu(shell, SWT.DROP_DOWN);
        opcoes.setMenu(opMenu);

        MenuItem opGrafo = new MenuItem(opMenu, SWT.CASCADE);
        opGrafo.setText("Grafo");

        Menu grafoMenu = new Menu(shell, SWT.DROP_DOWN);
        opGrafo.setMenu(grafoMenu);

        final MenuItem grafoOrientado = new MenuItem(grafoMenu, SWT.CHECK);
        grafoOrientado.setText("Orientado");

        grafoOrientado.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                if (!grafoOrientado.getSelection())
                    grafo.setOrientado(false);
                else
                    grafo.setOrientado(true);
                canvas.redraw();
            }
        });
        
        final MenuItem grafoRotulado = new MenuItem(grafoMenu, SWT.CHECK);
        grafoRotulado.setText("Rotulado");

        grafoRotulado.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event arg0) {
                if (!grafoRotulado.getSelection())
                    grafo.setRotulado(false);
                else
                    grafo.setRotulado(true);
                canvas.redraw();
            }
        });
        
        MenuItem algoritmos = new MenuItem(menu, SWT.CASCADE);
        algoritmos.setText("Algoritmos");

        Menu algMenu = new Menu(shell, SWT.DROP_DOWN);
        algoritmos.setMenu(algMenu);

        MenuItem compCon = new MenuItem(algMenu, SWT.PUSH);
        compCon.setText("Componentes Conexas");

        compCon.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                ComponentesConexas comp = new ComponentesConexas(grafo, shell.getDisplay());
                comp.solve();
                canvas.redraw();
            }
        });

//        MenuItem cicloHam = new MenuItem(algMenu, SWT.PUSH);
//        cicloHam.setText("Ciclo Hamiltoniano Mínimo");
//        
//        cicloHam.addListener(SWT.Selection, new Listener() {
//            public void handleEvent(Event e) {
//                CicloHamiltoniano ciclo = new CicloHamiltoniano(grafo);
//                ciclo.solve();
//                canvas.redraw();
//            }
//        });
        
        MenuItem ajuda = new MenuItem(menu, SWT.CASCADE);
        ajuda.setText("Ajuda");

    }

    /**
     * Cria a barra de ferramentas da aplicação
     */
    public void createToolBar() {
        ToolBar bar = new ToolBar(shell, SWT.FLAT);
        bar.setSize(640, ConstantesUI.ALTURA_TOOLBAR);

        Image newIcon = new Image(shell.getDisplay(), "new.gif");
        Image openIcon = new Image(shell.getDisplay(), "open.gif");
        Image saveIcon = new Image(shell.getDisplay(), "save.gif");

        ToolItem newItem = new ToolItem(bar, SWT.PUSH);
        ToolItem openItem = new ToolItem(bar, SWT.PUSH);
        ToolItem saveItem = new ToolItem(bar, SWT.PUSH);

        newItem.setImage(newIcon);
        openItem.setImage(openIcon);
        saveItem.setImage(saveIcon);

        newItem.addListener(SWT.Selection, new Listener() { 
            public void handleEvent(Event e) {
                grafo = GrafoFactory.getInstance().getGrafo(TipoGrafo.LISTA_ARESTAS);
                canvas.redraw();
            }
        });

        
        openItem.addListener(SWT.Selection, new Listener() { 
            public void handleEvent(Event e) {
                String fileExtensions[] = { "*.graph" };
                
                FileDialog file = new FileDialog(shell, SWT.OPEN);
                file.setText("Abrir grafo");
                file.setFilterPath(".");
                file.setFilterExtensions(fileExtensions);	
                
                String arquivo = file.open(); 
                if ( arquivo == null )
                    return;
                
                try {
                    ObjectInputStream in = new ObjectInputStream( new FileInputStream ( arquivo ) );
                    grafo = (AbstractGrafo) in.readObject();
                    in.close();
                }
                catch ( Exception exp ) {
                    //JOptionPane.showMessageDialog( ArvoreGeradoraGUI.getInstance(), e );
                }
                canvas.redraw();
            }
        });
        
        saveItem.addListener(SWT.Selection, new Listener() { 
            public void handleEvent(Event e) {
                String fileExtensions[] = { "*.graph" };
                
                FileDialog file = new FileDialog(shell, SWT.SAVE);
                file.setText("Salvar grafo");
                file.setFilterPath(".");
                file.setFilterExtensions(fileExtensions);	
                
                String arquivo = file.open(); 
                if ( arquivo == null )
                    return;
                
                try {
                    ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream ( arquivo ) );
                    out.writeObject( grafo );
                
                    out.flush();
                    out.close();
                } catch ( IOException ioe ) {
                    //JOptionPane.showMessageDialog( ArvoreGeradoraGUI.getInstance(), ioe );
                }

            }
        });
        
        ToolItem sep1 = new ToolItem(bar, SWT.SEPARATOR);

        Image arrowIcon = new Image(shell.getDisplay(), "arrow.gif");
        Image handIcon = new Image(shell.getDisplay(), "hand.gif");

        ToolItem arrowItem = new ToolItem(bar, SWT.RADIO);
        ToolItem handItem = new ToolItem(bar, SWT.RADIO);

        arrowItem.setImage(arrowIcon);
        arrowItem.setToolTipText("Ferramenta Seleção");
        handItem.setImage(handIcon);
        handItem.setToolTipText("Ferramenta Seleção");

        Image addVertIcon = new Image(shell.getDisplay(), "addvertice.gif");
        Image addAresIcon = new Image(shell.getDisplay(), "addaresta.gif");
        Image remVertIcon = new Image(shell.getDisplay(), "remvertice.gif");
        Image remAresIcon = new Image(shell.getDisplay(), "remaresta.gif");

        ToolItem addVertItem = new ToolItem(bar, SWT.RADIO);
        ToolItem addAresItem = new ToolItem(bar, SWT.RADIO);
        ToolItem remVertItem = new ToolItem(bar, SWT.RADIO);
        ToolItem remAresItem = new ToolItem(bar, SWT.RADIO);

        addVertItem.setImage(addVertIcon);
        addVertItem.setToolTipText("Adicionar Vértices");
        addAresItem.setImage(addAresIcon);
        addAresItem.setToolTipText("Adicionar Arestas");
        remVertItem.setImage(remVertIcon);
        remVertItem.setToolTipText("Remover Vértices");
        remAresItem.setImage(remAresIcon);
        remAresItem.setToolTipText("Remover Arestas");

        ToolItem sep2 = new ToolItem(bar, SWT.SEPARATOR);
        sep2.equals(sep1); // Apenas para não ficar dando warning!

        Image colorIcon = new Image(shell.getDisplay(), "colors.gif");
        ToolItem colorItem = new ToolItem(bar, SWT.PUSH);

        colorItem.setImage(colorIcon);
        colorItem.setToolTipText("Colorir Grafo");

        Image resetIcon = new Image(shell.getDisplay(), "refresh.gif");
        ToolItem resetItem = new ToolItem(bar, SWT.PUSH);

        resetItem.setImage(resetIcon);
        resetItem.setToolTipText("Resetar Grafo");

        
        handItem.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                actualAction = ConstantesUI.ACAO_MAO;
            }
        });

        addVertItem.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                actualAction = ConstantesUI.ACAO_ADVERTICE;
            }
        });

        addAresItem.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                actualAction = ConstantesUI.ACAO_ADARESTA;
            }
        });

        remVertItem.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                actualAction = ConstantesUI.ACAO_REMVERTICE;
            }
        });

        remAresItem.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                actualAction = ConstantesUI.ACAO_REMARESTA;
            }
        });

        colorItem.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                Coloracao coloracao = new Coloracao(grafo, shell.getDisplay());
                coloracao.solve();
                canvas.redraw();
            }
        });

        resetItem.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                Iterator it = grafo.getListaVertices().iterator();
                while(it.hasNext()) {
                    Vertice v = (Vertice) it.next();
                    v.setCor(shell.getDisplay().getSystemColor(SWT.COLOR_GRAY));
                }
                canvas.redraw();
            }
        });

        
    }

    /**
     * Cria a área de trabalho da aplicação
     */
    public void createCanvas() {
        canvas = new Canvas(shell, SWT.BORDER);
        canvas.setLocation(5, ConstantesUI.ALTURA_TOOLBAR + 5);
        canvas
                .setBackground(shell.getDisplay().getSystemColor(
                        SWT.COLOR_WHITE));

        // Redimensiona o canvas quando o tamanho da tela mudar
        shell.addPaintListener(new PaintListener() {
            public void paintControl(PaintEvent arg0) {
                canvas.setSize(shell.getSize().x - 20, shell.getSize().y
                        - ConstantesUI.ALTURA_TOOLBAR - 66);
            }
        });

        gc = new GC(canvas);

        canvas.addPaintListener(new PaintListener() {
            public void paintControl(PaintEvent arg0) {
                drawArestas();
                drawVertices();
            }
        });

        canvas.addMouseListener(new MouseAdapter() {
            public void mouseDown(MouseEvent e) {

                switch (actualAction) {
                case ConstantesUI.ACAO_ADVERTICE:
                    grafo.addVertice(new Vertice(e.x, e.y, shell.getDisplay()
                            .getSystemColor(SWT.COLOR_GRAY)));
                    canvas.redraw();
                    break;
                case ConstantesUI.ACAO_REMVERTICE:
                    Vertice v;
                    if ((v = verticeAtual(e.x, e.y)) != null)
                        grafo.remVertice(v);
                    canvas.redraw();
                    break;
                case ConstantesUI.ACAO_ADARESTA:
                    if (cliqueAresta == 0) {
                        v = verticeAtual(e.x, e.y);
                        if (v != null) {
                            selectedVertice = v;
                            selectedVertice.setCor(shell.getDisplay()
                                    .getSystemColor(SWT.COLOR_BLUE));
                            cliqueAresta = 1;
                            canvas.redraw();
                        }
                    } else if (cliqueAresta == 1) {
                        v = verticeAtual(e.x, e.y);

                        if (v != null) {
                            v.setCor(shell.getDisplay().getSystemColor(
                                    SWT.COLOR_BLUE));

                            Aresta a = new Aresta();
                            a.setInicio(selectedVertice);
                            a.setFim(v);
                            a.setOrientada(grafo.isOrientado());
                            
                            if (grafo.isRotulado()) {
                                InputDialog input = new InputDialog(shell);
                                input.setText("Custo da Aresta");
                                InputDialogData data = input.open();
                                try {
                                    a.setCusto(Integer.parseInt(data.getTextResponse()));
                                } catch(NumberFormatException nfe) {
                                    
                                }
                            }
                                
                            
                            grafo.addAresta(a);
                            canvas.redraw();
                            
                            selectedVertice.setCor(shell.getDisplay()
                                    .getSystemColor(SWT.COLOR_GRAY));
                            v.setCor(shell.getDisplay().getSystemColor(
                                    SWT.COLOR_GRAY));
                        }

                        cliqueAresta = 0;
                    }
                    break;
                case ConstantesUI.ACAO_REMARESTA:
                    if (cliqueAresta == 0) {
                        v = verticeAtual(e.x, e.y);
                        if (v != null) {
                            selectedVertice = v;
                            selectedVertice.setCor(shell.getDisplay()
                                    .getSystemColor(SWT.COLOR_BLUE));
                            cliqueAresta = 1;
                            canvas.redraw();
                        }
                    } else if (cliqueAresta == 1) {
                        v = verticeAtual(e.x, e.y);

                        if (v != null) {
                            v.setCor(shell.getDisplay().getSystemColor(
                                    SWT.COLOR_BLUE));

                            Aresta a = new Aresta();
                            a.setInicio(selectedVertice);
                            a.setFim(v);
                            grafo.remAresta(a);
                            canvas.redraw();

                            selectedVertice.setCor(shell.getDisplay()
                                    .getSystemColor(SWT.COLOR_GRAY));
                            v.setCor(shell.getDisplay().getSystemColor(
                                    SWT.COLOR_GRAY));
                        }

                        cliqueAresta = 0;
                    }
                    break;
                default:
                    selectedVertice = verticeAtual(e.x, e.y);
                    break;
                }
            }

        });

        canvas.addMouseMoveListener(new MouseMoveListener() {
            public void mouseMove(MouseEvent e) {
                if (actualAction == ConstantesUI.ACAO_MAO) {
                    if ((e.stateMask != 0) && (selectedVertice != null)) {
                        selectedVertice.setX(e.x);
                        selectedVertice.setY(e.y);
                        canvas.redraw();
                    }
                    shell.setCursor(new Cursor(shell.getDisplay(),
                            SWT.CURSOR_HAND));
                }
            }
        });

    }

    /**
     * Desenha todos os vértices do grafo
     */
    private void drawVertices() {
        Vector vertices = grafo.getListaVertices();
        Iterator it = vertices.iterator();
        int a = 0;

        while (it.hasNext()) {
            Vertice v = (Vertice) it.next();
            Color corOld = gc.getBackground();
            
            gc.setBackground(new Color(shell.getDisplay(), v.getCorR(), v.getCorG(), v.getCorB()));
            gc.fillOval(v.getX() - (ConstantesUI.RAIO_VERTICE / 2), v.getY()
                    - (ConstantesUI.RAIO_VERTICE / 2),
                    ConstantesUI.RAIO_VERTICE, ConstantesUI.RAIO_VERTICE);
            
            gc.setFont ( new Font( shell.getDisplay(),  "Arial", 14, SWT.BOLD ) );
            
            if ( a < 9 ) 
                gc.drawString( String.valueOf ( a + 1 ), v.getX() - 5, v.getY() - 10 );
            else
                gc.drawString( String.valueOf ( a + 1 ), v.getX() - 10, v.getY() - 10);

            gc.setBackground(corOld);
            a++;
        }
    }

    /**
     * Desenha todas as arestas do grafo
     */
private void drawArestas() {
        Vector arestas = grafo.getListaArestas();
        Iterator it = arestas.iterator();
        
        while (it.hasNext()) {
            Aresta a = (Aresta) it.next();        
            Vertice origem = a.getInicio();
            Vertice destino = a.getFim();
            boolean igual = false;
            
            if (a.isSelected())
                gc.setForeground(shell.getDisplay().getSystemColor(SWT.COLOR_RED));
            else
                gc.setForeground(shell.getDisplay().getSystemColor(SWT.COLOR_BLACK));
            
            if (!origem.equals(destino)) {
                gc.drawLine(origem.getX(), origem.getY(), destino.getX(), destino.getY());
            	gc.drawLine(origem.getX()+1, origem.getY()+1, destino.getX()+1, destino.getY()+1);
            } else {
                gc.drawArc(origem.getX(), origem.getY() - ConstantesUI.RAIO_VERTICE, 
                        ConstantesUI.RAIO_VERTICE, ConstantesUI.RAIO_VERTICE, 270, 270);
                igual = true;
            }
            
            if (grafo.isOrientado()) {
                double angulo = Math.atan2(destino.getY() - origem.getY(), destino.getX() - origem.getX());
                
                int xP = (int) (destino.getX() - (Math.cos(angulo) * ConstantesUI.RAIO_VERTICE/2)); 
                int yP = (int) (destino.getY() - (Math.sin(angulo) * ConstantesUI.RAIO_VERTICE/2));

                Arrow.init(0, 0, shell.getDisplay());
                if (igual)
                    Arrow.drawArrow(gc, origem.getX(), origem.getY()-ConstantesUI.RAIO_VERTICE, origem.getX(), origem.getY()-ConstantesUI.RAIO_VERTICE/2);
                else
                    Arrow.drawArrow(gc, origem.getX(), origem.getY(), xP, yP);
            }

            if (grafo.isRotulado()) {
                gc.setFont( new Font(shell.getDisplay(), "Arial", 12, SWT.BOLD ));
                gc.drawString ( String.valueOf ( a.getCusto() ),  origem.getX() + ( destino.getX() - origem.getX() ) / 2 - 15 , origem.getY() + ( destino.getY() - origem.getY() ) / 2 - 15 );
            }

        }

    }
    /**
     * Retorna o vértice para o qual o ponteiro do mouse está apontando
     * 
     * @param x
     *            Coordenada x do ponteiro
     * @param y
     *            Coordenada y do ponteiro
     * @return Vértice encontrado ou null.
     */
    private Vertice verticeAtual(int x, int y) {
        Vector vertices = grafo.getListaVertices();
        Iterator it = vertices.iterator();
        while (it.hasNext()) {
            Vertice v = (Vertice) it.next();
            if (v.isInside(x, y)) {
                return v;
            }
        }
        return null;
    }

}