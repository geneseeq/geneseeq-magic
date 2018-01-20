package com.geneseeq.common.pojo.order;

public class SampleOrderResponseVO {

	private String orderNumber;
	private String name;
	private String state_name;
	private String product_name;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	@Override
	public String toString() {
		return "SampleOrderResponseVO [orderNumber=" + orderNumber + ", name=" + name + ", state_name=" + state_name
				+ ", product_name=" + product_name + "]";
	}

}
