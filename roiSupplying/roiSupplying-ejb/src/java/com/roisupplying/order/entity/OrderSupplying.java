
package com.roisupplying.order.entity;

import com.roisupplying.dto.OrderSupplyingDTO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderSupplying implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int orderId;
    int clientId;
    Date startDate;
    int hiredVolume;
    int serviceStationNumber;
    Date closingBillingDate;
    boolean cancelled;

    public OrderSupplying(){}
    
    public OrderSupplying(int clientId, Date startDate, int hiredVolume, int serviceStationNumber, Date closingBillingDate) {
        this.clientId = clientId;
        this.startDate = startDate;
        this.hiredVolume = hiredVolume;
        this.serviceStationNumber = serviceStationNumber;
        this.closingBillingDate = closingBillingDate;
        this.cancelled = false;
    }
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getHiredVolume() {
        return hiredVolume;
    }

    public void setHiredVolume(int hiredVolume) {
        this.hiredVolume = hiredVolume;
    }

    public int getServiceStationNumber() {
        return serviceStationNumber;
    }

    public void setServiceStationNumber(int serviceStationNumber) {
        this.serviceStationNumber = serviceStationNumber;
    }

    public Date getClosingBillingDate() {
        return closingBillingDate;
    }

    public void setClosingBillingDate(Date closingBillingDate) {
        this.closingBillingDate = closingBillingDate;
    }
    
    
}
