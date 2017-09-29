package Other;

import java.util.ArrayList;
import java.util.List;

public class Generate0s_And_1s {
	
	
	//https://sites.google.com/site/spaceofjameschen/home/string/generate-strings-with-a-specified-pattern----google

	public static void main(String[] args) {
		List<String> list = generatePatterns("101");
		System.out.println(list.toString());
	}
	
	// pattern: 11?11 --> 11011 and 11111
	public static List<String> generatePatterns(String pattern) {
		List<String> list = new ArrayList<String>();
		generatePatterns(pattern, list, 0, "");
		return list;
	}
	
	private static void generatePatterns(String pattern, List<String> list, int index, String generatedPattern) {
		if (index == pattern.length()) {
			list.add(generatedPattern);
			return;
		}
		if (pattern.charAt(index) == '?') {
			generatePatterns(pattern, list, index+1, generatedPattern+"0");
			generatePatterns(pattern, list, index+1, generatedPattern+"1");
		}
		else
			generatePatterns(pattern, list, index+1, generatedPattern+""+pattern.charAt(index));
	}

}