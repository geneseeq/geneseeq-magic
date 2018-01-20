package com.geneseeq.service.order;

import com.geneseeq.common.pojo.order.SampleOrderResponseVO;

/**
 * @author yanshou.gao
 * @date 2018/01/03
 */

public interface OrderService {

    SampleOrderResponseVO getOrderInfo(String orderId) throws Exception;

}
