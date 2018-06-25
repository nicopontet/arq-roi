
package com.roisupplying.order.entity;

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
    int closingBillingDate;

    public OrderSupplying(){}
    public OrderSupplying(int clientId, Date startDate, int hiredVolume, int serviceStationNumber, int closingBillingDate) {
        this.clientId = clientId;
        this.startDate = startDate;
        this.hiredVolume = hiredVolume;
        this.serviceStationNumber = serviceStationNumber;
        this.closingBillingDate = closingBillingDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public int getClosingBillingDate() {
        return closingBillingDate;
    }

    public void setClosingBillingDate(int closingBillingDate) {
        this.closingBillingDate = closingBillingDate;
    }
    
    
}
