package com.geneseeq.common.mysqldao.express;

import com.geneseeq.common.domain.express.Express;
import com.geneseeq.common.pojo.express.ExpressData;
import com.geneseeq.common.pojo.express.ExpressInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface InternalExpressDao {
    List<Express> getExpressInfoList();

    int insertExpressInfo(ExpressInfoVO expressInfo) throws Exception;

    int serExpressNo(String expressNo) throws Exception;

    int updateExpress(@Param("updatetime") String updatetime, @Param("express_no") String express_no) throws Exception;

    ExpressInfoVO getExpressInfoVOByNo(String express_no) throws Exception;

    int updataExdata_sync_status(@Param("expressno")String expressno,@Param("status") String status,@Param("uptime") String uptime) throws Exception;

    List<ExpressData> getExpressDataByExpressNo(String ExpressNo) throws Exception;
}
