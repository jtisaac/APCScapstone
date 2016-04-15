import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class WebpageReader {
    public static void main(String[] args) throws IOException {
        String line = null, response;
        URL url = new URL("https://new.uschess.org/home/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn
                .getInputStream()));
        while (rd.readLine() != null) {
            line += rd.readLine();
        }
        System.out.println(line);

    }
}