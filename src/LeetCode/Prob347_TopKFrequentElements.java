package LeetCode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

public class Prob347_TopKFrequentElements {
	
	public static void main(String[] args) {
		System.out.println(topKFrequent(new int[]{1,1,2,3,3,3}, 3));
		Object obj = new Object();
		System.out.println(obj.hashCode());
		Objects.hashCode(obj);
	}
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
		if ( k < 1 || nums == null || nums.length < 1)
			return null;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i : nums) {
			hm.put(i, hm.getOrDefault(i, 0)+1);
		}
		
		TreeMap<Integer, List<Integer>> sm = new TreeMap<Integer, List<Integer>>(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				Integer i1 = (Integer)o1;
				Integer i2 = (Integer)o2;
				return i2.compareTo(i1);
			}
			
		});
		for (int i : hm.keySet()) {
			int val = hm.get(i);
			if (sm.containsKey(val)) {
				List<Integer> list = sm.get(val);
				list.add(i);
				sm.put(val, list);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				sm.put(val, list);
			}
		}
		
		List<Integer> finalList = new ArrayList<Integer>();
		int count = 0;
		for (int i : sm.keySet()) {
			for (int j : sm.get(i)) {
				finalList.add(j);
				if (++count >= k)
					return finalList;
			}
		}
		return finalList;
	}
}
