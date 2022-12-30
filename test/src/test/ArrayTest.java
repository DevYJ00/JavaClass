package test;

import java.util.Random;

public class ArrayTest {

	public static void main(String[] args) {

		int[] nums = { 20, 5, 7, 98, 45, 7, 45, 2, 12, 47 };

		// 값 출력
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%d", nums[i]);
			if (i < nums.length - 1)
				System.out.print(',');
		}
		
		Random rand = new Random(); // Random은 처음보네
		
		
		int s = rand.nextInt(10); // 0~10(미포함) 수 반환
		int d = rand.nextInt(10); // 0~10(미포함) 수 반환
		// nums에서 [0]공간의 값과 [2]공간의 값 바꾸기 -> 랜덤하게 섞기 위해 0,2라는 특정값 대신 변수화
		
		int tmp;
		tmp = nums[s];
		nums[s] = nums[d];
		nums[d] = tmp;
		
		System.out.println();
		
		// 값 출력 - 파일로 하라고했나?
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%d", nums[i]);
			if (i < nums.length - 1)
				System.out.print(',');
		}
	}

}
