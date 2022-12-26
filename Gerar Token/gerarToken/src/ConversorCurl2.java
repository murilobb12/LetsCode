import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorCurl2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apis-gateway-h.bndes.gov.br/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", "Basic cWVVV3JxMGZrNWVtU2FxakgwSTlUVXFzQ3dzYTpPeGlnRlYyMUZpb1ZvMEJlMENnbXBVU01nY1Vh")
                .method("POST", HttpRequest.BodyPublishers.ofString("grant_type=client_credentials&scope=fg2_read%20fg2_write"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();

        int posInicial = responseBody.indexOf(":") + 2;
        int posFinal = responseBody.indexOf(":", 16) - 9;

        System.out.println(responseBody.indexOf(":"));
        System.out.println(responseBody.indexOf(":" , 16));

        String bearerToken = "Bearer " + responseBody.substring(posInicial, posFinal);
        System.out.println(bearerToken);
    }
}