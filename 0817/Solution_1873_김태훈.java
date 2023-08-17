package swea;
import java.util.*;
import java.io.*;
public class Solution_1873_김태훈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int T, h, w, n, x, y;
	static char map[][], commend[];
	
	private static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new char[h][w];
		for (int i = 0; i < h; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < w; j++) {
				if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
					x = i; y = j;
				}
			}
		}
		n = Integer.parseInt(br.readLine());
		commend = br.readLine().toCharArray();
		
//		for (int i = 0; i < h; i++) {
//			for (int j = 0; j < w; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("x : "+ x + " y : "+y);
	}
	
	private static void solve() {
		for (int i = 0; i < n; i++) {
			if(commend[i] == 'U') {
				map[x][y] = '^';
				if(x-1>=0 && map[x-1][y] == '.') {
					x--;
					map[x][y] = '^';
					map[x+1][y] = '.';
				}
			}
			else if(commend[i] == 'D') {
				map[x][y] = 'v';
				if(x+1<h && map[x+1][y] == '.') {
					x++;
					map[x][y] = 'v';
					map[x-1][y] = '.';
				}
			}
			else if(commend[i] == 'L') {
				map[x][y] = '<';
				if(y-1>=0 && map[x][y-1] == '.') {
					y--;
					map[x][y] = '<';
					map[x][y+1] = '.';
				}
			}
			else if(commend[i] == 'R') {
				map[x][y] = '>';
				if(y+1<w && map[x][y+1] == '.') {
					y++;
					map[x][y] = '>';
					map[x][y-1] = '.';
				}
			}
			else if(commend[i] == 'S') {
				int sx = x;
				int sy =y;
				if(map[x][y] == '^') {
					while(true) {
						sx--;
						if(sx<0)
							break;
						if(map[sx][sy] == '*') {
							map[sx][sy] = '.';
							break;
						}
						else if(sx<=0 || map[sx][sy]=='#') {
							break;
						}
						else if(map[sx][sy]=='.' || map[sx][sy] == '-')
							continue;
					}
				}
				else if(map[x][y] == 'v') {
					while(true) {
						sx++;
						if(sx>=h)
							break;
						if(map[sx][sy] == '*') {
							map[sx][sy] = '.';
							break;
						}
						else if(sx>h || map[sx][sy]=='#') {
							break;
						}
						else if(map[sx][sy]=='.' || map[sx][sy] == '-')
							continue;
					}
				}
				else if(map[x][y] == '>') {
					while(true) {
						sy++;
						if(sy>=w)
							break;
						if(map[sx][sy] == '*') {
							map[sx][sy] = '.';
							break;
						}
						else if(sy>w || map[sx][sy]=='#') {
							break;
						}
						else if(map[sx][sy]=='.' || map[sx][sy] == '-')
							continue;
					}
				}
				else if(map[x][y] == '<') {
					while(true) {
						sy--;
						if(sy<0)
							break;
						if(map[sx][sy] == '*') {
							map[sx][sy] = '.';
							break;
						}
						else if(sy<=0 || map[sx][sy]=='#') {
							break;
						}
						else if(map[sx][sy]=='.' || map[sx][sy] == '-')
							continue;
					}
				}
			}	
		}
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
	}
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			init();
			sb.append("#").append(t+1).append(" ");
			solve();
		}
		System.out.println(sb);
	}

}
