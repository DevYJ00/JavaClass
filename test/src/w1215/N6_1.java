package w1215;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class N6_1 {

	public static void main(String[] args) throws Exception {
		// 2. bitmap이라는 이름으로 10x20크기의 정수를 담을 수 있는 이차원 배열을 생성하시오.
		int[][] bitmap = new int[10][20];

		// 데이터 담기
		FileInputStream fis = new FileInputStream("res/bitmap.txt");
		Scanner scan = new Scanner(fis);

		String[] tmpString = new String[10];

		// 문자열로 받기
		for (int i = 0; i < tmpString.length; i++) {
			tmpString[i] = scan.nextLine();
		}

		// char[] 배열안거치고 바로 bitmap 배열에 넣기가능....
		for (int j = 0; j < tmpString.length; j++) { // 10
			for (int i = 0; i < bitmap[j].length; i++) // 20
				bitmap[j][i] = (tmpString[j].charAt(i)) - '0'; // charAt() -> char 반환
		}

		// bitmap[][] 넣은 데이터 출력
		for (int j = 0; j < bitmap.length; j++) {
			for (int i = 0; i < bitmap[j].length; i++)
				System.out.print(bitmap[j][i]);
			System.out.println();
		}

//		값의 위치를 변경
		for (int j = 0; j < bitmap.length; j++) {
			for (int i = 0; i < bitmap[j].length / 2 - j; i++) {
				int tmp = bitmap[j][i];
				bitmap[j][i] = bitmap[j][19 - i];
				bitmap[j][19 - i] = tmp;
			}

		}

		// bitmap[][] 넣은 데이터 출력
		for (int j = 0; j < bitmap.length; j++) {
			for (int i = 0; i < bitmap[j].length; i++)
				System.out.print(bitmap[j][i]);
			System.out.println();
		}

	}

}
