package com.litl.www.algorithm.ch08;

import java.util.Random;

public class RandomArray {
	public static void random1(int[] array) {
		Random random = new Random();
		int n = array.length;
		for (int i = 0; i < n; i++) {
			int j = random.nextInt(n);
			int k = random.nextInt(n);
			int temp = array[j];
			array[j] = array[k];
			array[k] = temp;
		}
		System.out.println("随机后结果:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public static void random2(int[] array) {
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			int j = random.nextInt(array.length - i) + i;
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		System.out.println("随机后结果:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
}
