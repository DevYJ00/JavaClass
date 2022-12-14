package w1214;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class N4 {

	public static void main(String[] args) throws IOException {

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
			int tmp;
			Random rand = new Random();

			for (int i = 0; i < 50; i++) {
				int rNum1 = rand.nextInt(15); // 15제외
				int rNum2 = rand.nextInt(15);

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
		    
		    //스트림 : 직접 읽고 쓰는 기능(FileOutStream, FileInputStream)
		    //보조 스트림 : 직접 읽고 쓰는 기능은 없지만 보조적인 추가기능 제공(PrintStream)
		    //Scanner는 java.util 클래스! 유용한 기능 제공!
		}

	}

}
