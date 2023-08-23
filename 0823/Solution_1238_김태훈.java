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
	
	/*
	 * T = 테스트 케이스, 10으로 고정
	 * n = 최대가 100이고 연결 되는 경우도 있고 안되는 경우도 있고 해서 100으로 고정
	 * edge = 입력 받은 간선
	 * arr[] = 마지막에 넣은 값 다 저장, 저장하고 정렬해서 제일 큰 값 출력
	 * 로직 => 입력 받은 선 graph 연결한다
	 * 		bfs 똑같이 돌리면서 탐색하는데 같은 깊이에 있는 숫자들을 매번 저장해야됨
	 * 		깊이를 알아야 하는데 while문 풀고 depht정보를 매개변수로 매번 돌리던지
	 * 		같은 깊이에 있는 애들을 for문으로 돌리고 거기서 poll된 애들 저장하면 된다.
	 * 		나는 for문으로 돌리고 배열에 저장. queue의 마지막이 아니라서 while문 다시돌면 저장 배열 초기화
	 * 		다 끝나고 배열 정렬해서 제일 큰놈 출력
	 */

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
