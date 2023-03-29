package models;
/*
 * - KhachHang:
	+ MaKhachHang
	+ TenDangNhap
	+ MatKhau
	+ HoVaTen
	+ GioiTinh
	+ DiaChi
	+ DiaChiNhanHang
	+ NgaySinh
	+ SoDienThoai
	+ Email
	+ DangKyNhanBanTinEmail
 * */

import java.sql.Date;

public class Customer {
	private String customerId;
	private String username;
	private String password;
	private String fullName;
	private String gender;
	private String address;
	private String orderAddress;
	private String shippingAddress;
	private Date birthDay;
	private String phonenumber;
	private String email;
	private String thumbnailUrl;
	private boolean subcribe;
	public Customer(String customerId, String username, String password, String fullName, String gender, String address,String orderAddress,
			String shippingAddress, Date birthDay, String phonenumber, String email,String thumbnailUrl, boolean subcribe) {
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.orderAddress = orderAddress;
		this.shippingAddress = shippingAddress;
		this.birthDay = birthDay;
		this.phonenumber = phonenumber;
		this.email = email;
		this.thumbnailUrl = thumbnailUrl;
		this.subcribe = subcribe;
	}
	
	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isSubcribe() {
		return subcribe;
	}
	public void setSubcribe(boolean subcribe) {
		this.subcribe = subcribe;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", username=" + username + ", password=" + password
				+ ", fullName=" + fullName + ", gender=" + gender + ", address=" + address + ", orderAddress="
				+ orderAddress + ", shippingAddress=" + shippingAddress + ", birthDay=" + birthDay + ", phonenumber="
				+ phonenumber + ", email=" + email + ", thumbnailUrl=" + thumbnailUrl + ", subcribe=" + subcribe + "]";
	}
	
	
}
