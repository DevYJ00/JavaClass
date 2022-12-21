package w1221;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
	
		
		
		
		
//		Composition 방식
		Room room = new Room();
		
		room.load("res/students.csv");
		room.print();
		
		room.shuffle();
		room.print();
		
		room.sort();
		room.print();
		
	}

}
