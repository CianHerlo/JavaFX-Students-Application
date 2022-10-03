package Model;

/*******************************************************************************************
								Cian Herlihy - R00205604
									  Final Project
*******************************************************************************************/

public class Student {
	private String studentID;
	private String studentDOB;


	public Student(String studentID, String studentDOB) {
		this.studentID = studentID;
		this.studentDOB = studentDOB;
	}


	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(String studentDOB) {
		this.studentDOB = studentDOB;
	}

}
