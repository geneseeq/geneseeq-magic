package com.geneseeq.common.dao.cancer;

import com.geneseeq.common.pojo.cancer.WeichatCancerResponseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CancerDao {
    List<WeichatCancerResponseVO> listWeichat_Cancer() throws Exception;
}
