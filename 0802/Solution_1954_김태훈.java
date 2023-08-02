package swea;
import java.util.*;
import java.io.*;
public class Solution_1954_김태훈 {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[][][] map = new int[t][11][11];
		int[] n = new int[t];
		for(int i=0; i<t; i++) {
			n[i] = Integer.parseInt(br.readLine());
			int count = 1;
			int dir = 0;
			int x = 0;
			int y = 0;
			
			while(count <= n[i]*n[i]) {
				
				map[i][x][y] = count++;
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if(ny<0 || nx<0 || ny>=n[i] || nx>=n[i] || map[i][nx][ny]!=0) {
					dir = (dir+1)%4;
					ny = y + dy[dir];
					nx = x + dx[dir];
					
				}
				y = ny;
				x = nx;
			}
		}
		
		
		
		
		for(int i=0; i<t; i++) {
			System.out.printf("#%d\n",i+1);
			for(int j=0; j<n[i]; j++) {
				for(int k=0; k<n[i]; k++) {
					System.out.printf("%d ",map[i][j][k]);
				}
				System.out.println();
			}
		}
	}

}
