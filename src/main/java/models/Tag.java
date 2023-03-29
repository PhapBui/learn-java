package models;

public class Tag {
	private String tagId;
	private String tagName;
	private String tagThumbnailUrl;
	private String tagDescription;
	public Tag(String tagId, String tagName, String tagThumbnailUrl, String tagDescription) {
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagThumbnailUrl = tagThumbnailUrl;
		this.tagDescription = tagDescription;
	}
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTagThumbnailUrl() {
		return tagThumbnailUrl;
	}
	public void setTagThumbnailUrl(String tagThumbnailUrl) {
		this.tagThumbnailUrl = tagThumbnailUrl;
	}
	public String getTagDescription() {
		return tagDescription;
	}
	public void setTagDescription(String tagDescription) {
		this.tagDescription = tagDescription;
	}
	
	
}
