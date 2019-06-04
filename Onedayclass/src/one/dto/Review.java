package one.dto;

public class Review {
	
	private int reviewNum;
	private String content;
	private int classNum;
	private int userNum;
	
	@Override
	public String toString() {
		return "Review [reviewNum=" + reviewNum + ", content=" + content + ", classNum=" + classNum + ", userNum="
				+ userNum + "]";
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
		
}
