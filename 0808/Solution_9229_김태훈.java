package swea;
import java.util.*;
import java.io.*;
public class Solution_9229_김태훈 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int n,m;
		int[] arr = new int[t];
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int max = -1;
			ArrayDeque<Integer> que = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				que.offer(Integer.parseInt(st.nextToken()));
				if(que.peekLast()>=m)
					que.pollLast();
			}
			while(!que.isEmpty()) {
				int a;
				int tmep;
				a = que.poll();
				int q_size = que.size();
				for (int j = 0; j < q_size; j++) {
					tmep = que.poll();
					if(tmep+a == m) {
						max = m;
						break;
					}
					else if(max < a+tmep && a+tmep<m) {
						max = a+tmep;
					}
					que.offer(tmep);
				}
				if(max == m) {
					max = m;
					break;
				}
			}
			sb.append("#").append(i+1).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
