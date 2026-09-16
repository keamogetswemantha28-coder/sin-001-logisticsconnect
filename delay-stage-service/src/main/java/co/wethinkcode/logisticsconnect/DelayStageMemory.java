package co.wethinkcode.logisticsconnect;

import java.util.HashMap;
import java.util.Map;

public class DelayStageMemory {
    private final Map<String, Integer> hubIdStages = new HashMap<>();


    public void setStage(String hubId , int stage) {
        hubIdStages.put(hubId,stage);
    }
    public Integer getStage(String hubId){
        return hubIdStages.get(hubId);
    }
}
