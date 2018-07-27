package com.litl.www.algorithm.ch02.extend;

public class HanoiTest {
	public static void hanoi(int n, char A, char B, char C) {
		if (n == 1) {
			move(A, C);
			return;
		}
		hanoi(n - 1, A, C, B);
		move(A, C);
		hanoi(n - 1, B, A, C);

	}

	private static void move(char A, char C) {
		// TODO Auto-generated method stub
		System.out.println(A + "-->" + C);
	}

	public static void main(String[] args) {
		hanoi(3, 'A', 'B', 'C');
	}
}
