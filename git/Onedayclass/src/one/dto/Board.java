package one.dto;

import java.sql.Date;

public class Board {

	private int boardno;
	private Date writedate;
	private String title;
	private String content;
	private int usernum;
	private int hit;
	private int boardtypenum;
	@Override
	public String toString() {
		return "Board [boardno=" + boardno + ", writedate=" + writedate + ", title=" + title + ", content=" + content
				+ ", usernum=" + usernum + ", hit=" + hit + ", boardtypenum=" + boardtypenum + "]";
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
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
	public int getUsernum() {
		return usernum;
	}
	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getBoardtypenum() {
		return boardtypenum;
	}
	public void setBoardtypenum(int boardtypenum) {
		this.boardtypenum = boardtypenum;
	}
	

}









