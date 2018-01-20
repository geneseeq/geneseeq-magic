package com.geneseeq.common.pojo.user;


import com.geneseeq.common.pojo.sample.OrderSampleVO;

import java.util.List;

/**
 * Created by jamesRMBP on 13/09/2017.
 */
public class UserOrderVO {
    private String orderid;
    private String customer_name;
    private String order_amount;
    private String payment_state;
    private String state;
    private String send_sample_date;
    //private String report_finished_date;
    private String order_created_at;

    private List<OrderSampleVO> sample_info_list;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(String order_amount) {
        this.order_amount = order_amount;
    }

    public String getPayment_state() {
        return payment_state;
    }

    public void setPayment_state(String payment_state) {
        this.payment_state = payment_state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSend_sample_date() {
        return send_sample_date;
    }

    public void setSend_sample_date(String send_sample_date) {
        this.send_sample_date = send_sample_date;
    }

    public String getOrder_created_at() {
        return order_created_at;
    }

    public void setOrder_created_at(String order_created_at) {
        this.order_created_at = order_created_at;
    }

    public List<OrderSampleVO> getSample_info_list() {
        return sample_info_list;
    }

    public void setSample_info_list(List<OrderSampleVO> sample_info_list) {
        this.sample_info_list = sample_info_list;
    }
}
