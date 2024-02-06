import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class ShowSelectedValueComboBox extends Application {
    @Override
    public void start(Stage stage) {
        /* set a title to screen */
        stage.setTitle("Country Names");
        /* Creating a combobox with default constructor */
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().add("India");
        comboBox.getItems().add("Newzealand");
        comboBox.getItems().add("Pakistan");
        comboBox.getItems().add("Australia");
        comboBox.getItems().add("Afghanistan");
        comboBox.getItems().add("South Africa");
        /* setting combo box property to editable */
        comboBox.setEditable(true);
        /* label for default text */
        Label getSelectedValue = new Label("No country selected yet!");
        /* Event handler for getting selected country */
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                getSelectedValue.setText("You selected \"" + comboBox.getValue() + "\" country");
            }
        };
        /* set action class to combo box */
        comboBox.setOnAction(event);
        /* Creating a tile pane for adding combobox and getSelectedValue */
        TilePane tilePane = new TilePane(comboBox, getSelectedValue);
        /* Creating a scene for adding tile pane */
        Scene scene = new Scene(tilePane, 300, 300);
        /* adding scene to stage */
        stage.setScene(scene);
        /* display scene for showing output */
        stage.show();
    }

    public static void main(String args[]) {
        /* launch method calls internally start() method */
        launch(args);
    }
}
