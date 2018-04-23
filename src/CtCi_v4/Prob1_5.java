package CtCi_v4;

public class Prob1_5 {

	/*
	 * 1.5: Write a method to replace all spaces in a string with %20
	 * Each 'space' or a space block?
	 * if it is each space then just use string.replace(' ', '%20')
	 * otherwise we can use regex 
	 */

	public static void main(String[] args) {
		System.out.println(replaceSpaces("s  s s"));
		System.out.println(replaceSpaceBlock("s  s s"));
	}
	
	public static String replaceSpaces(String s) {
		s = s.replace(" ", "%20");
		return s;
	}
	
	public static String replaceSpaceBlock(String s) {
		s = s.replaceAll("[\\s]+", "%20");
		return s;
	}

}
