package models;
/*
 * - TheLoai
	+ MaTheLoai
	+ TenTheLoai
	+ description
 * */
public class Category {
	private String categoryId;
	private String categoryName;
	private String description;
	private String thumbnailUrl;
	public Category(String categoryId, String categoryName, String description,String thumbnailUrl) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
		this.thumbnailUrl = thumbnailUrl;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description
				+ ", thumbnailUrl=" + thumbnailUrl + "]";
	}
	
	
}
