package one.dto;

public class Comment {
	
	private int rnum;
	private int commNum;
	private String content;
	private int classNum;
	private int userNum;
	
	
	
	@Override
	public String toString() {
		return "Comment [rnum=" + rnum + ", commNum=" + commNum + ", content=" + content + ", classNum=" + classNum
				+ ", userNum=" + userNum + "]";
	}
	
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
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
