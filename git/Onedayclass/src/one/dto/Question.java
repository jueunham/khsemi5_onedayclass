package one.dto;

import java.util.Date;

public class Question {
	private int quesNum;
	private String content;
	private Date quesDate;
	private int classNum;
	private int userNum;
	
	
	
	@Override
	public String toString() {
		return "Question [quesNum=" + quesNum + ", content=" + content + ", quesDate=" + quesDate + ", classNum="
				+ classNum + ", userNum=" + userNum + "]";
	}
	
	public int getQuesNum() {
		return quesNum;
	}
	public void setQuesNum(int quesNum) {
		this.quesNum = quesNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getQuesDate() {
		return quesDate;
	}
	public void setQuesDate(Date quesDate) {
		this.quesDate = quesDate;
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
