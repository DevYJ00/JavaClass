package w1219;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class N8 {
	
	static  Scanner scan = new Scanner(System.in); // main메서드가 static이라 static으로 선언해놔야 사용가능
	
	public static void main(String[] args) throws Exception {

		// 2. map이라는 이름으로 5x3 크기의 정수를 담을 수 있는 이차원 배열과 board라는 이름의
		// 10X6크기의 문자를 담을 수 있는 이차원 배열을 생성하시오.
		// 행렬로는 (3,5) (6, 10)
		
//		map 길이도 가변으로 잡고싶으면
		
		
		
		int[][] map = new int[3][5];
		
		
		
		//board size설정
//		Scanner scan = new Scanner(System.in);
		
		System.out.println("board 사이즈를 몇 배로 할지 입력하세요  o배 >");
		
		int m = scan.nextInt(); 
		scan.nextLine(); //한번씩 버려줘야 에러없음 (공백이라던가 이런거 버려주기)

		
		char[][] board = new char[3*m][5*m];

		{
			FileInputStream fis = new FileInputStream("res/map.txt");
			Scanner sc = new Scanner(fis);
			
			String str = sc.nextLine();
			str.length();
			
			
			
			
			

			String[] tmpArr = new String[map.length];
			
			//txt파일을 읽어오는 중간 과정,  String파일로 담는 과정(임시)
			readTxtByString(sc, tmpArr);
			
			//String[] 을 int[][]에 담는 과정
			transStrToInt2D(tmpArr, map);

			System.out.println("map 데이터 로드 완료");
			
			// 똑바로 넣었는지 확인
			print(map);
			
			sc.close();
			fis.close();

		}
		
//		makeShape(int[][] map, char[][] board, int num,int multi,  char shap1, char shap2)
//      num, shap1 : map에서 어떤 숫자를 shap1으로 변경할지,  shap2 : 그외 숫자는 무슨 모양 할지
//      multi : board를 map의 몇 배로 할지
		makeShape(map, board, 1,m, '▩' ,'○');
		
// 출력
		print(board);
	} //main 끝
	
	
	
	
	public static void makeShape(int[][] map, char[][] board, int num,int multi,  char shap1, char shap2) {
		for(int j=0; j<map.length; j++) {
			for(int i=0;i <map[j].length;i++) {
				int by = multi*j; int bx = multi*i;
				char tl = '┌'; char tr ='┐'; char bl = '└'; char br ='┘'; char shape1 = shap1;  char shape2 = shap2;
				if(map[j][i] == num) {
					for (int k = 0; k < multi; k++) { // 
						for (int t = 0; t < multi; t++) {
							board[by + k][bx + t] = shap1; //보드사이즈 떄문에 에러!
						}
					}
					
					
					
				} else {
					for (int k = 0; k < multi; k++) {
						for (int t = 0; t < multi; t++) {
							board[by + k][bx + t] =shap2;
						}
					}
				}
			}
		}
	}
	
	
	private static void transStrToInt2D(String[] tmpArr, int[][] map) {
		for(int i=0; i<tmpArr.length; i++) {
			for(int j=0; j<tmpArr[i].length(); j++) {
				map[i][j] = (tmpArr[i].charAt(j))-'0';
			}
		}
	}



	//print( ) 메서드 하나로 만들고싶은데, 매개변수 타입이 달라서 별개로 생성하게됨 - 수정하려면?
		public static void print(int[][] map) {
			for(int j=0; j<map.length; j++) {
				for(int i=0; i<map[j].length;i++)
					System.out.print(map[j][i]);
				System.out.println();
			}
		}
		
		public static void print(char[][] board) {
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
