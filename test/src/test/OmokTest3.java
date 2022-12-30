package test;

import java.util.Scanner;

public class OmokTest3 {

	public static void main(String[] args) {

		// 오목판(보드) 100개의 문자를 담을 수 있는 배열
		char[][] board = new char[10][10];

		// 오목판 생성하기
		// 1. 덮어씌우는 방식
		/*
		 * for (int y = 1; y <= 10; y++) { for (int x = 1; x <= 10; x++) board[y - 1][x
		 * - 1] = '┼';
		 * 
		 * }
		 * 
		 * for(int x=1; x<=10; x++) { board[0][x-1] = '┬'; board[9][x-1] = '┴'; }
		 * 
		 * for(int y=1; y<=10; y++) { board[y-1][0] = '├'; board[y-1][9] = '┤'; }
		 * 
		 * board[0][0] = '┌'; board[0][9] = '┐'; board[9][0] = '└'; board[9][9] = '┘';
		 * 
		 * 
		 */
		// 1. else if 문으로 작성 가장 특이한 케이스들을 위쪽으로 올린다!
		{
			for (int y = 1; y <= 10; y++) {
				for (int x = 1; x <= 10; x++) {
					if (x == 1 && y == 1)
						board[y - 1][x - 1] = '┌';
					else if (x == 1 && y == 10)
						board[y - 1][x - 1] = '└';
					else if (x == 10 && y == 1)
						board[0][9] = '┐';
					else if (x == 10 && y == 10)
						board[9][9] = '┘';
					else if (y == 1)
						board[y - 1][x - 1] = '┬';
					else if (y == 10)
						board[y - 1][x - 1] = '┴';
					else if (x == 1)
						board[y - 1][x - 1] = '├';
					else if (x == 10)
						board[y - 1][x - 1] = '┤';
					else
						board[y - 1][x - 1] = '┼';

				}

			}
		}

		// 보드 출력하기
		{
			for (int y = 1; y <= 10; y++) {
				for (int x = 1; x <= 10; x++)
					System.out.printf("%c", board[y - 1][x - 1]);
				System.out.println();

			}
		}

		int ox = 0, oy = 0;
		// 사용자에게 좌표 입력받기
		{
			// 사용자로부터 다음 모양의 입력을 요청한다
			// (x,y) > 3 4 => nextInt() 2번 이용

			int count = 0; // 검은돌 흰돌 번갈아 사용하기 위한 변수
			int pers = 0; // 0이면 게임 진행, 1이면 종료
			boolean power = true;

			while (power) {

				Scanner scan = new Scanner(System.in);

//				int tmpX, tmpY; //어차피 임시로 잠깐 쓰는거니까 내부에?
				try {

					System.out.println("오목을 놓을 위치를 입력하세요(1~10) x >");
					int tmpX = scan.nextInt();
					System.out.println("오목을 놓을 위치를 입력하세요(1~10) y >");
					int tmpY = scan.nextInt();
					if ((tmpX > 0 && tmpX <= 10) && (tmpY > 0 && tmpY <= 10)) {

						if (board[tmpY - 1][tmpX - 1] == '●' || board[tmpY - 1][tmpX - 1] == '○') {
							System.out.println("이미 돌이 있습니다.");
							continue;
						}

						ox = tmpX;
						oy = tmpY;
					} else {
						System.out.println("1~10 숫자만 입력하세요");
						continue;
					}
				} catch (Exception e) {
					System.out.println("숫자만 입력가능합니다!!!");
					continue;
				}
				// while문에서 벗아날 방법을 해주지 않아서 에러?
//				System.out.println("종료하시겠습니까?");

				// finally는 예외발생 하나 안하나 실행 catch절 수행하고 finally도 수행
				// 출력문 - count를 출력문에서 올려줘야 정상출력만 ++
				{
					count++;
					if (count % 2 == 0)
						board[oy - 1][ox - 1] = '○';
					else
						board[oy - 1][ox - 1] = '●';

					for (int y = 1; y <= 10; y++) {
						for (int x = 1; x <= 10; x++)
							System.out.printf("%c", board[y - 1][x - 1]);
						System.out.println();
					}

				}
				System.out.println("카운트" + count);

				System.out.println("게임을 계속 진행하시겠습니까? (0.계속 진행 그 외.종료) >"); // boolean으로 활용하는게 더 좋을 것 같음 0
				pers = scan.nextInt();
				power = (pers == 0) ? true : false; // 삼항연산자
				System.out.println("종료합니다.");

			}

		}

	}
}
