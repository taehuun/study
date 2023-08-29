package baekjoon;
import java.util.*;
import java.io.*;
public class Main_1149_김태훈 {
	

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int N, map[][];
	
	static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solve() {
		int[][] sum = new int[N][3];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			sum[0][i] = map[0][i];
		}
		//sum[][]배열을 만들어서 더해 나가서 맨 마지막 3개 비교하기
		//근데 위에 1번이면 아래에서 1번 못더하니까 같으면 그냥 패스,
		//sum이 만약에 sum[2][1]이면 sum[3][0]에 더한거 저장하고 sum[3][2]에 더한거 저장하는데
		//이미 저장된 값이 있으면 더 작은값 저장
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if(k==j) continue;
					int a = sum[i-1][j] + map[i][k];
					if(sum[i][k] == 0) {
						sum[i][k] = a;
					}
					else {
						sum[i][k] = Math.min(sum[i][k], a);
					}
				}
			}
		}
		min = Math.min(sum[N-1][0], sum[N-1][1]);
		min = Math.min(min, sum[N-1][2]);
		System.out.println(min);
	}
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
	}

}
