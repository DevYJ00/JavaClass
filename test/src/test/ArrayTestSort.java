package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayTestSort {

	public static void main(String[] args) throws Exception {

		// 1. nums라는 이름으로 정수 15개를 저장할 수 있는 배열 객체를 생성한다.
		int[] nums = new int[15];

		// 2. res/data.txt 파일에 저장된 값들을 nums 배열에 로드한다.
		{
			FileInputStream fis = new FileInputStream("res/data.txt");
			Scanner scan = new Scanner(fis);

			for (int i = 0; i < nums.length; i++) {
				nums[i] = scan.nextInt();
			}

			scan.close();
			fis.close();
			System.out.printf("로드 완료");
		}

		// 3. 0~14 범위의 랜덤값 2개를 얻어서 그 위치의 값을 서로 바꾼다. 그것을 50번 반복한다.
		{
			// 20 30 29 39 49 38 10 19 87 29 38 27 8 90 87
			Random rand = new Random();

			for (int i = 0; i < 50; i++) {
				int rNum1 = rand.nextInt(15); // 15제외
				int rNum2 = rand.nextInt(15);

				int tmp;
				tmp = nums[rNum1];
				nums[rNum1] = nums[rNum2];
				nums[rNum2] = tmp;

			}
			System.out.println("번호 섞기 완료");
		}

		// 4. res/data-out.txt 파일로 배열의 값들을 저장
		{
//			FileOutputStream fos = new FileOutputStream("res/dataSave.txt");
			File file = new File("res/dataSave.txt");
			PrintStream out = new PrintStream(file);

			for (int i = 0; i < nums.length; i++) {
				out.printf("%d ", nums[i]);
			}

			out.flush();
			out.close();
//			fos.close();

			System.out.println("저장 완료");
		}
		
		//기존 값
		for (int i : nums) 
			System.out.printf("%d ", i);
		System.out.println();

		// sort 하기
		int tmp;
		{
			// j는 제일 큰 번호 순서를 몇 번째까지 구할것인지의 반복
			for (int j = 0; j < 15 - 1; j++) { // j도 N-1 인게 맞는듯..(헷갈리) <=> 몇등까지 구할건가 같은 개념?
				for (int i = 0; i < (15 - 1)-j; i++) { // N-1개 : N개 명시해주고싶어서 이렇게 표현
					// 이기면 자리 바꾸고 지거나비기면 안바꿈
					// i가 i+1보다 큰 경우
					if (nums[i] > nums[i + 1]) {
						tmp = nums[i];
						nums[i] = nums[i + 1];
						nums[i + 1] = tmp;
					}
				}
//				for (int i : nums) 
//					System.out.printf("%d ", i);
//				System.out.println();
				
				
			}
		}
		

		 
		 
		 
		 
		
		for (int i : nums) {
			System.out.printf("%d ", i);
		}

	}

}
// 스트림 : 직접 읽고 쓰는 기능(FileOutStream, FileInputStream)
// 보조 스트림 : 직접 읽고 쓰는 기능은 없지만 보조적인 추가기능 제공(PrintStream)
// Scanner는 java.util 클래스! 유용한 기능 제공!