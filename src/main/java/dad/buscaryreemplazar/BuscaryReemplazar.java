package dad.buscaryreemplazar;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscaryReemplazar extends Application {

    private TextField findText;
    private TextField remplaceText;
    private Label findLabel;
    private Label remplaceLabel;
    private Button findButton;
    private Button remplaceButton;
    private Button remplaceallButton;
    private Button closeButton;
    private Button helpbutton;
    private RadioButton togglecaps;
    private RadioButton regular;
    private RadioButton findback;
    private RadioButton standup;


    @Override
    public void start(Stage primaryStage) throws Exception {

        findText = new TextField();
        remplaceText = new TextField();
        findLabel = new Label("Buscar: ");
        remplaceLabel = new Label("Reemplazar con: ");

        findButton = new Button("Buscar");
        findButton.setPrefWidth(120);
        remplaceButton = new Button("Reemplazar");
        remplaceButton.setPrefWidth(120);
        remplaceallButton = new Button("Reemplazar todo");
        remplaceallButton.setPrefWidth(120);
        closeButton = new Button("Cerrar");
        closeButton.setPrefWidth(120);
        helpbutton = new Button("Ayuda");
        helpbutton.setPrefWidth(120);

        togglecaps = new RadioButton("Mayúsculas y minúsculas");
        regular = new RadioButton("Expresión regular");
        findback = new RadioButton("Buscar hacia atrás");
        standup = new RadioButton("Resaltar resultados");

        ToggleGroup radiobuttons = new ToggleGroup();
        radiobuttons.getToggles().addAll(togglecaps,findback,regular,standup);

        GridPane buttons = new GridPane();
        buttons.addRow(0, togglecaps, findback);
        buttons.addRow(1, regular, standup);
        buttons.setVgap(5);

        ColumnConstraints[] constraintButtons = {
                new ColumnConstraints(), new ColumnConstraints()
        };
        constraintButtons[0].setHgrow(Priority.ALWAYS);
        constraintButtons[1].setHgrow(Priority.ALWAYS);

        buttons.getColumnConstraints().setAll(constraintButtons);

        VBox rightButtons = new VBox();
        rightButtons.getChildren().addAll( remplaceallButton,closeButton,helpbutton);
        rightButtons.setSpacing(5);

        GridPane root = new GridPane();
        root.setGridLinesVisible(false);
        root.setVgap(5);
        root.setHgap(5);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(5));
        root.addRow(0, findLabel, findText,findButton);
        root.setPadding(new Insets(5));
        root.addRow(1, remplaceLabel, remplaceText,remplaceButton);
        root.addRow(2, new Label(""), buttons, rightButtons);

        ColumnConstraints[] constraintView = {new ColumnConstraints(), new ColumnConstraints()};
        constraintView[0].setHalignment(HPos.LEFT);
        constraintView[1].setFillWidth(true);
        constraintView[1].setHgrow(Priority.ALWAYS);

        root.getColumnConstraints().setAll(constraintView);

        Scene scene = new Scene(root, 520, 230);

        primaryStage.setTitle("Buscar y reemplazar");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
