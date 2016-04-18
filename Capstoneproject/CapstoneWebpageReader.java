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
/**
 * This class reads data from a webpage, specifically USchess.org, then writes this information to a file.
 * IMPORTANT  -use reader class from unit 8. HELPFUL
 * @author (Joseph Isaac) 
 * @version (4/16/16)
 */
public class CapstoneWebpageReader
{
    private String memberDataString;
    private String memberDataFileString;
    private String memberID;
    public CapstoneWebpageReader()
    {
        memberDataString = "";
        memberDataFileString  ="";
        memberID = "";
    }

    /**
     * This method Accepts a USCF member id and prints the data page for that member.
     * 
     * 
     */
    public String read() throws IOException
    {
        Document memberData = null;
        Scanner memberIDScanner = new Scanner(System.in);

        System.out.println("Please enter the member ID of the player: ");
        memberID = memberIDScanner.next();
        String memberURL = "http://www.uschess.org/msa/MbrDtlTnmtHst.php?" + memberID; // datapage for specific member

        Connection connection = Jsoup.connect(memberURL).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21").timeout(10000); // this is the workaround needed to access the webpage without getting an HTTPerrorfetchingURL
        Connection.Response response = connection.execute();
        if (response.statusCode() == 200) {
            memberData = connection.get();
        }

        memberDataString = memberData.text();

        System.out.println(memberDataString);
        return memberID;
    }

    /**
     * This method Accepts a USCF member id and prints the data page for that member.
     * 
     * 
     */
    public void write() throws IOException
    {
        String line = "";
        Scanner memberIDScanner = new Scanner(System.in);

        try
        {
            FileWriter writer = new FileWriter("memberData" + memberID + ".txt");
            writer.write(memberDataString);
            writer.close();

            FileReader fileReader = new FileReader("memberData" + memberID + ".txt");
            BufferedReader fileReaderReader = new BufferedReader(fileReader);

            while ((line = fileReaderReader.readLine()) != null)
            {
                memberDataFileString += line;
            }

            System.out.println(memberDataFileString);
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            File memberDataFile = new File("memberData" + memberID + ".txt");
        }
    }

    /**
     * Accessor method that returns the member's id.
     * 
     * 
     */
    public String getMemberID()
    {
        return this.memberID;
    }

     /**
     * Accessor method that returns the member's data string.
     * 
     * 
     */
    public String getMemberDataString()
    {
        return this.memberDataString;
    }
    
    /**
     * Method that fetches the name of the member.
     */
    public String fetchName()
    {
        return memberDataFileString.split("Help . " + memberID + ": " , 2)[1].split(" Events",2)[0];
    }
    
    /**
     * This method Accepts a USCF member id and prints the data page for that member.
     * 
     * 
     */
    public void main() throws IOException
    {
        this.read();
        this.write();
        System.out.println( "This member's ID is: " + getMemberID());
        System.out.println("The name of the member is: " + this.fetchName());
    }
}

