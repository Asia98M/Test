package Test1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import javafx.scene.control.cell.PropertyValueFactory;

public class DishView {
	private Stage stage;

    protected TableView<DishModel> dishTableView;
    protected Button addButton, deleteButton, saveButton, quitButton, updateButton, submitButton, uploadImageButton;
    protected ImageView mainImageView;
    protected TextField caloriesField, nameField, descriptionField, originField;

    // Fields for the add/edit dish window
    protected TextField editNameField, editDescriptionField, editCaloriesField, editOriginField;
    protected ImageView editImageView;

	public DishView(Stage stage) {
		this.stage = stage;

		// Initialize buttons
		addButton = new Button("Add");
		deleteButton = new Button("Delete");
		saveButton = new Button("Save");
		updateButton = new Button("Update");
		quitButton = new Button("Quit");

		// Initialize TableView for Dish attributes
		dishTableView = new TableView<>();
		TableColumn<DishModel, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn<DishModel, String> descriptionColumn = new TableColumn<>("Description");
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		TableColumn<DishModel, Integer> caloriesColumn = new TableColumn<>("Calories");
		caloriesColumn.setCellValueFactory(new PropertyValueFactory<>("calories"));
		TableColumn<DishModel, String> originColumn = new TableColumn<>("Origin");
		originColumn.setCellValueFactory(new PropertyValueFactory<>("origin"));
		dishTableView.getColumns().addAll(nameColumn, descriptionColumn, caloriesColumn, originColumn);

		// Initialize ImageView for displaying the selected dish's image
		mainImageView = new ImageView();
		mainImageView.setFitWidth(300);
		mainImageView.setFitHeight(300);
		mainImageView.setPreserveRatio(true);

		// Layout organization for TableView and ImageView
		HBox contentBox = new HBox(20, dishTableView, mainImageView);
		contentBox.setAlignment(Pos.CENTER);
		contentBox.setPadding(new javafx.geometry.Insets(20));

		HBox buttonBox = new HBox(10, addButton, deleteButton, saveButton, updateButton, quitButton);
		buttonBox.setAlignment(Pos.CENTER);

		VBox mainLayout = new VBox(20, contentBox, buttonBox);
		mainLayout.setAlignment(Pos.CENTER);
		mainLayout.setPadding(new javafx.geometry.Insets(20));

		Scene scene = new Scene(mainLayout, 800, 500);
		stage.setScene(scene);
		stage.setTitle("Dish Manager");
		stage.show();
	}



	// Open a window to add or edit a dish
	public void openEditDishWindow(DishModel dish) {
		Stage editStage = new Stage();
		GridPane editLayout = new GridPane();
		editLayout.setAlignment(Pos.CENTER);
		editLayout.setHgap(10);
		editLayout.setVgap(10);

		// Form fields for editing a dish
		editNameField = new TextField(dish != null ? dish.getName() : "");
		editDescriptionField = new TextField(dish != null ? dish.getDescription() : "");
		editCaloriesField = new TextField(dish != null ? Integer.toString(dish.getCalories()) : "");
		editOriginField = new TextField(dish != null ? dish.getOrigin() : "");
		editImageView = new ImageView(dish != null && dish.getImagePath() != null ? new Image("file:" + dish.getImagePath()) : null);
		editImageView.setFitWidth(150);
		editImageView.setFitHeight(150);

		uploadImageButton = new Button("Upload Image");

		submitButton = new Button("Submit");

		// Add elements to layout
		editLayout.add(new Label("Name:"), 0, 0);
		editLayout.add(editNameField, 1, 0);
		editLayout.add(new Label("Description:"), 0, 1);
		editLayout.add(editDescriptionField, 1, 1);
		editLayout.add(new Label("Calories:"), 0, 2);
		editLayout.add(editCaloriesField, 1, 2);
		editLayout.add(new Label("Origin:"), 0, 3);
		editLayout.add(editOriginField, 1, 3);
		editLayout.add(uploadImageButton, 0, 4);
		editLayout.add(editImageView, 1, 4);
		editLayout.add(submitButton, 1, 5);

		Scene editScene = new Scene(editLayout, 500, 500);
		editStage.setScene(editScene);
		editStage.setTitle(dish == null ? "Add New Dish" : "Edit Dish");
		editStage.show();

		// Upload Image button action
		uploadImageButton.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
					);
			File selectedFile = fileChooser.showOpenDialog(editStage);
			if (selectedFile != null) {
				editImageView.setImage(new Image(selectedFile.toURI().toString()));
				editImageView.setUserData(selectedFile.getAbsolutePath());
			}
		});
	}
}