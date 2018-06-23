
package com.roisupplying.order.imp;

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
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/MyQueue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ReceiverBean implements MessageListener {
    
    @EJB
    private OrderPersistenceLocal orderPersistenceLocal;
    
    
    public ReceiverBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println("reading messages:");
        try {
            TextMessage txt = (TextMessage) message;
            System.out.println("LLEGO DESDE LA QUEUE = " + txt.getText());
            OrderSupplying o = new OrderSupplying();
            orderPersistenceLocal.create(o);
        } catch (JMSException ex) {
            Logger.getLogger(ReceiverBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
