package one.dto;

import java.sql.Date;

public class Payment {

	private int paymentNum;
	private Date paymentDate;
	private String price;
	private String paymentType;
	private int reservNum;
	
	@Override
	public String toString() {
		return "Payment [paymentNum=" + paymentNum + ", paymentDate=" + paymentDate + ", price=" + price
				+ ", paymentType=" + paymentType + ", reservNum=" + reservNum + "]";
	}
	
	public int getPaymentNum() {
		return paymentNum;
	}
	public void setPaymentNum(int paymentNum) {
		this.paymentNum = paymentNum;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public int getReservNum() {
		return reservNum;
	}
	public void setReservNum(int reservNum) {
		this.reservNum = reservNum;
	}
	
	
	
}
