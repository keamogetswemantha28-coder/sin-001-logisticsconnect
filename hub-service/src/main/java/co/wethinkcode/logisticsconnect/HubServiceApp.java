package co.wethinkcode.logisticsconnect;

import io.javalin.Javalin;

public class HubServiceApp {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7051);

        app.get("/health", ctx -> ctx.result("OK"));

        // TODO (Serves provinces and sorting centers (place-name source of truth).)
        // Add domain endpoints for hub-service here.
        app.get("/hubs", context -> context.result("OK"));
        app.get("/hubs/{hubId", context -> {
            String id = context.pathParam("hubId");

            //convert id to integer
            int hubId = Integer.valueOf(id);
        });
    }
}
