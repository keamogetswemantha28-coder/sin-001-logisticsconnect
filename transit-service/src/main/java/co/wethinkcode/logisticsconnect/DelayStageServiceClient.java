package co.wethinkcode.logisticsconnect;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DelayStageServiceClient {
    public DelayStageResponse fetchDelayStage(String hubId){
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("" +
                    "http://localhost:7052/delay-stage/" + hubId)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200){
                System.out.println("Delay Stage Service returned status: "+ response.statusCode());
                return null;
            }
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body(), DelayStageResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
