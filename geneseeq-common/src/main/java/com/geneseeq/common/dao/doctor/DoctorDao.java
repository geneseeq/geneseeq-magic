package com.geneseeq.common.dao.doctor;

import com.geneseeq.common.pojo.doctor.DoctorResponseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorDao {
	List<DoctorResponseVO> listDoctor() throws Exception;

}
