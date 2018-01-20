package com.geneseeq.common.dao.express;

import com.geneseeq.common.pojo.express.ExpressCompanyResponseVO;
import com.geneseeq.common.pojo.express.GoodsSampleWayResponseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExpressDao {

	List<ExpressCompanyResponseVO> listSys_Express_Company() throws Exception;

	int insertGoods_sample_way(GoodsSampleWayResponseVO goods) throws Exception;

}
