import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
/**
 * The lower pane where shape colors are set and shapes are added
 * 
 * @author (Joseph Isaac) 
 * @version (FINAL)
 */
public class ControlPanel extends JPanel
{
    /** Setting up variables and listeners */
    private JButton pickcolor;
    private JButton addcircle;
    private JButton addsquare;
    private JPanel color;
    private DrawingPanel canvas;
    private ButtonListener listener;
    
    /**
     * Default constructor for objects of class ControlPanel
     */
    public ControlPanel(DrawingPanel canvas)
    {
        this.canvas = canvas;
        
        //buttons:
        this.pickcolor = new JButton( "Pick Color" );
        this.add( pickcolor );
        
        this.addcircle = new JButton( "Add Circle" );
        this.add( addcircle );
        
        this.addsquare = new JButton( " Add Square" );
        this.add( addsquare );
        
        //color panel:
        color = new JPanel();
        this.add(color);
        
        //Listener for buttons:
        listener = new ButtonListener();
        
        this.pickcolor.addActionListener( listener );
        this.addcircle.addActionListener( listener );
        
        this.addsquare.addActionListener( listener );
    }

    public class ButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent event )
        {
            if (event.getActionCommand().equals("Pick Color"))
            {
                System.out.println("Picking color");
                canvas.pickColor();
                Color currColor = canvas.getColor();
                color.setBackground(currColor);
            }
            else if (event.getActionCommand().equals("Add Circle"))
            {
                System.out.println("Adding Circle");
                canvas.addCircle();
            }
            else 
            {
                System.out.println("Adding Square");
                canvas.addSquare();
            }
            canvas.repaint();
        }
    }
}