package Assignment2;

public class DishModel {
    private String name;
    private String description;
    private int calories;
    private String origin;
    private String imagePath;  // Path to the image

    public DishModel(String name, String description, int calories, String origin, String imagePath) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.origin = origin;
        this.imagePath = imagePath;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getCalories() { return calories; }
    public void setCalories(int calories) { this.calories = calories; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    @Override
    public String toString() {
        return name;
    }
}
