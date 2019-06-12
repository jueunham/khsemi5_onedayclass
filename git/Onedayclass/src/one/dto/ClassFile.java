package one.dto;

import java.util.Date;

public class ClassFile {
	
	private int fileno;
	private String originname;
	private String storedname;
	private long filesize;
	private Date writedate;
	private int classNum;
	
	
	@Override
	public String toString() {
		return "ClassFile [fileno=" + fileno + ", originname=" + originname + ", storedname=" + storedname
				+ ", filesize=" + filesize + ", writedate=" + writedate + ", classNum=" + classNum + "]";
	}
	
	
	public int getFileno() {
		return fileno;
	}
	public void setFileno(int fileno) {
		this.fileno = fileno;
	}
	public String getOriginname() {
		return originname;
	}
	public void setOriginname(String originname) {
		this.originname = originname;
	}
	public String getStoredname() {
		return storedname;
	}
	public void setStoredname(String storedname) {
		this.storedname = storedname;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	
	
	
	
}
