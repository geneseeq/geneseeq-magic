package com.geneseeq.common.dao.user;

import com.geneseeq.common.persistence.annotation.MyBatisDao;

import com.geneseeq.common.pojo.user.SalerPerformanceSearchingVO;
import com.geneseeq.common.pojo.user.SalerPerformanceVO;
import com.geneseeq.common.pojo.user.SalerUserVO;
import com.geneseeq.common.pojo.user.UserInfoResponseVO;
import com.geneseeq.common.pojo.user.UserOrderSearchingVO;
import com.geneseeq.common.pojo.user.UserOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface UserDao {
    List<UserInfoResponseVO> listUser() throws Exception;

    List<UserOrderVO> getUserOrderList(UserOrderSearchingVO userOrderSearchingVO);

    List<SalerPerformanceVO> getSalerPerformanceList(SalerPerformanceSearchingVO salerPerformanceSearchingVO);

    UserInfoResponseVO getUserById(String id) throws Exception;

    SalerUserVO getUserIdByName(String username) throws Exception;
}
