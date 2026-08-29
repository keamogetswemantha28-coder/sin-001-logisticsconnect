package co.wethinkcode.logisticsconnect;

import java.util.Set;

public class HubCleaner {

    //Remove trailing spaces and inner spaces
    public String cleanWhiteSpace(String text){
        return text.replaceAll("\\s+", " ").trim();
    }

    public String normaliseBoolean(String value){
        Set<String> trueValues = Set.of("1", "true", "yes", "y");
        Set<String> falseValues = Set.of("0", "false", "n", "no");
        if ((trueValues.contains(value.toLowerCase()))){
            return "true";
        }
        else if (falseValues.contains(value.toLowerCase())){
            return "false";
        }
        return null;
    }

    //Convert to titlecase
    public String toTitleCase(String text){
        return "";
    }

}
