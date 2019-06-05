package one.dto;

public class Comment {

	private int commentNum;
	private String content;
	private int classNum;
	private int userNum;
	
	
	@Override
	public String toString() {
		return "Comment [commentNum=" + commentNum + ", content=" + content + ", classNum=" + classNum + ", userNum="
				+ userNum + "]";
	}
	
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
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
