package com.geneseeq.common.pojo.packdata;

public class SampleInfoResponseVO {
	private String ts;
	private String sig;
	private PackDataResponseVO data;

	public SampleInfoResponseVO(String ts, String sig, PackDataResponseVO data) {
		this.ts = ts;
		this.sig = sig;
		this.data = data;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getSig() {
		return sig;
	}

	public void setSig(String sig) {
		this.sig = sig;
	}

	public PackDataResponseVO getData() {
		return data;
	}

	public void setData(PackDataResponseVO data) {
		this.data = data;
	}

}
