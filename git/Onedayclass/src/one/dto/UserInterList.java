package one.dto;

public class UserInterList {
	
	private int listNum;
	private int userNum;
	private int interListNum;
	
	@Override
	public String toString() {
		return "UserInterList [listNum=" + listNum + ", userNum=" + userNum + ", interListNum=" + interListNum + "]";
	}

	public int getListNum() {
		return listNum;
	}

	public void setListNum(int listNum) {
		this.listNum = listNum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getInterListNum() {
		return interListNum;
	}

	public void setInterListNum(int interListNum) {
		this.interListNum = interListNum;
	}
		
}
