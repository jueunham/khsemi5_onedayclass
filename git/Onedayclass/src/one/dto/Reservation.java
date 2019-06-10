package one.dto;

public class Reservation {

	private int reservNum;
	private int classNum;
	private int userNum;
	
	@Override
	public String toString() {
		return "Reservation [reservNum=" + reservNum + ", classNum=" + classNum + ", userNum=" + userNum + "]";
	}

	public int getReservNum() {
		return reservNum;
	}

	public void setReservNum(int reservNum) {
		this.reservNum = reservNum;
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
