package TestJavaAtHome;

public class LargB {
	final static int WIDTH = 8;

	public static void upperPart() {
		for (int i=1; i<= WIDTH; i=i+2) {
			for (int k=1; k<=i; k++) {
				System.out.println("++");
			}
			System.out.println();
		}
	}

	public static void lowerPart() {
		for (int i = WIDTH;i>=1; i=i-2 ) {
			for (int k=1; k <=i; k++) {
				System.out.println("++");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		upperPart(); lowerPart(); upperPart(); lowerPart();


	}

}
