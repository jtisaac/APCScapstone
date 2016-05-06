import java.util.Scanner;
import java.io.IOException;
/**
 * Write a description of class RatingsGraph here.
 * 
 * @author (Joseph Isaac) 
 * @version (May 5, 2016)
 */
public class RatingsGraph
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class RatingsGraph
     */
    public RatingsGraph()
    {
                    
    }
    public void request() throws IOException
    {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the ID of the player that you would like to graph: ");
        String id = in.next();
        WebpageReader wr = new WebpageReader(id);
        String data = wr.main();
        Parser p = new Parser(data);
        
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void main( String[] args )
    {
       
        
    }
    
}
