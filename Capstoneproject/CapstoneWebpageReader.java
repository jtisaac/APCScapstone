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
/**
 * This class reads data from a webpage, specifically USchess.org, then writes this information to a file.
 * IMPORTANT  -use reader class from unit 8. HELPFUL
 * @author (Joseph Isaac) 
 * @version (4/16/16)
 */
public class CapstoneWebpageReader
{
    private static String memberDataString;
    private static String memberDataFileString;
    public static String memberID;
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
    public static String read() throws IOException
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
    public static void write() throws IOException
    {
        String line = "";
        Scanner memberIDScanner = new Scanner(System.in);
        
        try
        {
            //File memberDataFile = new File("memberData.txt");
            
            FileWriter writer = new FileWriter("memberData.txt");
            writer.write(memberDataString);
            writer.close();

            FileReader fileReader = new FileReader("memberData.txt");
            BufferedReader fileReaderReader = new BufferedReader(fileReader);

            while ((line = fileReaderReader.readLine()) != null)
            {
                memberDataFileString += line;
            }
            
            System.out.println(memberDataFileString);

            //Scanner in = new Scanner(memberDataFile);
            //in.useDelimiter("=>");
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            File memberDataFile = new File("memberData.txt");
        }
    }
    /**
     * This method Accepts a USCF member id and prints the data page for that member.
     * 
     * 
     */
    public static String getMemberID()
    {
        return memberID;
    }
    /**
     * This method Accepts a USCF member id and prints the data page for that member.
     * 
     * 
     */
    public static void main() throws IOException
    {
        CapstoneWebpageReader.read();
        CapstoneWebpageReader.write();
    }
}

