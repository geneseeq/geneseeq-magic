package com.geneseeq.common.mysqldao.order;

import com.geneseeq.common.pojo.express.ExpressNoVO;
import com.geneseeq.common.pojo.order.OrderNumber;
import com.geneseeq.common.pojo.order.SampleOrderIdVO;
import com.geneseeq.common.pojo.order.SampleOrderTVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InternalOrderDao {
    public int insertsampleOrder(SampleOrderTVO orderTVO) throws Exception;

    public int updateSampleOrder(String order_no) throws Exception;

    public SampleOrderIdVO getOrderByNo(String order_no) throws Exception;

    public String getOrderByCaseAndNo(String order_no) throws Exception;

    public int searchOrderNoByNo(@Param("order_no") String order_no, @Param("status") String status) throws Exception;

    public int updateFailSampleOrder(String order_no) throws Exception;

    public List<ExpressNoVO> getExpressNosByOrderNo(String order_no) throws Exception;

    public List<OrderNumber> getOrderPhoneNumber(@Param("updateTimeStart") String updateTimeStart,@Param("updateTimeEnd") String updateTimeEnd);
}
