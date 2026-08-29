package co.wethinkcode.logisticsconnect;

import java.util.Set;

public class HubCleaner {

    //Remove trailing spaces and inner spaces
    public String cleanWhiteSpace(String text){
        return text.replaceAll("\\s+", " ").trim();
    }

    public String normaliseBoolean(String text){
        return "";
    }
}
