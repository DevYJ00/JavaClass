package w1216;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class N7 {

	public static void main(String[] args) throws Exception {

		// 2. map이라는 이름으로 5x3 크기의 정수를 담을 수 있는 이차원 배열과 board라는 이름의
		// 10X6크기의 문자를 담을 수 있는 이차원 배열을 생성하시오.
		// 행렬로는 (3,5) (6, 10)
		int[][] map = new int[3][5];
		char[][] board = new char[6][10];

		// 3. res/map.txt에서 읽은 데이터로 map 배열을 채우시오.
		{
			FileInputStream fis = new FileInputStream("res/map.txt");
			Scanner sc = new Scanner(fis);

			String[] tmpArr = new String[map.length];

			for (int i = 0; i < tmpArr.length; i++) {
				tmpArr[i] = sc.nextLine();
			}

			// 한줄먼저~~~~ map[0][i] = String[0]
			for (int j = 0; j < map.length; j++) {
				for (int i = 0; i < map[j].length; i++) {
					map[j][i] = (tmpArr[j].charAt(i)) - '0';
				}
			}

			System.out.println("map 데이터 로드 완료");
			
			sc.close();
			fis.close();
			// 문자->숫자 말고 String-> int 바로 갈 방법 생각해보기
			// split쓰면 String[] 으로 반환해줌..이게 더 복잡하려나? - 이따 해보기
//			for(int i=0; i<map[0].length; i++) {
//				map[0][i] = Integer.parseInt(tmpArr[0].sp);
//			}

//		System.out.println(Arrays.deepToString(map));
		}

		//// 4. map 데이터 하나는 board 배열의 4칸과 대응되며 다음과 같은 모양으로 대응된다.
		/*
		 * 
		 * 
		 * map -> board 가로세로 2배씩이니까 -> 면적은 4배차이남
		 * 
		 * map에서 1-> board에서 이상한 모양으로 -> 시작과 끝 1간격으로 증가시켜주면 되려나? 00010 01010 00000
		 */
		{
			char tl = '┌';
			for (int j = 0; j < map.length; j++) {
				for (int i = 0; i < map[j].length; i++) {
					if (map[j][i] == 1) {
//						for (int m = 0; m < 2; m++) //여기 밑에서 어차피 4개를 출력해줘서  board 를 돌 필요가 없음!
//							for (int n = 0; n < 2; n++) 
						{
							board[2 * j][2 * i] = '▩';    //2j 변수명 잡아주는것도 깔끔할것같음 mx my이런식으로
							board[2 * j][2 * i + 1] = '▩';
							board[2 * j + 1][2 * i] = '▩';
							board[2 * j + 1][2 * i + 1] = '▩';
						}

					} else {
//						for (int m = 0; m < 2; m++)
//							for (int n = 0; n < 2; n++) 
						{
							board[2 * j][2 * i] = '┌';
							board[2 * j][2 * i + 1] = '┐';
							board[2 * j + 1][2 * i] = '└';
							board[2 * j + 1][2 * i + 1] = '┘';
						}
					}
				}
			}
		}
// 출력
		for (int m = 0; m < board.length; m++) {
			for (int n = 0; n < board[m].length; n++) {
				System.out.print(board[m][n]);
			}
			System.out.println();
		}
	}
}
