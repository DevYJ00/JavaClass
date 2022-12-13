package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class N1Ex {
	/*
	 * res/data.txt 파일에 다음처럼 빈 공백으로 구분 된 값들이 있다.
	 * 
	 * 20 30 29 39 49 38 10 19 87 29 38 27 8 90 87
	 * 
	 * 문제 1 : 이 값들의 개수를 구하는 코드를 작성하시오. int count = 0; { // 코드를 작성하는 공간
	 * 
	 * 
	 * } Sysout.out.printf(“count is %d\n”, count);
	 */
	public static void main(String[] args) throws Exception {
		{
			// 파일 출력
			FileOutputStream fos = new FileOutputStream("res/data2.txt");
			PrintStream out = new PrintStream(fos);
			out.print("20 30 29 39 49 38 10 19 87 29 38 27 8 90 87");
		}

		// 1번
		int count = 0;
		{
			FileInputStream fis = new FileInputStream("res/data2.txt");
			Scanner scan = new Scanner(fis);
			while (scan.hasNext()) {
				scan.nextInt(); // 비워주기, 자리이동
				count++;

			}
			System.out.printf("count is %d\n", count);

		}

		// 2.이 값들 중에서 가장 큰 값이 무엇인지 출력
		int max = -1;

		{
			FileInputStream fis = new FileInputStream("res/data2.txt");
			Scanner scan = new Scanner(fis);
			while (scan.hasNext()) {
				int tmp = scan.nextInt();
				if (tmp > max)
					max = tmp;

			}
			System.out.println("max " + max);
		}

		// 3. 이 값들 중에 10 을 찾아서 그 위치(인덱스 값)을 출력
		int index = 0;
		{
			FileInputStream fis = new FileInputStream("res/data2.txt");
			Scanner scan = new Scanner(fis);

			while (scan.hasNext()) {
				
				if (scan.nextInt() == 10)
					System.out.println(index);
				index++;
			}
		}
	}
}
