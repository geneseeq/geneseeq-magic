package com.geneseeq.common.dao.product;


import com.geneseeq.common.pojo.product.ProductResponseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ProductDao {
	List<ProductResponseVO> listSYS_Product() throws Exception;
}
