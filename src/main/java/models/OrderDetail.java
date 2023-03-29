package models;
/*
 * - ChiTietDonHang:
	+ MaChiTietDonHang
	+ DonHang
	+ MaSach
	+ SoLuong
	+ GiaBia
	+ GiaBan
	+ ThueVAT
	+ ThanhTien
 * */
public class OrderDetail {
	private String orderDetailId;
	private Order order;
	private Product product;
	
	private double quantity;
	
	private double originalPrice;
	private double price;
	private double currentPrice;
	
	private double VAT;
	private double total;
	
	
	public OrderDetail(String orderDetailId, Order order, Product product, double quantity, double originalPrice, double price,
			double currentPrice, double vAT, double total) {
		super();
		this.orderDetailId = orderDetailId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.originalPrice = originalPrice;
		this.price = price;
		this.currentPrice = currentPrice;
		VAT = vAT;
		this.total = total;
	}
	
	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public double getVAT() {
		return VAT;
	}
	public void setVAT(double vAT) {
		VAT = vAT;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
