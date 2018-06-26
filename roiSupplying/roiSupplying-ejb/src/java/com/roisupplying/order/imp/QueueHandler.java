
package com.roisupplying.order.imp;

import com.google.gson.Gson;
import com.roisupplying.dto.OrderSupplyingDTO;
import com.roisupplying.dto.PlanDTO;
import com.roisupplying.dto.QueueDTO;
import com.roisupplying.order.entity.OrderSupplying;
import com.roisupplying.order.persistence.OrderPersistenceLocal;
import java.util.Date;
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
            QueueDTO newQueueDTO = gson.fromJson(txt.getText(), QueueDTO.class);
            OrderSupplying newOrder = gson.fromJson(newQueueDTO.getData(),OrderSupplying.class);
            if (RegistrationBean.TOKEN_KREMLIN.equals(newQueueDTO.getToken())) {
                switch (newQueueDTO.getAction()){
                    case RegistrationBean.OPERATION_CREATE_ORDER:
                        orderPersistenceLocal.create(newOrder);
                        //call to create plan
                        PlanDTO plan = new PlanDTO(newOrder.getOrderId());
                        ExternalOperationsHandler.callOperation("CreatePlan", "POST", gson.toJson(plan));
                        break;
                    case RegistrationBean.OPERATION_MODIFY_ORDER:
                        OrderSupplying baseOrder = orderPersistenceLocal.find(newOrder.getOrderId());
                        if(baseOrder!=null && !baseOrder.isCancelled()){
                            baseOrder = OrderLogic.updateOrder(baseOrder, newOrder);
                            orderPersistenceLocal.edit(baseOrder);
                        }
                        break;
                    case RegistrationBean.OPERATION_DELETE_ORDER:
                        OrderSupplying baseOrderDelete = orderPersistenceLocal.find(newOrder.getOrderId());
                        if(baseOrderDelete!=null){
                            baseOrderDelete.setCancelled(true);
                            orderPersistenceLocal.edit(baseOrderDelete);
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (JMSException ex) {
            Logger.getLogger(QueueHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
