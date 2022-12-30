package w1215;

import java.util.Random;

public class Selection {

	public static void main(String[] args) {

		Random ran = new Random();

		int[] num = new int[10];

		for (int i = 0; i < num.length; i++) {
			num[i] = ran.nextInt(50);
		}

		System.out.println("정렬 전");
		for (int k : num)
			System.out.printf("%d ", k);
		System.out.println();

		// 선택정렬 - 오름차순
		for (int i = 0; i < num.length - 1; i++) { // i번째가 최솟값이라 가정하고 픽스하는 회차
			int MinIndex = i;
			for (int j = i + 1; j < num.length; j++) { //비교되는 num[j]는 배열 끝까지 가야하니까 num.length
				if (num[MinIndex] > num[j]) // num[0] > num[j]
					MinIndex = j;
			}
			int tmp = num[MinIndex];
			num[MinIndex] = num[i];
			num[i] = tmp;

		}

		System.out.println("정렬 후");
		for (int k : num)
			System.out.printf("%d ", k);
	}

}
