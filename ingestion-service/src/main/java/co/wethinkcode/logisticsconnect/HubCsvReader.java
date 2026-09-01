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
        return hubs;
    }
}
