package com.geneseeq.common.pojo.user;

/**
 * Created by jamesRMBP on 12/09/2017.
 */
public class SalerPerformanceVO {

    private String userid;

    private String name;

    private String order_amount;

    private String sale_amount;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(String order_amount) {
        this.order_amount = order_amount;
    }

    public String getSale_amount() {
        return sale_amount;
    }

    public void setSale_amount(String sale_amount) {
        this.sale_amount = sale_amount;
    }
}
