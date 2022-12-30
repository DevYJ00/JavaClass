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
			
			//String[] 배열에 한 줄씩 담기(임시)
			
			
//			txt파일에서 자주 읽어오니까, String[] 으로 불러오기 메서드		
//			for (int i = 0; i < tmpArr.length; i++) {
//				tmpArr[i] = sc.nextLine();
//			}
			readTxtByString(sc, tmpArr);
			
			

			// int[][] 배열에 담기 - 데이터 로드 완료
//			for (int j = 0; j < map.length; j++) {
//				for (int i = 0; i < map[j].length; i++) {
//					map[j][i] = (tmpArr[j].charAt(i)) - '0';
//				}
//			}
			transStrToInt2D(tmpArr, map);

			System.out.println("map 데이터 로드 완료");
			
			// 똑바로 넣었는지 확인
			printMap(map);
			
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
		char tl = '┌'; char tr ='┐'; char bl = '└'; char br ='┘'; char box = '▩';  
		
		{
			for (int j = 0; j < map.length; j++) {
				for (int i = 0; i < map[j].length; i++) {
					int by = 2 * j; int bx = 2 * i;
					if (map[j][i] == 1) {

							board[by][bx] = box; // 2j 변수명 잡아주는것도 깔끔할것같음 bx by이런식으로
							board[by][bx + 1] = box; //여기서 1은 num-1 인듯!
							board[by + 1][bx] = box;
							board[by + 1][bx + 1] = box;

					} else {
						
							board[by][bx] = tl;
							board[by][bx + 1] = tr;
							board[by+ 1][bx] = bl;
							board[by+ 1][bx + 1] = br;
					}
				}
			}
		}
		makeShape(map, board, num,size);
// 출력
		printBoard(board);
	}
	public static void makeShape(int[][] map, String[] board, int num,int multi) {
		for(int j=0; j<map.length; j++) {
			for(int i=0;i <map[j].length;j++) {
				
			}
		}
	}
	
	

	 static void transStrToInt2D(String[] tmpArr, int[][] map) {
		for(int i=0; i<tmpArr.length; i++) {
			for(int j=0; j<tmpArr[i].length(); j++) {
				map[i][j] = (tmpArr[i].charAt(j))-'0';
			}
		}
	}



	//print( ) 메서드 하나로 만들고싶은데, 매개변수 타입이 달라서 별개로 생성하게됨 - 수정하려면?
		public static void printMap(int[][] map) {
			for(int j=0; j<map.length; j++) {
				for(int i=0; i<map[j].length;i++)
					System.out.print(map[j][i]);
				System.out.println();
			}
		}
		
		public static void printBoard(char[][] board) {
			for(int j=0; j<board.length; j++) {
				for(int i=0; i<board[j].length;i++)
					System.out.print(board[j][i]);
				System.out.println();
			}
		}

		

		//txt파일 자료 불러다가 int[][] 자주 담으니까?
		public static void readTxtByString(Scanner sc, String[] strArr) {
			for(int i=0; i<strArr.length; i++) {
				strArr[i] = sc.nextLine();
			}
		}
		
	
}
