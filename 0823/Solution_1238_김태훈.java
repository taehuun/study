package swea;
import java.util.*;
import java.io.*;
public class Solution_1238_김태훈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int T = 10, n = 101, edge, start, arr[];
	static boolean visit[];
	static ArrayList<ArrayList<Integer>> graph;
	
	static void init() throws IOException {
		graph = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		edge = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < edge/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
		}
	}
	
	
	static void bfs() {
		ArrayDeque<Integer> que = new ArrayDeque<>();
		que.offer(start);
		visit[start] = true;
		while(!que.isEmpty()) {
			arr = new int[n];
			int q_size = que.size();
			for ( int k = 0 ; k <q_size ; k++) {
				int curr = que.poll();
				arr[k] = curr;
				for (int i = 0; i < graph.get(curr).size(); i++) {
					int a = graph.get(curr).get(i);
					if(!visit[a]) {
						que.offer(a);
						visit[a] = true;
					}
				}
			}
		}
		solve();
	}
	
	static void solve() {
		int len = arr.length;
		Arrays.sort(arr);
		sb.append(arr[len-1]);
	}
	
	public static void main(String[] args) throws IOException{
		for (int t = 0; t < T; t++) {
			sb.append("#").append(t+1).append(" ");
			init();
			bfs();
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
