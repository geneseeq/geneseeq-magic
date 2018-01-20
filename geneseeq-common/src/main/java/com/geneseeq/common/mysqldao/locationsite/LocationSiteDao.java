package com.geneseeq.common.mysqldao.locationsite;

import com.geneseeq.common.pojo.orderexpresssite.LocationSite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LocationSiteDao {
    Integer insertLocationSite(@Param("locationSite") LocationSite locationSite);
}
