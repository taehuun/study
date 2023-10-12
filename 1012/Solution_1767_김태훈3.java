package swea;

import java.util.*;
import java.io.*;

public class Solution_1767_김태훈3 {

	static class Core {
		int x, y;

		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int N, map[][], min;
	static List<Core> core;
	static boolean visit[];

	static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		core = new ArrayList<>();
		visit = new boolean[12];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
					continue;
				}
				if (map[i][j] == 1) {
					core.add(new Core(i, j));
				}
			}
		}
	}

	static void solve() {
		for (int i = core.size(); i >= 0; i--) {
			
			combi(0, 0, i);
			if (min < Integer.MAX_VALUE) {
				sb.append(min);
				return;
			}
		}
	}

	static void combi(int idx, int start, int n) {
		if (idx == n) {

			go(0, 0);
			return;
		}
		for (int i = start; i < core.size(); i++) {
			visit[i] = true;
			combi(idx + 1, i + 1, n);
			visit[i] = false;
		}
	}

	static void go(int idx, int sum) {
		if (idx == core.size()) {
			min = Math.min(min, sum);
			return;
		}

		if (!visit[idx]) {
			go(idx + 1, sum);
			return;
		}
		for (int dir = 0; dir < 4; dir++) {
			int x = core.get(idx).x;
			int y = core.get(idx).y;
			int count = 0;
			while (true) {
				x += dx[dir];
				y += dy[dir];
				if (x < 0 || x >= N || y < 0 || y >= N) {
					go(idx + 1, sum + count);
					break;
				}
				if (map[x][y] != 0) {
					break;
				}
				map[x][y] = 2;
				count++;
			}
			while (true) {
				x -= dx[dir];
				y -= dy[dir];
				if (x == core.get(idx).x && y == core.get(idx).y) {
					break;
				}
				map[x][y] = 0;
			}

		}
	}

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			init();
			solve();

			sb.append("\n");
		}
		System.out.println(sb);
	}

}
