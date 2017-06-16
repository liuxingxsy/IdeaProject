package com.message.middleware.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jms.*;

/**
 * Created by siyong.xu on 2017-06-15.
 */
public class Consumer implements  MessageListener {
    private final static Logger log= LogManager.getLogger(Producer.class);
    public static void main(String[] args) {
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("admin","admin","tcp://localhost:61616");
        Connection connection=null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination testActiveMQ = session.createQueue("testActiveMQ");
            MessageConsumer consumer=session.createConsumer(testActiveMQ);
            Consumer consumerListenr=new Consumer();
            consumer.setMessageListener(consumerListenr);
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void onMessage(Message message) {
        TextMessage tMsg= (TextMessage) message;
        try {
            log.info("get Message:{}",tMsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
