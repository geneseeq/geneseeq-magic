package com.geneseeq.common.pojo.packdata;

import java.util.List;

import com.geneseeq.common.pojo.order.OrderSearchingVO;

public class PackDataResponseVO {
	private String companyId;
	private String companyName;
	private String expressCode;
	private String typeOfShipping;
	private String createUserId;
	private String createUserName;
	private String transBoxId;
	private List<OrderSearchingVO> orderList;

	public PackDataResponseVO(String companyId, String companyName, String expressCode, String typeOfShipping,
			String createUserId, String createUserName, String transBoxId, List<OrderSearchingVO> orderList) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.expressCode = expressCode;
		this.typeOfShipping = typeOfShipping;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.transBoxId = transBoxId;
		this.orderList = orderList;
	}

	public String getTransBoxId() {
		return transBoxId;
	}

	public void setTransBoxId(String transBoxId) {
		this.transBoxId = transBoxId;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public String getTypeOfShipping() {
		return typeOfShipping;
	}

	public void setTypeOfShipping(String typeOfShipping) {
		this.typeOfShipping = typeOfShipping;
	}

	public List<OrderSearchingVO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderSearchingVO> orderList) {
		this.orderList = orderList;
	}

}
