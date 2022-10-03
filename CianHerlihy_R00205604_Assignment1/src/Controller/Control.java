package Controller;

/*******************************************************************************************
								Cian Herlihy - R00205604
									  Final Project
*******************************************************************************************/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import Model.Student;
//import Model.Module;



public class Control {
	private ObservableList<String>  studentsNames = FXCollections.observableArrayList();
	private ObservableList<String>  studentsIdNumber = FXCollections.observableArrayList();
	static final String FILENAME = "studentDetails.txt";
	static final String MODULEFILENAME = "moduleDetails.txt";
	
	
	
	/*******************************************************************************************
	 ****************************** Connection to database *************************************
	 ******************************************************************************************/
	private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
	private static final String DATABASEURL = "jdbc:derby://localhost:1527/studentsDB;create=true";
	
	
	
	/*******************************************************************************************
	 							Show all Students in student Table
	 ******************************************************************************************/
	public ResultSet showStudentSQL()
	{
		try
		{
			Class.forName(DRIVER);
			Connection connect = DriverManager.getConnection(DATABASEURL);
			Statement statement = connect.createStatement();
			statement = connect.createStatement();
			String selectStudentSQL = "SELECT * FROM student";
			statement.execute(selectStudentSQL);
			ResultSet selectStudent = statement.executeQuery(selectStudentSQL);
			return selectStudent;
		}
		catch (Exception sql) 
		{
			sql.printStackTrace();
		}
		return null;
	}
	
	
	
	/*******************************************************************************************
	 							Show all Students in Module Table
	 ******************************************************************************************/
	public ResultSet showStudentModuleSQL()
	{
		try
		{
			Class.forName(DRIVER);
			Connection connect = DriverManager.getConnection(DATABASEURL);
			Statement statement = connect.createStatement();
			statement = connect.createStatement();
			String selectStudentSQL = "SELECT * FROM module";
			statement.execute(selectStudentSQL);
			ResultSet selectStudent = statement.executeQuery(selectStudentSQL);
			return selectStudent;
		}
		catch (Exception sql) 
		{
			sql.printStackTrace();
		}
		return null;
	}
	
	
	
	/*******************************************************************************************
							Add Students Info to student Table
	******************************************************************************************/
	public void addStudentSQL(String studentID, String studentFN, String studentMI, String studentLN, String studentDOB)
	{
		try
		{
			Class.forName(DRIVER);
			Connection connect = DriverManager.getConnection(DATABASEURL);
			Statement statement = connect.createStatement();
			statement = connect.createStatement();
			String insertSQL = "INSERT INTO student VALUES ('"+studentID.toUpperCase()+"', '"+studentFN+"', '"+studentMI+"', '"+studentLN+"', '"+studentDOB+"')";
			
			
			statement.execute(insertSQL);
			return;
		}
		catch (Exception sql) 
		{
			sql.printStackTrace();
		}
	}
	
	
	
	/*******************************************************************************************
							Remove Students Info to student Table
	******************************************************************************************/
	public void removeStudentSQL(String studentID)
	{
		try
		{
			Class.forName(DRIVER);
			Connection connect = DriverManager.getConnection(DATABASEURL);
			Statement statement = connect.createStatement();
			statement = connect.createStatement();
			String deleteSQL = "DELETE FROM student WHERE studentID='"+studentID+"'"; 
			statement.execute(deleteSQL);
			return;
		}
		catch (Exception sql) 
		{
			sql.printStackTrace();
		}
	}
	
	
	
