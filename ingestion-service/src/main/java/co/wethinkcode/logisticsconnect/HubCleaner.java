package co.wethinkcode.logisticsconnect;

public class HubCleaner {

    //Remove trailing spaces and inner spaces
    public String cleanWhiteSpace(String text){
        return text.replaceAll("\\s+", " ").trim();
    }
}
