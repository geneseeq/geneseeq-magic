package com.geneseeq.common.utils;

import java.util.UUID;

public class Content {
    private Content() {
    }

    private static Content Instance = null;

    public static synchronized Content getContent() {
        if (Instance == null) {
            Instance = new Content();
        }
        return Instance;
    }


    public static final String unpaid = "0";
    public static final String free = "3";
    public static final String donestatus = "02";
    public static final String nodealstatus = "99";
    public static final String nodeal = "未处理";
    public static final String address = "南京本部";
    public static final String sendbyself = "自己送至公司";
    public static final String dataremarks = "lims不存在的订单号，无法进行取样打包的关联";
    public static final String successpackage = "打包成功";
    public static final String maindataremarks = "已经关联取样打包的订单号，无法进行再次关联";
    public static final String[] express = {"ID", "CODE", "EXPRESS_COMPANY", "EXPRESS_ORDER", "SEND_TIME", "PACK_USER", "STATE_ID", "STATE_NAME"};
    public static final String WebServiceKey = "Jason";
    public static final String OrderKey = "shihedingdan";
    public static final String ExpressKey = "shihequyang";
    public static final String Character = "UTF-8";
    public static final String savePath = "D:/Myimage";
    public static final String WebServiceUrl = "http://geneseeqshippingtracking.azurewebsites.net/api/GetExpressInfo";
/*    public static final String OrderUrl = "http://192.168.0.199:8090/rest/SampleOrderMainRestful/saveSampleOrderMain";
    public static final String OrderUrl = "http://192.168.17.253:8080/rest/SampleOrderMainRestful/saveSampleOrderMain";
    public static final String ExpressUrl = "http://192.168.0.199:8090/rest/SampleInfoMainRestfulService/createSampleInfoMain";
    public static final String ExpressUrl = "http://192.168.17.253:8080/rest/SampleInfoMainRestfulService/createSampleInfoMain";*/


    public static final String[] Orderfield = {"ts", "sig", "orderNumber", "projectId", "createUserId",
            "createUserName", "contacts", "name", "gender", "medicalInstitutionsId", "medicalInstitutionsName",
            "inspectionDepartmentId", "inspectionDepartmentName", "attendingDoctorId", "attendingDoctorName", "IdCard",
            "inspectionItemsId", "inspectionItemsName", "cancerTypeId", "cancerTypeName", "cancerTypeSeedOneId",
            "cancerTypeSeedOneName", "cancerTypeSeedTwoId", "cancerTypeSeedTwoName", "note", "isFee", "commissionerId",
            "commissionerName", "familyPhone", "isShowHospital", "image"};
    public static final String[] Expressfield = {"ts", "sig", "companyId", "companyName", "expressCode",
            "ToAddress", "createUserId", "createUserName", "transBoxId", "orderList"};
}
