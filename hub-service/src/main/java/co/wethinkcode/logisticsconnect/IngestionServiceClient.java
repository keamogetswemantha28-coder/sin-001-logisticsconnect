package co.wethinkcode.logisticsconnect;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class IngestionServiceClient {
    public List<Hub> fetchData(){
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(URI
                    .create("http://localhost:7050/hubs")).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() !=200){
                System.out.println("Ingestion Service returned status: "+ response.statusCode());
                return null;
            }
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readValue(response.body(), new TypeReference<List<Hub>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