	/*******************************************************************************************
							Add Module Info to module Table
	******************************************************************************************/
	public void addModulesSQL(String studentID, String moduleName1, String moduleName2, String moduleName3, String moduleName4, String moduleName5, String moduleName6, int moduleGrade1, int moduleGrade2, int moduleGrade3, int moduleGrade4, int moduleGrade5, int moduleGrade6)
	{
		try
		{
			Class.forName(DRIVER);
			Connection connect = DriverManager.getConnection(DATABASEURL);
			Statement statement = connect.createStatement();
			statement = connect.createStatement();
			
			
			String insertSQL = "INSERT INTO module VALUES ('"+studentID+"', '"+moduleName1+"', '"+moduleName2+"', '"+moduleName3+"', '"+moduleName4+"', '"+moduleName5+"', '"+moduleName6+"', "+moduleGrade1+", "+moduleGrade2+", "+moduleGrade3+", "+moduleGrade4+", "+moduleGrade5+", "+moduleGrade6+")";
			statement.execute(insertSQL);
			
			return;
		}
		catch (Exception sql) 
		{
			sql.printStackTrace();
		}
	}
	
	
	
	/*******************************************************************************************
							Delete Module Info from module Table
	******************************************************************************************/
	public void removeModulesSQL(String studentID)
	{
		try
		{
			Class.forName(DRIVER);
			Connection connect = DriverManager.getConnection(DATABASEURL);
			Statement statement = connect.createStatement();
			statement = connect.createStatement();
			String deleteSQL = "DELETE FROM module WHERE studentID='"+studentID+"'";
			statement.execute(deleteSQL);
			return;
		}
		catch (Exception sql) 
		{
			sql.printStackTrace();
		}
	}
	
	
	
	/*******************************************************************************************
								Return Modules for Student on Tab 3
	 ******************************************************************************************/
	public String showModuleSQL(String id)
	{
		try
		{
			Class.forName(DRIVER);
			Connection connect = DriverManager.getConnection(DATABASEURL);
			Statement statement = connect.createStatement();
			statement = connect.createStatement();
			String selectModuleSQL = "SELECT * FROM module WHERE studentID='"+id+"'";
			ResultSet selectModule = statement.executeQuery(selectModuleSQL);

			while(selectModule.next())
			{
				String moduleName1 = selectModule.getString(2);
				String moduleName2 = selectModule.getString(3);
				String moduleName3 = selectModule.getString(4);
				String moduleName4 = selectModule.getString(5);
				String moduleName5 = selectModule.getString(6);
				String moduleName6 = selectModule.getString(7);
				
				
				StringBuilder stringBuild = new StringBuilder();
				stringBuild.append("\t\tModules");
				stringBuild.append("\n---------------------------------\n");
				stringBuild.append(moduleName1+"\n");
				stringBuild.append(moduleName2+"\n");
				stringBuild.append(moduleName3+"\n");
				stringBuild.append(moduleName4+"\n");
				stringBuild.append(moduleName5+"\n");
				stringBuild.append(moduleName6+"\n");
				return stringBuild.toString();
			}
			return "No Details Found";
		}
		catch (Exception sql) 
		{
			sql.printStackTrace();
		}
		return null;
	}
	
	
	
	/*******************************************************************************************
								Return Grades for Student on Tab 3
	 ******************************************************************************************/
	
	public String showGradeSQL(String id)
	{
		try
		{
			Class.forName(DRIVER);
			Connection connect = DriverManager.getConnection(DATABASEURL);
			Statement statement = connect.createStatement();
			statement = connect.createStatement();
			String selectModuleSQL = "SELECT * FROM module WHERE studentID='"+id+"'";
			ResultSet selectModule = statement.executeQuery(selectModuleSQL);

			while(selectModule.next())
			{
				int moduleGrade1 = Integer.parseInt(selectModule.getString(8));
				int moduleGrade2 = Integer.parseInt(selectModule.getString(9));
				int moduleGrade3 = Integer.parseInt(selectModule.getString(10));
				int moduleGrade4 = Integer.parseInt(selectModule.getString(11));
				int moduleGrade5 = Integer.parseInt(selectModule.getString(12));
				int moduleGrade6 = Integer.parseInt(selectModule.getString(13));
				
				
				StringBuilder stringBuild2 = new StringBuilder();
				stringBuild2.append("\t\tGrades");
				stringBuild2.append("\n---------------------------------\n");
				stringBuild2.append(moduleGrade1+"\n");
				stringBuild2.append(moduleGrade2+"\n");
				stringBuild2.append(moduleGrade3+"\n");
				stringBuild2.append(moduleGrade4+"\n");
				stringBuild2.append(moduleGrade5+"\n");
				stringBuild2.append(moduleGrade6+"\n");
				return stringBuild2.toString();
			}
			return "No Details Found";
		}
		catch (Exception sql) 
		{
			sql.printStackTrace();
		}
		return null;
	}
	
	
	
