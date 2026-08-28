package co.wethinkcode.logisticsconnect;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HubCleanerTest {

    @Test
    void cleanWhiteSpace_ShouldRemoveTrailingSpaces(){
        HubCleaner cleaner = new HubCleaner();

        String results = cleaner.cleanWhiteSpace("H-502 ");

        assertEquals("H-502", results);
    }

    @Test
    void cleanWhiteSpace_ShouldRemoveDoubleSpaces(){
        HubCleaner cleaner = new HubCleaner();

        String results = cleaner.cleanWhiteSpace("Johannesburg  Hub");

        assertEquals("Johannesburg Hub", results);
    }
}
