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
        String dis = "";
        String line = null, response;
        String address = "https://www.data.gov/education/";
        URL pageLocation = new URL(address);
        Scanner in = new Scanner(pageLocation.openStream());
        HttpURLConnection conn = (HttpURLConnection) pageLocation.openConnection();
        dis = in.next();
        System.out.println(dis);
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn
                .getInputStream()));
        while (rd.readLine() != null) {
            line += rd.readLine();
        }
        System.out.println(line);
    }
}
