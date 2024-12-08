package TestJavaAtHome;

import java.util.Scanner;

public class Soundex {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter your word");
		String soundex = sc.nextLine();
		while (!soundex.equalsIgnoreCase("stop")) {
			String afterSoundex = soundex.replaceAll("[aeiouy]", "");
				System.out.println(soundex + " shortens to " + afterSoundex.toLowerCase());
			System.out.println("enter your word");
			soundex = sc.nextLine();
		}
		sc.close();
	}

}


