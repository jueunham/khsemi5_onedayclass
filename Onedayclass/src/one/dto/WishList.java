package one.dto;

public class WishList {
	
	private int wishNum;
	private int userNum;
	private int classNum;
	
	@Override
	public String toString() {
		return "WishList [wishNum=" + wishNum + ", userNum=" + userNum + ", classNum=" + classNum + "]";
	}

	public int getWishNum() {
		return wishNum;
	}

	public void setWishNum(int wishNum) {
		this.wishNum = wishNum;
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
