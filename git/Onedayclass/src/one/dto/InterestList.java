package one.dto;

public class InterestList {
	
	private int interlistNum;
	private String interName;
	
	@Override
	public String toString() {
		return "InterestList [interlistNum=" + interlistNum + ", interName=" + interName + "]";
	}
	
	public int getInterlistNum() {
		return interlistNum;
	}
	public void setInterlistNum(int interlistNum) {
		this.interlistNum = interlistNum;
	}
	public String getInterName() {
		return interName;
	}
	public void setInterName(String interName) {
		this.interName = interName;
	}
	
	

}
