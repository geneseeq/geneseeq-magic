package com.geneseeq.common.utils;

import com.geneseeq.common.pojo.code.ReturnCode;
import com.geneseeq.common.pojo.order.SampleOrderTVO;
import com.geneseeq.common.pojo.user.SalerUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderControllerUtil {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public boolean flagSuccess = false;
    public boolean flagExits = false;

    public String getPicture(String token, String orderNumber, String imageid) {
        List<String> imgList = new ArrayList<String>();
        String[] imageIds = imageid.split(",");
        for (String imgId : imageIds) {
            String filepath = PicDownload.downloadMedia(token, imgId, Content.savePath, orderNumber);
            if (filepath == null) {
                filepath = "";
            }
            imgList.add(filepath);
            log.info(token + "------" + imageid);
        }
        return imgList.get(0);
    }

    public ReturnCode isTrueOrderNumber(String orderNumber) {
        ReturnCode code = null;
        if (orderNumber == null || orderNumber.equals("")) {
            code = new ReturnCode("1", "the orderNumber can't be empty");
        }
        return code;
    }

    //查询order情况
    public ReturnCode checkOrderByOrderNo(int result) {
        ReturnCode code = null;
        if (result == 1) {
            log.info("the order is already exist both in mysql and lims");
            code = new ReturnCode("4", "the order is already exist");
        }
        if (result == 2) {
            log.info("mysql has error:faile to look up the order info");
            code = new ReturnCode("2", "faile to look up the order info！");
        }
        return code;
    }


    //请求lims的map
    public Map<String, String> getNewMapForPost(Map<String, String> map, String userId, String imgId) {
        String ts = String.valueOf(DateUtils.currentTimeStamp());
        String sig = MD5Test.GetMD5Code(ts + Content.OrderKey);
        map.put("ts", ts);
        map.put("sig", sig);
        map.put("image", imgId);
        //处理值
        if (userId != null) {
            log.info("userId::::" + userId.toLowerCase());
            map.put("createUserId", userId.toLowerCase());
        } else {
            map.put("createUserId", "");
        }
        if (map.get("isFee") == null || map.get("isFee").equals("false")) {
            map.put("isFee", Content.unpaid);
        } else {
            map.put("isFee", Content.free);
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                map.put(entry.getKey(), "");
            }
            log.info("key= " + entry.getKey() + " and value= " + entry.getValue());
    }
        return map;
    }

    public ReturnCode sendToLimsByDateAndUrl(Map<String, String> postMap, String orderUrl) {
        ReturnCode code = null;
        String result = null;
        try {
            Long StartTime = DateUtils.currentTimeStamp();
            log.info("begin send to lims :" + StartTime);
            result = HttpPostUrl.SubmitPost(postMap, orderUrl);
            Long endTime = DateUtils.currentTimeStamp();
            log.info("lims Request end" + endTime);
            log.info("The request was spent in total" + (endTime - StartTime) + "S");
        } catch (Exception e) {
            log.error("failed send to lims", e);
            code = new ReturnCode("1", "failed send to lims");
        }
        if (result.equals("Success")) {
            log.info("send to lims success！");
            flagSuccess = true;
            code = new ReturnCode("0", "Success!");
        } else if (result.equals("orderExist")) {
            log.info("the order has already exist in lims");
            flagExits = true;
            code = new ReturnCode("4", "the order has already exist");
        } else {
            log.info("failed send to lims！");
            code = new ReturnCode("1", result);
        }
        return code;
    }


    //插入本地的数据
    public SampleOrderTVO returnOrder(Map<String, String> map) {
        String currentTime = DateUtils.currentFormatDate(DateUtils.DATE_TO_STRING_DETAIAL_PATTERN);
        SampleOrderTVO orderTVO = new SampleOrderTVO();
        orderTVO.setAttending_doctor(map.get("attendingDoctorName"));
        orderTVO.setAttending_doctor_id(map.get("attendingDoctorId"));
        orderTVO.setCancer_type_id(map.get("cancerTypeId"));
        orderTVO.setCancer_type_name(map.get("cancerTypeName"));
        orderTVO.setCancer_type_seed_one_id(map.get("cancerTypeSeedOneId"));
        orderTVO.setCancer_type_seed_one_name(map.get("cancerTypeSeedOneName"));
        orderTVO.setCancer_type_seed_two_id(map.get("cancerTypeSeedTwoId"));
        orderTVO.setCancer_type_seed_two_name(map.get("cancerTypeSeedTwoName"));
        orderTVO.setCommissioner(map.get("commissionerName"));
        orderTVO.setCommissioner_id(map.get("commissionerId"));
        orderTVO.setCreated_at(currentTime);
        orderTVO.setCreated_by_id(map.get("createUserId"));
        orderTVO.setCreated_by_name(map.get("createUserName"));
        orderTVO.setGender(map.get("gender"));
        orderTVO.setIdcard(map.get("IdCard"));
        orderTVO.setInspection_department(map.get("inspectionDepartmentName"));
        orderTVO.setInspection_department_id(map.get("inspectionDepartmentId"));
        orderTVO.setIs_fee(map.get("isFee"));
        orderTVO.setMedical_institutions(map.get("medicalInstitutionsName"));
        orderTVO.setMedical_institutions_id(map.get("medicalInstitutionsId"));
        orderTVO.setOrder_no(map.get("orderNumber"));
        orderTVO.setPatient_name(map.get("name"));
        orderTVO.setProcess_case(Content.nodeal);
        orderTVO.setProcess_status("");
        orderTVO.setProduct_id(map.get("inspectionItemsId"));
        orderTVO.setProduct_name(map.get("inspectionItemsName"));
        orderTVO.setProject_id(map.get("projectId"));
        orderTVO.setReport_show_flag(map.get("isShowHospital"));
        orderTVO.setRemarks(map.get("note"));
        orderTVO.setTel_no(map.get("familyPhone"));
        orderTVO.setUpdated_at(currentTime);
        orderTVO.setUpdated_by(map.get("createUserName"));
        return orderTVO;
    }

    public String getPhoneNo(String phoneNos) {
        log.info(phoneNos);
        String regex = "1\\d{10}";
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phoneNos);
        while (m.find()) { //一定需要先查找再调用group获取电话号码
            sb.append(m.group());
            sb.append(",");
        }
        if (sb.toString().length() < 2) {
            return null;
        } else {
            String phoneNo = sb.substring(0, sb.length() - 1);
            log.info(phoneNo);
            return phoneNo;
        }

    }


    public static void main(String[] args) {
        OrderControllerUtil orderControllerUtil = new OrderControllerUtil();
        System.out.println(orderControllerUtil.getPhoneNo("212345 678910"));
    }
}
