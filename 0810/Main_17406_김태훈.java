package baekjoon;

import java.util.*;
import java.io.*;

public class Main_17406_김태훈 {
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int n, m, k; // 배열 크기 n,m 연산 횟수 k
	static int[][] map; // 배열
	static int[] orderR, orderC, orderS; // 연산 순서
	static int r, c, s;
	static int[][] orderRCS;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
//		orderR = new int[k];
//		orderC = new int[k];
//		orderS = new int[k];
		orderRCS = new int[k][3];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ============여기까지가 기본 맵 입력받는곳===========
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
//			orderR[i] = Integer.parseInt(st.nextToken());
//			orderC[i] = Integer.parseInt(st.nextToken());
//			orderS[i] = Integer.parseInt(st.nextToken());
			orderRCS[i][0] = Integer.parseInt(st.nextToken());
			orderRCS[i][1] = Integer.parseInt(st.nextToken());
			orderRCS[i][2] = Integer.parseInt(st.nextToken());
		}
		// ============연산 입력받고 연산 메소드 호출===========================
				// 입력 받은 R C S 배열들 회전 연산 사용 순서를 파악 하기 위한 순열 구현해야됨
				// 1~k의 순열을 구한 다음에 ex) k가 3이면 1 2 3 1 3 2 2 1 3이런식으로
				// 구한거 배열에 저장하고 저장한 배열로 for문 돌린다음에 그거를 rcs 배열에 i부분에 넣고
				// 회전 메소드 실행 전에 원판에서 복사부터 하고 복사한걸로 돌리자
				// 회전 메소드 실행
				// 회전하고 나서 각 줄 최솟값 구하는 메소드 실행
				// 최솟값 나온거에서 최솟값 구함
		//순열
		int[] order = new int[k];
		for (int i = 0; i < k; i++) {
			order[i] = i;
		}
		int min = Integer.MAX_VALUE;
		//모든 순열에 대해서 반복
		while(true) {
			
			//맵 복사해놓기
			int[][] tempMap = new int[n][m];
			for(int i=0; i<n; i++) {
				for (int j = 0; j < m; j++) {
					tempMap[i][j] = map[i][j];
				}
			}
			
			//회전 연산하기
			for (int i = 0; i < k; i++) {
				int r = orderRCS[order[i]][0];
				int c = orderRCS[order[i]][1];
				int s = orderRCS[order[i]][2];
				roate(r, c, s, tempMap);
				//출력확인을위한 for문
				System.out.println();
				for (int j = 0; j < n; j++) {
					for (int j2 = 0; j2 < m; j2++) {
						System.out.print(tempMap[j][j2]+" ");
					}
					System.out.println();
				}
				//출력확인을 위한 for문
			}
			//최솟값
			min = Math.min(min, minsum(tempMap));
			
			if (!nextPermutation(order)) {
				break; // 모든 순열이 끝나면 반복 종료
			}
		}
		//출력
		System.out.println(min);
	}
	private static void roate(int r, int c, int s, int[][] array) {
		// TODO Auto-generated method stub
		for (int i = 1; i < s; i++) {
			int startX = r-s-1;
			int startY = c-s-1;
			int endX = r+s-1;
			int endY = c+s-1;
			
			int temp = array[startX][startY];
			int x = startX;
			int y = startY;
			int dir = 0;
			//==========================
			System.out.printf("startX : %d startY : %d\n endX : %d endY : %d\n",startX,startY,endX,endY);
			//=====================
			//회전
			while(dir<4) {
				int nx = x+dx[dir];
				int ny = y+dy[dir];
				
				if(nx >= startX && nx <= endX && ny >= startY && ny <= endY) {
					array[x][y] = array[nx][ny];
					x = nx;
					y = ny;
				}
				else {
					dir++;
				}
			}
			array[startX][startY + 1] = temp;
		}
	}
	public static int minsum(int[][] array) {
		int minsum = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int rowsum = 0;
			for (int j = 0; j < m; j++) {
				rowsum += array[i][j];
			}
			minsum = Math.min(minsum, rowsum);
		}
		return minsum;
	}

	// 다음 순열 생성 함수
    private static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        // 순열의 끝부터 감소하는 부분 찾기
        while (i > 0 && a[i - 1] >= a[i]) {
            i--;
        }
        if (i <= 0) {
            return false; // 모든 순열이 끝난 경우
        }
        int j = a.length - 1;
        // 감소하는 부분의 바로 앞 요소보다 큰 요소 찾기
        while (a[j] <= a[i - 1]) {
            j--;
        }
        // 요소 바꾸기
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;
        
        // 위치 변경
        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
