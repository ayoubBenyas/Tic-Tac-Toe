package src.main;

import src.exception.*;

/* Graphic Class use */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.security.KeyPair;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GraphicTicTacToe extends TicTacToe
    implements MouseListener, WindowListener, KeyListener {
    
    JFrame maFrame;
    public GraphicTicTacToe(){
        super();
        this.maFrame = new JFrame("Tic Tac Toe");
        this.maFrame.getContentPane().setBackground(Color.DARK_GRAY);
        this.maFrame.setLayout(null);
        this.maFrame.setSize(600, 600);
        this.maFrame.setResizable(false);
        this.maFrame.setUndecorated(true);
        this.maFrame.setLocationRelativeTo(null);
        this.maFrame.setVisible(true);
        setTicTacToe();
    }

    public void setTicTacToe(){
        super.setTicTacToe();
        alert("Start the TicTacToe game");
        
        final Graphics graphic = this.maFrame.getGraphics();
        ((Graphics2D) graphic).setStroke(new BasicStroke(5.0F));

        graphic.setColor(new Color(255, 99, 71));
        graphic.drawLine(200, 0, 200, 600);
        graphic.drawLine(400, 0, 400, 600);
        graphic.drawLine(0, 200, 600, 200);
        graphic.drawLine(0, 400, 600, 400);
    }

    public void play() {
        this.maFrame.addWindowListener(this);
        this.maFrame.addMouseListener(this);
        this.maFrame.addKeyListener(this);
    }

    public void keyPressed(final KeyEvent k) {
        switch (k.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                    maFrame.dispatchEvent(new WindowEvent(maFrame, WindowEvent.WINDOW_CLOSING));
                break;
            case 103:
                    lineChoice.setChoice(0,0);
                    this.go();            
                break;
            case 104:
                    lineChoice.setChoice(0,1);
                    this.go();            
                break;
            case 105:
                    lineChoice.setChoice(0,2);
                    this.go();            
                break;
            case 100:
                    lineChoice.setChoice(1,0);
                    this.go();            
                break;
            case 101:
                    lineChoice.setChoice(1,1);
                    this.go();            
                break;
            case 102:
                    lineChoice.setChoice(1,2);
                    this.go();            
                break;
            case 97:
                    lineChoice.setChoice(2,0);
                    this.go();            
                break;
            case 98:
                    lineChoice.setChoice(2,1);
                    this.go();            
                break;
            case 99:
                    lineChoice.setChoice(2,2);
                    this.go();            
                break;
            case 96:
                    this.confirm("Restart Game!");
                break;
            case 8:
                    /*this.board[lineChoice.getRow()][lineChoice.getCol()].setValue(' ');
                    this.switchPlayer();*/
                break;
            default:
                System.out.println("key:Pressed[" + k.getKeyCode() + "]");
                break;
        }

    }

    public void keyTyped(final KeyEvent k) {
        System.out.println("key:Released[" + k.getKeyCode() + "]");
    }

    public void keyReleased(final KeyEvent k) {
        System.out.println("key:Released[" + k.getKeyCode() + "]");
    }

    public void windowClosing(final WindowEvent de) {
        System.exit(0);
    }

    public void windowOpened(final WindowEvent de) {
    }

    public void windowClosed(final WindowEvent de) {
    }

    public void windowActivated(final WindowEvent de) {
    }

    public void windowDeactivated(final WindowEvent de) {
    }

    public void windowIconified(final WindowEvent de) {
    }

    public void windowDeiconified(final WindowEvent de) {
    }

    public void mouseReleased(final MouseEvent e) {
        System.out.println("mouse:Released");
    }

    public void mouseEntered(final MouseEvent e) {
        System.out.println("mouse:Entered");
    }

    public void mouseExited(final MouseEvent e) {
        System.out.println("mouse:Exited");
    }

    public void mousePressed(final MouseEvent e) {
        System.out.println("mouse:Pressed");
    }

    private void getChoice(int x, int y) {
        if (x <= 200) {
            x = 0;
        }
        if ((200 < x) && (x <= 400)) {
            x = 1;
        }
        if ((400 < x) && (x <= 600)) {
            x = 2;
        }
        if (y <= 200) {
            y = 0;
        }
        if ((200 < y) && (y <= 400)) {
            y = 1;
        }
        if ((400 < y) && (y <= 600)) {
            y = 2;
        }

        lineChoice.setChoice(x, y);

    }

    public void mouseClicked(final MouseEvent e) {
        this.getChoice(e.getY(), e.getX());
        this.go();
    }

    void drawBar(final Graphics graphik, final int BarIndex) {
        graphik.setColor(Color.PINK);
        ((Graphics2D) graphik).setStroke(new BasicStroke(9.0F));
        switch (BarIndex) {
            case 0:
                graphik.drawLine(50, 100, 550, 100);
                break;

            case 1:
                graphik.drawLine(50, 300, 550, 300);
                break;

            case 2:
                graphik.drawLine(50, 500, 550, 500);
                break;

            case 3:
                graphik.drawLine(100, 50, 100, 550);
                break;

            case 4:
                graphik.drawLine(300, 50, 300, 550);
                break;

            case 5:
                graphik.drawLine(500, 50, 500, 550);
                break;

            case 6:
                graphik.drawLine(75, 75, 525, 525);
                break;

            case 7:
                graphik.drawLine(525, 75, 75, 525);
                break;

            default:
                break;
        }
    }

    public int go() {
        final Graphics graphic = this.maFrame.getGraphics();
        ((Graphics2D) graphic).setStroke(new BasicStroke(5.0F));
        //lineChoice.setChoice(x, y);
        boolean quit = false;
        int index;
        try {
            quit = (index = super.go()) > -1;
        } catch (final CellAlreadyTakenException ex) {
            System.err.print(ex.getMessage());
            return -1;
        }
        int pX, pY;
        pY = this.lineChoice.getRow() * 200;
        pX = this.lineChoice.getCol() * 200;
        System.out.println("( " + pX + ", " + pY + ")");

        ((Graphics2D) graphic).setStroke(new BasicStroke(15.0F));

        if ((this.curPlayer.getId() == _PLMAYER1)) {
            graphic.setColor(new Color(30, 144, 255)); // DodgerBlue , X
            graphic.drawLine(pX + 20, pY + 20, pX + 180, pY + 180);/* \ */
            graphic.drawLine(pX + 180, pY + 20, pX + 20, pY + 180);/* / */
            graphic.setColor(new Color(255, 99, 71)); // Tomato , |
        } else {
            graphic.setColor(new Color(255, 99, 71)); // Tomato, O
            graphic.drawOval(pX + 20, pY + 20, 160, 160);
            graphic.setColor(new Color(30, 144, 255)); // DodgerBlue , |

        }

        ((Graphics2D) graphic).setStroke(new BasicStroke(5.0F));
        graphic.drawLine(200, 0, 200, 600);
        graphic.drawLine(400, 0, 400, 600);
        graphic.drawLine(0, 200, 600, 200);
        graphic.drawLine(0, 400, 600, 400);

        if (quit) {
            maFrame.removeMouseListener(this);
            drawBar(graphic, index);
            this.alert("You win, congradulation to " + curPlayer.getSymbol());
            this.confirm("Do U Wanna Play Again?");
        } else
            this.switchPlayer();
        int count = 0;
        for (int i = 0; i < TicTacToe._LEN; i++) {
            for (int j = 0; j < TicTacToe._LEN; j++) {
                count += (board[i][j].getValue() == ' ') ? 0 : 1;
            }
        }
        if (count == 9) {
            this.maFrame.removeMouseListener(this);
            alert("GaMe OvEr!!!!!!");
            confirm("Do U Wanna Play Again?");
        }
        return 0;
    }

    void alert(final String message) {
        JOptionPane.showMessageDialog(maFrame, message);
    }

    void confirm(String message) {
        final int res = JOptionPane.showConfirmDialog(maFrame, message, "Select an option",
                JOptionPane.YES_NO_CANCEL_OPTION);
        if(res == JOptionPane.YES_OPTION){
            this.maFrame.getContentPane().removeAll();
            this.maFrame.repaint();
            this.setTicTacToe();
            play();
        }else if(res == JOptionPane.NO_OPTION){
            maFrame.dispatchEvent(new WindowEvent(maFrame, WindowEvent.WINDOW_CLOSING));
        }
    }


}
