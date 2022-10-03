package Model;

/*******************************************************************************************
								Cian Herlihy - R00205604
									  Final Project
*******************************************************************************************/

public class Name {
	private String studentID;
	private String studentFN;
	private String studentMI;
	private String studentLN;


	public Name(String studentID, String studentFN, String studentMI, String studentLN) {
		this.studentFN = studentFN;
		this.studentFN = studentMI;
		this.studentFN = studentLN;
	}


	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public String getStudentFN() {
		return studentFN;
	}
	public void setStudentFN(String studentFN) {
		this.studentFN = studentFN;
	}

	public String getStudentMI() {
		return studentMI;
	}
	public void setStudentMI(String studentMI) {
		this.studentMI = studentMI;
	}

	public String getStudentLN() {
		return studentLN;
	}
	public void setStudentLN(String studentLN) {
		this.studentLN = studentLN;
	}
}
