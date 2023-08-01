package baekjoon;
import java.util.*;
import java.io.*;
public class Main_15649_김태훈 {
	static int n;
	static int m;
	static int[] numbers;
	static boolean[] isSelected;
	static void perm(int count) {
		
		if(m==count) {
			for (int num : numbers) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		else {
			for(int i=1; i<=n; i++) {
				if(isSelected[i])
					continue;
				numbers[count] = i;
				isSelected[i] = true;
				perm(count+1);
				isSelected[i]=false;
			}
		}
	}
	
	
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		numbers = new int[m];
		isSelected = new boolean[n+1];
		perm(0);
	}

}
