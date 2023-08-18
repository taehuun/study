package baekjoon;
import java.util.*;
import java.io.*;
public class Main_1987_김태훈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int r, c, x, y, count;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static boolean[] visited;

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[26];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
//여기까지 입력받는곳========================
    static int dfs(int x, int y, int count) {
        int currentCount = count;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {	//벽이 아니면
                int idx = (int) (map[nx][ny]) - 'A';	//알파벳자리

                if (!visited[idx]) {			//알파벳 방문한적없으면	
                    visited[idx] = true;		//방문처리
                    currentCount = Math.max(currentCount, dfs(nx, ny, count + 1));	//한칸 이동하고 거기서 나온 카운트 연산
                    visited[idx] = false;
                }
            }
        }

        return currentCount;
    }

    static void solve() {
        visited[(int) (map[0][0]) - 'A'] = true;	//시작위치 초기화
        count = dfs(0, 0, 1);			//4방탐색하러 고고

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        init();				//입력받는 메소드
        solve();			//연산하는 메소드
    }
}
