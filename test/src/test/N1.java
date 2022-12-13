package test;

import java.io.FileInputStream;
import java.util.Scanner;

public class N1 {

	public static void main(String[] args) throws Exception {
//20 30 29 39 49 38 10 19 87 29 38 27 8 90 87 

		// 파일 읽어오기
		FileInputStream fis = new FileInputStream("res/data.txt");

		Scanner scan = new Scanner(fis);
		scan.hasNext();
		// 1. 합이 600이라는걸 안다는 가정하에 한 방법.
		// 2. 이 값들 중에서 가장 큰 값이 무엇인지 출력하는 코드를 작성하시오.
		int tmpSum = 600; //

		int sum = 0;
		int count = 0;
		int max = -1;
		int index = -1;

		while (sum != tmpSum) {
			int num = scan.nextInt();
			sum += num;
			count++;

			if (num > max)
				max = num;
			
			if (num == 10) {
				index = count-1;
				System.out.printf("값이 10인 인덱스는 %d\n",index);
			}

		}
		System.out.printf("count is %d\n", count);
		System.out.printf("max is %d\n", max);

	}

}
