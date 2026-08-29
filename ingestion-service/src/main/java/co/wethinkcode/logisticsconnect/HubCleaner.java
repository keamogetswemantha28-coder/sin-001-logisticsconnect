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

}
