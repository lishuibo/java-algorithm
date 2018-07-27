package com.litl.www.algorithm.ch04;

public class YoungSearchTest {
	public static void main(String[] args) {
		int[][] array = { { 1, 2, 8, 9, 15, 22, 38 }, { 2, 5, 9, 12, 16, 25, 42 }, { 4, 7, 13, 15, 21, 28, 46 },
				{ 7, 9, 16, 18, 24, 32, 52 } };
		YoungSearch youngSearch = new YoungSearch(array);
		// System.out.println(youngSearch.recursionSearch(0, 0, 13));
		// System.out.println(youngSearch.recursionSearch(0, 0, 20));
		//
		// System.out.println(youngSearch.search(13));
		// System.out.println(youngSearch.search(20));

		// System.out.println(youngSearch.search2(13));
		// System.out.println(youngSearch.search2(20));
		// System.out.println(youngSearch.search2(46));
		// System.out.println(youngSearch.search2(4));
		// System.out.println(youngSearch.search2(99));

		System.out.println(youngSearch.search3(13));
		System.out.println(youngSearch.search3(20));
	}
}
