package one.dto;

import java.util.Date;

public class MemberFile {
	private int fileno;
	private String userid;
	private String originName;
	private String storedName;
	private long filesize;
	
	@Override
	public String toString() {
		return "MemberFile [fileno=" + fileno + ", userid=" + userid + ", originName=" + originName + ", storedName="
				+ storedName + ", filesize=" + filesize + "]";
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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
	
	

	
}