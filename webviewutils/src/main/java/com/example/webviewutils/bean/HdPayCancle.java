package com.example.webviewutils.bean;


import java.io.Serializable;

public class HdPayCancle implements Serializable {

    private String newOrderNumber;

    private String oldOrderNumber;
    

    public String getNewOrderNumber() {
        return newOrderNumber;
    }

    public void setNewOrderNumber(String newOrderNumber) {
        this.newOrderNumber = newOrderNumber;
    }

    public String getOldOrderNumber() {
        return oldOrderNumber;
    }

    public void setOldOrderNumber(String oldOrderNumber) {
        this.oldOrderNumber = oldOrderNumber;
    }

}
