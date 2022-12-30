package w1215;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class N5 {

	public static void main(String[] args) throws Exception {
		// 1. res/alphabet.txt 파일을 생성하고 다음 데이터를 복사/붙여넣으시오.

		// 2. alphabet이라는 이름으로 문자 15개를 저장할 수 있는 배열 객체를 생성한다.
		char[] alphabet = new char[15];

		// 3. res/alphabet.txt 파일에 저장된 구분자가 없는 영문자 값들을 alphabet 배열에 로드한다.
		{
			FileInputStream fis = new FileInputStream("res/alphabet.txt");

			for (int i = 0; i < alphabet.length; i++)
				alphabet[i] = (char) fis.read();

			System.out.println("로드 완료");
			fis.close();
		}

//		 4. 배열의 값이 다음과 같은 상태가 되도록 자리를 바꾼다.
		
	
		{
			for (int j = 0; j < alphabet.length - 1; j++)
				for (int i = 0; i < alphabet.length - 1 - j; i++) {
					if (alphabet[i] < alphabet[i + 1]) {
						char tmp = alphabet[i + 1];
						alphabet[i + 1] = alphabet[i];
						alphabet[i] = tmp;
						
					}
				}

			System.out.println("자리변경 완료”");
		}
		
		//배열 값들에 -1 곱하기  - 뻘짓 - 유니코드값으로 97 ~ 111 까지임 -> 마이너스 곱
//		char num[] = {'a','b'};
//		System.out.println(Arrays.toString(num));
//		for(int n=0; n<num.length; n++) {
//			num[n] = (char) (num[n]*(-1)); //
//		}
		
		//abcdefghijklmn
		//￿nmlkjihgfedcba

		//방법3 
		for(int i=0; i<alphabet.length/2; i++) {
			char tmp = alphabet[14-i];
			alphabet[14-i] = alphabet[i];
			alphabet[i] = tmp;
		}
		System.out.println("자리변경 완료”");
			
		for(char k : alphabet) {
			System.out.print(k);
		}
		
		
		//방법4
		
		

		// 4. res/alphabet-out.txt 파일로 배열의 값들을 저장
//		File file  = new File("res/alphabet-out.txt"); //FileOutputStream 쓰는거지만 Stream겹치니까
//		PrintStream ps  = new PrintStream(file);
		FileOutputStream fos = new FileOutputStream("res/alphabet-out.txt");
		PrintStream ps = new PrintStream(fos);

		ps.print(alphabet); // print(char[] s)

		System.out.println("저장 완료");

	}

}
