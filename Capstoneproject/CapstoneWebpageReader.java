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
    /**
     * This method Accepts a USCF member id and prints the data page for that member.
     * 
     * 
     */
    public static void main(String[] args) throws IOException, HttpStatusException
    {
        Document memberData = null;
        String memberDataString = null;
        String memberDataFileString = "";
        String line = null;
        Scanner memberIDScanner = new Scanner(System.in);

        System.out.println("Please enter the member ID of the player: ");
        String memberID = memberIDScanner.next();
        String memberURL = "http://www.uschess.org/msa/MbrDtlTnmtHst.php?" + memberID; // datapage for specific member

        Connection connection = Jsoup.connect(memberURL).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21").timeout(10000); // this is the workaround needed to access the webpage without getting an HTTPerrorfetchingURL
        Connection.Response response = connection.execute();
        if (response.statusCode() == 200) {
            memberData = connection.get();
        }

        memberDataString = memberData.text();

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

            //             while (in.hasNext())
            //             {
            //                 //charcount ++;
            //                 in.next();
            //             }
            //System.out.println();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        //         /**
        //          * Write a description of class thingreadedr here.
        //          * 
        //          * @author (your name) 
        //          * @version (a version number or a date)
        //          */
        //         public class reader
        //         {
        //             /** description of instance variable x (add comment for each instance variable) */
        //             private static int charcount;
        //             private static int wordcount;
        //             private static int linecount;
        // 
        //             /**
        //              * Default constructor for objects of class thingreadedr
        //              */
        //             public reader()
        //             {
        //                 // initialise instance variables
        //                 charcount = 0;
        //             }
        // 
        //             public static void main(String[] args)
        //             {
        //                 try
        //                 {
        //                     File inputFile = new File("words.txt");
        // 
        //                     Scanner in = new Scanner(inputFile);
        //                     in.useDelimiter("");
        // 
        //                     while (in.hasNext())
        //                     {
        //                         charcount ++;
        //                         in.next();
        //                     }
        //                     //System.out.println();
        //                 }
        //                 catch(FileNotFoundException e)
        //                 {
        //                     System.out.println(e.getMessage());
        //                 }
        //                 try
        //                 {
        //                     File inputFile = new File("words.txt");
        // 
        //                     Scanner inz = new Scanner(inputFile);
        //                     inz.useDelimiter(" ");
        // 
        //                     while (inz.hasNext())
        //                     {
        //                         wordcount ++;
        //                         inz.next();
        //                     }
        //                     //System.out.println();
        //                 }
        //                 catch(FileNotFoundException e)
        //                 {
        //                     System.out.println(e.getMessage());
        //                 }
        //                 try
        //                 {
        //                     File inputFile = new File("words.txt");
        // 
        //                     Scanner inq = new Scanner(inputFile);
        //                     inq.useDelimiter("\n");
        // 
        //                     while (inq.hasNext())
        //                     {
        //                         linecount ++;
        //                         inq.next();
        //                     }
        //                     //System.out.println();
        //                 }
        //                 catch(FileNotFoundException e)
        //                 {
        //                     System.out.println(e.getMessage());
        //                 }
        //                 System.out.println("The # of characters is: " + charcount + "\n"  + "The # of words is: " + wordcount + "\n" + "The # of lines is: " + linecount );
    }
}

