package Model;

/*******************************************************************************************
								Cian Herlihy - R00205604
									  Final Project
*******************************************************************************************/

public class Module {
	
	private String studentID, moduleName1, moduleName2, moduleName3, moduleName4, moduleName5, moduleName6;
	private int moduleGrade1, moduleGrade2, moduleGrade3, moduleGrade4, moduleGrade5, moduleGrade6;


	public Module(String studentID, String moduleName1, String moduleName2, String moduleName3, String moduleName4, String moduleName5, 
			String moduleName6, int moduleGrade1, int moduleGrade2, int moduleGrade3, int moduleGrade4, int moduleGrade5, int moduleGrade6) 
	{
		this.studentID = studentID;
		this.moduleName1 = moduleName1;
		this.moduleName2 = moduleName2;
		this.moduleName3 = moduleName3;
		this.moduleName4 = moduleName4;
		this.moduleName5 = moduleName5;
		this.moduleName6 = moduleName6;
		this.moduleGrade1 = moduleGrade1;
		this.moduleGrade2 = moduleGrade2;
		this.moduleGrade3 = moduleGrade3;
		this.moduleGrade4 = moduleGrade4;
		this.moduleGrade5 = moduleGrade5;
		this.moduleGrade6 = moduleGrade6;
	}

	//Student ID to link modules to student
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}


	//Module Names
	public String getModuleName1() {
		return moduleName1;
	}
	public void setModuleName1(String moduleName1) {
		this.moduleName1 = moduleName1;
	}
	public String getModuleName2() {
		return moduleName2;
	}
	public void setModuleName2(String moduleName2) {
		this.moduleName2 = moduleName2;
	}
	public String getModuleName3() {
		return moduleName3;
	}
	public void setModuleName3(String moduleName3) {
		this.moduleName3 = moduleName3;
	}
	public String getModuleName4() {
		return moduleName4;
	}
	public void setModuleName4(String moduleName4) {
		this.moduleName4 = moduleName4;
	}
	public String getModuleName5() {
		return moduleName5;
	}
	public void setModuleName5(String moduleName5) {
		this.moduleName5 = moduleName5;
	}
	public String getModuleName6() {
		return moduleName6;
	}
	public void setModuleName6(String moduleName6) {
		this.moduleName6 = moduleName6;
	}


	//Module Grades
	public int getModuleGrade1() {
		return moduleGrade1;
	}
	public void setModuleGrade1(int moduleGrade1) {
		this.moduleGrade1 = moduleGrade1;
	}
	public int getModuleGrade2() {
		return moduleGrade2;
	}
	public void setModuleGrade2(int moduleGrade2) {
		this.moduleGrade2 = moduleGrade2;
	}
	public int getModuleGrade3() {
		return moduleGrade3;
	}
	public void setModuleGrade3(int moduleGrade3) {
		this.moduleGrade3 = moduleGrade3;
	}
	public int getModuleGrade4() {
		return moduleGrade4;
	}
	public void setModuleGrade4(int moduleGrade4) {
		this.moduleGrade4 = moduleGrade4;
	}
	public int getModuleGrade5() {
		return moduleGrade5;
	}
	public void setModuleGrade5(int moduleGrade5) {
		this.moduleGrade5 = moduleGrade5;
	}
	public int getModuleGrade6() {
		return moduleGrade6;
	}
	public void setModuleGrade6(int moduleGrade6) {
		this.moduleGrade6 = moduleGrade6;
	}
	
	
}
