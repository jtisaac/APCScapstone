import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
/**
 * This is where we set up the window, as well as use the borderLayout class to place things where they need to be.
 * border layout class
 * @author (Joseph Isaac) 
 * @version (2/29/15)
 */
public class GraphEditor extends JFrame
{
    /** Setting constant variables up */
    
    
    
    private static final int FRAMEHEIGHT = 800;
    private static final int FRAMEWIDTH = 1000;
    /**
     * Default constructor for objects of class DrawingEditor
     */
    public GraphEditor()
    {
        
        
        String title = "Drawing Editor";
        this.setTitle(title);
        DrawingPanel canvas = new DrawingPanel();
        ControlPanel controls = new ControlPanel(canvas);
        this.add(canvas, BorderLayout.CENTER);
        this.add(controls, BorderLayout.SOUTH);
        this.setSize(1000,500);
        this.setVisible(true);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    /**
     * This method runs the drawing editor.
     *

     */
    public static void main()
    {
        DrawingEditor cool = new DrawingEditor();
        
    }

}