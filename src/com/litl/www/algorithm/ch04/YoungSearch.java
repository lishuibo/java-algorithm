package com.litl.www.algorithm.ch04;

public class YoungSearch {
	private int[][] array;

	public YoungSearch(int[][] array) {
		this.array = array;
	}

	public boolean recursionSearch(int x, int y, int target) {
		if (x == array.length || y == array[0].length) {
			return false;
		}
		if (target < array[x][y]) {
			return false;
		}
		if (target == array[x][y]) {
			System.out.println(String.format("x: %d,y: %d", x, y));
			return true;
		}
		return recursionSearch(x + 1, y, target) || recursionSearch(x, y + 1, target);
	}

	public boolean search(int target) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; target >= array[i][j] && j < array[0].length; j++) {
				if (target == array[i][j]) {
					System.out.println(String.format("x: %d,y: %d", i, j));
					return true;
				} else if (target < array[i][j]) {
					return false;
				}
			}
		}
		return false;
	}

	public boolean search2(int target) {
		int width = array[0].length;
		int height = array.length;
		if (target >= array[0][0]) {
			int i = 0;
			for (; target >= array[0][i] && i < width - 1; i++) {
				if (target == array[0][i]) {
					System.out.println(String.format("x: %d,y: %d", 0, i));
					return true;
				}
			}
			if (i > width - 1) {
				i--;
			}
			for (int j = 1; j < height; j++) {
				if (array[j][i] == target) {
					System.out.println(String.format("x: %d,y: %d", j, i));
					return true;
				} else if (array[j][i] > target) {
					for (; i >= 0; i--) {
						if (array[j][i] == target) {
							System.out.println(String.format("x: %d,y: %d", j, i));
							return true;
						} else if (array[j][i] <= target) {
							break;
						}
					}
					if (i < 0) {
						i++;
					}
				} else if (array[j][i] < target) {
					for (; i < width - 1; i++) {
						if (array[j][i] == target) {
							System.out.println(String.format("x: %d,y: %d", j, i));
							return true;
						} else if (array[j][i] >= target) {
							break;
						}
					}
				}
				if (i > width - 1) {
					i--;
				}
			}
		}
		return false;
	}

	public boolean search3(int target) {
		int i = 0;
		int j = array[0].length - 1;
		int temp = array[i][j];
		while (true) {
			if (target == temp) {
				System.out.println(String.format("x: %d,y: %d", i, j));
				return true;
			} else if (temp < target && i < array.length - 1) {
				temp = array[i++][j];
			} else if (temp > target && j > 0) {
				temp = array[i][--j];
			} else {
				return false;
			}
		}
	}
}
