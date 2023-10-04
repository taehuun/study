package swea;
import java.util.*;
import java.io.*;

public class Solution_5643_김태훈 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, M, count, value;
	static boolean visit[];
	static List<Integer>[] list1;
	static List<Integer>[] list2;
	
	static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list1 = new ArrayList[N+1];
		list2 = new ArrayList[N+1];
		value = 0;
		for (int i = 1; i <= N; i++) {
			list1[i] = new ArrayList<Integer>();
			list2[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list1[a].add(b);
			list2[b].add(a);
		}
		
	}
	
	static void solve() {
		int m1=0, m2=0;
		for (int i = 1; i <= N; i++) {
			visit = new boolean[N+1];
			count = 0;
			dfs(i, list1);
			m1 = count;
			visit = new boolean[N+1];
			count = 0;
			dfs(i, list2);
			m2 = count;
			if(m1+m2 == N-1) {
				value++;
			}
		}
		sb.append(value);
	}
	
	static void dfs(int v, List<Integer>[] list) {
		visit[v] = true;
		for (int i : list[v]) {
			if(!visit[i]) {
				count++;
				dfs(i, list);
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
