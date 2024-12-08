package TestJavaAtHome;

public class Switch {

	public static void main(String[] args) {
		int temperature = 1;
		
		switch (temperature) {
		
		case 0: System.out.println("Das Bier is 0 Grad"); break;
		case 1: System.out.println("Das Bier is 1 Grad"); break;
		case 2: System.out.println("Das Bier is 2 Grad"); break;
		case 3: System.out.println("Das Bier is 3 Grad"); break;
		default: System.out.println("Das Bier ist zu warm"); break;
		}
	}

}
