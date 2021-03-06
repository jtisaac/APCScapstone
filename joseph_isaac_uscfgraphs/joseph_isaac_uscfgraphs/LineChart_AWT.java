import org.jfree.chart.ChartPanel;/// All this code is from http://www.jfree.org/  - thianks so much to the maker!
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame
{
    public LineChart_AWT( String applicationTitle , String chartTitle )
    {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "date","rating",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset( )
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
//         for (int x = 0; x < ratings.size(); x++)
//         {
//             dataset.addValue( ratings.get(x) , "Joseph Isaac" , "1970" );
//         }
        dataset.addValue( 30 , "schools" , "1980" );
        dataset.addValue( 60 , "schools" ,  "1990" );
        dataset.addValue( 120 , "schools" , "2000" );
        dataset.addValue( 240 , "schools" , "2010" );
        dataset.addValue( 300 , "schools" , "2014" );
        dataset.addValue( 2000, "Joseph Isaac" , "2016" );
        dataset.addValue( 560, "Joseph Isaac" , "2018" );
        return dataset;
    }

    public static void main( String[ ] args ) 
    {
        LineChart_AWT chart = new LineChart_AWT(
                "School Vs Years" ,
                "Number of Schools vs years");

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}
