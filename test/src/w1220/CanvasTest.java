package w1220;

public class CanvasTest {

	public static void main(String[] args) {
		
		Canvas ca = new Canvas(); // Canvas인스턴스를 생성, 생성자에 의해 char[][] buf 생성
		
		//참조변수 buf를 통해 char[][] 배열을 다룰 수 있음
		
		//buf배열을 board판으로 만들어보면
		ca.drawBoard();
		//(5,2,2,3)
		ca.drawLine(40,2,2,30); // 기울기가 1미만일때는 int로 0이 되버리니까 -1로 보정한 예제
		
		
		ca.print();
//		ca.drawLine(1,3,3,9);
//		ca.print();
//		
		
		
	}

}
