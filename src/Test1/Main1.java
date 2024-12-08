package Test1;

public class Main1 {

	public static void main(String[] args) {
		
		Car1 car1 = new Car1(); //objects
		Bike1 bike1 = new Bike1();
		
		Vehicals1 [] racers = {car1, bike1};
		for (Vehicals1 x : racers) {
			x.go(); // methods
			
		}
		
		
	}

}
