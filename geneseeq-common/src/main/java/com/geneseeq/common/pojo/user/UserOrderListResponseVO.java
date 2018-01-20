package com.geneseeq.common.pojo.user;


import com.geneseeq.common.pojo.BaseResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jamesRMBP on 12/09/2017.
 */
public class UserOrderListResponseVO<T> extends BaseResponse implements Serializable {

    private static final long serialVersionUID = -8360254900955269614L;

    private List<T> orderlist = new ArrayList<T>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<T> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(List<T> orderlist) {
        this.orderlist = orderlist;
    }


}
