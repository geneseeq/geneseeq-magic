package com.geneseeq.service.order.impl;

import com.geneseeq.common.dao.order.OrderDao;
import com.geneseeq.common.pojo.order.SampleOrderResponseVO;
import com.geneseeq.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OrderService")
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    public SampleOrderResponseVO getOrderInfo(String orderId) throws Exception{
        return orderDao.getOrderInfo(orderId);
    }
}
