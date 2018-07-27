package com.litl.www.algorithm.ch09;

import com.litl.www.algorithm.ch08.RandomArray;

public class LostNumberTest {
	public static void main(String[] args) {
		int[] arrayOld = new int[100];
		for (int i = 0; i < arrayOld.length; i++) {
			arrayOld[i] = i + 1;
		}
		RandomArray.random2(arrayOld);
		int[] array1 = new int[99];
		int[] array2 = new int[99];
		int[] array3 = new int[99];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = arrayOld[i];
			array2[i] = arrayOld[i];
			array3[i] = arrayOld[i];
		}
		LostNumber.find1(array1);
		LostNumber.find2(array2);
		LostNumber.find3(array3);
		LostNumber.find4(array3);
	}
}
