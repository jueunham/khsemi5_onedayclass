package one.dto;

public class Member {

	private int userNum;
	private String userName;
	private String userid;
	private String userpw;
	private int userPhone;
	private String userLevel;
	
	@Override
	public String toString() {
		return "Member [userNum=" + userNum + ", userName=" + userName + ", userid=" + userid + ", userpw=" + userpw
				+ ", userPhone=" + userPhone + ", userLevel=" + userLevel + "]";
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public int getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	
}
