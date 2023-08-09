package baekjoon;
import java.util.*;
import java.io.*;
public class Main_2563_김태훈 {
	static int x;
	static int y;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[101][101];
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					if(arr[j][k]==0) 		//만약에 처음 방문한 곳이면 카운트 올림
						count++;			//한번 이상 방문한 곳이면 ==> 겹치는 곳이면 숫자 안셈
					arr[j][k]++;			//방문체크
				}
			}
			
		}
		System.out.println(count);
	}

}
