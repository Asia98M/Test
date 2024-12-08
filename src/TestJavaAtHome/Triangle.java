package TestJavaAtHome;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter an interger smaller than 80");
		int n = scan.nextInt();
		scan.close();
		char star = '*';
		for (int k = 1; k<=n; k++) {
			for (int i = 1; i<=k; i++); {
				System.out.println(star);
			}
			System.out.println();
		}

	}

}
