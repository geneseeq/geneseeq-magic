package com.geneseeq.controller.order;

import com.geneseeq.common.pojo.order.SampleOrderResponseVO;
import com.geneseeq.model.BaseOrder;
import com.geneseeq.service.mongodb.BaseOrderDao;
import com.geneseeq.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private BaseOrderDao baseOrderDao;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public SampleOrderResponseVO getOrder(HttpServletRequest request, HttpServletResponse response){
        String OrderID = request.getParameter("orderNumber");
        try {
            SampleOrderResponseVO order = orderService.getOrderInfo(OrderID);
            BaseOrder baseOrder = new BaseOrder();
            baseOrder.setId(order.getName());
            baseOrder.setPassWord(order.getOrderNumber());
            baseOrder.setUserName(order.getProduct_name());
            baseOrderDao.saveBaseOrder(baseOrder);
            //log.info("success look up the order's info:" + order.toString());
            return order;
        } catch (Exception e) {
            //log.error("failed to look up the orderInfo");
            return null;
        }
    }
}
