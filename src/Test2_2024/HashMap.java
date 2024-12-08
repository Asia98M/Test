package Test2_2024;

public class HashMap {

	public static void main(String[] args) {


		HashMap<String, Integer> fun = new HashMap<String, Integer>();
		fun.put("Asia98", 4554);
		fun.put("Asia100", 4600);
		fun.put("Asia3", 4500);

		fun.remove("Asia98");

		System.out.println(fun);

	}
}
