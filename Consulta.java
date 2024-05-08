import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Consulta{
    //agregar try-catch???
    
    public double conversor(double amount, String base, String currency) throws IOException, InterruptedException{

        String apikey = "8ec851d67139e4ebb0a7871a";
        String direction = "https://v6.exchangerate-api.com/v6/"+apikey+"/latest/"+base;
        Gson gson = new GsonBuilder().create();
    
        HttpClient client = HttpClient.newHttpClient();
    
        HttpRequest request = HttpRequest.newBuilder()
         .uri(URI.create(direction))
         .build();
    
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        
        String json = response.body();
        Rates rates = gson.fromJson(json, Rates.class);

        return amount*rates.conversion_rates().get(currency);
        
    }
}