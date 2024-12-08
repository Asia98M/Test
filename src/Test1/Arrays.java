package Test1;

public class Arrays {

	public static void main(String[] args) {
		
		int schrank [] = {1,2,3,4};
		
		System.out.println("Wer an Position 1: " + schrank[0]);
		
		int laenge = schrank.length;
		System.out.println(laenge);
		
		System.out.println("Wert an Position 4: " + schrank[3]);
		
		schrank[3]= 10;
		System.out.println("Wert an Position 4: " + schrank[3]);
		
		String [] array = new String [4];
		array [0] = "Hallo,";
		array[1]="du ";
		array[2] = "bist ";
		array [3] = "cool!";
		
		for (int i = 0; i<array.length; i++) {
			
			System.out.println(array[i] + " ");
		}

	}

}
