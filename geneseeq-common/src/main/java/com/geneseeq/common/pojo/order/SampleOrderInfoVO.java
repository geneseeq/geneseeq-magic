package com.geneseeq.common.pojo.order;

import com.geneseeq.common.pojo.express.ExpressData;

import java.util.List;


public class SampleOrderInfoVO {
	private String name;
	private String product_name;
	private String create_user;
	private String commissioner;
	private String first_received_date;
	private List<ExpressData> expressdata;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ExpressData> getExpressdata() {
		return expressdata;
	}

	public void setExpressdata(List<ExpressData> expressdata) {
		this.expressdata = expressdata;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public String getCommissioner() {
		return commissioner;
	}

	public void setCommissioner(String commissioner) {
		this.commissioner = commissioner;
	}

	public String getFirst_received_date() {
		return first_received_date;
	}

	public void setFirst_received_date(String first_received_date) {
		this.first_received_date = first_received_date;
	}

}
