package com.litl.www.algorithm.ch08;

public class AssignArray {
	public static void assign(int[] a) {
		int[] b = new int[a.length];
		b[0] = 1;
		for (int i = 1; i < a.length; i++) {
			b[0] *= a[i - 1];
			b[i] = b[0];
		}
		b[0] = 1;
		for (int i = a.length - 2; i > 0; i--) {
			b[0] *= a[i + 1];
			b[i] *= b[0];
		}
		b[0] *= a[1];
		System.out.print("赋值后结果:");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
			if (i != b.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
}
