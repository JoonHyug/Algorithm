package offline.day230213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_Main_2023_신기한소수_황준혁 {

	static int N;
	static StringBuilder sb = new StringBuilder();	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(0, "");
		System.out.println(sb.toString());
	}
	
	private static void dfs(int cnt, String num) {
		if(cnt == N) {
			sb.append(num+"\n");
			return;
		}
		for(int i=1;i<=9;i++) {
			String temp = num + i;
			if(check(Integer.parseInt(temp))&& temp.charAt(0) != '1') {
				dfs(cnt+1, temp);
			}
		}
	}
	
	private static boolean check(int num) {
		for(int i=2;i<=num/2;i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
