package Test1;

public class Main {

	public static void main(String[] args) {
		
		Car car = new Car(); //objects
		Bike bike = new Bike();
		Boat boat = new Boat();
		
		Vehicle [] racers = {car,bike,boat}; // array
		
//		car.go();
//		bike.go();
//		boat.go();
//		
		for(Vehicle x : racers) {
			x.go();
		}

	}

}
