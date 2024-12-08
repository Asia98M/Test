package TestJavaAtHome;

public class IfElse {

	public static void main(String[] args) {
		int temperature;
		
		temperature = 9;
		
		if (temperature >= 25) {
			System.out.println("Get ice cream");
		} else if(temperature == 30) {
			System.out.println("Go swimming");
		} else {
			System.out.println("Why is it so cold");
		}
	}

}
