package baekjoon;
import java.util.*;
import java.io.*;

/*
 * 초밥 접시 : N, 초밥 숫자 : d, 연속 접시 수 : k, 쿠폰 번호 : c
 * 슬라이딩 윈도우로 해야됨
 * 
 */
public class Main_15961_김태훈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int N, d, k, c, list[], visit[];
	
	static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		list = new int[N+k-1];
		visit = new int[d+1];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
	}
	
	static int solve() {
		for (int i = 0; i < k-1; i++) {
			list[N++] = list[i];
		}
		
		//max가 1부터 시작하는 이유는 일단 쿠폰은 무조건 먹었다고 치고
		//중복된거 빼면 쿠폰도 중복되면 같이 빠지니까 1로 치고 시작함
		int max = 1;
		visit[c]++;
		//0번 인덱스 부터 시작해서 N+K번 인덱스까지 확인하면 순환하는거랑
		//똑같은 효과
		for (int i = 0; i < k; i++) {
			if(visit[list[i]] == 0) {	//먹은적 없으면
				max++;
			}
			visit[list[i]]++;
		}
		//========== 여기까지가 슬라이딩 윈도우 초반 세팅,
		//이 아래로는 윈도우 이동
		//슬라이딩 윈도우를 잘 모르니까 잘 아는 투포인터로 그냥 하자
		int start = 0;
		int end = k;
		int result = max;
		for (int i = end; i < N; i++) {
			//앞에부터 빼기
			visit[list[start]]--;
			
			if(visit[list[start]] == 0) {
				result--;
			}
			if(visit[list[i]] == 0) result++;
			visit[list[i]]++;
			max = Math.max(max, result);
			start++;
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException{
		init();
		System.out.println(solve());
	}

}
