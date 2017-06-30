
public class Prob413_ArithmeticSlices {

	public static void main(String[] args) {
		System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4,5,5,6,7,8,9,10,12}));
	}
	
	
	/*
	 * 
	 * [1, 2, 3, 4] = 3
	 * [1, 3, 5, 6, 6, 6] = 2
	 * [1,2,2,3,3,4]
	 * 
	 */
	public static int numberOfArithmeticSlices(int[] A) {
		
		assert A.length >= 3 && A != null;
		
		int slices=0;
		int start = 0, end=0;
		int difference = A[start]-A[end+1];
		for (int i = 0; i < A.length-1; i++, end++) {
			if (difference != A[i]-A[end+1]) {
				slices += countSlices(start, end);
				start = i;
				difference = A[i]-A[end+1];
			}
			if (i == A.length -2)
				slices += countSlices(start,end+1);
		}
		
        return slices;
    }

	private static int countSlices(int start, int end) {
		int n = end-start;
		return (n-1)*(n-2)/2;
	}
	

}

// 135 -1 =  0 + 1
// 1357 -3=  1  +  2
// 13579 -6= 3 + 3
// 1357911 -10 = 6 + 4

// 135678 -2