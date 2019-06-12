package one.dto;

import java.sql.Date;

public class Bulletin_Comment {

	private int commentno;
	private String content;
	private String commentdate;
	private String userid;
	private int boardno;
	@Override
	public String toString() {
		return "Bulletin_Comment [commentno=" + commentno + ", content=" + content + ", commentdate=" + commentdate
				+ ", userid=" + userid + ", boardno=" + boardno + "]";
	}
	public int getCommentno() {
		return commentno;
	}
	public void setCommentno(int commentno) {
		this.commentno = commentno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(String commentdate) {
		this.commentdate = commentdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	
	
	
}
