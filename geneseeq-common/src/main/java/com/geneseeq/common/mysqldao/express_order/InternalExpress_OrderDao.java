package com.geneseeq.common.mysqldao.express_order;


import com.geneseeq.common.pojo.express_order.SampleOrderExpressVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InternalExpress_OrderDao {

    int insertExpress_Order(SampleOrderExpressVO orderExpressVO) throws Exception;
}
