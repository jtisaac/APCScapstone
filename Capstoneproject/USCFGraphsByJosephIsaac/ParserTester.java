package USCFGraphsByJosephIsaac;

import java.io.IOException;
/**
 * Write a description of class ParserTester here.
 * 
 * @author (Joseph Isaac) 
 * @version (May)
 */
public class ParserTester
{


    /**
     * Constructor
     */
    public ParserTester()
    {

    }

    /**
     * Tests Parser with sample data
     */
    public static void main() throws IOException
    {
        WebpageReader wr = new WebpageReader("14733522");
        String str = wr.main();
        Parser p = new Parser(str);
        p.main();
        
    }
}
