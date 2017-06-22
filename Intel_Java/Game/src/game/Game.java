package game;

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
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Application {

    Stage window;
    Scene scene;

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Game Title");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(30);
        grid.setAlignment(Pos.CENTER);
        final VBox all = new VBox();
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.TOP_CENTER);

        Button button1 = new Button("1");
        button1.setMinSize(40, 40);
        grid.add(button1, 0, 5);

        Button button2 = new Button("2");
        button2.setMinSize(40, 40);
        grid.add(button2, 1, 5);

        Button button3 = new Button("3");
        button3.setMinSize(40, 40);
        grid.add(button3, 2, 5);

        Button button4 = new Button("4");
        button4.setMinSize(40, 40);
        grid.add(button4, 0, 4);

        Button button5 = new Button("5");
        button5.setMinSize(40, 40);
        grid.add(button5, 1, 4);

        Button button6 = new Button("6");
        button6.setMinSize(40, 40);
        grid.add(button6, 2, 4);

        Button button7 = new Button("7");
        button7.setMinSize(40, 40);
        grid.add(button7, 0, 3);

        Button button8 = new Button("8");
        button8.setMinSize(40, 40);
        grid.add(button8, 1, 3);

        Button button9 = new Button("9");
        button9.setMinSize(40, 40);
        grid.add(button9, 2, 3);

        Button button0 = new Button("0");
        button0.setMinSize(40, 40);
        grid.add(button0, 1, 6);

        Button calculate = new Button("=");
        calculate.setMinSize(40, 40);
        grid.add(calculate, 2, 6);

        Button add = new Button("+");
        add.setMinSize(40, 40);
        grid.add(add,3, 3);

        TextArea result = new TextArea();
        result.setEditable(false);
        result.setMaxWidth(150);
        result.setMaxHeight(50);
        hbox.getChildren().add(result);

        Separator separator = new Separator();
        grid.add(separator, 1, 0);

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    result.appendText("1");
                }
            });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
             public void handle(ActionEvent event) {
                    result.appendText("2");
                }
            });
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.appendText("3");
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.appendText("4");
            }
        });
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.appendText("5");
            }
        });
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.appendText("6");
            }
        });
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.appendText("7");
            }
        });
        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.appendText("8");
            }
        });
        button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.appendText("9");
            }
        });
        button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.appendText("0");
            }
        });

        all.getChildren().addAll(hbox, grid);
        scene = new Scene(all, 800, 600);
        grid.setPadding(new Insets(30, 30, 30, 30));
        hbox.setPadding(new Insets(100, 0, 0, 0));
        window.setScene(scene);
        window.show();
    }
}