package offline.day230213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1228_암호문1_황준혁 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=1;tc<=10;tc++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			ArrayList<String> pwd = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				pwd.add(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "I");
			for(int i=0;i<M;i++) {
				String[] temp = st.nextToken().trim().split(" ");
				int s = Integer.parseInt(temp[0]);
				int e = Integer.parseInt(temp[1]);
				for(int j=0;j<e;j++) {
					pwd.add(s+j, temp[2+j]);
				}
			}
			for(int i=0;i<10;i++) {
				sb.append(pwd.get(i)+" ");
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
		}
	}

}
