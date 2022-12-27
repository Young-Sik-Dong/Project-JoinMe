package himedia.joinme.domain;

public class Community {
	private String postNo;
	private String postTitle;
	private String postWriter;
	private String postDate;
	private Long index;
	private String category;
	private String text;
	private String joinLink;
	
	public String getPostNo() {
		return postNo;
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostWriter() {
		return postWriter;
	}
	public void setPostWriter(String postWriter) {
		this.postWriter = postWriter;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public Long getIndex() {
		return index;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getJoinLink() {
		return joinLink;
	}
	public void setJoinLink(String joinLink) {
		this.joinLink = joinLink;
	}
}
