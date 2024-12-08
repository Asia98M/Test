package Test1;

import java.io.*;
import java.util.ArrayList;

public class DishDAO {
    private static final String CSV_FILE = "resources/dishes.csv";

    public ArrayList<DishModel> loadDishes() {
        ArrayList<DishModel> dishes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 5) {
                    try {
                        String name = fields[0].trim();
                        String description = fields[1].trim();
                        int calories = Integer.parseInt(fields[2].trim()); // Remove spaces before parsing
                        String origin = fields[3].trim();
                        String imagePath = fields[4].trim();

                        dishes.add(new DishModel(name, description, calories, origin, imagePath));
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing calories for line: " + line);
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dishes;
    }

    public void saveDishes(ArrayList<DishModel> dishes) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CSV_FILE))) {
            for (DishModel dish : dishes) {
                pw.println(dish.getName() + "," + dish.getDescription() + "," +
                        dish.getCalories() + "," + dish.getOrigin() + "," + dish.getImagePath());
            }
            System.out.println("Dishes saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
