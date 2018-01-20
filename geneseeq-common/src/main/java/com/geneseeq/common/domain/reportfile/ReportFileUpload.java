package com.geneseeq.common.domain.reportfile;

public class ReportFileUpload extends ReportFile{

    private Integer batchNo;

    private Integer batchId;

    private String processStatus;

    private String processCase;

    public Integer getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Integer batchNo) {
        this.batchNo = batchNo;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getProcessCase() {
        return processCase;
    }

    public void setProcessCase(String processCase) {
        this.processCase = processCase;
    }
}
