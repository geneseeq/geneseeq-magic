package com.geneseeq.common.pojo.code;

public class ReturnCode {
	private String errcode;
	private String errmessage;

	public ReturnCode(String errcode, String errmessage) {
		super();
		this.errcode = errcode;
		this.errmessage = errmessage;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmessage() {
		return errmessage;
	}

	public void setErrmessage(String errmessage) {
		this.errmessage = errmessage;
	}

	@Override
	public String toString() {
		return "Return_Code [errcode=" + errcode + ", errmessage=" + errmessage + "]";
	}

}
