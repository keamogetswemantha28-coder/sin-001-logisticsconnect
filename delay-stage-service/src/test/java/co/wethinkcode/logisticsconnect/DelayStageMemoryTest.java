package co.wethinkcode.logisticsconnect;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DelayStageMemoryTest {

    @Test
    void setStageAndGetStage_ReturnsTheSameValue(){
        DelayStageMemory memory = new DelayStageMemory();

        memory.setStage("H-501", 3);

        assertEquals(3, memory.getStage("H-501"));
    }

    @Test
    void getStage_ReturnsNull_whenHubWasNeverSet(){
        DelayStageMemory memory = new DelayStageMemory();

        assertNull(memory.getStage("H-999"));
    }
}
