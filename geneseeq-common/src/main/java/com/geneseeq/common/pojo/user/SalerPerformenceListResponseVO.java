package com.geneseeq.common.pojo.user;


import com.geneseeq.common.pojo.BaseResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SalerPerformenceListResponseVO<T> extends BaseResponse implements Serializable {

    private static final long serialVersionUID = -8360254902355269614L;

    private List<T> userlist = new ArrayList<T>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<T> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<T> userlist) {
        this.userlist = userlist;
    }
}
