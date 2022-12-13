package test;
import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		
		//ar1
		int[] ar1 = new int[5];
		ar1 = new int[7]; //ar1 이 새로운 배열을 참조하는것 가능
		
		
		
		//5개짜리 정수를 담을 수 있는 배열을 이끄는 3개
		int[][] ar2 = new int[3][5];
		//C++이면  new int[3][5] 통짜이고,  3*5*4byte
		//Java는 
		
		ar2 = new int[2][6]; //가능
		
		ar2[0] = new int[9]; //가능 길이가 달라져도 되네.
		ar2[1] = new int[5];
		/*
		 톱니형 배열 (2차배열이 이렇게도 가능하기때문에 톱니형이라 불름.  c++은 2차원이 딱 정해졌는데, 자바는 이런게 가능)
		 [0, 0, 0, 0, 0, 0, 0, 0, 0]
		 [0, 0, 0, 0, 0]	
		 
		 
		 */
		
		//이것도 가능
		int[][] ar3 = new int[3][]; //위에처럼 데이터값을 나중에 넣을거라면, 이렇게 생성하는게 좋지
		
	}

}
