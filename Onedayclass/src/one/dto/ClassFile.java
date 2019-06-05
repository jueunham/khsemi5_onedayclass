package one.dto;

import java.util.Date;

public class ClassFile {
	private int fileno;
	private int classNum;
	private String originName;
	private String storedName;
	private long filesize;
	private Date writeDate;
	
	@Override
	public String toString() {
		return "BoardFile [fileno=" + fileno + ", classNum=" + classNum + ", originName=" + originName + ", storedName="
				+ storedName + ", filesize=" + filesize + ", writeDate=" + writeDate + "]";
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getStoredName() {
		return storedName;
	}

	public void setStoredName(String storedName) {
		this.storedName = storedName;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
}
