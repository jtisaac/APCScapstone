import org.jfree.chart.ChartPanel;/// All this code is from http://www.jfree.org/  - thianks so much to the maker!
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.Scanner;
import java.io.IOException;
/** //this WHOLE CLASS is thanks to http://www.jfree.org/ - CUSTOMIZED IT TO MY PURPOSES  - thianks so much to the maker!
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
 * Write a description of class RatingsGraph here.
 * 
 * @author (Joseph Isaac) 
 * @version (May 5, 2016)
 */
public class RatingsGraph extends ApplicationFrame
{
    // instance variables - replace the example below with your own
    private DefaultCategoryDataset graphdata;
    /**
     * Constructor for objects of class RatingsGraph
     */
    public RatingsGraph(String applicationTitle , String chartTitle) throws IOException
    {
        super(applicationTitle);
        graphdata = new DefaultCategoryDataset();
        
        JFreeChart ratingchart = ChartFactory.createLineChart( chartTitle , "date" , "rating" , makeDataset() , PlotOrientation.VERTICAL, true , true, false);
        ChartPanel panel = new ChartPanel (ratingchart);
        panel.setPreferredSize( new java.awt.Dimension( 600, 400 ));
        setContentPane( panel);

    }

    public Parser request() throws IOException
    {

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the ID of the player that you would like to graph: ");
        String id = in.next();
        WebpageReader wr = new WebpageReader(id);
        String data = wr.main();
        Parser p = new Parser(data);
        
        return p;
    }
    private DefaultCategoryDataset makeDataset() throws IOException
    {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the ID of the player that you would like to graph: ");
        String id = in.next();
        WebpageReader wr = new WebpageReader(id);
        String data = wr.main();
        Parser p = new Parser(data);
        p.main();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int x = p.getRatings().size() -1; x >= 0; x--)
        {
            dataset.addValue( p.getRatings().get(x) , id , p.getDates().get(x) );
        }
        return dataset;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main( String[] args ) throws IOException
    {
        RatingsGraph graph = new RatingsGraph( "Rating Over Time" , "Rating Over Time");
        
        graph.pack(); 
        RefineryUtilities.centerFrameOnScreen(graph);
        graph.setVisible(true);
    }
}
