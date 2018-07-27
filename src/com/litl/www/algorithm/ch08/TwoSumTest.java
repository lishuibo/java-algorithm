package com.litl.www.algorithm.ch08;

public class TwoSumTest {
	public static void main(String[] args) {
		int[] array = { 1, 3, 7, 5, 15, 9 };
		int sum = 10;
		TwoSum.find1(array, sum);
		TwoSum.find2(array, sum);
		TwoSum.find3(array, sum);
		TwoSum.find4(array, sum);
	}
}
