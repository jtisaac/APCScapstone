package isaac.joseph.uscfgraphs;

import org.jfree.chart.*;// All this code is from http://www.jfree.org/  - thianks so much to the maker!
import org.jfree.ui.*;
import org.jfree.data.*;
import org.jfree.data.time.*;
import java.util.*;
import java.io.*;
import org.jfree.data.xy.XYDataset;
import java.text.*;
import javax.swing.*;
import java.awt.BasicStroke;
import java.util.Arrays;
import java.util.List;
import org.jsoup.*;

/** //this WHOLE CLASS is thanks to http://www.jfree.org/ - CUSTOMIZED IT TO MY PURPOSES  - thianks so much to the maker!

 * Write a description of class RatingsGraph here.
 * 
 * @author (Joseph Isaac) 
 * @version (May 5, 2016)
 */
public class RatingsGraph extends ApplicationFrame
{
    /**
     * Constructor for objects of class RatingsGraph
     */
    public RatingsGraph(String applicationTitle , String chartTitle) throws IOException
    {
        super(applicationTitle);
        JPanel panel1 = createPanel();
        panel1.setPreferredSize( new java.awt.Dimension( 1400, 1000 ));
        setContentPane( panel1);
    }

    public static JPanel createPanel() throws IOException
    {
        JFreeChart chart = createChart(makeDataset());
        return new ChartPanel(chart);
    }

    private static JFreeChart createChart(XYDataset dataset) 
    {
        JFreeChart chart = ChartFactory.createTimeSeriesChart("USCF Graphs by Joseph Isaac","Time","Rating",dataset,true,true,false);
        return chart;
    }

    public static TimeSeriesCollection makeDataset() throws IOException
    {
        Scanner in = new Scanner(System.in);
        String another = "y";
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        String[] temp;
        while (another.compareTo("y") == 0)
        {
            System.out.print("Please enter the ID of the player that you would like to graph: ");
            temp = in.next().split(",");
            for (int x = 0; x < temp.length; x++)
            {
                WebpageReader wr = new WebpageReader(temp[x]);
                String data = wr.main();
                Parser p = new Parser(data);
                p.main();
                TimeSeries dat = new TimeSeries(wr.fetchName());
                for (int y = 0; y < p.getYear().size(); y++)
                {
                    dat.add(new Day(p.getDay().get(y), p.getMonth().get(y), p.getYear().get(y)), p.getRatings().get(y));
                }
                dataset.addSeries(dat);

            }

            System.out.print("Would you like to enter another member id (y/n)? ");
            another = in.next();
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
        RatingsGraph graph1 = new RatingsGraph("Rating Over Time", "ratings");
        graph1.pack(); 
        RefineryUtilities.centerFrameOnScreen(graph1);
        graph1.setVisible(true);
    }
}
