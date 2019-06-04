package one.dto;

public class DayClass {

	private int classnum;
	private String classname;
	private String classcontent;
	private String classday;
	private String classtime;
	private String classplace;
	private int classprice;
	private int classrunningtime;
	private int usernum;

	
	@Override
	public String toString() {
		return "DayClass [classnum=" + classnum + ", classname=" + classname + ", classcontent=" + classcontent
				+ ", classday=" + classday + ", classtime=" + classtime + ", classplace=" + classplace + ", classPrice="
				+ classprice + ", classrunningtime=" + classrunningtime + ", usernum=" + usernum + "]";
	}
	
	public int getClassnum() {
		return classnum;
	}
	public void setClassnum(int classnum) {
		this.classnum = classnum;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getClasscontent() {
		return classcontent;
	}
	public void setClasscontent(String classcontent) {
		this.classcontent = classcontent;
	}
	public String getClassday() {
		return classday;
	}
	public void setClassday(String classday) {
		this.classday = classday;
	}
	public String getClasstime() {
		return classtime;
	}
	public void setClasstime(String classtime) {
		this.classtime = classtime;
	}
	public String getClassplace() {
		return classplace;
	}
	public void setClassplace(String classplace) {
		this.classplace = classplace;
	}
	
	public int getClassprice() {
		return classprice;
	}

	public void setClassprice(int classprice) {
		this.classprice = classprice;
	}
	
	public int getClassrunningtime() {
		return classrunningtime;
	}
	public void setClassrunningtime(int classrunningtime) {
		this.classrunningtime = classrunningtime;
	}
	public int getUsernum() {
		return usernum;
	}
	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}
	

}
