package one.dto;

import java.util.Date;

public class Review {
	
	private int rnum;
	private int reviewNum;
	private String content;
	private Date reviewDate;
	private int userNum;
	private int classNum;
	
	
	@Override
	public String toString() {
		return "Review [rnum=" + rnum + ", reviewNum=" + reviewNum + ", content=" + content + ", reviewDate="
				+ reviewDate + ", userNum=" + userNum + ", classNum=" + classNum + "]";
	}
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
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
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	
	
	
	
	
	
	
	
}
