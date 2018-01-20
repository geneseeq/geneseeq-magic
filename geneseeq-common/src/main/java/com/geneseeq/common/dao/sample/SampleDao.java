package com.geneseeq.common.dao.sample;

import com.geneseeq.common.domain.sample.SampleInfo;
import com.geneseeq.common.pojo.sample.OrderSampleVO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author  xiaojun.cheng
 * @date 171121
 */
@Mapper
public interface SampleDao {

    /**
     *
     * @param orderId
     * @return
     * @throws Exception
     */
    List<SampleInfo> getSampleInfoListByOrderId(@Param("orderId") String orderId) throws Exception;

    /**
     *
     * @param code
     * @return
     * @throws Exception
     */
    Long getInLaboStateCountBySampleCode(@Param("code") String code) throws Exception;


    List<OrderSampleVO> getSampleVOListByOrderId(@Param("orderId") String orderId) throws Exception;

}
