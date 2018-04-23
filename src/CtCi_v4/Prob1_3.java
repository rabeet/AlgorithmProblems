package CtCi_v4;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Prob1_3 {

	/*
	 * 1.3: Remove dupes in a string
	 * 
	 * how am i removing? doing in place or return a new char[]? If its a string
	 * it has to be a new string since string is an immutable object. Assuming
	 * i'm given a char arr.
	 * 
	 * charset? ASCII? utf-8?
	 * 
	 * one way would be to use a char to represent as a null char and loop
	 * through the array n^2 times and remove dupes by element and making the
	 * dupes as null char. O(n^2)
	 * 
	 * If it is 26 lowercase letters then we can use an integer as a bit holder.
	 * each 0 to 25th bit will represent a letter a-z. if we encounter it once
	 * we make it 1 otherwise leave it at 0. this way we can just delete them by
	 * replacing them with a null char of choice.
	 * 
	 * Test case would be to sort it and go through a pass to see if it has
	 * dupes.
	 * 
	 */

	public static void main(String[] args) {
		String str = "aaaccafffl";
		char[] arr = str.toCharArray();
		System.out.println(Arrays.toString(arr));
		removeDupes(arr);
		System.out.println(Arrays.toString(arr));
		List list = new ArrayList();
		
	}

	public static void removeDupes(char[] str) {
		if (str == null)
			return;
		if (str.length < 2)
			return;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 0)
				continue;
			for (int j = 0; j < str.length; j++) {
				if (i == j)
					continue;
				if (str[i] == str[j])
					str[j] = 0;
			}
		}

		int last_pos = 1;
		for (int i = 1; i < str.length; i++) {
			if (str[i] != 0) {
				str[last_pos++] = str[i];
				
				if (last_pos != i)
					str[i] = 0;
			}
		}
	}
}
