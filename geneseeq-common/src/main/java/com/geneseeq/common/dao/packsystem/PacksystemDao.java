package com.geneseeq.common.dao.packsystem;

import com.geneseeq.common.pojo.packsystem.SamplePackSystemResponseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PacksystemDao {
	List<SamplePackSystemResponseVO> listSYS_SAMPLE_PACK_SYSTEM() throws Exception;

	SamplePackSystemResponseVO getSamplePackById(String id) throws Exception;

}
