package LeetCode;
import java.util.PriorityQueue;

public class Prob378_KthSmallestElement {

	public static void main(String[] args) {
		int[][] matrix = {
						{1,5,9},
						{10,11,13},
						{12,13,15}
						};
		System.out.println(kthSmallest(matrix, 8));
		System.out.println(kthSmallestEfficient(matrix, 8));
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
	
	// Above code is inefficient since every the time complexity of it is N*M + Klog(K)
	// We can make it to be KlogK efficient
	
	// By first inserting the first row in the PQ and then making sure that every time we poll we insert the next smallest element in the heap
	// Having done that k-1 times will result in the heap to have its head pointed to the kth smallest element
	public static int kthSmallestEfficient(int[][] matrix, int k) {
		
		PriorityQueue<Data> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
		
		for (int i = 0; i < matrix[0].length; i++) {
			pq.offer(new Data(0,i,matrix[0][i]));
		}
		for (int i = 0; i < k-1; i++) {
			Data d = pq.poll();
			if (d.row+1 == matrix.length) continue;
			pq.offer(new Data(d.row+1,d.col, matrix[d.row+1][d.col]));
		}
		return pq.poll().val;
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

class Data implements Comparable<Data>{
	int row, col, val;
	
	public Data (int x, int y, int z) {
		row = x;
		col = y;
		val = z;
	}

	@Override
	public int compareTo(Data o) {
		return this.val - o.val;
	}

}
