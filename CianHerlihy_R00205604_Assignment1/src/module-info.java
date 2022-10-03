module CianHerlihy_R00205604_Assignment1 {
	requires javafx.controls;
	requires java.sql;
	
	opens View to javafx.graphics, javafx.fxml;
	opens Controller to javafx.graphics, javafx.fxml;
	opens Model to javafx.graphics, javafx.fxml;
}
