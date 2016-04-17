import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
/**
 * This class reads data from the member's file and creates arrays based on this data.
 * 
 * @author (Joseph Isaac) 
 * @version (4/17/16)
 */
public class CapstoneFileReader
{

    private static String amemberID;
    ArrayList<String> names;
    ArrayList<Double> ratings;
    ArrayList<Date> days;
    /**
     * Constructor for objects of class CapstoneFileReader
     */
    public CapstoneFileReader()
    {
        // initialise instance variables
        
        names = new ArrayList<String>();
        ratings = new ArrayList<Double>();
        days = new ArrayList<Date>();
    }

    public static void parse() throws FileNotFoundException, IOException
    {
        CapstoneWebpageReader wr = new CapstoneWebpageReader();
        wr.main();
        String memberID = wr.getMemberID();
        String memberData = wr.getMemberDataString();
        String name = wr.fetchName();
        
        
        int memberAmount = 0;
        Scanner in = new Scanner("memberData.txt");
        in.useDelimiter("/n");
        while (in.hasNext())
        {
            memberAmount ++;
            in.next();
        }
        
        System.out.println(memberAmount);
        
        
    }



    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main() throws IOException
    {
        
        
        
        parse();
    }
}
