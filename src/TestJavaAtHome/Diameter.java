package TestJavaAtHome;

public class Diameter {

	public static void main(String[] args) {
		int diameter = 22;
		for (int side = 14; side<=18; side++) {
			boolean fits = (Math.sqrt(side*side*2) < 22);
			System.out.println(fits + " when side is " + side);
		}

	}

}
