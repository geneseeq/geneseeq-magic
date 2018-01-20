package com.geneseeq.common.pojo.user;

import java.util.List;

/**
 * Created by jamesRMBP on 12/09/2017.
 */
public class SalerPerformanceSearchingVO {

    //private String[] userlist;

    private List<SalerUserVO> userlist;

    private String start_date;

    private String end_date;

   /* public String[] getUserlist() {
        return userlist;
    }

    public void setUserlist(String[] userlist) {
        this.userlist = userlist;
    }*/

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public List<SalerUserVO> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<SalerUserVO> userlist) {
        this.userlist = userlist;
    }
}
