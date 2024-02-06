import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

/*
 * Adriel Adasa
 * INFO2313 S13
 * Simily Joseph
 * date
 * Creates a log in page using JavaFX
 */

public class Login extends Application {

    // Creates the combobox for country
    private ComboBox<String> cbo = new ComboBox<>();
    private String[] countries = { "Canada", "China", "Denmark",
    "France", "Germany", "India", "Norway", "United Kingdom",
    "United States of America" };
    private Label countryLabel = new Label();

    // A string for the default message in the combobox
    String dMsg = "Select a country";
    // Creates the username field
    TextField userTextField = new TextField();
    // Creates the password field
    PasswordField pwBox = new PasswordField();
    // Creates the Text for the message
    final Text msg = new Text();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Sets the title of the stage
        primaryStage.setTitle("Login Page");
        // Creates the layout of the panes using gridpane
        GridPane grid = new GridPane();
        // Aligns the grid to be aligned to the center
        grid.setAlignment(Pos.CENTER);
        // Sets the horizontal and vertical gaps
        grid.setHgap(10);
        grid.setVgap(10);
        // Sets the padding
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Displays the login label
        Text scenetitle = new Text("Login Page");
        // Sets the font information
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        // Adds the countries array strings to the combobox
        ObservableList<String> items = FXCollections.observableArrayList(countries);
        // Add items to combo box
        cbo.getItems().addAll(items);
        // Display the selected country
        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));
        cbo.setPrefWidth(400);
        // A string for the default message in the combobox
        String dMsg = "Select a country";
        // Sets the value of the default option in the combobox to the default message
        cbo.setValue(dMsg);
        // Creates the display for the country section
        Label country = new Label("Country: ");
        // Adds the combobox and its label to the first 2 columns on row 1
        grid.add(country, 0, 1);
        grid.add(cbo, 1, 1);

        // Creates the label for the username section
        Label userName = new Label("Username:");
        grid.add(userName, 0, 2);

        grid.add(userTextField, 1, 2);
        userTextField.setText(null);

        // Creates the label for the password section
        Label pw = new Label("Password:");
        // Adds the label to the 0th column, 3rd row
        grid.add(pw, 0, 3);

        // Adds the password field to the 1st column, 3rd row
        grid.add(pwBox, 1, 3);
        pwBox.setText(null);

        // Creates the button for log in
        Button btn = new Button("Login");
        HBox hbBtn = new HBox(10);
        // Aligns the button to the bottom right
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        // Adds the button to the HBox
        hbBtn.getChildren().add(btn);
        // Adds the log in button to the 1st column, 5th row
        grid.add(hbBtn, 1, 5);


        // Adds the message to the 1st column, 6th row
        grid.add(msg, 1, 6);

        // Set the event that occurs when the log in button is clicked
        LoginHandlerClass loginHandler = new LoginHandlerClass();
        btn.setOnAction(loginHandler);

        // Alternate method to implement ActionEvent handler for the login button
        /* btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                // Sets the colour of the text 
                msg.setFill(Color.FIREBRICK);

                // The order of requirement priority is username -> password -> country
                // Displays success message when requirements are met
                if(userTextField.getText() != null && pwBox.getText() != null && cbo.getValue() != dMsg)
                {
                    msg.setText("Submitted Successfully");
                }
                // If no username is entered then display a message
                // First in priority so if this is not met then the other messages do not matter yet
                else if(userTextField.getText() == null)
                {
                    msg.setText("Please enter a username");
                }
                // If not password is entered then display a message
                // Can only reach here if the username is not filled
                // Higher priority than country so this message will display first
                else if(pwBox.getText() == null)
                {
                    msg.setText("Please enter a password");
                }
                // If a country is not selected then display a message
                // If the other requirements are met but the combobox value is defualt message
                // then logically only the country requirement is not met 
                else
                {
                    msg.setText("Please select a country");
                }
            }
        }); */
        
        // Sets the grid to the scene
        Scene scene = new Scene(grid, 300, 275);
        // Places the scene in the stage
        primaryStage.setScene(scene);
        // Displays the stage
        primaryStage.show();
    }

    // Handler class for the login button
    class LoginHandlerClass implements EventHandler<ActionEvent>
    {
    @Override
    public void handle(ActionEvent e)
        {
            // Sets the colour of the text 
            msg.setFill(Color.FIREBRICK);

            // The order of requirement priority is username -> password -> country
            // Displays success message when requirements are met
            if(userTextField.getText() != null && pwBox.getText() != null && cbo.getValue() != dMsg)
            {
                msg.setText("Submitted Successfully");
            }
            // If no username is entered then display a message
            // First in priority so if this is not met then the other messages do not matter yet
            else if(userTextField.getText() == null)
            {
                msg.setText("Please enter a username");
            }
            // If not password is entered then display a message
            // Can only reach here if the username is not filled
            // Higher priority than country so this message will display first
            else if(pwBox.getText() == null)
            {
                msg.setText("Please enter a password");
            }
            // If a country is not selected then display a message
            // If the other requirements are met but the combobox value is defualt message
            // then logically only the country requirement is not met 
            else
            {
                msg.setText("Please select a country");
            }
        }
    }
    //Set display information on the combobox pane
    public void setDisplay(int index) 
    {
        countryLabel.setText(countries[index]);
    }
}