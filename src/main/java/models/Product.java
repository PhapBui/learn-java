package models;
/*
 * - Sach:
	+ MaSach
	+ TenSach
	+ TenTacGia
	+ NamXuatBan
	+ GiaBan
	+ SoLuong
	+ TheLoai
	+ NgonNgu
	+ MoTa
	+ Avatar
 * */
public class Product {
	private String productId;
	private String productName;
	private Author author;
	private int yearRelease;
	private double originalPrice;
	private double price;
	private double currentPrice;
	private double quantity;
	private Category category;
	private String description;
	private String thumbnailUrl;
	private Tag tag;
	

	
	
	public Product(String productId, String productName, Author author, int yearRelease, double originalPrice,
			double price, double currentPrice, double quantity, Category category, String description, String thumbnailUrl,
			Tag tag) {
		this.productId = productId;
		this.productName = productName;
		this.author = author;
		this.yearRelease = yearRelease;
		this.originalPrice = originalPrice;
		this.price = price;
		this.currentPrice = currentPrice;
		this.quantity = quantity;
		this.category = category;
		this.description = description;
		this.thumbnailUrl = thumbnailUrl;
		this.tag = tag;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getYearRelease() {
		return yearRelease;
	}
	public void setYearRelease(int yearRelease) {
		this.yearRelease = yearRelease;
	}
	public double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
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
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", author=" + author
				+ ", yearRelease=" + yearRelease + ", originalPrice=" + originalPrice + ", price=" + price
				+ ", currentPrice=" + currentPrice + ", quantity=" + quantity + ", category=" + category
				+ ", description=" + description + ", thumbnailUrl=" + thumbnailUrl + ", tag=" + tag + "]";
	}
	
	
	
}
