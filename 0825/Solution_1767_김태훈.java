package swea;
import java.util.*;
import java.io.*;
/*
 * 일단 map으로 입력 받음, 입력 받으면서 들어오는 숫자가 1이면 list에 따로 저장한다
 * 이때 테두리는 고려 대상이 아니니까 저장 안하고.
 * 저장한 배열로 중복 순열을 만든다. 중복이 허용되는 순열이라서 중복 체크 한다
 * 0부터 3까지 숫자를  list사이즈만큼 하는 배열에 저장
 * 저장한 배열 숫자대로 0이면 > 1이면 ^ 2면 < 3이면 v 방향
 * 순열 한 번 돌아서 확인하면서 count값 저장
 * max_count랑 비교해서 저장 max_count가 정답임
 */
class point {
	public int x, y;
	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "point [x=" + x + ", y=" + y + "]";
	}
	
}
public class Solution_1767_김태훈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int T, n, map[][], numbers[];
	static boolean visit[][];
	static ArrayList<point> list;
	static int min_count;
	
	static void init() throws IOException{
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		list = new ArrayList<>();
		min_count = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1 && i>0 && j >0 && i<n-1 && j<n-1) {
					list.add(new point(i, j));
				}
			}
		}
		numbers = new int[list.size()];
	}
	
	static void prem(int count) {
		if(count == list.size()) {
			min_count = Math.min(min_count, dfs());
			return;
		}
		for (int i = 0; i < 4; i++) {
			numbers[count] = i;
			prem(count+1);
		}
	}
	
	static int dfs() {
		visit = new boolean[n][n];
		int cnt = 0;
		for (int i = 0; i < numbers.length; i++) {
			// 0 : >, 1 : ^, 2 : <, 3 : v
			int x = list.get(i).x;
			int y = list.get(i).y;
			if(numbers[i] == 0) {
				int nx = x;
				int ny = y+1;
				while(nx>=0 && nx<n && ny>=0 && ny<n && !visit[nx][ny] && map[nx][ny] == 0) {
					visit[nx][ny] = true;
					cnt++;
					ny++;
				}
				
				if(ny != n) {
					return Integer.MAX_VALUE;
				}
			}
			else if(numbers[i] == 1) {
				int nx = x-1;
				int ny = y;
				while(nx>=0 && nx<n && ny>=0 && ny<n && !visit[nx][ny] && map[nx][ny] == 0) {
					visit[nx][ny] = true;
					cnt++;
					nx--;
				}
				if(nx != -1) {
					return Integer.MAX_VALUE;
				}
			}
			else if(numbers[i] == 2) {
				int nx = x;
				int ny = y-1;
				while(nx>=0 && nx<n && ny>=0 && ny<n && !visit[nx][ny] && map[nx][ny] == 0) {
					visit[nx][ny] = true;
					cnt++;
					ny--;
				}
				if(ny != -1) {
					return Integer.MAX_VALUE;
				}
			}
			else if(numbers[i] == 3) {
				int nx = x+1;
				int ny = y;
				while(nx>=0 && nx<n && ny>=0 && ny<n && !visit[nx][ny] && map[nx][ny] == 0) {
					visit[nx][ny] = true;
					cnt++;
					nx++;
				}
				if(nx != n) {
					return Integer.MAX_VALUE;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			init();
			prem(0);
			sb.append(min_count);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
