package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Prob56_MergeIntervals {
	
	public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null ) return null;
        if (intervals.size() <= 1) return intervals;
        
        // sort phase
        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        
        // Answer list
        List<Interval> ans = new ArrayList<>();
       
        // merge phase
        Interval interval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            int n = intervals.get(i).end;
            if (interval.end >= intervals.get(i).start)
                interval.end = interval.end >= n ? interval.end : n;
            else {
                ans.add(interval);
                interval = intervals.get(i);
            }
            if (i == intervals.size()-1)
                ans.add(interval);
        }
        return ans;
    }
}

// Definition for an interval.
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}