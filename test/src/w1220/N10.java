package w1220;

public class N10 {

	public static void main(String[] args) {

		// 1. canvas라는 이름으로 문자 20x20개를 저장할 수 있는 배열 객체를 생성한다.
		char[][] canvas = new char[20][20];

		// 2. canvas 배열을 다음처럼 ‘┼’ 문자로 채우는 코드를 작성하시오.
		{
			for (int i = 0; i < canvas.length; i++) {
				for (int j = 0; j < canvas[i].length; j++)
					canvas[i][j] = '┼';
			}
			System.out.println("board 초기화 완료");
		}

		// 3. ‘○’ 문자를 이용해서 canvas에 선을 그리는 함수를 작성하시오.
		// 함수의 호출 예
		{

			int x1 = 2;
			int y1 = 2;
			int x2 = 13;
			int y2 = 13;
//			drawLineOnCanvas(canvas,  x1, y1, x2, y2);
			drawLineOnCanvas(canvas, x1, y1, x2, y2);
			print(canvas);

		}
	}

	// y=x 축을 따라 원을 그리는데, 시작값과 끝값 바운더리를 x1~y2이용
	static private void drawLineOnCanvas(char[][] canvas, int x1, int y1, int x2, int y2) {
		
		for (int i = y1; i < y2; i++) {
			for (int j = x1; j < x2; j++) {
				if (i==j) // i = y, j= x
					canvas[i - 1][j - 1] = '○'; // char[][] 배열은 (0,0)부터 시작이지만 3번 문제에서 x1.y1 잡을 때 좌표를 (1,1)부터 시작이라고 가정했기
												// 때문에 canvas[i-1][j-1] 로 좌표 보정.
			}
		}

	}

	static private void print(char[][] ch) {
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[i].length; j++)
				System.out.print(ch[i][j]);
			System.out.println();
		}
	}
}
