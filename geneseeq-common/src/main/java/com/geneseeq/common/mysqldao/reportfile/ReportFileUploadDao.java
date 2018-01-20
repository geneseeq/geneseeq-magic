package com.geneseeq.common.mysqldao.reportfile;

import com.geneseeq.common.domain.reportfile.ReportFileUpload;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiaojun.cheng
 */
@Mapper
public interface ReportFileUploadDao {

    List<ReportFileUpload> getReportFileUploadByProcessStatus(@Param("processStatus") String processStatus);
}
