import java.net.URL;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/**
 * Write a description of class CapstoneWebReader here.
 * This is my capstone project
 * @author (Joseph Isaac) 
 * @version (4/15/16)
 */
public class CapstoneWebReader
{

    public static void main(String[] args) throws MalformedURLException, IOException
    {
        String bit = "";
        String line = "";
        Scanner memberid = new Scanner(System.in);
        System.out.println("Please input the member id # of the member: " );
        String id = memberid.next();
        memberid.close();
        String address = "http://www.uschess.org/msa/MbrDtlRtgSupp.php?" + id;
        URL pageLocation = new URL(address);
        HttpURLConnection conn = (HttpURLConnection) pageLocation.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while (rd.readLine() != null) {
            line += rd.readLine();
            bit = rd.readLine();
            System.out.println(bit);
        }
    }
}
