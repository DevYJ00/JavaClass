package w1219;

public class N9 {

	public static void main(String[] args) {
		/*
		 * 1. 다음 한문장을 반복해서 다음과 같은 출력이 가능하도록 하는 코드를 작성하시오. System.out.printf(“%c”, ‘┼’);
		 * 또는 System.out.printf(“%c”, ‘○’);
		 * 
		 * ○┼┼┼┼┼┼┼┼┼ ┼○┼┼┼┼┼┼┼┼ ┼┼○┼┼┼┼┼┼┼ ┼┼┼○┼┼┼┼┼┼ ┼┼┼┼○┼┼┼┼┼ ┼┼┼┼┼○┼┼┼┼ ┼┼┼┼┼┼○┼┼┼
		 * ┼┼┼┼┼┼┼○┼┼ ┼┼┼┼┼┼┼┼○┼ ┼┼┼┼┼┼┼┼┼○
		 */
		char[][] sh = new char[11][11];
		{
			// 보드생성
			for (int i = 0; i < sh.length; i++) {
				for (int j = 0; j < sh[i].length; j++) {
					sh[i][j] = '┼';
				}
			}
		}

		// 출력
		printBoard(sh);

		// 점 찍기
		for (int i = 0; i < sh.length; i++) {
			for (int j = 0; j < sh[i].length; j++)
				if (i == j)
					sh[i][j] = '○';
		}
		// 출력
		printBoard(sh);

		// 2번
		for (int i = 0; i < sh.length; i++) {
			for (int j = 0; j < sh[i].length; j++)
				if (j == 10 - i)
					sh[i][j] = '○';

		}
		printBoard(sh);
		
		
		//3번
//		(y>x) && (y>-x+10) y=i x=j
		for (int i = 0; i < sh.length; i++) {
			for (int j = 0; j < sh[i].length; j++)
				if((i>j)&&(i>-j+10))
					sh[i][j] = '○';

		}
		printBoard(sh);
		
		
	

	} // main 끝

	static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
		System.out.println("-----출력 완료-----");
	}

}
