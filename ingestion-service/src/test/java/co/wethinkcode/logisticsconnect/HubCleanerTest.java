package co.wethinkcode.logisticsconnect;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

//    "TRUE" → "true"
//            "1" → "true"
//            "Y" → "true"
//            "yes" → "true"
//            "FALSE" → "false"
//            "0" → "false"
//            "N" → "false"
//            "no" → "false"

    @Test
    void normaliseBoolean_ReturnsTheCorrectValue(){
        HubCleaner hubCleaner = new HubCleaner();

        //String results = hubCleaner.normaliseBoolean("TRUE");

        assertEquals("true", hubCleaner.normaliseBoolean("TRUE"));
        assertEquals("true", hubCleaner.normaliseBoolean("1"));
        assertEquals("true", hubCleaner.normaliseBoolean("yes"));
        assertEquals("true", hubCleaner.normaliseBoolean("Y"));
        assertEquals("false", hubCleaner.normaliseBoolean("0"));
        assertEquals("false", hubCleaner.normaliseBoolean("FALSE"));
        assertEquals("false", hubCleaner.normaliseBoolean("N"));
        assertEquals("false", hubCleaner.normaliseBoolean("no"));
    }

    @Test
    void testToTitleCase(){
        HubCleaner cleaner = new HubCleaner();

        assertEquals("Gauteng", cleaner.toTitleCase("gauteng"));
        assertEquals("Western Cape", cleaner.toTitleCase("western cape"));
        assertEquals("Gauteng", cleaner.toTitleCase("GAUTENG"));
    }

    @Test
    void toLowerCase_ShouldLowerStatusValues(){
        HubCleaner cleaner = new HubCleaner();
        assertEquals("active", cleaner.statusToLowerCase("ACTIVE"));
    }
}
