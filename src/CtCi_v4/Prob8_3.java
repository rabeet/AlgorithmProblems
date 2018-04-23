package CtCi_v4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prob8_3 {

	/*
	 * 8.3: Generate all subsets of a set There are 2^n subsets of a set.
	 * Basically total subsequences +1 (indicating an empty set).
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		List<List<Integer>> alist = getPermutations(list, 0);
//		for (List l : alist) {
//			System.out.println(l.toString());
//		}
		
		List<List<Integer>> slist = getSubsets(list);
		for (List l : slist) {
			System.out.println(l.toString());
			
		}
		List<Integer> arl = new ArrayList<>();
		arl.add(2);
		arl.add(4);
		System.out.println(slist.contains(arl));
		
	}
	
	public static List<List<Integer>> getSubsets(List<Integer> list) {
		List<List<Integer>> ans = new ArrayList<>();
		subsetsBacktrack(ans, new ArrayList<>(), list, 0);
		return ans;
	}

	private static void subsetsBacktrack(List<List<Integer>> ans, ArrayList<Integer> tempList, List<Integer> given, int start) {
		if (tempList.size() == given.size()) {
			ans.add(new ArrayList<>(tempList)); // new because we need to make changes to this temp list
		}
		else {
			ans.add(new ArrayList<>(tempList));
			for (int i = start; i < given.size(); i++) {
				if (tempList.contains(given.get(i))) continue;
				tempList.add(given.get(i));
				subsetsBacktrack(ans, tempList, given, i+1);
				tempList.remove(tempList.size()-1);
			}
		}
	}

	public static List<List<Integer>> getPermutations(List<Integer> list, int index) {
		List<List<Integer>> ans = new ArrayList<>();
		permutationsBacktrack(ans, new ArrayList<>(), list);
		return ans;
	}

	private static void permutationsBacktrack(List<List<Integer>> ans, ArrayList<Integer> tempList, List<Integer> given) {
		if (tempList.size() == given.size()) {
//			System.out.println(tempList);
//			new Scanner(System.in).nextLine();
			ans.add(new ArrayList<>(tempList));
			return;
		}
		for (int i = 0; i < given.size(); i++) {
			if (tempList.contains(given.get(i))) continue;
			tempList.add(given.get(i));
//			System.out.println(tempList);
			permutationsBacktrack(ans, tempList, given);
//			new Scanner(System.in).nextLine();
			tempList.remove(tempList.size()-1);
//			System.out.println(tempList);
		}
	}

	// 1 2
	// 1, 2, 1 2
	// 1, 2, 3: 1, 2, 3, 12, 23, 13,
	// 1, 2, 3, 1 2, 2 3, 1 3, 1 2 3, ,
	public static ArrayList<Integer> getSubsets(List<Integer> mainList, int s, int e) {
		if (s > e)
			return null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (s <= e) {
			list.add(mainList.get(s));
			s++;
		}
		return list;
	}
	
	public static ArrayList<Integer> getSubsets(List<Integer> mainList, int s, int e, int b) {
		if (s > e)
			return null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (s <= e) {
			list.add(mainList.get(s));
			s++;
		}
		return list;
	}

}
