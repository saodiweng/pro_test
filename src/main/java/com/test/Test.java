package com.test;

/**考点：一.高效的实现方式，
 * 			测一：1.可以用拟二进制(三进制、五进制)加移位实现；【貌似复杂化了】
 * 				 2.可以用mod；
 * 			测二：1.可以用String的按位截取，是否等于3或5；
 * 				 2.可以先mod，再除以10*n，取到每一位。
	       二.高效的代码实现(逻辑精准——正确、可读性强【注解、常见编写技巧】、无冗余代码、整洁【封装】、扩展性强【设计原则】)。
	       三.代码自测环节(正确性、性能)*/
public class Test {
	
	public static final int RES_FIZZ_3 = 3;
	public static final int RES_BUZZ_5 = 5;
	public static final int RES_FB_35 = 35;
	
	public static void main(String[] args) {
		for (int i = 1; i < 101; i++) {
//			testOneImple(i);
//			testTwoImple1(i);
			testTwoImple2(i);
		}
	}
	
	public static void printConsolTool(int flag) {
		switch (flag) {
		case RES_FIZZ_3:
			System.out.println("Fizz");
			break;
		case RES_BUZZ_5:
			System.out.println("Buzz");
			break;
		case RES_FB_35:
			System.out.println("FizzBuzz");
			break;
		default:
			System.out.println(flag);
			break;
		}
	}
	
	// the test 1 implements style
	public static void testOneImple(int data) {
		if (0==data%3 && 0==data%5) {
			printConsolTool(RES_FB_35);
		} else if (0==data%3) {
			printConsolTool(RES_FIZZ_3);
		} else if (0==data%5) {
			printConsolTool(RES_BUZZ_5);
		} else {
			printConsolTool(data);
		}
	}
	
	// the test 2 implements style 1,this style's performance is low
	public static void testTwoImple1(int data) {
		String targetData = data + "";
		int cnData = targetData.length();
		int flag_3 = 0;
		int flag_5 = 0;
		for (int i = 0; i < cnData; i++) {
			if (RES_FIZZ_3 == Integer.valueOf(targetData.charAt(i)+"")) {
				flag_3 = RES_FIZZ_3;
			}
			if (RES_BUZZ_5 == Integer.valueOf(targetData.charAt(i)+"")) {
				flag_5 = RES_BUZZ_5;
			}
		}
		if ((0==data%3 && 0==data%5) || (flag_3==RES_FIZZ_3 && flag_5 == RES_BUZZ_5)) {	
			//TODO
			//this place have business require problem,I should to ask the business agent about this problem. --> 
			//(0==data%3 || flag_3==RES_FIZZ_3) && (0==data%5 || flag_5 == RES_BUZZ_5)
			printConsolTool(RES_FB_35);
		} else if (0==data%3 || flag_3==RES_FIZZ_3) {
			printConsolTool(RES_FIZZ_3);
		} else if (0==data%5 || flag_5==RES_BUZZ_5) {
			printConsolTool(RES_BUZZ_5);
		} else {
			printConsolTool(data);
		}
	}
	
	// the test 2 implements style 2,this style's performance is higher than style 1
	public static void testTwoImple2(int data) {
		if (31 == data) {
			System.out.println(111111);
		}
		String targetData = data + "";
		int cnData = targetData.length();
		int containData = data;
		int flag_3 = 0;
		int flag_5 = 0;
		for (int i = cnData; i > 0; i--) {
			if (1 == i) {
				containData = data%(int)Math.pow(10, i);
			} else {
				containData = (data%(int)Math.pow(10, i))/(int)Math.pow(10, i-1);
			}
			if (RES_FIZZ_3 == containData) {
				flag_3 = RES_FIZZ_3;
			}
			if (RES_BUZZ_5 == containData) {
				flag_5 = RES_BUZZ_5;
			}
		}
		if ((0==data%3 && 0==data%5) || (flag_3==RES_FIZZ_3 && flag_5 == RES_BUZZ_5)) {	
			//TODO
			//this place have business require problem,I should to ask the business agent about this problem. --> 
			//(0==data%3 || flag_3==RES_FIZZ_3) && (0==data%5 || flag_5 == RES_BUZZ_5)
			printConsolTool(RES_FB_35);
		} else if (0==data%3 || flag_3==RES_FIZZ_3) {
			printConsolTool(RES_FIZZ_3);
		} else if (0==data%5 || flag_5==RES_BUZZ_5) {
			printConsolTool(RES_BUZZ_5);
		} else {
			printConsolTool(data);
		}
	}
	
}
