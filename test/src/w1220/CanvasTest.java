package w1220;

public class CanvasTest {

	public static void main(String[] args) {
		
		Canvas ca = new Canvas(); // Canvas인스턴스를 생성, 생성자에 의해 char[][] buf 생성
		
		//참조변수 buf를 통해 char[][] 배열을 다룰 수 있음
		
		//buf배열을 board판으로 만들어보면
		ca.drawBoard();
		ca.drawLine(50,2,3,4); // (30-1)/(6-100) 29/100 =0.3
		
		
		ca.print();
//		ca.drawLine(1,3,3,9);
//		ca.print();
//		
		
		
	}

}
