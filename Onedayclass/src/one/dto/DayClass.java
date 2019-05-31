package one.dto;

import java.sql.Date;

public class DayClass {

	private int classNum;
	private String className;
	private String classContent;
	private Date classDay;
	private Date classTime;
	private String classPlace;
	private int classPrice;
	private int classRunningTime;
	@Override
	public String toString() {
		return "Class [classNum=" + classNum + ", className=" + className + ", classContent=" + classContent
				+ ", classDay=" + classDay + ", classTime=" + classTime + ", classPlace=" + classPlace + ", classPrice="
				+ classPrice + ", classRunningTime=" + classRunningTime + "]";
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassContent() {
		return classContent;
	}
	public void setClassContent(String classContent) {
		this.classContent = classContent;
	}
	public Date getClassDay() {
		return classDay;
	}
	public void setClassDay(Date classDay) {
		this.classDay = classDay;
	}
	public Date getClassTime() {
		return classTime;
	}
	public void setClassTime(Date classTime) {
		this.classTime = classTime;
	}
	public String getClassPlace() {
		return classPlace;
	}
	public void setClassPlace(String classPlace) {
		this.classPlace = classPlace;
	}
	public int getClassPrice() {
		return classPrice;
	}
	public void setClassPrice(int classPrice) {
		this.classPrice = classPrice;
	}
	public int getClassRunningTime() {
		return classRunningTime;
	}
	public void setClassRunningTime(int classRunningTime) {
		this.classRunningTime = classRunningTime;
	}
	
	
}
