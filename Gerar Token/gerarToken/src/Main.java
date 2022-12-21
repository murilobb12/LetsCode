import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {


//        HttpRequest request = HttpRequest.newBuilder()
////                .GET()
//                .DELETE()
////                .uri(URI.create("https://xkcd.com/info.0.json")) /*Usar no get*/
//                .uri(URI.create("https://postman-echo.com/delete")) /*Usar no delete*/
//                .build();
//
//        HttpClient httpClient = HttpClient.newBuilder()
//                .followRedirects(HttpClient.Redirect.NORMAL)
//                .build();
//
//        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.body());

/**
 * -----------------------------------------------------------------------------------------------------
 */
//        HttpClient client = HttpClient.newHttpClient();
//
//        String requisicao = "{\"id\":1,\"nome\":\"Murilo Santos\",\"sexo\":\"MASCULINO\"}";
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI("http://localhost:8080/users"))
//                .GET()
//                .header("Content-Type", "application/json")
////                .POST(HttpRequest.BodyPublishers.ofString(requisicao))
//                .build();
//
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//
//        System.out.println(response.body());
/**
 * -----------------------------------------------------------------------------------------------------
 */
//        HttpClient client = HttpClient.newHttpClient();
//
//
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .POST(HttpRequest.BodyPublishers.noBody())
//                .uri(new URI("https://apis-gateway-h.bndes.gov.br/token"))
//                .header("Authorization", "Basic cWVVV3JxMGZrNWVtU2FxakgwSTlUVXFzQ3dzYTpPeGlnRlYyMUZpb1ZvMEJlMENnbXBVU01nY1Vh")
//                .header("Content-Type", "application/x-www-form-urlencoded")
//                .header("grant_type", "client_credentials")
//                .header("scope", "fg2_read fg2_write")
//                .build();
//
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.body());
//    }

/**
 * ------------------------------------------------------------------------------------------------
 */

        String token = "\t\"access_token\": \"ac44f794-7ba9-3879-a154-d6ae8bf29267\",\n" +
                "\t\"scope\": \"am_application_scope fg2_read fg2_write\",\n" +
                "\t\"token_type\": \"Bearer\",\n" +
                "\t\"expires_in\": 3600";

        System.out.println(token);
        int posInicial = token.indexOf(":") + 3;
        int posFinal = token.indexOf(":", 16) - 11;



        String bearerToken = "Bearer " + token.substring(posInicial, posFinal);
        System.out.println(bearerToken);

//        System.out.println(token.toLowerCase().contains("access_token"));

//        System.out.println(token.substring(17,53));



    }

}
