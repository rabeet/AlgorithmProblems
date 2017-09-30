package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob582_KillProcess {

	// HashMap + Depth First Search

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		List<Integer> ans = new ArrayList<Integer>();
		if (pid == null && ppid == null)
			return ans;
		if (pid.size() == 0)
			return ans;
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < ppid.size(); i++) {
			if (ppid.get(i) == 0)
				continue;
			List<Integer> list = map.getOrDefault(ppid.get(i), new ArrayList<Integer>());
			list.add(pid.get(i)); // add its current child to the ans list
			map.put(ppid.get(i), list);
		}
		addAll(ans, map, kill);
		return ans;
	}

	public void addAll(List<Integer> ans, Map<Integer, List<Integer>> map, int kill) {
		ans.add(kill);
		List<Integer> list = map.getOrDefault(kill, null);
		if (list == null)
			return;
		for (Integer in : list) {
			addAll(ans, map, in);
		}
	}

}
