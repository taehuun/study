package baekjoon;
import java.util.*;
import java.io.*;
public class Main_2578_김태훈 {
	static int[][] map;
	static int[][] check;
	static int size = 5;
	static int answer;
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map = new int[size][size];
		check = new int[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//============연산=========================
		// 입력 받을때 마다 카운트 1씩 일단 늘어나고
		// 카운트가 12 이상일때부터 체크 시작
		// 완탐으로 한 줄의 합이 5가되면 빙고, 열탐색, 행탐색, 대각선탐색으로 하면 될듯
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				int n = Integer.parseInt(st.nextToken());
				count++;
				for (int x = 0; x < size; x++) {
					for (int y = 0; y < size; y++) {
						if(map[x][y] == n) {
							check[x][y]++;
							break;
						}
					}
				}
				int bingo = 0;
				if(count>=12) {
					//행탐색
					for (int x = 0; x < size; x++) {
						int sum = 0;
						for (int y = 0; y < size; y++) {
							sum += check[x][y];
						}
						if(sum >= 5) {
							bingo++;
						}
					}
					//열탐색
					for (int x = 0; x < size; x++) {
						int sum = 0;
						for (int y = 0; y < size; y++) {
							sum += check[y][x];
						}
						if(sum >= 5) {
							bingo++;
						}
					}
					//대각선 탐색
					int sum_1 = 0;
					int sum_2 = 0;
					for (int x = 0; x < size; x++) {
						sum_1 += check[x][x];
						sum_2 += check[size-x-1][x];
					}
					if(sum_1 >= 5) {
						bingo++;
					}
					if(sum_2 >= 5) {
						bingo++;
					}
				}
				if(bingo >= 3) {
					System.out.println(count);
					return;
				}
			}
		}
		
	}

}
