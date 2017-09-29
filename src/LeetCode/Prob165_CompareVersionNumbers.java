package LeetCode;
import java.util.Arrays;

public class Prob165_CompareVersionNumbers {

	public static void main(String[] args) {
		Prob165_CompareVersionNumbers prob = new Prob165_CompareVersionNumbers();
		System.out.println(prob.compareVersions("1.5.1.2.2", "1.5.1.2.2"));
	}

	public int compareVersions(String version1, String version2) {
		if (version1 == null || version2 == null)
			return 0;
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int i = 0;
		int ans = 0;
		while (true) {
			Integer c1, c2;
			if (i >= v1.length)
				c1 = 0;
			else
				c1 = Integer.parseInt(v1[i]);
			if (i >= v2.length)
				c2 = 0;
			else
				c2 = Integer.parseInt(v2[i]);
			
			if (c1 > c2) {
				ans = 1;
				break;
			} else if (c1 < c2) {
				ans = -1;
				break;
			} else if (i > v1.length && i > v2.length) {
				break;
			}
			i++;
		}
		return ans;
	}

}
