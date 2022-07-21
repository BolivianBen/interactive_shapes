package application;

//Benjamin Holman, Student ID 2371353


//pretty much copied these imports from various of the sample problems in the text that were provided in the zip.
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//Extend the Application,
public class Exercise16_2 extends Application {
	
	///Create the three shapes,
	protected Circle circle = new Circle(60);	
	protected Rectangle rectangle = new Rectangle(); 
	protected Ellipse ellipse = new Ellipse();

	///Override to start the main
	@Override 
		public void start(Stage primaryStage) {
			///actually give the shapes the the color values and sizes
			//the circle
			circle.setStroke(Color.BLACK);
			circle.setFill(Color.WHITE);
			
			//rectangle
			rectangle.setStroke(Color.BLACK);
			rectangle.setWidth(150);
			rectangle.setFill(Color.WHITE);
			rectangle.setHeight(100);
			
			///the ellipse
			ellipse.setFill(Color.WHITE);
			ellipse.setStroke(Color.BLACK);
			ellipse.setRadiusX(100);
			ellipse.setRadiusY(50);

		// Now I need three buttons to put at the bottom of the pane, Set these in a HBOX
			///these will all be radiobuttons.
		HBox paneForButtons = new HBox(5);
			//align the buttons and then name them
			paneForButtons.setAlignment(Pos.CENTER);
				RadioButton CircleButton = new RadioButton("Circle"); 
				RadioButton RectangleButton = new RadioButton("Rectangle"); 
				RadioButton EllipseButton = new RadioButton("Ellipse"); 

		//now that I've made the radio buttons. they have to be exclusive,
		///I'll use the toggleGroup code from RadioButtonDemo.java in the zip files
		ToggleGroup group = new ToggleGroup();
		CircleButton.setToggleGroup(group);
		RectangleButton.setToggleGroup(group);
		EllipseButton.setToggleGroup(group);

		///Now just create the last button, which is a checkbox titled Fill
		CheckBox chkFill = new CheckBox("Fill");

		///Get all buttons into the Hbox using the getChildren method thingy
		paneForButtons.getChildren().addAll(CircleButton, RectangleButton, EllipseButton, chkFill);

		// Time to make the actual pane for everything to go into
		// Within the pane I need to create two sections. First to hold the buttons and the top to hold the shapes
		StackPane paneForShapes = new StackPane();
		paneForShapes.setStyle("-fx-border-color: black");
		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons);
		pane.setCenter(paneForShapes);

		///Ideally buttons are now registered to show up in the pane...Now I need to tell the program what each button is going to do.
			///this is going to strongly mimic the code found in RadioButtonDemo from the chapter.
			///using the same concept of if statements I need several if statements for each radio button to display a different shape
		
		
		///pretty much copied this code, but instead of changing the font, it displays the shape
		///also added the clearing method so that the shapes didn't stack on top of eachother
		CircleButton.setOnAction(e -> {
			if (CircleButton.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(circle);} });

		RectangleButton.setOnAction(e -> {
			if (RectangleButton.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(rectangle);}});

		EllipseButton.setOnAction(e -> {
			if (EllipseButton.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(ellipse);}});

		///next create an if statement that will change the shape being displayed for the check box.
			///when the box is checked, fill the shape with a color. I figured red, yellow and green were cool.
		
		chkFill.setOnAction(e -> {
			if (chkFill.isSelected()) {
				circle.setFill(Color.RED);
				rectangle.setFill(Color.YELLOW);
				ellipse.setFill(Color.GREEN);}
			
				///if its not clicked, they remain white
				else {
					circle.setFill(Color.WHITE);
					rectangle.setFill(Color.WHITE);
					ellipse.setFill(Color.WHITE);}});

		// Now just show off my work in the pane!!!! I hope....
		
		Scene scene = new Scene(pane, 300, 200);
		primaryStage.setTitle("Exercise16_02"); 
		primaryStage.setScene(scene); 
		primaryStage.show();
	}
}