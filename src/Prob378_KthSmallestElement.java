import java.util.PriorityQueue;

public class Prob378_KthSmallestElement {

	public static void main(String[] args) {
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		System.out.println(kthSmallest(matrix, 8));
	}

	public static int kthSmallest(int[][] matrix, int k) {
		
		assert matrix != null && k >= 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				pq.offer(matrix[i][j]);
			}
		}
		int ans =0;
		for (int i = 0; i < k; i++) {
			ans = pq.poll();
		}
		
		return ans;
	}

	private static int[] parseMatrix(int[][] matrix) {
		
		int[] arr = new int[matrix.length*matrix[0].length];
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		
		int index = 0;
		arr[index++] = matrix[0][0];
		
		int i = 0, j =0;
		
		while (i < matrix.length || j < matrix[0].length) {
			
			if (j >= matrix[0].length) {
				j = 0;
				i++;
				arr[index++] = matrix[i][j];
			}
			if (matrix[i][j+1] < matrix[i+1][j]) {
				arr[index++] = matrix[i][j+1];
				j++;
			}
			else {
				arr[index++] = matrix[i+1][j];
				i++;
			}
		}
		
		return arr;
	}
}
