import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import org.jsoup.HttpStatusException;
import org.jsoup.Connection;
/**
 * Write a description of class Read here.
 * 
 * @author (Joseph Isaac) 
 * @version (4/16/16)
 */
public class CapstoneWebpageReader
{
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main(String[] args) throws IOException, HttpStatusException
    {
        //Document doc = Jsoup.connect("http://jsoup.org/cookbook/extracting-data/example-list-links").get();
        //String textContents = doc.select(".newsText").first().text();

        String baseUrl = "http://www.uschess.org/msa/MbrDtlTnmtHst.php?14733522";
        Connection con = Jsoup.connect(baseUrl).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21").timeout(10000);
        Connection.Response resp = con.execute();
        Document doc = null;
        if (resp.statusCode() == 200) {
            doc = con.get();

        }
        String title = doc.text();
        System.out.println(title);
    }
}
