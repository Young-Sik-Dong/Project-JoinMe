package himedia.joinme.domain;

public enum PostType {
	CONTEST("공모전"), JOIN("모집"), COMMUNITY("커뮤니티");
	
	private final String classification;
	
	private PostType(String classification) {
		this.classification = classification;
	}
	
	public String getClassification() {
		return classification;
	}
}
