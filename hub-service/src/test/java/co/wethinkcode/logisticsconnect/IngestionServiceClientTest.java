package co.wethinkcode.logisticsconnect;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IngestionServiceClientTest {
    @Test
    void fetchDataDoesNotReturnAnEmptyList(){

        IngestionServiceClient serviceClient = new IngestionServiceClient();

        List<Hub> hubs = serviceClient.fetchData();
        assertNotNull(hubs);
        assertFalse(hubs.isEmpty());

    }
}
