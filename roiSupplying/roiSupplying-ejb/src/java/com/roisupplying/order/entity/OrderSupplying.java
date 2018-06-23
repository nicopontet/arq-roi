
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
}
