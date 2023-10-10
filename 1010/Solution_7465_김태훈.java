package swea;

import java.util.*;
import java.io.*;

public class Solution_7465_김태훈 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, M, count;
	static boolean visit[];
	static List<Integer>[] graph;
	
	static void init() throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		count = 0;
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph[a].add(b);
			graph[b].add(a);
		}
	}
	
	static void solve() {

			
			for (int i = 0; i < N; i++) {
				if(!visit[i]) {
					dfs(i);
					count++;
				}
			}

		sb.append(count);
	}
	
	static void dfs(int v) {
		visit[v] = true;
		for (int i : graph[v]) {
			if(!visit[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException{
		
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
