package one.dto;

public class Banner {
	private int bannerNum;
	private int classNum;
	private int userNum;
	
	@Override
	public String toString() {
		return "Banner [bannerNum=" + bannerNum + ", classNum=" + classNum + ", userNum=" + userNum + "]";
	}
	
	public int getBannerNum() {
		return bannerNum;
	}
	public void setBannerNum(int bannerNum) {
		this.bannerNum = bannerNum;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
	
}
