package w1220;

public class Test {

	public static void main(String[] args) {

		char[][] canvas = new char[100][100];

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

			int x1 = 9;
			int y1 = 1;
			int x2 = 2;
			int y2 = 30;
//					drawLineOnCanvas(canvas,  x1, y1, x2, y2);
			drawLineOnCanvas(canvas, x1, y1, x2, y2);
			print(canvas);

		}

	}

	static private void drawLineOnCanvas(char[][] canvas, int x1, int y1, int x2, int y2) {
		int incli = 0;
		if (x1 > x2) { // ca.drawLine(3,1,1,3); x1=3 y1=1 x2=1 y2=3
			incli = (y2 - y1) / (x2 - x1); // (3-1)/(1-3) = -1
			for (int i = y1; i < y2; i++) { // for(int i=1, i<3; i++)
				for (int j = x2; j < x1; j++) { // for( int j=1; j<3; j++) {
					if (i - y1 == incli * (j - x1)) // if( i == -tmp)
						canvas[i - 1][j - 1] = '○';
				}
			}

		} else {
			incli = (y2 - y1) / (x2 - x1);
			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					if (i - y1 == incli * (j - x1))
						canvas[i - 1][j - 1] = '○';
				}
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
