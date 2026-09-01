package co.wethinkcode.logisticsconnect;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HubCsvReaderTest {

    @Test
    void readAndClean_ShouldReturnNonEmptyList(){
        //Arrange
        HubCsvReader reader = new HubCsvReader();

        //Act
        List<Hub> hubs = reader.readAndClean();

        //Assert
        assertNotNull(hubs);

        //Check if the list is not empty
        assertFalse(hubs.isEmpty());



    }
}
