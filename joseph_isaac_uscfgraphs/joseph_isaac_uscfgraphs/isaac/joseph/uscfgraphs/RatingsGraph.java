package isaac.joseph.uscfgraphs;

import org.jfree.chart.ChartPanel;/// All this code is from http://www.jfree.org/  - thianks so much to the maker!
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.Scanner;
import java.io.IOException;

import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.BasicStroke;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.MovingAverage;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.date.MonthConstants;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import org.jsoup.HttpStatusException;
import org.jsoup.Connection;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.regex.Pattern;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
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
    //private DefaultCategoryDataset graphdata;
    /**
     * Constructor for objects of class RatingsGraph
     */
    public RatingsGraph(String applicationTitle , String chartTitle) throws IOException
    {
        super(applicationTitle);
        JPanel panel1 = createPanel(); //new ChartPanel (ratingchart);
        panel1.setPreferredSize( new java.awt.Dimension( 1400, 1000 ));
        setContentPane( panel1);

        //JPanel panel2 = createPanel2(); //new ChartPanel (ratingchart);
        //panel2.setPreferredSize( new java.awt.Dimension( 600, 400 ));
        //setContentPane( panel2);
        //graphdata = new DefaultCategoryDataset();

        //JFrame frame = new JFrame("graph");
        //frame.getContentPane().add(new ChartPanel(panel1), BorderLayout.EAST);
        //frame.getContentPane().add(new ChartPanel(panel2), BorderLayout.WEST);

        //JFreeChart ratingchart = ChartFactory.createLineChart( chartTitle , "date" , "rating" , makeDataset() , PlotOrientation.VERTICAL, true , true, false);

    }

    public static JPanel createPanel() throws IOException
    {
        JFreeChart chart = createChart(makeDataset());
        return new ChartPanel(chart);
    }

    //     public static JPanel createPanel1() throws IOException
    //     {
    //         JFreeChart chart = createChart(makeDataset()[0]);
    //         return new ChartPanel(chart);
    //     }
    // 
    //     public static JPanel createPanel2() throws IOException
    //     {
    //         JFreeChart chart = createChart(makeDataset()[1]);
    //         return new ChartPanel(chart);
    //     }

    private static JFreeChart createChart(XYDataset dataset) 
    {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "USCF Graphs by Joseph Isaac",
                "Time",
                "Rating",
                dataset,
                true,
                true,
                false
            );
        //         XYPlot plot = (XYPlot) chart.getPlot();
        //         NumberAxis yAxis2 = new NumberAxis(null);
        //         yAxis2.setAutoRangeIncludesZero(false);
        //         plot.setRangeAxis(1, yAxis2);
        //         List axisIndices = Arrays.asList(new Integer[] {new Integer(0),
        //                 new Integer(1)});
        //         plot.mapDatasetToRangeAxes(0, axisIndices);
        // 
        //         XYLineAndShapeRenderer renderer
        //                 = (XYLineAndShapeRenderer) plot.getRenderer();
        //         renderer.setAutoPopulateSeriesStroke(false);
        //         renderer.setBaseStroke(new BasicStroke(1.5f,
        //                 BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        //         renderer.setDrawSeriesLineAsPath(true);
        //         StandardXYToolTipGenerator g = new StandardXYToolTipGenerator(
        //                 StandardXYToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT,
        //                 new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.00"));
        //         renderer.setBaseToolTipGenerator(g);
        //         ChartUtilities.applyCurrentTheme(chart);
        return chart;
    }

    //     public Parser request() throws IOException
    //     {
    // 
    //         Scanner in = new Scanner(System.in);
    // 
    //         String[] temp;
    // 
    //         System.out.print("Please enter the ID of the player that you would like to graph: ");
    //         temp = in.next().split(",");
    //         for (int x = 0; x < temp.length; x++)
    //         {
    //             WebpageReader wr = new WebpageReader(id);
    //             String data = wr.main();
    //             Parser p = new Parser(data);
    //         }
    //         return p;
    //     }

    public static TimeSeriesCollection makeDataset() throws IOException
    {
        Scanner in = new Scanner(System.in);
        String another = "y";
        //TimeSeriesCollection dataset1 = new TimeSeriesCollection();
        //TimeSeriesCollection dataset2 = new TimeSeriesCollection();
        //TimeSeriesCollection[] tot = {dataset1,dataset2};
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        //final int strandDivision = 1400;

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
                //                 int currRating = p.getRatings().get(p.getRatings().size()-1);
                //                 if(currRating >= strandDivision)
                //                 {
                //                     dataset1.addSeries(dat);
                //                 }
                //                 else
                //                 {
                //                     dataset2.addSeries(dat);
                //                 }
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

        //RatingsGraph graph2 = new RatingsGraph("Rating Over Time", "ratings");

        //graph2.pack(); 
        //RefineryUtilities.centerFrameOnScreen(graph2);
        //graph2.setVisible(true);

    }
}
