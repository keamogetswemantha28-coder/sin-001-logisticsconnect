package co.wethinkcode.logisticsconnect;

import io.javalin.Javalin;

import java.util.List;

public class IngestionServiceApp {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7050);

        app.get("/health", ctx -> ctx.result("OK"));

        //Add hub endpoint
        app.get("/hubs", context -> {
            HubCsvReader reader = new HubCsvReader();
            List<Hub> hubs = reader.readAndClean();
            context.json(hubs);

        });


        // TODO: read and clean src/main/resources/hubs-global.csv (hubs, sorting centers, regional districts data —
        // trim whitespace, fix casing, normalize dates/booleans) and expose the
        // cleaned records here for the other services to consume.
    }
}
