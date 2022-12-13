package test;

import java.util.Scanner;

public class OmokTest3 {

	public static void main(String[] args) {

		// 오목판(보드) 100개의 문자를 담을 수 있는 배열
		char[][] board = new char[10][10];

		// 1차원 배열보단 2차원배열이 좋다는걸 배울 예정

		for (int y = 1; y <= 10; y++) {
			for (int x = 1; x <= 10; x++)
				board[y - 1][x - 1] = '┼';

		}

		// 윗판 마감

		for (int i = 1; i <= 10; i++) {

			board[0][i - 1] = '┬';

		}

		// 보드 출력하기
		{
			for (int y = 1; y <= 10; y++) {
				for (int x = 1; x <= 10; x++)
					System.out.printf("%c", board[y - 1][x - 1]);
				System.out.println();

			}
		}

		// 오목 입력하기

		{
			// 사용자로부터 다음 모양의 입력을 요청한다
			// (x,y) > 3 4 => nextInt() 2번 이용
			int ox, oy;
			int count = 0; // 검은돌 흰돌 번갈아 사용하기 위한 변수

			// 사용자 1, 2 구분 - 검은돌 흰돌 번갈아 출력.. -> while문 돌떄 count증가시켜서 홀짝으로

			while (true) {

				Scanner scan = new Scanner(System.in);

				int tmp;
				try {
					System.out.println("오목을 놓을 위치를 입력하세요 x >");
					tmp = scan.nextInt();
					if (tmp < 10)
						ox = tmp;
					else
						System.out.println("10미만의 숫자만 입력하세요.");
					continue;
				} catch (Exception e) {
					System.out.println("10미만의 숫자만 입력하세요.");
					continue;

				}

				try {
					System.out.println("오목을 놓을 위치를 입력하세요 y >");
					tmp = scan.nextInt();
					if (tmp < 10)
						oy = tmp;
					else 
						System.out.println("10미만의 숫자만 입력하세요.");
						
				}
				 catch (Exception e) {
					System.out.println("10미만의 숫자만 입력하세요.");
					continue;

				}

				
				count++;

				if (count % 2 == 0)
					board[oy - 1][ox - 1] = '○';
				else
					board[oy - 1][ox - 1] = '●';

				// 출력
				for (int y = 1; y <= 10; y++) {
					for (int x = 1; x <= 10; x++)
						System.out.printf("%c", board[y - 1][x - 1]);
					System.out.println();
				}

			
		}

		// 보드 출력하기

	}
}
