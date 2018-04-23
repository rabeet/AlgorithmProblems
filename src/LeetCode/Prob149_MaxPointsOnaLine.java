package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Prob149_MaxPointsOnaLine {

	
	/*
	 * sort by x, sort by y and sort by diagonal
	 * [1,1],[2,2],[3,3]
	 * sort by x: [[1,1],[2,2],[3,3]]
	 * sort by y: [[1,1],[2,2],[3,3]]
	 * sort by z: [[1,1],[2,2],[3,3]]
	 * 
	 * 			  [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
	 * sort by x: [[1,1],[1,4],[2,3],[3,2],[4,1],[5,3]]
	 * sort by y: [[1,1],[4,1],[3,2],[5,3],[2,3],[1,4]]
	 * 
	 */
	
	private static float lineEq(Point p1, Point p2) {
		float d = ((float)p2.y - (float)p1.y)/((float)p2.x-(float)p1.x);
		return d;
	}

	public static int maxPoints(Point[] points) {
		if (points == null || points.length == 0) return 0;
		Arrays.sort(points, pointComparator());
		return 0;
	}

	private static Comparator<? super Point> pointComparator() {
		return (p1, p2) -> lineEq(p1,p2) == 1.0 || lineEq(p1,p2) == -1.0 ? 0 : 1;
	}

	public static void main(String[] args) {
		Stream.of(new Point(1,1), new Point(3,2), new Point(5,3),new Point(4,1), new Point(2,3), new Point(1,4))
		.sorted(pointComparator()).forEach(System.out::println);

		Point p1 = new Point(1,1);
		Point p2 = new Point(3,2);
		float d = ((float)p2.y - (float)p1.y)/((float)p2.x-(float)p1.x);
		System.out.println(d);
	}

}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
	
	@Override
	public String toString() {
		return "x:"+x+",y:"+y;
	}
}
