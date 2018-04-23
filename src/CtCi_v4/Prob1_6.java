package CtCi_v4;
import java.util.Arrays;

public class Prob1_6 {

	/*
	 * 1.6: Given an image represented by an NxN matrix, where each pixel in the
	 * image is 4 bytes, write a method to rotate the image by 90 degrees. Can
	 * you do this in place? -----------------------
	 * 
	 */

	public static void main(String[] args) {
		int[][] image = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
		rotateImage(image);
		for (int[] i : image) {
			System.out.println(Arrays.toString(i));
		}
//		System.out.println();
//		int[][] image2 = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
//		rotateImageInplace(image2);
//		for (int[] i : image2) {
//			System.out.println(Arrays.toString(i));
//		}
		
		System.out.println();
		int[][] image3 = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
		rotateImageInplaceCopy(image3);
		for (int[] i : image3) {
			System.out.println(Arrays.toString(i));
		}
	}

	public static void rotateImage(int[][] image) {
		int[][] temp = new int[image.length][image.length];
		int row = 0, col = image.length - 1;
		for (int i = 0; i < image.length; i++, col--) {
			for (int j = 0; j < image.length; j++, row++) {
				temp[row][col] = image[i][j];
			}
			row = 0;
		}
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image.length; j++) {
				image[i][j] = temp[i][j];
			}
		}
	}

	public static void rotateImageInplace(int[][] image) {
		int r1 = 0, r2 = 0, r3 = image.length-1, r4 = image.length-1;
		int c1 = 0, c2 = image.length-1, c3 = image.length-1, c4 = 0;
		for (int i = 0; i < image.length; i++, r1++, r2++, r3--, r4--, c1++, c2--, c3--, c4++) {
			// r1c1 to r2c2
			int temp = image[r2][c2];
			image[r2][c2] = image[r1][c1];

			// r2c2 to r3c3
			image[r1][c1] = image[r3][c3];
			image[r3][c3] = temp;

			// r3c3 to r4c4
			temp = image[r4][c4];
			image[r4][c4] = image[r1][c1];

			// r4c4 to r1c1
			image[r1][c1] = temp;
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
