package Test1;

import javafx.application.Application;
import javafx.stage.Stage;

public class A2_Marti_Saner_MCV extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        DishView view = new DishView(primaryStage);
        new DishController(view);
    }
}
