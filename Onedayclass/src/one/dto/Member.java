package one.dto;

public class Member {

	private int usernum;
	private String username;
	private String userid;
	private String userpw;
	private int userphone;
	private String userlevel;
	

	@Override
	public String toString() {
		return "Member [usernum=" + usernum + ", username=" + username + ", userid=" + userid + ", userpw=" + userpw
				+ ", userphone=" + userphone + ", userlevel=" + userlevel + "]";
	}
	
	
	public int getUsernum() {
		return usernum;
	}
	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public int getUserphone() {
		return userphone;
	}
	public void setUserphone(int userphone) {
		this.userphone = userphone;
	}
	public String getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(String userlevel) {
		this.userlevel = userlevel;
	}
	

}
