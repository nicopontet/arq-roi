
package com.roisupplying.order.imp;

import com.google.gson.Gson;
import com.roisupplying.order.entity.OrderSupplying;
import com.roisupplying.order.persistence.OrderPersistenceLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/RoiSupplyingQueue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class QueueHandler implements MessageListener {

    @EJB
    private OrderPersistenceLocal orderPersistenceLocal;
    private Gson gson;
    
    public QueueHandler() {
        gson = new Gson();
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage txt = (TextMessage) message;
            OrderSupplying newOrder = gson.fromJson(txt.getText(), OrderSupplying.class);
            orderPersistenceLocal.create(newOrder);
        } catch (JMSException ex) {
            Logger.getLogger(QueueHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
