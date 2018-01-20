package com.geneseeq.common.pojo.sample;

/**
 * 用于销售订单页面样本信息
 */
public class OrderSampleVO {

    private String SampleCode;

    private String SampleType;

    /**
     * 已进入实验流程、未进入实验流程
     */
    private String SampleIsInLabo;

    public String getSampleCode() {
        return SampleCode;
    }

    public void setSampleCode(String sampleCode) {
        SampleCode = sampleCode;
    }

    public String getSampleType() {
        return SampleType;
    }

    public void setSampleType(String sampleType) {
        SampleType = sampleType;
    }

    public String getSampleIsInLabo() {
        return SampleIsInLabo;
    }

    public void setSampleIsInLabo(String sampleIsInLabo) {
        SampleIsInLabo = sampleIsInLabo;
    }
}
