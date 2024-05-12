import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Consulta{
    
    public double conversor(double amount, String base, String currency) throws IOException, InterruptedException{

        String apikey = "8ec851d67139e4ebb0a7871a";
        URI direction = URI.create("https://v6.exchangerate-api.com/v6/"+apikey+"/latest/"+base);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(direction)
        .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        
        Gson gson = new GsonBuilder().create();
        Rates rates = gson.fromJson(response.body(), Rates.class);

        return amount*rates.conversion_rates().get(currency);
    }
}