	/*******************************************************************************************
	 							Show all Modules for Student in module Table
	 ******************************************************************************************/
	public ArrayList<String> fillFormModules(String id)
	{
		try
		{
			Class.forName(DRIVER);
			Connection connect = DriverManager.getConnection(DATABASEURL);
			Statement statement = connect.createStatement();
			statement = connect.createStatement();
			String selectModuleSQL = "SELECT * FROM module WHERE studentID='"+id+"'";
			ResultSet selectModule = statement.executeQuery(selectModuleSQL);
			ArrayList<String> studentsInformation = new ArrayList<String>();

			while(selectModule.next())
			{
				String studentID = selectModule.getString(1);		studentsInformation.add(studentID);
				String moduleName1 = selectModule.getString(2);		studentsInformation.add(moduleName1);
				String moduleName2 = selectModule.getString(3);		studentsInformation.add(moduleName2);
				String moduleName3 = selectModule.getString(4);		studentsInformation.add(moduleName3);
				String moduleName4 = selectModule.getString(5);		studentsInformation.add(moduleName4);
				String moduleName5 = selectModule.getString(6);		studentsInformation.add(moduleName5);
				String moduleName6 = selectModule.getString(7);		studentsInformation.add(moduleName6);
				String moduleGrade1 = selectModule.getString(8);	studentsInformation.add(moduleGrade1);
				String moduleGrade2 = selectModule.getString(9);	studentsInformation.add(moduleGrade2);
				String moduleGrade3 = selectModule.getString(10);	studentsInformation.add(moduleGrade3);
				String moduleGrade4 = selectModule.getString(11);	studentsInformation.add(moduleGrade4);
				String moduleGrade5 = selectModule.getString(12);	studentsInformation.add(moduleGrade5);
				String moduleGrade6 = selectModule.getString(13);	studentsInformation.add(moduleGrade6);
				return studentsInformation;
				
			}
			return null;
		}
		catch (Exception sql) 
		{
			sql.printStackTrace();
		}
		return null;
	}
	
	
	
	/*******************************************************************************************
	 		Reads Database and fills Observable Arraylists with Names and ID's of Students
	 ******************************************************************************************/
	public void getStudentsNames()
	{
		try
		{
			Class.forName(DRIVER);
			Connection connect = DriverManager.getConnection(DATABASEURL);
			Statement statement = connect.createStatement();
			statement = connect.createStatement();
			String studentsInfo = "SELECT * FROM student";
			statement.execute(studentsInfo);
			ResultSet students = statement.executeQuery(studentsInfo);
			
			while(students.next())
			{
				String studentID = students.getString(1);
				String studentFN = students.getString(2);
				String studentMI = students.getString(3);
				String studentLN = students.getString(4);
				String name = studentFN+" "+studentMI+". "+studentLN;
				studentsNames.add(name);
				studentsIdNumber.add(studentID);
			}
			return;
		}
		catch (Exception sql) 
		{
			sql.printStackTrace();
		}
		return;
	}
	
	
	
	/*******************************************************************************************
						Returns StudentId from Observable ArrayList
	 ******************************************************************************************/
	public String getID(int index)
	{
		String studentID = studentsIdNumber.get(index);
		return studentID;
	}
	
	
	
	
	/*******************************************************************************************
			Returns Whole ObservableList to be Called in View for Direct Access (Copy)
	 ******************************************************************************************/
	public  ObservableList<String> getNames()
	{
		studentsNames.clear();
		studentsIdNumber.clear();
		getStudentsNames();
	    return studentsNames;
	}
	public  ObservableList<String> getIDNumbers()
	{
		studentsNames.clear();
		studentsIdNumber.clear();
		getStudentsNames();
	    return studentsIdNumber;
	}

}
