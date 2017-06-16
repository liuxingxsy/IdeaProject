package com.message.middleware.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jms.*;

/**
 * Created by siyong.xu on 2017-06-15.
 */
public class Producer {
    private final static Logger log= LogManager.getLogger(Producer.class);
    public static void main(String[] args) {
        //初始化连接工厂
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("admin","admin","tcp://localhost:61616");
        Connection connection = null;
        try {
            //获取连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建Session，此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
            Session  session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            //创建队列
            Destination testActiveMQ = session.createQueue("testActiveMQ");
            MessageProducer producer=session.createProducer(testActiveMQ);
            //发送消息
            sendMsg(session,producer);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection!=null){
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
    public static void sendMsg(Session session,MessageProducer producer) throws Exception{
        for (int i=0;i<100;i++){
            //初始化mq消息
            TextMessage message=session.createTextMessage("hello activeMQ"+i);
            producer.send(message);
            log.info("sendMessge:{}",message);
        }
    }
}
