package Assignment2;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DishController {
	private final DishView view;
	private final ObservableList<DishModel> dishes;
	private final DishDAO dao;

	public DishController(DishView view) {
		this.view = view;
		this.dishes = FXCollections.observableArrayList();
		this.dao = new DishDAO();

		// Load dishes from CSV
		dishes.addAll(dao.loadDishes());
		view.dishTableView.setItems(dishes);

		// Set button actions
		view.addButton.setOnAction(this::handleAdd);
		view.deleteButton.setOnAction(this::handleDelete);
		view.saveButton.setOnAction(this::handleSave);
		view.updateButton.setOnAction(this::handleUpdate);
		view.quitButton.setOnAction(e -> handleQuit());

		// Add selection listener for TableView
		view.dishTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				showSelectedDish(newSelection);
			}
		});
	}

	private void showSelectedDish(DishModel dish) {
		if (dish != null) {
			// Set the image in the mainImageView when a dish is selected
			if (dish.getImagePath() != null && !dish.getImagePath().isEmpty()) {
				view.mainImageView.setImage(new javafx.scene.image.Image("file:" + dish.getImagePath()));
			} else {
				view.mainImageView.setImage(null);
			}
		} else {
			// Clear the image if no dish is selected
			view.mainImageView.setImage(null);
		}
	}



	private void handleAdd(ActionEvent event) {
		view.openEditDishWindow(null); // Open a new window for adding a dish
		view.submitButton.setOnAction(e -> addNewDish());
	}

	private void handleUpdate(ActionEvent event) {
		DishModel selectedDish = view.dishTableView.getSelectionModel().getSelectedItem();
		if (selectedDish == null) {
			showAlert("No dish selected", "Please select a dish to update.", Alert.AlertType.WARNING);
			return;
		}

		// Open a window for editing the selected dish
		view.openEditDishWindow(selectedDish);
		view.submitButton.setOnAction(e -> updateDish(selectedDish));
	}

	private void addNewDish() {
		try {
			String name = view.editNameField.getText();
			String description = view.editDescriptionField.getText();
			String origin = view.editOriginField.getText();
			int calories = Integer.parseInt(view.editCaloriesField.getText());
			String imagePath = (view.editImageView.getUserData() != null) ? view.editImageView.getUserData().toString() : "";

			if (name.isEmpty() || description.isEmpty() || origin.isEmpty() || imagePath.isEmpty()) {
				throw new IllegalArgumentException("All fields must be filled.");
			}

			// Create a new DishModel instance
			DishModel newDish = new DishModel(name, description, calories, origin, imagePath);
			dishes.add(newDish);
			view.dishTableView.refresh();

			// Close the "Add New Dish" window
			Stage stage = (Stage) view.submitButton.getScene().getWindow();
			stage.close();

		} catch (NumberFormatException e) {
			showAlert("Invalid Input", "Calories must be a number.", Alert.AlertType.ERROR);
		} catch (IllegalArgumentException e) {
			showAlert("Incomplete Data", e.getMessage(), Alert.AlertType.ERROR);
		}
	}


	private void updateDish(DishModel dish) {
		try {
			// Get the updated values or fallback to the original values if no new input
			String name = view.editNameField.getText().isEmpty() ? dish.getName() : view.editNameField.getText();
			String description = view.editDescriptionField.getText().isEmpty() ? dish.getDescription() : view.editDescriptionField.getText();
			String origin = view.editOriginField.getText().isEmpty() ? dish.getOrigin() : view.editOriginField.getText();
			String caloriesStr = view.editCaloriesField.getText();
			int calories;

			// If calories field is not empty, parse it, otherwise keep the existing value
			if (caloriesStr.isEmpty()) {
				calories = dish.getCalories();
			} else {
				calories = Integer.parseInt(caloriesStr); // This can throw NumberFormatException
			}

			// Get the updated image path or use the existing one if not updated
			String imagePath = (view.editImageView.getUserData() != null) ? view.editImageView.getUserData().toString() : dish.getImagePath();

			// Validate that the required fields are filled in
			if (name.isEmpty() || description.isEmpty() || origin.isEmpty()) {
				throw new IllegalArgumentException("All fields must be filled.");
			}

			// Update dish details
			dish.setName(name);
			dish.setDescription(description);
			dish.setCalories(calories);
			dish.setOrigin(origin);
			dish.setImagePath(imagePath);

			System.out.println("Updated Dish: " + dish);
			view.dishTableView.refresh(); // Refresh the table to show the updated values

			// Close the update window
			Stage stage = (Stage) view.submitButton.getScene().getWindow();
			stage.close();

		} catch (NumberFormatException e) {
			showAlert("Invalid Input", "Calories must be a number.", Alert.AlertType.ERROR);
		} catch (IllegalArgumentException e) {
			showAlert("Incomplete Data", e.getMessage(), Alert.AlertType.ERROR);
		}
	}


	private void handleDelete(ActionEvent event) {
		DishModel selectedDish = view.dishTableView.getSelectionModel().getSelectedItem();
		if (selectedDish != null) {
			dishes.remove(selectedDish);
			view.mainImageView.setImage(null);  // Clear the image when a dish is deleted
		} else {
			showAlert("No dish selected", "Please select a dish to delete.", Alert.AlertType.WARNING);
		}
	}

	private void handleSave(ActionEvent event) {
		dao.saveDishes(new ArrayList<>(dishes));
		showAlert("Save Successful", "Dishes have been saved successfully.", Alert.AlertType.INFORMATION);
	}

	private void handleQuit() {
		Stage stage = (Stage) view.quitButton.getScene().getWindow();
		stage.close();
	}

	private void showAlert(String title, String message, Alert.AlertType type) {
		Alert alert = new Alert(type, message, ButtonType.OK);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.showAndWait();
	}
}
