package Other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WordCountEngine {
	static String[][] wordCountEngine(String document) throws Exception {
		// clear whitespace
		document = document.trim();
		String[] words = document.split("[\\s]+");
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			word = formatWord(word);
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		Set<String> set = map.keySet();
		Map<Integer, List<String>> tmap = new TreeMap<Integer, List<String>>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for (String key : set) {
			Integer val = map.get(key);
			List<String> list = tmap.getOrDefault(val, new ArrayList<>());
			list.add(key);
			tmap.put(val, list);
		}

		String[][] ans = new String[set.size()][2];

		Set<Integer> tset = tmap.keySet();
		int ind = 0;
		for (Integer key : tset) {
			List<String> list = tmap.get(key);
			for (String word : list) {
				ans[ind][0] = word;
				ans[ind][1] = "" + key;
				ind++;
			}
		}

		return ans;
	}

	static String formatWord(String word) {
		word = word.toLowerCase();
		word = word.replaceAll("[^a-z]", "");
		return word;
	}

	public static void main(String[] args) throws Exception {
		String[][] wordcount = wordCountEngine("Practice makes perfect. you'll only   get Perfect by practice. just practice!");
		for (String[] s : wordcount) {
			System.out.println(Arrays.toString(s));
		}
	}

}
