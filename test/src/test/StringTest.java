package test;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		
		
		String s = "아이유";
		String s1 = "아이유";
		
		System.out.println(s==s1);  //true
		System.out.println(s.equals(s1)); //true
		
		String s2 = new String("아이유");
		
		System.out.println(s==s2);//false
		System.out.println(s.equals(s2)); //true
		
		String q = "1 ";
		String q1 = "1";
		System.out.println(q==q1); //false
		
	
	}

}
