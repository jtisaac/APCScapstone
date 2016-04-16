import javax.swing.JPanel;
import javax.swing.JButton;
/**
 *The area of the window where the shapes are drawn.
 * 
 * @author (Joseph Isaac) 
 * @version (FINAL)
 */
public class DrawingPanel extends JPanel
{
    /** The arraylist of shapes, color, and the activeshape */
    //private ArrayList<Shape> shapes;
    //private Color currColor;
    //private Dimension dim;

    //private Shape currShape;
    /**
     * Default constructor for objects of class DrawingPanel
     */
    public DrawingPanel()
    {
        this.shapes = new ArrayList<Shape>(); 
        this.setBackground(Color.WHITE);
        this.dim = new Dimension(1000, 1000);
        this.addMouseListener(new ClickListener());
        this.addMouseMotionListener(new ClickListener());
    }

    /**
     * Fetches color
     *
     * @return    color of the panel
     */
    //public Color getColor()
    {
        return currColor;
    }

    /**
     * Picks color
     *
     * @post    Color is chosen
     * @return    none
     */
    public void pickColor()
    {
        currColor = JColorChooser.showDialog(this, "Pick Color", currColor);
    }

    /**
     * Adds a circle
     *
     */
    public void addCircle()
    {
        shapes.add(new Circle(new Point2D.Double(100,100), 50, currColor));
    }

    /** Adds a square
     */
    public void addSquare()
    {
        shapes.add(new Square(new Point2D.Double(150,150), 50, currColor));
    }

//     /**
//      * Paints the shapes in the arraylist
//      */
//     public void paintComponent(Graphics g)
//     {
//         super.paintComponent(g);
//         Graphics2D g2 = (Graphics2D) g;
//         for (Shape ape : shapes)
//         {
//             if (currShape == null)
//             {
//                 ape.draw(g2, true);
//             }
//             else if (currShape == ape)
//             {
//                 ape.draw(g2, false);
//             }
//             else
//             {
//                 ape.draw(g2, true);
//             }
//         }
//     }

    /**
     * Fetches best size
     * @return    dimension of the best size
     */
    public Dimension getPreferredSize()
    {
        Dimension dim = new Dimension(100,100);
        return dim;
    }
    public class ClickListener implements MouseListener, MouseMotionListener
    {
        public boolean selected;
        public void mouseClicked( MouseEvent event )
        {
            int x = event.getX();
            int y = event.getY();
            Point2D.Double coord = new Point2D.Double(x,y);
            boolean alreadytoggled = true;
            for (Shape ape: shapes)
            {
                boolean isinside = ape.isInside(coord);
                if (isinside == true && alreadytoggled == true)
                {
                    currShape = ape;
                    currShape.move(x,y);

                }
                else if (ape.isOnBorder(coord) || alreadytoggled == false)
                {
                        System.out.println("The cursor is on the border!");
                        double r = ape.getRadius();
                        ape.setRadius(r+1);
                        repaint();
                        alreadytoggled = false;
                }
                
                repaint();
            }
        }

        public void mouseEntered( MouseEvent event )
        {
        }

        public void mouseExited( MouseEvent event )
        {
        }

        public void mousePressed( MouseEvent event )
        {   
        }

        public void mouseReleased( MouseEvent event )
        {
        }

        public void mouseDragged(MouseEvent event)
        {
            int x = event.getX();
            int y = event.getY();
            Point2D.Double coord = new Point2D.Double(x,y);
            for (Shape ape: shapes)
            {
                boolean isinside = ape.isInside(coord);
                if (isinside == true)
                {
                    currShape = ape;
                    currShape.move(x,y);
                }
                else if (ape.isOnBorder(coord))
                {
                        System.out.println("The cursor is on the border!");
                        double r = ape.getRadius();
                        ape.setRadius(r+1);
                        repaint();
                }
                isinside = false;
                repaint();
            }
        }
        public void mouseMoved(MouseEvent event)
        {
        }
    }
}