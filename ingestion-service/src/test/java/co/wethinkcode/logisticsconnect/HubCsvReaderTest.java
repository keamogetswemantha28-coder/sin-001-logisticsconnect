package co.wethinkcode.logisticsconnect;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    void readAndClean_returnsCleanedValidData(){
        //Arrange
        HubCsvReader reader = new HubCsvReader();

        //Act
        List<Hub> hubs = reader.readAndClean();

        Hub hub = hubs.get(0);

        //assert
        assertEquals("H-500",hub.hubId());
        assertEquals("Gauteng", hub.province());
        assertTrue(hub.active());
    }
}
