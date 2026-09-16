package co.wethinkcode.logisticsconnect;

import io.javalin.Javalin;

import java.util.List;

public class HubServiceApp {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7051);

        app.get("/health", ctx -> ctx.result("OK"));

        // TODO (Serves provinces and sorting centers (place-name source of truth).)
        // Add domain endpoints for hub-service here.
        app.get("/hubs", context -> {
            IngestionServiceClient client = new IngestionServiceClient();
            List<Hub> hubs = client.fetchData();

            if (hubs == null){
                context.status(503).result("Ingestion service unavailable");
            }else {
                context.json(hubs);
            }

        });
        app.get("/hubs/{hubId}", context -> {
            IngestionServiceClient client = new IngestionServiceClient();

            List<Hub> hubs = client.fetchData();

            if (hubs == null){
                context.status(503).result("Ingestion service unavailable");
                return;
            }

            String id = context.pathParam("hubId");
             Hub matchFound = hubs.stream().filter(h -> h.hubId().equalsIgnoreCase(id)).findFirst()
                     .orElse(null);

             if (matchFound == null){
                 context.status(404);
             }else {
                 context.status(200).json(matchFound);
             }

        });
    }
}
