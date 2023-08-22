package baekjoon;
import java.util.*;
import java.io.*;
public class Main_1759_김태훈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int l, c;
	static String list[], permlist[];
	static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		list = new String[c];
		String in = br.readLine();
		list = in.split(" ");
		permlist = new String[l];
	}
	
	static void solve(int count, int start) {
		if(count == l) {
			int con_count = 0;
			int gather_count = 0;
			for (int i = 0; i < l; i++) {
				if(permlist[i].equals("a") || permlist[i].equals("e") || permlist[i].equals("i") || permlist[i].equals("o") || permlist[i].equals("u")) {
					con_count++;
				}else gather_count++;
			}
			if(con_count>0 && gather_count>1) {				
				for (String str : permlist) {
					sb.append(str);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = start; i < c; i++) {
			permlist[count] = list[i];
			solve(count+1, i+1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		init();
		Arrays.sort(list);
		solve(0, 0);
		System.out.println(sb);
	}

}
