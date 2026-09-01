package co.wethinkcode.logisticsconnect;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HubCsvReader {

    public List<Hub> readAndClean(){
        HubCleaner cleaner = new HubCleaner();
        //New list to store cleaned data
        List<Hub> hubs = new ArrayList<>();
        try(InputStream stream = getClass().getClassLoader().getResourceAsStream("hubs-global.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(stream))){

            reader.readNext();
            String [] row;
            while ((row = reader.readNext()) != null){
                String hubId = cleaner.hubIdToUpperCase(cleaner.cleanWhiteSpace(row[0]));
                String province = cleaner.toTitleCase(cleaner.cleanWhiteSpace(row[1]));
                String sortingCenter = cleaner.cleanWhiteSpace(row[2]);
                String activeStr = cleaner.normaliseBoolean(cleaner.cleanWhiteSpace(row[3]));
                boolean active = "true".equals(activeStr);

                Hub hub = new Hub(hubId, province,sortingCenter,active);
                hubs.add(hub);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return hubs;
    }
}
