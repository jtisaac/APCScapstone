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
        amemberID = CapstoneWebpageReader.getMemberID();
        names = new ArrayList<String>();
        ratings = new ArrayList<Double>();
        days = new ArrayList<Date>();
    }

    public static void parse() throws FileNotFoundException
    {
        int memberAmount = 0;
        amemberID = CapstoneWebpageReader.getMemberID();
        Scanner in = new Scanner("memberData.txt");
        in.useDelimiter("/n");
        while (in.hasNext())
        {
            memberAmount ++;
            in.next();
        }
        System.out.println(memberAmount);
        
        
    }

    public static void fetchName()
    {
        Scanner in = new Scanner("memberData.txt");
        in.useDelimiter("=>");
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main() throws IOException
    {
        CapstoneWebpageReader.main();
        System.out.println(amemberID);
        parse();
    }
}
