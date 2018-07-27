package com.litl.www.algorithm.ch08;

public class MaxSumSubArray {
	public static void find1(int[] array) {
		int maxSum = array[0];
		int currentSum = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				for (int k = i; k <= j; k++) {
					currentSum += array[k];
				}
				if (currentSum > maxSum) {
					maxSum = currentSum;
					start = i;
					end = j;
				}
				currentSum = 0;
			}
		}
		System.out.println("连加值最大的和为" + maxSum);
		System.out.print("连加值最大的子数组为:");
		for (int i = start; i <= end; i++) {
			System.out.print(array[i]);
			if (i != end) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public static void find2(int[] array) {
		int maxSum = array[0];
		int currentSum = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				currentSum += array[j];
				if (currentSum > maxSum) {
					maxSum = currentSum;
					start = i;
					end = j;
				}
			}
			currentSum = 0;
		}
		System.out.println("连加值最大的和为" + maxSum);
		System.out.print("连加值最大的子数组为:");
		for (int i = start; i <= end; i++) {
			System.out.print(array[i]);
			if (i != end) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public static void find3(int[] array) {
		int lastSum = 0;
		int maxSum = array[0];
		int start = 0;
		int end = 0;
		for (int i = 0; i < array.length; i++) {
			if (lastSum > 0) {
				lastSum = lastSum + array[i];
			} else {
				lastSum = array[i];
				start = i;
			}
			if (maxSum < lastSum) {
				maxSum = lastSum;
				end = i;
			}
		}
		System.out.println("连加值最大的和为" + maxSum);
		System.out.print("连加值最大的子数组为:");
		for (int i = start; i <= end; i++) {
			System.out.print(array[i]);
			if (i != end) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public static int maxSumSubMatrix(int[][] matrix) {
		int[][] total = matrix;
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				total[i][j] += total[i - 1][j];
			}
		}
		int maximum = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				int[] result = new int[matrix[0].length];
				for (int l = 0; l < matrix[0].length; l++) {
					if (i == 0) {
						result[l] = total[j][l];
					} else {
						result[l] = total[j][l] - total[i - 1][l];
					}
				}
				int maximal = maxSubArray(result);
				if (maximal > maximum) {
					maximum = maximal;
				}
			}
		}
		return maximum;
	}

	private static int maxSubArray(int[] array) {
		// TODO Auto-generated method stub
		int lastSum = 0;
		int maxSum = array[0];
		for (int i = 0; i < array.length; i++) {
			if (lastSum > 0) {
				lastSum = lastSum + array[i];
			} else {
				lastSum = array[i];
			}
			if (maxSum < lastSum) {
				maxSum = lastSum;
			}
		}
		return maxSum;
	}
}
