package USCFGraphsByJosephIsaac;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import java.util.Scanner;
import java.io.*;
import java.util.regex.Pattern;
import java.net.*;
import java.lang.*;

/**
 * This class reads data from a webpage, specifically USchess.org, then writes this information to a file.
 * @author (Joseph Isaac) 
 * @version (4/16/16)
 */
public class WebpageReader
{
    private String memberDataString; // the string for that member (the contents of the webpage for that member)
    private String memberID; // The id (string) of that member
    /**
     * Constructor for objects of class WebpageReader
     * 
     * @param ID the id of the member (should be just that, make a substring just in case extra characters are added in the back, but shouldn't be the case)
     */
    public WebpageReader(String ID) throws IOException
    {
        memberDataString = "";
        try
        {
            this.memberID = ID.substring(0,8);
        }
        catch(Exception exception)
        {

            exception.printStackTrace(); //http://stackoverflow.com/questions/6250231/handling-io-exceptions-in-java <-- error message
            String[] except = {" "};
            System.out.println("Oops... Something went wrong with id " + ID + " . Just email Joseph and he'll look into it.");
            RatingsGraph.main(except);
        }
    }

    /**
     * This method Accepts a USCF member id not as a parameter and prints the data page for that member.
     * @return the member data (the whole webpage for that member)
     */
    public String read() throws IOException
    {
        Document memberData = null; // this is a document that the webpage copies to

        for (int x = 1; x < 5; x++)
        {
            String memberURL = "http://www.uschess.org/msa/MbrDtlTnmtHst.php?" + memberID + "." + x; // datapage for specific member, in a Document

            Connection connection = Jsoup.connect(memberURL).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21").timeout(10000); 
            // this is the workaround needed to access the webpage without getting an HTTPerrorfetchingURL, gotten from StackOverflow: http://stackoverflow.com/questions/21858701/how-to-fix-http-error-fetching-url-status-500-in-java-while-crawling
            Connection.Response response = connection.execute();
            if (response.statusCode() == 200) {
                memberData = connection.get();
            }
            memberDataString += memberData.text();
        }
        System.out.println(this.fetchName());
        return memberDataString;
    }    

    /**
     * This method Accepts a USCF member id and prints the data page for that member. THIS METHOD IS NOT EXPLICITLY USED,HOWEVER IT IS AN EXTENSION FOR POSSIBLY MORE
     */
    public void write() throws IOException
    {
        try
        {
            FileWriter writer = new FileWriter("memberData" + memberID + ".txt");
            writer.write(memberDataString);
            writer.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            File memberDataFile = new File("memberData" + memberID + ".txt");
        }
    }

    /**
     * Accessor method that returns the member's id.
     * @return the member's id
     * 
     */
    public String getMemberID()
    {
        return this.memberID;
    }

    /**
     * Accessor method that returns the member's data string.
     * 
     * @return the name of the member
     */
    public String fetchName() throws NullPointerException, ArrayIndexOutOfBoundsException
    {
        try
        {
            return memberDataString.split(memberID + ": ")[1].split(" Events")[0]; //I learned java regex on my own: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
        }
        catch(Exception exception)
        {
            exception.printStackTrace(); //http://stackoverflow.com/questions/6250231/handling-io-exceptions-in-java
            String[] except = {" "};
            return "This player is nonexistent.";
        }
    }

    /**
     * This method Accepts a USCF member id and prints the data page for that member.
     * 
     * runs to get webpage
     * @return the webpage as a string
     */
    public String main() throws IOException
    {
        String data = this.read();
        this.write();
        return data;        
    }
}

