import java.util.List;

public class Prob339_NestedList {

	public static int depthSum(List<NestedInteger> list) {
		int sum = 0, depth = 1;
		for (NestedInteger ni : list) {
			if (ni.isInteger())
				sum += ni.getInteger();
			else
				sum += getListSum(ni.getList(), depth+1);
		}
		return sum;
	}

	private static int getListSum(List<NestedInteger> list, int depth) {
		int sum = 0;
		for (NestedInteger ni : list) {
			if (ni.isInteger())
				sum += ni.getInteger() * depth;
			else
				sum += getListSum(ni.getList(), depth+1);
		}
		return sum;
	}
}

interface NestedInteger {
	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list // Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
