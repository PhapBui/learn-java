package models;
/*
 *- DonHang:
	+ MaDonHang
	+ KhachHang
	+ DiaChiHoaDon
	+ DiaChiNhanHang
	+ TrangThai
	+ HinhThucThanhToan
	+ TrangThaiThanhToan
	+ TienCoc
	+ SoTienConThieu
	+ NgayDatHang
	+ NgayGiaoHang
 * */

import java.sql.Date;

public class Order {
	private String orderId;
	private Customer customer;
	private String address;
	private String shippingAddress;
	private String status;
	private String paymentMethod;
	private String paymentStatus;
	private double depositsAmount;
	private double restOfMoney;
	private Date orderDate;
	private Date orderShipping;
	
	public Order(String orderId, Customer customer, String address, String shippingAddress, String status,
			String paymentMethod, String paymentStatus, double depositsAmount, double restOfMoney, Date orderDate,
			Date orderShipping) {
		this.orderId = orderId;
		this.customer = customer;
		this.address = address;
		this.shippingAddress = shippingAddress;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.depositsAmount = depositsAmount;
		this.restOfMoney = restOfMoney;
		this.orderDate = orderDate;
		this.orderShipping = orderShipping;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getDepositsAmount() {
		return depositsAmount;
	}

	public void setDepositsAmount(double depositsAmount) {
		this.depositsAmount = depositsAmount;
	}

	public double getRestOfMoney() {
		return restOfMoney;
	}

	public void setRestOfMoney(double restOfMoney) {
		this.restOfMoney = restOfMoney;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getOrderShipping() {
		return orderShipping;
	}

	public void setOrderShipping(Date orderShipping) {
		this.orderShipping = orderShipping;
	}
	
	
	
}
