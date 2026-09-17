package co.wethinkcode.logisticsconnect;

import io.javalin.Javalin;

public class TransitServiceApp {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7053);

        app.get("/health", ctx -> ctx.result("OK"));

        // TODO (Calculates estimated arrival windows based on hub and delay stage.)
        // Add domain endpoints for transit-service here.

        HubServiceClient serviceClient = new HubServiceClient();
        DelayStageServiceClient stageServiceClient = new DelayStageServiceClient();

        app.get("/eta/{hubId}", context -> {
            String hubId = context.pathParam("hubId");

            Hub hub = serviceClient.fetchHub(hubId);

            if (hub == null){
                context.status(503).result("Hub service is unavailable");
                return;
            }

            DelayStageResponse delayStageResponse = stageServiceClient.fetchDelayStage(hubId);
            if (delayStageResponse == null){
                context.status(503).result("Delay Stage service is unavailable");
                return;
            }


            int baseMinutes = 30;
            int delayMinutes = delayStageResponse.stage() * 10;
            int totalMinutes = baseMinutes + delayMinutes;

            context.status(200).result("Estimated arrival for "+ hub.hubId() + ": "+ totalMinutes + " minutes");

        });
    }
}

// MQ TODO: subscribes to ActiveMQ topic MqConfig.TOPIC at MqConfig.BROKER_URL (see co.wethinkcode.logisticsconnect.mq.MqConfig)
