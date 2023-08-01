package baekjoon;

import java.util.*;
import java.io.*;
public class Main_1244_김태훈 {
	static int n = 0;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; // 만들긴 하지만 대기하지마 나 스페이스바 안써.
		n = Integer.parseInt(br.readLine()); // 엔터로 받을거야
		int p = 0;
		arr = new int[n+1];
		st = new StringTokenizer(br.readLine()); // 스페이바로 받을거니까 대기해
		for (int i = 1; i <=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 스페이스바로 받르거야	//전구 순서
		}
		p = Integer.parseInt(br.readLine());		//사람 몇명인지?
		int gender = 0;
		for (int j = 0; j < p; j++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());		//성별 뭔지?
			if (gender == 1) {
				man(Integer.parseInt(st.nextToken()));		//1이면 남자니까 남자 메소드로 보내
			}
			else
				woman(Integer.parseInt(st.nextToken()));		//아니면 여자겠지. 여자 메소드로 보내!
		}
		for (int i = 1; i <= n; i++) {
			System.out.printf("%d ", arr[i]);
			if(i%20==0)
				System.out.println();
		}
		br.close();
	}

	private static void woman(int parseInt) {
		int xx = parseInt;
		if (arr[xx] == 1)
			arr[xx] = 0;
		else
			arr[xx] = 1;
		for (int i = 1; i <= n / 2; i++) {
			if (xx-i < 1 || xx+i > n || arr[xx - i] != arr[xx + i])
				break;
			else {
				if (arr[xx - i] == 1) {
					arr[xx - i] = 0;
					arr[xx + i] = 0;
				} else {
					arr[xx - i] = 1;
					arr[xx + i] = 1;
				}
			}

		}

	}

	private static void man(int parseInt) {
		int xy = parseInt;			//파라미터로 받아온거 xy에 담은 이유 -> xy 계속 커질거야. 3 -> 6 -> 9 -> 만약에 n보다 크면 멈출거야.
		while(xy <= n) {			//여기에 xy < n 이게 아니라 xy <= n 이걸로 했어야돼
			if(arr[xy] == 1) {
				arr[xy] = 0;
			}
			else
				arr[xy] = 1;
			
			xy += parseInt;
		}
	}

}
