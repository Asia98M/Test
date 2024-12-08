package Test2_2024;

import java.util.Stack;

//push(T element): Adds an element to the top
//pop(): Removes and returns the top element
//peek(): Shows the top element without removing it from the stack
//isEmpty(): Checks if the stack is empty
//size(): Returns the number of elements

public class StackJava {
	public static void main(String [] args) 
//	{
//		
//		Stack<String> games = new Stack<String>();
//		
//		games.add("Call of Duty");
//		games.add("Hay Day");
//		games.add("Fortnite");
//		
//		System.out.println(games.peek()); 
//		System.out.println(games);
//		
//		System.out.println(games.pop()); 
//		System.out.println(games);
//		
//	}
{
		
		Stack<Character> tower = new Stack<Character>();
		
		// Y
		// B
		// R
		
		tower.add('R');
		tower.add('B');
		tower.add('Y');


		System.out.println(tower.get(0)); 
		System.out.println(tower);
		
		System.out.println(tower.size());
		System.out.println(tower);
		
		System.out.println(tower.set(1, 'P'));
		System.out.println(tower);
		
		System.out.println(tower.push('P'));
		System.out.println(tower);
		
		System.out.println(tower.pop()); 
		System.out.println(tower);
		
		System.out.println(tower.peek()); 
		System.out.println(tower);
	}

}
