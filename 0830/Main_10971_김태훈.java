package baekjoon;
import java.util.*;
import java.io.*;
public class Main_10971_김태훈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int N, map[][], min;
	static boolean visit[];
	
	static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		map = new int[N][N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void dfs(int v, int cnt, int start, int sum) {
		
		/*
		 * dfs 돌다가 종료 조건되면 맨 마지막 노드에서 첫 노드로 연결이 되어 있어야 한다
		 * 근데 정점이 계속 바뀌니까 start 매게변수로 계속 들고다니면서 첫 시작 정보 넘기기
		 * 그래서 만약에 연결 되어있으면 sum에다가 더해주고 최솟값 갱신하기
		 * 
		 */
		
		//종료 조건
		if(cnt == N-1) {
			if(map[v][start]>0) {
				sum += map[v][start];
				min = Math.min(min, sum);
			}
			return;
		}
		visit[v] = true;
		for (int i = 0; i < N; i++) {
			if(visit[i]) continue;
			if(map[v][i]>0 && !visit[i]) {
				dfs(i, cnt+1, start, sum+map[v][i]);
			}
		}
		visit[v] = false;
	}
	
	public static void main(String[] args) throws IOException{
		init();
		for (int i = 0; i < N; i++) {
			dfs(i, 0, i, 0);
		}
		System.out.println(min);
	}

}
