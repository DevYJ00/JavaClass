package w1215;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class N6 {

	public static void main(String[] args) throws Exception {

		// 2. bitmap이라는 이름으로 10x20크기의 정수를 담을 수 있는 이차원 배열을 생성하시오.
		int[][] bitmap = new int[10][20];

		// 데이터 담기
		FileInputStream fis = new FileInputStream("res/bitmap.txt");
		Scanner sc = new Scanner(fis);

		// 문자열 배얼에 담은다음에 숫자로 변환
		String[] tmpArr = new String[10];

		for (int i = 0; i < tmpArr.length; i++) {
			tmpArr[i] = sc.nextLine();
		}

		// tmpArr[i] 가 한 덩이리의 String인 상황 - 하나씩 잘라서 char 배열에 담기
		// 헷갈리니까 tmpArr[0] 한 덩어리만 해보기 -> tmpArr만큼 돌려야 해(10개)
		char[][] tmpChar = new char[10][20];

		for (int j = 0; j < tmpArr.length; j++) {

			for (int i = 0; i < tmpChar[j].length; i++) {
				tmpChar[j][i] = tmpArr[j].charAt(i);
			}

		}

//		System.out.println(Arrays.deepToString(tmpChar));

		
		for (int j = 0; j < tmpChar.length; j++) {
			for (int i = 0; i < tmpChar[j].length; i++) {
				bitmap[j][i] = tmpChar[j][i] - '0'; // 문자0 -> 숫자0
			}
		}

//		System.out.println(Arrays.deepToString(bitmap));

		// 3. 다음 그림과 같은 모양이 되도록 값의 위치를 변경하시오
		for (int j = 0; j < 10; j++) {

			for (int i = 0; i < (20 / 2) - j; i++) {
				int tmp = bitmap[j][19 - i];
				bitmap[j][19 - i] = bitmap[j][i];
				bitmap[j][i] = tmp;
			}
		}

//		System.out.println(Arrays.deepToString(bitmap));

		// 4. res/bitmap-out.txt 파일로 bitmap 배열의 값들을 저장
		FileOutputStream fos = new FileOutputStream("res/bitmap-out.txt");
		PrintStream ps = new PrintStream(fos);

		for (int j = 0; j < bitmap.length; j++) {
			for (int i = 0; i < bitmap[j].length; i++)
				ps.print(bitmap[j][i]);

			ps.print("\n");
		}

	}

}
