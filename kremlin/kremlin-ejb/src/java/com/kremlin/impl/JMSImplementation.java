
package com.kremlin.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSImplementation {
    
    private ConnectionFactory connectionFactory;
    private Queue queue;

    public JMSImplementation(String connectionFactoryName, String queueName){
        InitialContext ic = null;
        try {
            ic = new InitialContext();
            this.connectionFactory = (ConnectionFactory)ic.lookup(connectionFactoryName);
            this.queue = (Queue)ic.lookup(queueName);
        } catch (NamingException ex) {
            Logger.getLogger(JMSImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessage(String message) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession();
            TextMessage msg = session.createTextMessage(message);
            MessageProducer producer = session.createProducer(queue);
            producer.send(msg);
            session.close();
            connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(JMSImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
