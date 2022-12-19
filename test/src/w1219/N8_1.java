package w1219;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.print.DocFlavor.URL;

public class N8_1 {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		// 사용자가 map.txt 에 입력한 값을

		int[][] map;
		char[][] board;
		String path = "res/map.txt";
		
		
		map = createMap("res/map.txt");
	

		// board size설정

		System.out.println("board 사이즈를 몇 배로 할지 입력하세요  o배 >");

		int m = scan.nextInt(); // m은 board가 map의 몇 배가 될지 입력받는 변수
		
		int bY =m * map.length; int bX = m * map[0].length;
		board = new char[bY][bX];
		
		
		
		
		//map배열에 데이터 담기
		transStrToInt2D(map, path);

		

		// 똑바로 넣었는지 확인
		print(map);

		System.out.println("변경하고 싶은 숫자와 모양을 입력하세요");
		System.out.println("숫자>");
		int number = scan.nextInt();
		System.out.println("모양1>");
		char shape = scan.next().charAt(0);
		System.out.println("모양2>");
		char shape2 = scan.next().charAt(0);
		
		scan.close();

	

//		makeShape(int[][] map, char[][] board, int num,int multi,  char shap1, char shap2)
//      num, shap1 : map에서 어떤 숫자를 shap1으로 변경할지,  shap2 : 그외 숫자는 무슨 모양 할지
//      multi : board를 map의 몇 배로 할지
		makeShape(map, board, number, m, shape, shape2);
		
		print(board);

// 출력
//		printBoard(board);
	} // main 끝

	private static int[][]  createMap(String path) throws Exception {
		
		FileInputStream fis = new FileInputStream(path);
		Scanner sc = new Scanner(fis);

//		System.out.println(mX);
		int count = 0; // map 의 y축을 알아내기 위한 변수
		String tmp = "";
		while (sc.hasNextLine()) {
			++count;
			tmp = sc.nextLine();
		}
		int mX = tmp.length();
		int mY = count; // map의 Y축 길이
		int[][] map = new int[mY][mX];	
		
		return map;
	}

	public static void makeShape(int[][] map, char[][] board, int num, int multi, char shap1, char shap2) {
		for (int j = 0; j < map.length; j++) {
			for (int i = 0; i < map[j].length; i++) {
				int by = multi * j;
				int bx = multi * i;
//				char tl = '┌';
//				char tr = '┐';
//				char bl = '└';
//				char br = '┘';
//				char shape1 = shap1;
//				char shape2 = shap2;
				if (map[j][i] == num) {
					for (int k = 0; k < multi; k++) { //
						for (int t = 0; t < multi; t++) {
							board[by + k][bx + t] = shap1; // 보드사이즈 떄문에 에러!
						}
					}

				} else {
					for (int k = 0; k < multi; k++) {
						for (int t = 0; t < multi; t++) {
							board[by + k][bx + t] = shap2;
						}
					}	
				}
			}
		}
	}
	
	
	private static void transStrToInt2D( int[][] map, String path) throws Exception { //reference라서 굳이 return안해도됨
		
		String[] tmpArr = new String[map.length];
		
		FileInputStream fis = new FileInputStream(path);
		Scanner scan = new Scanner(fis);
		
		for(int i=0; i<tmpArr.length; i++) {
			tmpArr[i] = scan.nextLine();
		}
		
		for (int i = 0; i < tmpArr.length; i++) {
			for (int j = 0; j < tmpArr[i].length(); j++) {
				map[i][j] = (tmpArr[i].charAt(j)) - '0';
			}
		}
		System.out.println("map 데이터 로드 완료");
	}

	// print( ) 메서드 하나로 만들고싶은데, 매개변수 타입이 달라서 별개로 생성하게됨 - 수정하려면?
	public static void print(int[][] map) {
		for (int j = 0; j < map.length; j++) {
			for (int i = 0; i < map[j].length; i++)
				System.out.print(map[j][i]);
			System.out.println();
		}
	}

	public static void print(char[][] board) {
		for (int j = 0; j < board.length; j++) {
			for (int i = 0; i < board[j].length; i++)
				System.out.print(board[j][i]);
			System.out.println();
		}
	}




}
