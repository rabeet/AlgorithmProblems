import java.util.Arrays;

public class Prob48_ReverseImage {

	public static void main(String[] args) {
		int[][] image3 = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
		rotateImageInplaceCopy(image3);
		for (int[] i : image3) {
			System.out.println(Arrays.toString(i));
		}
	}
	
	/*
	 * First transpose the matrix: matrix[i][j] -> matrix[j][i]
	 * Then flip it vertically
	 */
	public static void rotateImageInplaceCopy(int[][] image) {
		
		// Transpose it
		for (int i =0; i <image.length; i++) {
			for (int j = i; j < image.length; j++) {
				int temp = image[i][j];
				image[i][j] = image[j][i];
				image[j][i] = temp;
			}
		}
		
		// Flip it vertically
		for (int i = 0; i < image.length/2; i++) {
			for (int j = 0; j < image.length; j++) {
				int temp =image[j][i];
				image[j][i] = image[j][image.length-1-i];
				image[j][image.length-1-i] = temp;
			}
		}
	}

}
