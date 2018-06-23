
package com.roisupplying.order.imp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Singleton
@Startup
@LocalBean
public class SenderBean {

    @Resource(lookup = "jms/ConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "jms/MyQueue")
    private Queue queue;
    
    @PostConstruct
    private void init() {
        //enviarMensaje();
        calloutToPlanner();
    }
    
    private void calloutToPlanner() {
        try {
            String uri = "http://localhost:8080/roiPlanner-war/plans";
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bufferReader = new BufferedReader(isr);
            String strAux;
            StringBuilder strBuilder = new StringBuilder();
            while ((strAux = bufferReader.readLine()) != null) {
                strBuilder.append(strAux);
                strBuilder.append("\n");
            }

            connection.disconnect();

            String jsonString = strBuilder.toString();
            System.out.println("$$$$$$$ jsonString:"+jsonString);

        } catch (Exception e) {
            
        }

    }
    
    private void enviarMensaje() {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession();
            
            TextMessage msg = session.createTextMessage("HOLA BOUCHA");
            MessageProducer producer = session.createProducer(queue);
            producer.send(msg);
            
            session.close();
            connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(SenderBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
