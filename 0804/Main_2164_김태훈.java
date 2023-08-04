package baekjoon;
import java.util.*;
import java.io.*;
public class Main_2164_김태훈 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> que = new ArrayDeque<>();
		for(int i=1; i<=n; i++) {
			que.offerLast(i);
		}
		while(n>1) {
			que.pollFirst();
			int num = que.pollFirst();
			que.offerLast(num);
			n--;
		}
		System.out.println(que.poll());
	}

}
