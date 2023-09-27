package baekjoon;

import java.util.*;
import java.io.*;
public class Main_3055_김태훈 {
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	//기본 입력
	static int R, C;
	static char map[][];
	
	//물 퍼지는 맵
	static int mapW[][];
	static boolean Wvisit[][];
	static ArrayDeque<int[]> Wque = new ArrayDeque<>();
	
	//고슴도치 이동 맵
	static int mapS[][];
	static boolean Svisit[][];
	static ArrayDeque<int[]> Sque = new ArrayDeque<>();
	
	//고슴도치 목적지 => D_X, D_Y
	static int D_X, D_Y;	
	
	
	static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		//초기화 영역
		map = new char[R][C];
		mapW = new int[R][C];
		mapS = new int[R][C];
		Wvisit = new boolean[R][C];
		Svisit = new boolean[R][C];
		
		for (int x = 0; x < R; x++) {
			map[x] = br.readLine().toCharArray();
			for (int y = 0; y < C; y++) {
				//물이면 물 que에 저장
				if(map[x][y] == '*') {
					Wque.add(new int[] {x, y});
					Wvisit[x][y] = true;
				}
				//고슴도치면 고슴도치 que에 저장
				else if(map[x][y] == 'S') {
					Sque.add(new int[] {x, y});
					Svisit[x][y] = true;
				}
				else if(map[x][y] == 'D') {
					D_X = x;
					D_Y = y;
				}
			}
		}
	}
	
	static void WBFS() {
		while(!Wque.isEmpty()) {
			int[] curr = Wque.poll();
			for (int i = 0; i < 4; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];
				//벽, 방문한곳, 돌이거나 비버굴 이면 못감 패스
				if(isValid(nx, ny)) continue;
				if(Wvisit[nx][ny]) continue;
				if(map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;
				
				Wque.add(new int[] {nx, ny});
				Wvisit[nx][ny] = true;
				// 물차는 속도
				mapW[nx][ny] = mapW[curr[0]][curr[1]] + 1;
			}
		}
	}
	
	static void SBFS() {
		while(!Sque.isEmpty()) {
			int[] curr = Sque.poll();
			for (int i = 0; i < 4; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];
				//벽, 방문한곳, 물차있는곳이나 돌이면 패스
				if(isValid(nx, ny)) continue;
				if(Svisit[nx][ny]) continue;
				if(map[nx][ny] == '*' || map[nx][ny] == 'X') continue;
				int tmp = mapS[curr[0]][curr[1]] + 1;
				//이미 물이 차있거나 물차는 속도가 고슴도치가 가는 속도보다 더 빨리 물차면 안됨
				if(mapW[nx][ny] != 0 && mapW[nx][ny] <= tmp) continue;
				Sque.add(new int[] {nx, ny});
				Svisit[nx][ny] = true;
				mapS[nx][ny] = tmp;
			}
		}
	}
	
	static boolean isValid(int x, int y) {
		return x<0 || x>=R || y<0 || y>=C;
	}
	
	public static void main(String[] args) throws IOException{
		init();
		WBFS();
		SBFS();
		//비버굴에 도착 못했으면 불가능, "KAKTUS"
		if(mapS[D_X][D_Y] == 0)
			sb.append("KAKTUS");
		else	//도착 했으면 고슴도치가 도착했을때 시간
			sb.append(mapS[D_X][D_Y]);
		System.out.println(sb);
	}

}
