import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Mousey extends JFrame{
    private int x, y, colorCounter = 0;
    private final Color[] line = {
        Color.BLUE, 
        Color.RED,
        Color.MAGENTA,
        Color.CYAN,
        Color.GREEN };
    
    private Color currentColor = line[colorCounter];
    
    private String mouseStatus = "The mouse is OUT of the window";
    
    public Mousey() {
        this.setBackground(Color.WHITE);
        this.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                mouseStatus = "The mouse is IN the window.";
            }
            public void mouseExited(MouseEvent e) {
                mouseStatus = "The mouse is OUT of the window.";
                repaint();
            }
            public void mouseClicked(MouseEvent e) {
                colorCounter++;
                if(colorCounter == line.length) colorCounter = 0;
                currentColor = line[colorCounter];
                repaint();
            }
        });
        
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved (MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });
        
        this.setSize(640,480);
        this.setTitle("The Mousey Program");
        this.show();                
    }
    
    public void paint (Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(currentColor);
        
        g.drawString(mouseStatus, 15,50);
        g.drawString("The color is " + currentColor.toString(), 15, 90);
        String position = "X = " + String.valueOf(x) + "y = " 
                + String.valueOf(y);
        g.drawString(position, 15,70);
        
        g.drawLine(0,0,x-25,y-25);
        g.drawLine(0, getHeight(), x-25, y+25);
        g.drawLine(getWidth(), 0, x+25, y-25);
        g.drawLine(getWidth(), getHeight(), x+25, y+25);
        g.drawRect(x-25,y-25,50,50);
        }
    public static void main (String args[]) {
        Mousey app = new Mousey();
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
