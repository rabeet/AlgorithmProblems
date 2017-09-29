package Other;

public class WaterByJthGlass {

	public static void main(String[] args) {
		WaterByJthGlassM(1,2,4);
	}
	/*
	 * X = 9
	 * 			1 = 1
	 * 		2=1		3=1
	 * 	4=1  	  5=1		6=1.5
	 * 7=0.25  8=1.25   1    10      11   12
	 */
	
	public static int WaterByJthGlassM(int i ,int j, long X) {
		if (i == 0 && j == 0 && X > 1) return 1;
		long[][] arr = new long[i][];
		int col = 1;
		arr[0] = new long[1];
		arr[0][0] = X;
		for (int c = 1; c < arr.length; c++) {
			arr[c] = new long[++col];
			
			X--;
			
		}
		return 0;
	}

}

interface I {
	
}
