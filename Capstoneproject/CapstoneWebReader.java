import java.net.URL;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.io.IOException;

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
        String address = "https://www.google.com/?gws_rd=ssl";
        URL pageLocation = new URL(address);
        Scanner in = new Scanner(pageLocation.openStream());
        String dis = in.next();
        System.out.println(dis);
    }
}
