import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob118_PascalsTriangle {
	
	public static void main(String[] args) {
		List<List<Integer>> list = generate(-1);
		for (List<Integer> l : list) {
			for (int i : l)
				System.out.print(i + " ");
			System.out.println();
		}
	}
	
	public static List<List<Integer>> generate(int numRows) {
		if (numRows <= 0) return new ArrayList();
		int top = 0, topleft = 0;
		List<List<Integer>> mainList = new ArrayList<List<Integer>>();
		ArrayList<Integer> ilist = new ArrayList<Integer>();
		ilist.add(1);
		mainList.add(ilist);
		for (int i = 1; i < numRows; i++) {
			ilist = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == i) top = 0;
				else top = mainList.get(i-1).get(j);
				if (j == 0) topleft = 0;
				else topleft = mainList.get(i-1).get(j-1);
				ilist.add(top+topleft);
			}
			mainList.add(ilist);
		}
		return mainList;
	}
}
