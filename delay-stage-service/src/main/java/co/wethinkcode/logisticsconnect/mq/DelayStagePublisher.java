package co.wethinkcode.logisticsconnect.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

public class DelayStagePublisher {

    public void publish(String hubId, int stage) {
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory(MqConfig.BROKER_URL);
            Connection connection = factory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic(MqConfig.TOPIC);
            MessageProducer producer = session.createProducer(topic);

            String json = String.format(
                    "{\"hubId\": \"%s\", \"stage\": %d}", hubId, stage
            );
            TextMessage message = session.createTextMessage(json);
            producer.send(message);

            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}