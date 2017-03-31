package biomart.beanClass;

import java.util.Date;

public class OrderDetails {
	
	private String o_id;
	private Date o_date;
	private Date delivary_date;
	private String retailer_id;
	private int quantity;
	private int t_amount;
	private String status;
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	public Date getO_date() {
		return o_date;
	}
	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}
	public Date getDelivary_date() {
		return delivary_date;
	}
	public void setDelivary_date(Date delivary_date) {
		this.delivary_date = delivary_date;
	}
	public String getRetailer_id() {
		return retailer_id;
	}
	public void setRetailer_id(String retailer_id) {
		this.retailer_id = retailer_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getT_amount() {
		return t_amount;
	}
	public void setT_amount(int t_amount) {
		this.t_amount = t_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
