package co.wethinkcode.logisticsconnect;

import io.javalin.Javalin;

public class DelayStageServiceApp {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7052);

        app.get("/health", ctx -> ctx.result("OK"));

        // TODO (Tracks the Transit Delay Stage (0-8, e.g. weather shutdowns).)
        // Add domain endpoints for delay-stage-service here.

        DelayStageMemory memory = new DelayStageMemory();

        app.get("/delay-stage/{hubId}", context -> {
            String hubId = context.pathParam("hubId");
            Integer hubStage =  memory.getStage(hubId);

            if (hubStage == null){
                context.status(404);
            }else {
                context.status(200).json(new DelayStageResponse(hubId, hubStage));
            }
        });

        app.post("/delay-stage/{hubId}", context -> {
            String hubId = context.pathParam("hubId");
            DelayStageUpdate request = context.bodyAsClass(DelayStageUpdate.class);

            memory.setStage(hubId, request.stage());
            context.status(200);

        });
    }
}

// MQ TODO: publishes to ActiveMQ topic MqConfig.TOPIC at MqConfig.BROKER_URL (see co.wethinkcode.logisticsconnect.mq.MqConfig)
