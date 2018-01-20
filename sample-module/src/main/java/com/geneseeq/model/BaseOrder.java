package com.geneseeq.model;

import java.io.Serializable;

public class BaseOrder implements Serializable{
    private static final long serialVersionUID = -3258839839160856613L;
    private String id;
    private String userName;
    private String passWord;

    public String getId() {
        return id;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
