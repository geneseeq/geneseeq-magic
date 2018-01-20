package com.geneseeq.common.dao.order;

import com.geneseeq.common.pojo.order.SampleOrderInfoVO;
import com.geneseeq.common.pojo.order.SampleOrderResponseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

    SampleOrderResponseVO getOrderInfo(String OrderID) throws Exception;

    SampleOrderInfoVO getSampleOrder(String OrderID) throws Exception;
}
