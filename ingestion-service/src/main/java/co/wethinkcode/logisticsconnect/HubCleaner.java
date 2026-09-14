package co.wethinkcode.logisticsconnect;

import java.util.Map;
import java.util.Set;

public class HubCleaner {
    //A map of messy province spellings
    private static final Map<String, String> PROVINCE_LOOKUP = Map.ofEntries(
            Map.entry("gauteng", "Gauteng"),
            Map.entry("western cape", "Western Cape"),
            Map.entry("kwazulu-natal", "KwaZulu-Natal"),
            Map.entry("kwa-zulu natal", "KwaZulu-Natal"),
            Map.entry("kwa zulu natal", "KwaZulu-Natal"),
            Map.entry("kwazulu natal", "KwaZulu-Natal"),
            Map.entry("eastern cape", "Eastern Cape"),
            Map.entry("free state", "Free State"),
            Map.entry("limpopo", "Limpopo"),
            Map.entry("mpumalanga", "Mpumalanga"),
            Map.entry("north west", "North West"),
            Map.entry("northern cape", "Northern Cape")
    );

    //Remove trailing spaces and inner spaces
    public String cleanWhiteSpace(String text){
        return text.replaceAll("\\s+", " ").trim();
    }

    public String normaliseProvince(String text){
        if (text == null){
            return null;
        }
        return PROVINCE_LOOKUP.getOrDefault(text.toLowerCase(), toTitleCase(text));
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

        if (text == null || text.isEmpty()){
            return text;
        }

        String [] words = text.split(" ");
        String results = "";
        for (String word: words){
            String i = word.substring(0,1);

            String restOfWord = word.substring(1);

            results+= i.toUpperCase()+ restOfWord.toLowerCase()+" ";
        }
        return results.trim();
    }

    //To lower case
    public String statusToLowerCase(String value){
        return value.trim().toLowerCase();
    }

    public String hubIdToUpperCase(String hubId){
        return hubId.trim().toUpperCase();
    }

    //Placeholder Values should return null
    public String placeholderValues(String value) {
        Set<String> placeholders = Set.of("N/A", "", "TBD", "-", "unknown", "NaN", "n/a");
        if (placeholders.contains(value)) {
            return null;
        }
        return value;
    }

}
