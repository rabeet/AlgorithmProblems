package MustDoQuestions.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllPermutations {

	public static void main(String[] args) {
		// Find all permutations of a given arraylist of ints
		List<Integer> list = Arrays.asList(new Integer[]{1,2,3});
		System.out.println(findPermutations(list));
	}
	
	public static List<List<Integer>> findPermutations(List<Integer> list) {
		List<List<Integer>> ans = new ArrayList();
		buildList(list, ans, new ArrayList<>());
		return ans;
	}
	
	static private void buildList(List<Integer> given, List<List<Integer>> ans, List<Integer> temp) {
		if (temp.size() == given.size()) {
			ans.add(new ArrayList(temp));
			return;
		}
		for (int i = 0; i < given.size(); i++) {
			if (temp.contains(given.get(i))) continue;
			temp.add(given.get(i));
			buildList(given, ans, temp);
			temp.remove(temp.size()-1); // backtrack
		}
	}

}