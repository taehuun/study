package baekjoon;
import java.util.*;
import java.io.*;
public class Main_2239_김태훈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int map[][];			//스도쿠
	static boolean row[][], col[][], box[][];	//숫자 체크
	static int N=9;			//스도쿠 크기
	
	static void init() throws IOException{
		map = new int[N][N];
		row = new boolean[N][N+1];
		col = new boolean[N][N+1];
		box = new boolean[N][N+1];
		
		
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			char[] input = in.toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = input[j] - '0';
				if(map[i][j] != 0) {
					row[i][map[i][j]] = true;
					col[j][map[i][j]] = true;
					box[(i/3)*3 + (j/3)][map[i][j]] = true;
				}
			}
		}
	}
	
	static void sudoku(int idx) {
		if(idx >= 81) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		int x = idx/9;
		int y = idx%9;
		
		if(map[x][y] != 0) sudoku(idx+1);
		
		else {
			for (int i = 1; i <= N; i++) {
				if(row[x][i] || col[y][i] || box[(x/3)*3+y/3][i]) continue;
				row[x][i] = true;
				col[y][i] = true;
				box[(x/3)*3+y/3][i] = true;
				map[x][y] = i;
				sudoku(idx+1);
				row[x][i] = false;
				col[y][i] = false;
				box[(x/3)*3+y/3][i] = false;
				map[x][y] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		init();
		sudoku(0);
	}

}
