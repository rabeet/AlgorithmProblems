package LeetCode;
import java.util.Arrays;

public class Prob186_ReverseWordsInAStringII {

	
	public static void main (String[] args) {
		char[] c = {'h','i', ' ','m','y', ' ', 'n','a',' ', 'y','o'};
		reverseWords(c);
		System.out.println(Arrays.toString(c));
	}
	
	public static void reverseWords(char[] s) {
        // find the number of words
        // shift a  word from the start to the end until the counter reaches the number of words
        // the skie is blue --> skiethee
        
        // 3 phase approach:
        // 1. reverse the whole sentence
        reverse(s, 0, s.length-1);
        // 2. reverse each word
        
        // the word hi --> ih word eht
        int end = s.length-1;
        for (int i = s.length-1; i>= 0; i--) {
            if (s[i] == ' ') {
                reverse(s, i+1, end);
                end = i-1;
            }
        }
        // 3. reverse the last word to allow for corner cases
        reverse(s, 0, end);
        
    }
	
	public static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = (char)temp;
            start++;
            end--;
        }
    }
}
