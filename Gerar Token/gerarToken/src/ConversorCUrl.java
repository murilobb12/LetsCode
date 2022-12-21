import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorCUrl {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://apis-gateway-h.bndes.gov.br/token");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("POST");

        httpConn.setRequestProperty("Authorization", "Basic cWVVV3JxMGZrNWVtU2FxakgwSTlUVXFzQ3dzYTpPeGlnRlYyMUZpb1ZvMEJlMENnbXBVU01nY1Vh");
        httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        httpConn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
        writer.write("grant_type=client_credentials&scope=fg2_read fg2_write");
        writer.flush();
        writer.close();
        httpConn.getOutputStream().close();

        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        String response = s.hasNext() ? s.next() : "";
        System.out.println(response);
    }


}
