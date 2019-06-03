package one.dto;

public class Comm {
	
	private int commNum;
	private String content;
	private int classNum;
	private int userNum;
	
	@Override
	public String toString() {
		return "Comm [commNum=" + commNum + ", content=" + content + ", classNum=" + classNum + ", userNum=" + userNum
				+ "]";
	}
	public int getCommNum() {
		return commNum;
	}
	public void setCommNum(int commNum) {
		this.commNum = commNum;
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
