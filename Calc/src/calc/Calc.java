package calc;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Calc extends Application {

    Stage window;
    Scene scene;
    String item;
    public static int selection;

    public static void main(String[] args) 
    {
        Application.launch(args);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Test Title");
        
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(30);
        grid.setAlignment(Pos.BASELINE_CENTER);
        final VBox all = new VBox();
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.TOP_CENTER);
        
        Text title = new Text("Factorio Calculator");
        title.setFont(Font.font("Ubuntu", FontWeight.BOLD, 20));
        hbox.getChildren().add(title);
        
        Button button = new Button("Calculate!");
        grid.add(button, 1, 2);
        
        Button closebutton = new Button("Exit");
        closebutton.setTextFill(Color.RED);
        closebutton.setPrefSize(80, 10);
        grid.add(closebutton, 1, 10);
        
        closebutton.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            Platform.exit();
        }
      });
        
        /* you can add something like 
        "scrollpane.setVbarPolicy(ScrollBarPolicy.NEVER);"
        ("scrollpane" being the name) to not allow use of that scroll */
        
        ScrollPane sp = new ScrollPane();
        sp.setContent(grid);
        sp.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        VBox.setVgrow(sp, Priority.ALWAYS);

        final ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll(
        		"Science Pack 1",
        		"Science Pack 2",
        		"Science Pack 3",
        		"Iron Plate",
        		"Copper Plate"
        	);
        //sets how many rows are visible/adds scrollpane :D
        comboBox.setVisibleRowCount(5);
        comboBox.setPrefSize(120, 30);
        grid.add(comboBox, 0, 1);
        /*
        comboBox.setValue("Science Pack 1");*/
        comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String t, String t1) {                
                item = t1;                
            }    
        });
        
        /*String[] items = { "Science Pack 1", "Science Pack 2", "Science Pack 3",
        		"Iron Plate", "Copper Plate" };
        JList list = new JList(items);
        list.setVisibleRowCount(3);*/
        
        //text areas
		final TextField inamount = new TextField();
		//faded-out gray background text
		inamount.setPromptText("Amount of it");
        inamount.setMaxSize(100, 20);
        grid.add(inamount, 0, 2);
        
		final TextField intime = new TextField();
		intime.setPromptText("Get this amount per (seconds)");
        intime.setMaxSize(100, 20);
        grid.add(intime, 0, 3);
        
        final TextArea output = new TextArea();
        output.setEditable(false);
        output.setMaxSize(300, 150);
        grid.add(output, 1, 1);
        
		//you can leave the parameters blank for no text, or put text in quotes
		final Label label = new Label();
		
		final ToggleGroup amgroup = new ToggleGroup();

		RadioButton am1 = new RadioButton("Assembly Machine 1 (0.5 crafting speed)");
		am1.setToggleGroup(amgroup);
		grid.add(am1, 0, 5);

		RadioButton am2 = new RadioButton("Assembly Machine 2 (0.75 crafting speed)");
		am2.setToggleGroup(amgroup);
		grid.add(am2, 0, 6);
		 
		RadioButton am3 = new RadioButton("Assembly Machine 3 (1.25 crafting speed)");
		am3.setToggleGroup(amgroup);
		grid.add(am3, 0, 7);
		
		Separator hseparator = new Separator();
		//only need to add this line for when making a VERTICAL separator
		hseparator.setOrientation(Orientation.HORIZONTAL);
		grid.add(hseparator, 0, 8);
		
		final ToggleGroup fgroup = new ToggleGroup();
		
		RadioButton sf = new RadioButton("Stone Furnace (production speed 1)");
		sf.setToggleGroup(fgroup);
		grid.add(sf, 0, 9);
		
		RadioButton stf = new RadioButton("Steel Furnace (production speed 2)");
		stf.setToggleGroup(fgroup);
		grid.add(stf, 0, 10);
		
		RadioButton ef = new RadioButton("Electric Furnace (production speed 2)");
		ef.setToggleGroup(fgroup);
		grid.add(ef, 0, 11);
		
		//gets selection and then gives it the value of the "UserData"
		am1.setUserData("Assembly Machine 1");
		am2.setUserData("Assembly Machine 2");
		am3.setUserData("Assembly Machine 3");

		sf.setUserData("Stone Furnace");
		stf.setUserData("Steel Furnace");
		ef.setUserData("Electric Furnace");
		
		
        button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
		        System.out.println(db.getMsg());
				int time = 0, amount = 0;
				String storage = new String();
				try 
				{
					storage = inamount.getText();
					amount = Integer.parseInt(storage);
					storage = intime.getText();
					time = Integer.parseInt(storage);
					System.out.println(amount + " and " + time);
					//catching the exception with a variable (var) called "ex"
				} catch (java.lang.NumberFormatException ex) {
					label.setText("Error. Amount and time are both required.");
				}
				System.out.println("Item = " + item);
				label.setText(item);
				try {
					storage = amgroup.getSelectedToggle().getUserData().toString();
				} catch (java.lang.NullPointerException ex) {
					System.err.println("Caught Exception: " + ex.getMessage());
				}
				double crafter = 0, smelter = 0, result = 0, IronPlate = 0, CopperPlate = 0, var1 = 0, var2 = 0, var3 = 0, var4 = 0;
				switch (storage)
				{
				case "Assembly Machine 1":
					output.appendText("\nAssembly Machine 1");
					crafter = 0.5;
					break;
				case "Assembly Machine 2":
					output.appendText("\nAssembly Machine 2");
					crafter = 0.75;
					break;
				case "Assembly Machine 3":
					output.appendText("\nAssembly Machine 3");
					crafter = 1.25;
					break;
				default:
					//will be the same as "AS3"
					output.appendText("\nDefault");
					crafter = 1.25;
				}
				try {
					storage = fgroup.getSelectedToggle().getUserData().toString();
				} catch (java.lang.NullPointerException ex) {
					System.err.println("Error, put an input for a furnace.");
				}
				switch (storage)
				{
				case "Stone Furnace":
					output.appendText("\nStone Furnace");
					smelter = 1;
					break;
				case "Steel Furnace":
					output.appendText("\nSteel Furnace");
					smelter = 2;
					break;
				case "Electric Furnace":
					output.appendText("\nElectric Furnace");
					smelter = 2;
					break;
				default:
					output.appendText("\nDefault");
				}
				switch (item)
				{
				case "Science Pack 1":
					selection = 1;
					output.appendText("\nScience Pack 1");
					var1 = amount * 0.5;
					CopperPlate = amount * 0.44;
					result = amount * 5 / crafter;
					break;
				case "Science Pack 2":
					selection = 2;
					output.appendText("\nScience Pack 2");
					break;
				case "Science Pack 3":
					output.appendText("\nScience Pack 3");
					break;
				default:
					
				}
		    }
        });      
        
		all.getChildren().addAll(hbox, grid, sp);
        scene = new Scene(all, 800, 600);
        grid.setPadding(new Insets(30, 30, 30, 30));
        window.setScene(scene);
        window.show();
    }
    public static int getSelection() {
    	return selection;
    }
    public static void setSelection(int s) {
    	selection = s;
    }
}