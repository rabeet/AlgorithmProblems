package Other;

import java.util.Calendar;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Practice {

	public static void main(String[] args) {
		
		int evennum = 2;
		System.out.println((evennum & 1) == 0);
		
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		
		Integer.valueOf(2);
		
		PriorityQueue<Integer> q = new PriorityQueue();
		q.offer(2);
		q.offer(5);
		q.offer(1);
		System.out.println(q.poll());
		Practice p = new Practice();
		
		boolean a = true;
		
		SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		});
		map.put(1, 2);
		map.put(2, 2);
		map.put(3, 2);
		map.put(0, 2);
		
		Set<Integer> s = map.keySet();
		for (Integer i : s) {
//			System.out.println(i);
		}
	}

}
