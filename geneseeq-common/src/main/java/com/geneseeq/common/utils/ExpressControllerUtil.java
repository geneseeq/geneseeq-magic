package com.geneseeq.common.utils;

import com.geneseeq.common.pojo.code.ReturnCode;
import com.geneseeq.common.pojo.express.ExpressInfoVO;
import com.geneseeq.common.pojo.express_order.SampleOrderExpressVO;
import com.geneseeq.common.pojo.order.OrderSearchingVO;
import com.geneseeq.common.pojo.order.SampleOrderIdVO;
import com.geneseeq.common.pojo.packdata.PackDataResponseVO;
import com.geneseeq.common.pojo.packdata.SampleInfoResponseVO;
import com.geneseeq.common.pojo.packsystem.SamplePackSystemResponseVO;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressControllerUtil {
    public boolean flag = false;
    public static JSONObject resultjson = null;
    private Logger log = Logger.getLogger(ExpressControllerUtil.class);

    public Map<String, String> getExpressMap(Map<String, String> expressMap) {
        String ts = String.valueOf(DateUtils.currentTimeStamp());
        String sig = MD5Test.GetMD5Code(ts + Content.ExpressKey);
        expressMap.put("ts", ts);
        expressMap.put("sig", sig);
        UUID uuid = UUID.randomUUID();
        if (expressMap.get("companyName").equals(Content.sendbyself)) {
            expressMap.put("expressCode", uuid.toString());
        }
        for (Map.Entry<String, String> entry : expressMap.entrySet()) {
            if (entry.getValue() == null) {
                expressMap.put(entry.getKey(), "");
            }
            log.info("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        return expressMap;
    }

    public ReturnCode getCode(Map<String, String> expressMap) {

        if (expressMap.get("transBoxId") == null) {
            return new ReturnCode("1", "请选择运输方式");
        }
        if (expressMap.get("ToAddress") == null) {
            return new ReturnCode("1", "请填写寄送地址");
        }
        if (expressMap.get("companyName").equals(Content.sendbyself)) {
            return new ReturnCode("0", "Success!");
        }
        if (!expressMap.get("ToAddress").equals(Content.address)) {
            return new ReturnCode("0", "Success!");
        }
        return null;
    }

    public ReturnCode getReCode(Map<String, String> expressMap) {
        if (expressMap.get("companyName").equals(Content.sendbyself)) {
            return new ReturnCode("0", "Success!");
        }
        if (!expressMap.get("ToAddress").equals(Content.address)) {
            return new ReturnCode("0", "Success!");
        }
        return null;
    }

    public void getPicture(String token, String expressCode, String imageid) {
        PicDownload.downloadMedia(token, imageid, Content.savePath, expressCode);
        System.out.println(token + "------" + imageid);
    }


    public ReturnCode getResultCode(int result) {
        ReturnCode code = null;
        if (result == 1) {
            log.info("该快递号已经存在");
            code = new ReturnCode("4", "该快递已存在");
        }
        if (result == 2) {
            log.info("查询快递号出错");
            code = new ReturnCode("2", "查询订单号出错！");
        }
        return code;
    }

    public List<String> getAllOrderList(String orderList) {
        List<String> orderLists = new ArrayList<String>();
        if (orderList.contains(";")) {
            String[] orderInfo = orderList.split(";");
            for (String s : orderInfo) {
                System.out.println(s);
                orderLists.add(s);
            }
        } else {
            orderLists.add(orderList);
        }
        return orderLists;
    }

    public List<OrderSearchingVO> getAllOrderListVO(List<String> allOrdeerList) {
        List<OrderSearchingVO> list = new ArrayList<OrderSearchingVO>();
        for (String order : allOrdeerList) {
            OrderSearchingVO orderVO = new OrderSearchingVO(order);
            list.add(orderVO);
        }
        return list;
    }

    public PackDataResponseVO getPackDataResponse(Map<String, String> map, List<OrderSearchingVO> orderList) {
        PackDataResponseVO data = new PackDataResponseVO(map.get("companyId"), map.get("companyName"),
                map.get("expressCode"), map.get("typeOfShipping"), map.get("createUserId"), map.get("createUserName"),
                map.get("transBoxId"), orderList);
        return data;
    }

    public ReturnCode getReturnCode(SampleInfoResponseVO sampleInfo, String expressUrl) {
        String result = "";
        ReturnCode code = null;

        try {
            result = HttpPostUrl.post(BeanToJson.getJsonData(sampleInfo), expressUrl);
            log.info(result);
            resultjson = JSONObject.fromObject(result);
            if (resultjson.get("error").equals("0")) {
                code = new ReturnCode("0", "Packaged successfully");
                flag = true;
            } else {
                code = new ReturnCode("1", "Packaged failed");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            code = new ReturnCode("1", "Packaged failed");
        }
        return code;
    }

    public SampleOrderExpressVO getSampleOrderExpress(SampleOrderIdVO orderTVO, ExpressInfoVO expressInfo1, Map<String, String> map) {
        String currentTime = DateUtils.currentFormatDate(DateUtils.DATE_TO_STRING_DETAIAL_PATTERN);
        SampleOrderExpressVO orderExpressVO = new SampleOrderExpressVO(orderTVO.getOrder_id(),
                expressInfo1.getExpress_id(), Content.successpackage, map.get("createUserName"),
                currentTime, map.get("createUserName"), currentTime);
        return orderExpressVO;
    }

    public List<String> getLastList(String datas, List<String> exitlist, List<String> alllist, List<String> pakagelist) {
        if (!datas.equals("")) {
            System.out.println("有不存在的订单");
            String orderdatas[] = datas.split(",");
            System.out.println(orderdatas.length);
            for (String s : orderdatas) {
                System.out.println(s);
                exitlist.add(s);
            }
            for (int i = 0; i < alllist.size(); i++) {
                if (exitlist.contains(alllist.get(i))) {
                    alllist.remove(i);
                    i--;
                }
            }
        }
        for (int i = 0; i < alllist.size(); i++) {
            if (pakagelist.contains(alllist.get(i))) {
                alllist.remove(i);
                i--;
            }
        }
        for (String s : alllist) {
            System.out.println(s);
        }
        return alllist;

    }

    public ExpressInfoVO getExpressInfo(Map<String, String> mapExpress, SamplePackSystemResponseVO samplepack) {
        String currentTime = DateUtils.currentFormatDate(DateUtils.DATE_TO_STRING_DETAIAL_PATTERN);
        ExpressInfoVO expressInfo = new ExpressInfoVO();
        expressInfo.setExpress_no(mapExpress.get("expressCode"));
        expressInfo.setCreated_at(currentTime);
        expressInfo.setCreated_by_id(mapExpress.get("createUserId"));
        expressInfo.setCreated_by_name(mapExpress.get("createUserName"));
        expressInfo.setExpress_company(mapExpress.get("companyName"));
        expressInfo.setExpress_company_id(mapExpress.get("companyId"));
        expressInfo.setMode_of_transport(samplepack.getName());// get name by id
        expressInfo.setMode_of_transport_id(mapExpress.get("transBoxId"));
        expressInfo.setBox_size(samplepack.getBox_size());
        expressInfo.setProcess_case(Content.nodeal);
        expressInfo.setProcess_status(Content.nodealstatus);
        expressInfo.setSend_to_address(mapExpress.get("ToAddress"));
        expressInfo.setUpdated_at(currentTime);
        expressInfo.setUpdated_by(mapExpress.get("createUserName"));
        return expressInfo;
    }

    public boolean isTrueExpressNo(String str) {
        String regex = "^[a-z0-9A-Z_-]+$";
        return str.matches(regex);
    }


}
