package baekjoon;

import java.util.*;
import java.io.*;

public class Main_1992_김태훈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int n, map[][];

	private static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			String[] in = input.split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(in[j]);
			}
		}
	}

	private static void go(int n, int x, int y) {
		if (ispossible(n, x, y)) {
			sb.append(map[x][y]);
			return;
		}
		sb.append("(");
		go(n / 2, x, y);
		go(n / 2, x, y + n / 2);
		go(n / 2, x + n / 2, y);
		go(n / 2, x + n / 2, y + n / 2);
		sb.append(")");
	}

	private static boolean ispossible(int n, int x, int y) {
		int value = map[x][y];
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if(value != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void print() {
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		init();
		go(n, 0, 0);
		print();
	}

}
