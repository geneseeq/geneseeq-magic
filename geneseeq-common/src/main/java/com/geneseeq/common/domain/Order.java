package com.geneseeq.common.domain;

import java.util.Date;

/**
 * Created by jamesRMBP on 13/10/2017.
 */
public class Order {

    private String id;

    private String fee;

    private String commissioner;

    private String name;

    private String stateName;

    private String isFee;

    private Date createDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getCommissioner() {
        return commissioner;
    }

    public void setCommissioner(String commissioner) {
        this.commissioner = commissioner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getIsFee() {
        return isFee;
    }

    public void setIsFee(String isFee) {
        this.isFee = isFee;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
