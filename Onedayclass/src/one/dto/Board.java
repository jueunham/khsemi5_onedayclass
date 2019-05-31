package one.dto;

import java.sql.Date;

public class Board {

	private int boardno;
	private Date writeDate;
	private String title;
	private String content;
	private int userNum;
	private int boardtypeNum;
	
	@Override
	public String toString() {
		return "Board [boardno=" + boardno + ", writeDate=" + writeDate + ", title=" + title + ", content=" + content
				+ ", userNum=" + userNum + ", boardtypeNum=" + boardtypeNum + "]";
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getBoardtypeNum() {
		return boardtypeNum;
	}

	public void setBoardtypeNum(int boardtypeNum) {
		this.boardtypeNum = boardtypeNum;
	}
	
	
}











