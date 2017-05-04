package com.demo.util;

public class Xom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ttReport";
		System.out.println(isAcronym(str));
	}

	public static boolean isAcronym(String word) {
		char first = word.charAt(0);
		char second= word.charAt(1);
		if (Character.isLowerCase(first)&&(Character.isUpperCase(second))) {
			return true;
		}
		return false;
	}
}
