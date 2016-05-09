package isaac.joseph.uscfgraphs;

import java.io.IOException;
/**
 * Write a description of class ParserTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParserTester
{


    /**
     * Constructor for objects of class ParserTester
     */
    public ParserTester()
    {

    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main() throws IOException
    {
        WebpageReader wr = new WebpageReader("14733522");
        String str = wr.main();
        Parser p = new Parser(str);
        p.main();
        
    }
}
