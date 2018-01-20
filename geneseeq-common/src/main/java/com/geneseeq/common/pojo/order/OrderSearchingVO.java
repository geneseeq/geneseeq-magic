package com.geneseeq.common.pojo.order;

public class OrderSearchingVO {
    private String orderNumber;

    public OrderSearchingVO(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }


}
