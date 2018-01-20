package com.geneseeq.common.pojo.express_order;

public class SampleOrderExpressVO {
	private int order_id;
	private int express_id;
	private String remarks;
	private String created_by;
	private String created_at;
	private String updated_by;
	private String updated_at;
	
	
	public SampleOrderExpressVO(int order_id, int express_id, String remarks, String created_by, String created_at,
			String updated_by, String updated_at) {
		super();
		this.order_id = order_id;
		this.express_id = express_id;
		this.remarks = remarks;
		this.created_by = created_by;
		this.created_at = created_at;
		this.updated_by = updated_by;
		this.updated_at = updated_at;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getExpress_id() {
		return express_id;
	}
	public void setExpress_id(int express_id) {
		this.express_id = express_id;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	
	
	

}
