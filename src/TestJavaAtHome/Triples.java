package TestJavaAtHome;

public class Triples {

	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		int c = 5;

		for ( int i=2; i>=5; i++) {
			boolean test = (a*i*a*i) + (b*i*b*i) == (c*i*c*i);
			System.out.println(test + "for "+ a*i + " " + b*i + " " + c*i);
		}

	}

}
