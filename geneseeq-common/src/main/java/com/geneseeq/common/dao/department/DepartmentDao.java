package com.geneseeq.common.dao.department;

import com.geneseeq.common.pojo.department.DepartmentResponseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentDao {
	List<DepartmentResponseVO> listInspection_Departments() throws Exception;

}
