package USCFGraphsByJosephIsaac;

import org.jfree.chart.*;// All this code is from http://www.jfree.org/  - thianks so much to the maker!
import org.jfree.ui.*;
import org.jfree.data.*;
import org.jfree.data.time.*;
import org.jfree.data.time.TimeSeries;
import java.util.*;
import java.io.*;
import org.jfree.data.xy.XYDataset;
import java.text.*;
import javax.swing.*;
import java.awt.BasicStroke;
import java.util.Arrays;
import java.util.List;
import org.jsoup.*;
import java.lang.Throwable.*;

/** //this WHOLE CLASS is thanks to http://www.jfree.org/ - CUSTOMIZED IT TO MY PURPOSES  - thianks so much to the maker!

 * This class makes a graph displaying player(s)' ratings in relation to time constructed with the Parser and WebpageReader class 
 * 
 * @author (Joseph Isaac) 
 * @version (May 5, 2016)
 */
public class RatingsGraph extends ApplicationFrame
{
    /**
     * Constructor for objects of class RatingsGraph
     * 
     * @param applicationTitle the title of the application that you want to run
     * @param chartTitle the title of the chart
     */
    public RatingsGraph(String applicationTitle , String chartTitle) throws IOException
    {
        super(applicationTitle);
        JPanel panel1 = createPanel();
        panel1.setPreferredSize( new java.awt.Dimension( 1400, 1000 ));
        setContentPane( panel1);
    }
    /**
     * creates a JPanel based on createChart's dataset
     * 
     * @return     a JPanel 
     */
    public static JPanel createPanel() throws IOException
    {
        JFreeChart chart = createChart(makeDataset());
        return new ChartPanel(chart);
    }
    /**
     * creates a JFreeChart based on the dataset
     * 
     * @param  dataset an XYDataset (ratings and time)
     * @return     JFreeChart
     */
    private static JFreeChart createChart(XYDataset dataset) 
    {
        JFreeChart chart = ChartFactory.createTimeSeriesChart("USCF Graphs by Joseph Isaac","Time","Rating",dataset,true,true,false);
        return chart;
    }
    /**
     * creates a TimeSeriesCollection using Parser and WebpageReader
     * 
     * @return     dataset a TimeSeriesCollection
     */
    public static TimeSeriesCollection makeDataset() throws IOException
    {
        Scanner in = new Scanner(System.in);
        String another = "y";
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        String[] temp;
        while (another.compareTo("y") == 0)
        {
            System.out.print("Please enter a player's ID or a key that you would like to graph: ");
            temp = in.next().split(",");
            for (int x = 0; x < temp.length; x++)
            {
                try
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
                catch(IOException exception)
                {
                    exception.printStackTrace(); //http://stackoverflow.com/questions/6250231/handling-io-exceptions-in-java  <-- helped with the error message printing
                    String[] except = {" "};
                    System.out.println("Oops... Something went wrong with id " + temp[x] + " . Just email Joseph and he'll look into it.");
                    RatingsGraph.main(except);
                }

            }
            System.out.print("Would you like to enter another member id (y/n)? ");
            another = in.next();
        }
        return dataset;
    }

    /**
     * Runs the whole program 
     */
    public static void main( String[] args ) throws IOException
    {
        RatingsGraph graph1 = new RatingsGraph("Rating Over Time", "ratings");
        graph1.pack(); 
        RefineryUtilities.centerFrameOnScreen(graph1);
        graph1.setVisible(true);
    }
}
