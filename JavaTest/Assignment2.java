
//import Assignment2.CountryHandlerClass.LoginHandlerClass;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Assignment2 extends Application {
    private String[] countries = { "Canada", "China", "Denmark",
            "France", "Germany", "India", "Norway", "United Kingdom",
            "United States of America" };

    private ComboBox<String> cbo = new ComboBox<>();

    private DescriptionPane descriptionPane = new DescriptionPane();

    Text usernameText = new Text(50, 50, "ff");

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        /*
         * Button btOK = new Button("OK");
         * Button btCancel = new Button("Cancel");
         * OKHandlerClass handler1 = new OKHandlerClass();
         * btOK.setOnAction(handler1);
         * CancelHandlerClass handler2 = new CancelHandlerClass();
         * btCancel.setOnAction(handler2);
         */
        // pane.getChildren().addAll(btOK, btCancel);

        Button btLogin = new Button("Login");
        LoginHandlerClass handler3 = new LoginHandlerClass();
        CountryHandlerClass event = new CountryHandlerClass();
        btLogin.setOnAction(handler3);
        pane.getChildren().add(btLogin);

        BorderPane borderpane = new BorderPane();
        // Pane borderpane = new Pane();

        BorderPane paneForComboBox = new BorderPane();
        // Pane paneForComboBox = new Pane();
        paneForComboBox.setLeft(new Label("Select a country: "));
        paneForComboBox.setCenter(cbo);
        paneForComboBox.setRight(getSelectedValue);
        
        BorderPane paneForTextField = new BorderPane();
        // paneForComboBox.setBottom(event);
        borderpane.setTop(paneForComboBox);
        borderpane.setBottom(paneForTextField);
        borderpane.setCenter(btLogin);
        // borderpane.setBottom(event);
        cbo.setPrefWidth(400);
        cbo.setValue("");

        ObservableList<String> items = FXCollections.observableArrayList(countries);
        cbo.getItems().addAll(items); // Add items to combo box

        // Display the selected country
        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));
        cbo.setOnAction(event);
        paneForTextField.setPadding(new Insets(500, 500, 50, 50));
        paneForTextField.setStyle("-fx-border-color: green");
        paneForTextField.setLeft(new Label("Enter a username: "));

        TextField usernameField = new TextField();
        usernameField.setAlignment(Pos.BOTTOM_LEFT);
        paneForTextField.setCenter(usernameField);

        usernameField.setOnAction(e -> usernameText.setText(usernameField.getText()));
        
        StackPane rootPane = new StackPane();
        // Create a scene and place it in the stage
        Scene scene = new Scene(rootPane);
        rootPane.getChildren().addAll(/* pane, */ borderpane);
        primaryStage.setTitle("Login Page"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }

    /* label for default text */
    Label getSelectedValue = new Label("No country selected yet!");

    /* Event handler for getting selected country */
    class CountryHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            getSelectedValue.setText("You have selected \"" + cbo.getValue());
        }
    }

    Label getLoginValue = new Label("testests");

    /** Set display information on the description pane */
    public void setDisplay(int index) {
        descriptionPane.setTitle(countries[index]);
    }

/*     class LoginHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            //System.out.println("Ok byutton clicked");
            // System.out.println("Fortnite");
            //getLoginValue.setText("Submitted Successfully");
            if (usernameText.getText() != null /* && password.getValue() != null */) {
                System.out.println("Submitted Successfully");
                //System.out.println(usernameField.getText());
            }
            else if (username.get() == null)
            {
            System.out.println("Please enter a username");
            }
            else
            {
            System.out.println("Please enter a password");
             }
            
        }
    } */

    public class DescriptionPane extends BorderPane {
        /** Label for displaying an image and a title */
        private Label lblImageTitle = new Label();
        /** Text area for displaying text */
        private TextArea taDescription = new TextArea();

        public DescriptionPane() {
            // Center the icon and text and place the text under the icon
            lblImageTitle.setContentDisplay(ContentDisplay.TOP);
            lblImageTitle.setPrefSize(200, 100);

            // Set the font in the label and the text field
            lblImageTitle.setFont(new Font("SansSerif", 16));
            taDescription.setFont(new Font("Serif", 14));

            taDescription.setWrapText(true);
            taDescription.setEditable(false);

            // Create a scroll pane to hold the text area
            ScrollPane scrollPane = new ScrollPane(taDescription);

            // Place label and scroll pane in the border pane
            setLeft(lblImageTitle);
            setCenter(scrollPane);
            setPadding(new Insets(5, 5, 5, 5));
        }

        /** Set the title */
        public void setTitle(String title) {
            lblImageTitle.setText(title);
        }

        /** Set the image view */
        public void setImageView(ImageView icon) {
            lblImageTitle.setGraphic(icon);
        }

        /** Set the text description */
        public void setDescription(String text) {
            taDescription.setText(text);
        }
    }
}