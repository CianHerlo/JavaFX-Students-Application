package View;

/*******************************************************************************************
								Cian Herlihy - R00205604
									  Final Project
*******************************************************************************************/

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import java.sql.ResultSet;
import Controller.Control;



public class View extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// set the title of our window
			primaryStage.setTitle("R00205604 - MTU Student Record System");
			

			Control controller = new Control();
			ObservableList<String> names = controller.getNames();
			ObservableList<String> studentsIDNums = controller.getIDNumbers();
			
			
			// Creating Layout
			Group group = new Group();
			TabPane tabPane = new TabPane();
			tabPane.setSide(Side.LEFT);

			//Students Tab
			VBox VBox = new VBox();
			HBox HBox1 = new HBox();
			HBox HBox2 = new HBox();
			HBox HBox3 = new HBox();
			HBox HBox4 = new HBox();
			HBox HBox5 = new HBox();
			HBox HBox6 = new HBox();

			//Modules Tab
			VBox modVBox = new VBox();
			HBox modHBox1 = new HBox(); // Students Drop Down Menu
			HBox modHBox2 = new HBox(); // Module and Grad Labels
			HBox modHBox3 = new HBox(); // TextFields for 6 Module Name and Grade Fields
			HBox modHBox4 = new HBox();
			HBox modHBox5 = new HBox();
			HBox modHBox6 = new HBox();
			HBox modHBox7 = new HBox();
			HBox modHBox8 = new HBox();
			HBox modHBox9 = new HBox(); // Status Text Field
			HBox modHBox10 = new HBox(); // Save and Exit button

			//Details Tab
			VBox detVBox = new VBox();
			HBox detHBox1 = new HBox();
			HBox detHBox2 = new HBox();
			HBox detHBox3 = new HBox();

			// Buttons
			Button addBTN = new Button("Add");
			Button removeBTN = new Button("Remove");
			Button listBTN = new Button("List");
			Button exitBTN = new Button("Exit");
			Button addModulesGradesBTN = new Button("Add");
			Button updateModulesGradesBTN = new Button("Update");
			Button updateTab2DDBTN = new Button("Update");
			Button updateTab3DDBTN = new Button("Update");
			Button modulesExitBTN = new Button("Exit");
			Button detailsExitBTN = new Button("Exit");

			// Tabs
			Tab tab1 = new Tab("Students");
			tab1.setClosable(false);
			Tab tab2 = new Tab("Modules");
			tab2.setClosable(false);
			Tab tab3 = new Tab("Details");
			tab3.setClosable(false);

			// Labels
			Label nameLabel = new Label("Name ");
			Label sidLabel = new Label("Student ID ");
			Label dobLabel = new Label("Date of Birth");
			Label modulesDDLabel = new Label("Students ");
			Label moduleNameLabel = new Label("Module Name");
			Label moduleGradeLabel = new Label("Grade");
			Label detailsDDLabel = new Label("Students ");

			// Text Fields
			TextField nameFirstTextField = new TextField();
			TextField nameMITextField = new TextField();
			TextField nameLastTextField = new TextField();
			TextField sidTextField = new TextField();
			TextField studentIDTextField = new TextField();
			TextField name1TextField = new TextField();
			TextField name2TextField = new TextField();
			TextField name3TextField = new TextField();
			TextField name4TextField = new TextField();
			TextField name5TextField = new TextField();
			TextField name6TextField = new TextField();
			TextField grade1TextField = new TextField();
			TextField grade2TextField = new TextField();
			TextField grade3TextField = new TextField();
			TextField grade4TextField = new TextField();
			TextField grade5TextField = new TextField();
			TextField grade6TextField = new TextField();
			TextField statusTextField = new TextField();
			

			// Date Selector in Text Field
			DatePicker dateSelector = new DatePicker();

			//Modules Drop Down Menu
			ComboBox<String> tab2DDMenu = new ComboBox<String>();
			for (int x=0; x < names.size(); x++)
			{
				tab2DDMenu.setItems(names);
			}


			//Drop Down Menu - Tab 3
			ComboBox<String> tab3DDMenu = new ComboBox<String>();
			for (int x=0; x < names.size(); x++)
			{
				tab3DDMenu.setItems(names);
			}


			// Text Area
			TextArea tab1Col1TextArea = new TextArea();
			TextArea tab1Col2TextArea = new TextArea();
			TextArea tab1Col3TextArea = new TextArea();
			TextArea tab3Col1TextArea = new TextArea();
			TextArea tab3Col2TextArea = new TextArea();

			// VBox 1
			VBox.setSpacing(10);
			VBox.setPadding(new Insets(30));
			VBox.getChildren().addAll(HBox1, HBox2, HBox3, HBox4, HBox5, HBox6);

			// HBox 1 - 6
			HBox1.setSpacing(10);
			HBox1.getChildren().addAll(nameLabel, nameFirstTextField, nameMITextField, nameLastTextField);
			HBox2.setSpacing(10);
			HBox2.getChildren().addAll(sidLabel, sidTextField);
			HBox3.setSpacing(10);
			HBox3.getChildren().addAll(dobLabel, dateSelector);
			HBox4.setSpacing(10);
			HBox4.getChildren().addAll(addBTN, removeBTN, listBTN);
			HBox5.setSpacing(10);
			HBox5.getChildren().addAll(tab1Col1TextArea, tab1Col2TextArea, tab1Col3TextArea);
			HBox6.setSpacing(10);
			HBox6.getChildren().addAll(exitBTN);

			// Tab Pane
			tabPane.getTabs().addAll(tab1, tab2, tab3);


			// Modules Layout
			modVBox.setSpacing(10);
			modVBox.setPadding(new Insets(30));
			modVBox.getChildren().addAll(modHBox1, modHBox2, modHBox3, modHBox4, modHBox5, modHBox6, modHBox7, modHBox8, modHBox9, modHBox10);

			// HBox 1 - 4
			modHBox1.setSpacing(10);
			modHBox1.setPadding(new Insets(0, 0, 30, 0));
			modHBox1.getChildren().addAll(modulesDDLabel, tab2DDMenu, updateTab2DDBTN);
			modHBox2.setSpacing(10);
			modHBox2.getChildren().addAll(studentIDTextField, moduleNameLabel, moduleGradeLabel); // moduleNameLabel
			modHBox3.setSpacing(10);
			modHBox3.getChildren().addAll(name1TextField, grade1TextField);
			modHBox4.setSpacing(10);
			modHBox4.getChildren().addAll(name2TextField, grade2TextField);
			modHBox5.setSpacing(10);
			modHBox5.getChildren().addAll(name3TextField, grade3TextField);
			modHBox6.setSpacing(10);
			modHBox6.getChildren().addAll(name4TextField, grade4TextField);
			modHBox7.setSpacing(10);
			modHBox7.getChildren().addAll(name5TextField, grade5TextField);
			modHBox8.setSpacing(10);
			modHBox8.getChildren().addAll(name6TextField, grade6TextField);
			modHBox9.setSpacing(10);
			modHBox9.getChildren().addAll(statusTextField);
			modHBox10.setSpacing(10);
			modHBox10.getChildren().addAll(addModulesGradesBTN, updateModulesGradesBTN, modulesExitBTN);
			modHBox10.setAlignment(Pos.BASELINE_RIGHT);


			// Details Layout
			detVBox.setSpacing(10);
			detVBox.setPadding(new Insets(30));
			detVBox.getChildren().addAll(detHBox1, detHBox2, detHBox3);

			// HBox 1 - 3
			detHBox1.setSpacing(10);
			detHBox1.getChildren().addAll(detailsDDLabel, tab3DDMenu, updateTab3DDBTN);
			detHBox2.setSpacing(10);
			detHBox2.getChildren().addAll(tab3Col1TextArea, tab3Col2TextArea);
			detHBox3.setSpacing(10);
			detHBox3.getChildren().addAll(detailsExitBTN);
			detHBox3.setAlignment(Pos.BASELINE_RIGHT);


			// Set Widths to line up
			nameFirstTextField.setPrefWidth(150);
			nameMITextField.setPrefWidth(30);
			nameLastTextField.setPrefWidth(151);
			sidTextField.setPrefWidth(326);
			statusTextField.setPrefWidth(400);
			tab1Col1TextArea.setPrefWidth(199);
			tab1Col2TextArea.setPrefWidth(90);
			tab1Col3TextArea.setPrefWidth(90);
			tab1Col1TextArea.setPrefHeight(195);
			tab1Col2TextArea.setPrefHeight(195);
			tab1Col3TextArea.setPrefHeight(195);
			tab3Col1TextArea.setPrefWidth(195);
			tab3Col2TextArea.setPrefWidth(195);
			tab3Col1TextArea.setPrefHeight(300);
			tab3Col2TextArea.setPrefHeight(300);
			dateSelector.setPrefWidth(319);
			tab2DDMenu.setPrefWidth(230);
			tab3DDMenu.setPrefWidth(230);
			moduleNameLabel.setPrefWidth(170);
			moduleGradeLabel.setPrefWidth(100);
			updateTab2DDBTN.setPrefWidth(100);
			updateTab3DDBTN.setPrefWidth(100);
			studentIDTextField.setPrefWidth(100);
			moduleNameLabel.setAlignment(Pos.BASELINE_CENTER);
			moduleGradeLabel.setAlignment(Pos.BASELINE_CENTER);

			name1TextField.setPrefWidth(290);
			grade1TextField.setPrefWidth(100);
			name2TextField.setPrefWidth(290);
			grade2TextField.setPrefWidth(100);
			name3TextField.setPrefWidth(290);
			grade3TextField.setPrefWidth(100);
			name4TextField.setPrefWidth(290);
			grade4TextField.setPrefWidth(100);
			name5TextField.setPrefWidth(290);
			grade5TextField.setPrefWidth(100);
			name6TextField.setPrefWidth(290);
			grade6TextField.setPrefWidth(100);

			// Make TextFields Editable/Non-Editable
			nameFirstTextField.setEditable(true);
			nameMITextField.setEditable(true);
			nameLastTextField.setEditable(true);
			sidTextField.setEditable(true);
			dateSelector.setEditable(true);
			tab1Col1TextArea.setEditable(false);
			tab3Col1TextArea.setEditable(false);
			statusTextField.setEditable(false);
			studentIDTextField.setEditable(false);
			HBox6.setAlignment(Pos.BASELINE_RIGHT);

			// Students Tab (Setting Scene)
			tab1.setContent(VBox);

			// Modules Tab (Setting Scene)
			tab2.setContent(modVBox);

			// Details Tab (Setting Scene)
			tab3.setContent(detVBox);
			
			group.getChildren().addAll(tabPane);
			Scene scene = new Scene(group, 480, 420, Color.WHITE);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();

			


			
			/*******************************************************************************************
			 					Add Button on Tab 1 to Add Student to Derby Database 
			 *******************************************************************************************/

			// Add Button Handler - Adds Data to Array List
			addBTN.setOnAction(e -> 
			{
				try
				{
					String studentFN = nameFirstTextField.getText().strip();
					String studentMI = nameMITextField.getText();
					String studentLN = nameLastTextField.getText().strip();
					String studentID = sidTextField.getText().toUpperCase();
					String studentDOB = dateSelector.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					
					if(studentID!=null && studentID.length()==9 && studentID.startsWith("R")==true && studentFN!=null && studentMI!=null && studentMI.length()==1 && studentLN!=null && studentDOB!=null)
					{
						controller.addStudentSQL(studentID, studentFN, studentMI, studentLN, studentDOB);
						tab1Col1TextArea.setText("Student Records Submitted");
						tab1Col2TextArea.setText("");
						tab1Col3TextArea.setText("");
					}
					else
					{
						System.out.println("Error in Input");
					}
				}
				catch(NullPointerException nullPoint)
				{
					tab1Col1TextArea.setText("Error! A Field Was Left NULL");
				}
				catch (Exception addE) 
				{
					System.out.println("Add Button Error");
					addE.printStackTrace();
				}
			});



			/*******************************************************************************************
						Remove Button to Remove Student if the ID matches another Student
			 *******************************************************************************************/
			removeBTN.setOnAction(e -> 
			{
				try
				{
					String studentID = sidTextField.getText().toUpperCase();
					//String result = controller.removeStudents(studentID);
					controller.removeStudentSQL(studentID);
					controller.removeModulesSQL(studentID);
					tab1Col1TextArea.setText("Removed");
					tab1Col2TextArea.setText("");
					tab1Col3TextArea.setText("");
				} 
				catch (Exception removeE) 
				{
					System.out.println("Remove Button Error");
					removeE.printStackTrace();
				}
			});



			/*******************************************************************************************
				 List Button to List Students Details on Tab 1 (Student ID, Full Name, Date of Birth)
			 *******************************************************************************************/
			listBTN.setOnAction(e -> 
			{
				try
				{
					StringBuilder stringBuild = new StringBuilder();
					StringBuilder stringBuild2 = new StringBuilder();
					StringBuilder stringBuild3 = new StringBuilder();
					ResultSet students = controller.showStudentSQL();
					while(students.next())
					{
						String studentID = students.getString(1);
						String studentFN = students.getString(2);
						String studentMI = students.getString(3);
						String studentLN = students.getString(4);
						String studentDOB = students.getString(5);
						
						stringBuild.append(studentFN+" "+studentMI+". "+studentLN+"\n");
						stringBuild2.append(studentID+"\n");
						stringBuild3.append(studentDOB+"\n");
					}
					tab1Col1TextArea.setText(stringBuild.toString().trim());
					tab1Col2TextArea.setText(stringBuild2.toString().trim());
					tab1Col3TextArea.setText(stringBuild3.toString().trim());
				}
				catch (Exception listE)
				{
					System.out.println("List Button Error");
					listE.printStackTrace();
				}

			});



			/*******************************************************************************************
								Update Drop Down Menu on Tab 2 if New Names were Added
			 *******************************************************************************************/
			updateTab2DDBTN.setOnAction(e -> 
			{
				name1TextField.clear();
				name2TextField.clear();
				name3TextField.clear();
				name4TextField.clear();
				name5TextField.clear();
				name6TextField.clear();
				grade1TextField.clear();
				grade2TextField.clear();
				grade3TextField.clear();
				grade4TextField.clear();
				grade5TextField.clear();
				grade6TextField.clear();
				statusTextField.clear();
				
				ObservableList<String> studentNames = controller.getNames();
				tab2DDMenu.setItems(studentNames);
				statusTextField.setText("Updated Menu");
				studentIDTextField.setText("Updated Menu");
			});


			
			/*******************************************************************************************
								Update Drop Down Menu on Tab 3 if New Names were Added
			 *******************************************************************************************/
			updateTab3DDBTN.setOnAction(e -> 
			{
				name1TextField.clear();
				name2TextField.clear();
				name3TextField.clear();
				name4TextField.clear();
				name5TextField.clear();
				name6TextField.clear();
				grade1TextField.clear();
				grade2TextField.clear();
				grade3TextField.clear();
				grade4TextField.clear();
				grade5TextField.clear();
				grade6TextField.clear();
				statusTextField.clear();
				
				ObservableList<String> studentNames = controller.getNames();
				tab3DDMenu.setItems(studentNames);
				tab3Col1TextArea.setText("Updated Menu");
				tab3Col2TextArea.setText("Updated Menu");
			});
			
			
			
			/*******************************************************************************************
					Updates Data for Students Modules by Removing Old Data and Adding New Data
			 *******************************************************************************************/
			updateModulesGradesBTN.setOnAction(e -> 
			{
				String studentID = studentIDTextField.getText();
				String module1 = name1TextField.getText();
				String module2 = name2TextField.getText();
				String module3 = name3TextField.getText();
				String module4 = name4TextField.getText();
				String module5 = name5TextField.getText();
				String module6 = name6TextField.getText();
				int grade1 = Integer.parseInt(grade1TextField.getText());
				int grade2 = Integer.parseInt(grade2TextField.getText());
				int grade3 = Integer.parseInt(grade3TextField.getText());
				int grade4 = Integer.parseInt(grade4TextField.getText());
				int grade5 = Integer.parseInt(grade5TextField.getText());
				int grade6 = Integer.parseInt(grade6TextField.getText());
				int mod1len = name1TextField.getLength();
				int mod2len = name2TextField.getLength();
				int mod3len = name3TextField.getLength();
				int mod4len = name4TextField.getLength();
				int mod5len = name5TextField.getLength();
				int mod6len = name6TextField.getLength();
				
				if (mod1len != 0 && mod2len != 0 && mod3len != 0 && mod4len != 0 && mod5len != 0 && mod6len != 0)
				{
					if (grade1 >= 0   && grade2 >= 0   && grade3 >= 0   && grade4 >= 0   && grade5 >= 0   && grade6 >= 0   && 
							grade1 <= 100 && grade2 <= 100 && grade3 <= 100 && grade4 <= 100 && grade5 <= 100 && grade6 <= 100)
					{
						controller.removeModulesSQL(studentID);
						controller.addModulesSQL(studentID, module1, module2, module3, module4, module5, module6, grade1, grade2, grade3, grade4, grade5, grade6);
						
						// Clear all fields after saving
						name1TextField.clear();
						grade1TextField.clear();
						name2TextField.clear();
						grade2TextField.clear();
						name3TextField.clear();
						grade3TextField.clear();
						name4TextField.clear();
						grade4TextField.clear();
						name5TextField.clear();
						grade5TextField.clear();
						name6TextField.clear();
						grade6TextField.clear();
						statusTextField.setText("Student Updated");
					}
					else
					{
						System.out.println("Grade is not valid");
						statusTextField.setText("Grade is not valid");
					}
				}
				else
				{
					System.out.println("Module Not Input");
					statusTextField.setText("Module Not Input");
				}
			});

			

			/*******************************************************************************************
							Add Modules for Student if No Previous Data Exists Yet
			 *******************************************************************************************/
			addModulesGradesBTN.setOnAction(e -> 
			{
				// Variables to improve logic (Shorten if - else)
				//int index = tab2DDMenuIndex.get(0);System.out.println(tab2DDMenuIndex);
				String studentID = studentIDTextField.getText();
				String module1 = name1TextField.getText();
				String module2 = name2TextField.getText();
				String module3 = name3TextField.getText();
				String module4 = name4TextField.getText();
				String module5 = name5TextField.getText();
				String module6 = name6TextField.getText();
				int grade1 = Integer.parseInt(grade1TextField.getText());
				int grade2 = Integer.parseInt(grade2TextField.getText());
				int grade3 = Integer.parseInt(grade3TextField.getText());
				int grade4 = Integer.parseInt(grade4TextField.getText());
				int grade5 = Integer.parseInt(grade5TextField.getText());
				int grade6 = Integer.parseInt(grade6TextField.getText());
				int mod1len = name1TextField.getLength();
				int mod2len = name2TextField.getLength();
				int mod3len = name3TextField.getLength();
				int mod4len = name4TextField.getLength();
				int mod5len = name5TextField.getLength();
				int mod6len = name6TextField.getLength();
				
				
				if (mod1len != 0 && mod2len != 0 && mod3len != 0 && mod4len != 0 && mod5len != 0 && mod6len != 0)
				{
					if (grade1 >= 0   && grade2 >= 0   && grade3 >= 0   && grade4 >= 0   && grade5 >= 0   && grade6 >= 0   && 
							grade1 <= 100 && grade2 <= 100 && grade3 <= 100 && grade4 <= 100 && grade5 <= 100 && grade6 <= 100)
					{
						controller.addModulesSQL(studentID, module1, module2, module3, module4, module5, module6, grade1, grade2, grade3, grade4, grade5, grade6);

						// Clear all fields after saving
						studentIDTextField.clear();
						name1TextField.clear();
						grade1TextField.clear();
						name2TextField.clear();
						grade2TextField.clear();
						name3TextField.clear();
						grade3TextField.clear();
						name4TextField.clear();
						grade4TextField.clear();
						name5TextField.clear();
						grade5TextField.clear();
						name6TextField.clear();
						grade6TextField.clear();
						statusTextField.setText("Student Updated");
					}
					else
					{
						System.out.println("Grade is not valid");
						statusTextField.setText("Grade is not valid");
					}
				}
				else
				{
					System.out.println("Module Not Input");
					statusTextField.setText("Module Not Input");
				}
			});
			
			
			
			/*******************************************************************************************
				  Drop Down Menu on Tab 2 Auto Fills Form if the Data for that Student Already Exists
			 *******************************************************************************************/
			tab2DDMenu.setOnAction((event) -> 
			{
				try
				{
					statusTextField.setText("Add or Update Student Information");
					int index = tab2DDMenu.getSelectionModel().getSelectedIndex();
					String studentID = studentsIDNums.get(index);
					
					studentIDTextField.setText(studentID);
					ArrayList<String> studentsInformation = controller.fillFormModules(studentID);
					name1TextField.clear();
					name2TextField.clear();
					name3TextField.clear();
					name4TextField.clear();
					name5TextField.clear();
					name6TextField.clear();
					grade1TextField.clear();
					grade2TextField.clear();
					grade3TextField.clear();
					grade4TextField.clear();
					grade5TextField.clear();
					grade6TextField.clear();
					statusTextField.clear();
					
					name1TextField.setText(studentsInformation.get(1));
					name2TextField.setText(studentsInformation.get(2));
					name3TextField.setText(studentsInformation.get(3));
					name4TextField.setText(studentsInformation.get(4));
					name5TextField.setText(studentsInformation.get(5));
					name6TextField.setText(studentsInformation.get(6));
					grade1TextField.setText(studentsInformation.get(7));
					grade2TextField.setText(studentsInformation.get(8));
					grade3TextField.setText(studentsInformation.get(9));
					grade4TextField.setText(studentsInformation.get(10));
					grade5TextField.setText(studentsInformation.get(11));
					grade6TextField.setText(studentsInformation.get(12));
					statusTextField.setText("Update this Student");
				}
				catch (Exception  tabDD)
				{
					System.out.println("");
					//tabDD.printStackTrace();
				}
			});


			
			/*******************************************************************************************
						Drop Down Menu on Tab 3 Will List Data for Student when Selected
			 *******************************************************************************************/
			tab3DDMenu.setOnAction((event) -> 
			{
				try
				{
					int selectedIndex=99;
					String selectedName = tab3DDMenu.getValue();
					for (int i=0; i<names.size(); i++)
					{
						if (selectedName == names.get(i))
						{
							selectedIndex = i;
						}
					}
					
					if (selectedIndex<=studentsIDNums.size())
					{
						String studentID = studentsIDNums.get(selectedIndex);
						String stringBuild = controller.showModuleSQL(studentID);
						String stringBuild2 = controller.showGradeSQL(studentID);
						tab3Col1TextArea.setText(stringBuild.toString());
						tab3Col2TextArea.setText(stringBuild2.toString());
					}
					else
					{
						tab3Col1TextArea.setText("No Information for this Student");
					}
				}
				catch (Exception  tabDD)
				{
					System.out.println("Details Drop Down Menu Error");
					tabDD.printStackTrace();
				}
			});



			/*******************************************************************************************
									Exit Button for Whole Program on Tab 1
			 *******************************************************************************************/
			exitBTN.setOnAction(e -> 
			{
				try
				{
					Alert alertBox = new Alert(AlertType.NONE, "", ButtonType.YES, ButtonType.NO);
					alertBox.setTitle("Confirm Exit?");
					alertBox.setHeaderText("Are you sure you want to Exit?");

					Optional<ButtonType> option = alertBox.showAndWait();
					if (option.get() == ButtonType.YES)
					{
						System.exit(0);
					}
					else if (option.get() == ButtonType.NO)
					{
						alertBox.close();
					}
				} 
				catch (Exception exitE) 
				{
					System.out.println("Exit Button Error");
					exitE.printStackTrace();
				}
			});



			/*******************************************************************************************
									Exit Button for Whole Program on Tab 2
			 *******************************************************************************************/
			modulesExitBTN.setOnAction(e -> 
			{
				try
				{
					Alert alertBox = new Alert(AlertType.NONE, "", ButtonType.YES, ButtonType.NO);
					alertBox.setTitle("Confirm Exit?");
					alertBox.setHeaderText("Are you sure you want to Exit?");

					Optional<ButtonType> option = alertBox.showAndWait();
					if (option.get() == ButtonType.YES)
					{
						System.exit(0);
					}
					else if (option.get() == ButtonType.NO)
					{
						alertBox.close();
					}
				} 
				catch (Exception exitE) 
				{
					System.out.println("Exit Button Error");
					exitE.printStackTrace();
				}
			});



			/*******************************************************************************************
									Exit Button for Whole Program on Tab 3
			 *******************************************************************************************/
			detailsExitBTN.setOnAction(e -> 
			{
				try
				{
					Alert alertBox = new Alert(AlertType.NONE, "", ButtonType.YES, ButtonType.NO);
					alertBox.setTitle("Confirm Exit?");
					alertBox.setHeaderText("Are you sure you want to Exit?");

					Optional<ButtonType> option = alertBox.showAndWait();
					if (option.get() == ButtonType.YES)
					{
						System.exit(0);
					}
					else if (option.get() == ButtonType.NO)
					{
						alertBox.close();
					}
				} 
				catch (Exception exitE) 
				{
					System.out.println("Exit Button Error");
					exitE.printStackTrace();
				}
			});

		} 
		catch (Exception e) 
		{
			System.out.println("Application Error");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}
