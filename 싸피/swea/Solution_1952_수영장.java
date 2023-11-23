package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {

	static int[] price;
	static int[] month;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1;tc<=T;tc++) {
			price = new int[4];
			month = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<price.length;i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<month.length;i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			dfs(0, 0);
			min = Math.min(min, price[3]);
			sb.append("#"+tc+" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int cnt, int sum) {
		if(cnt == 12) {
			min = Math.min(min, sum);
			return;
		}
		if(month[cnt] != 0) {
			dfs(cnt + 1, sum + (price[0] * month[cnt]));
			dfs(cnt + 1, sum + price[1]);
			if(cnt + 3 <= 12) {
				dfs(cnt + 3, sum + price[2]);								
			} else {
				dfs(cnt + 1, sum + price[2]);
			}
		} else {
			dfs(cnt + 1, sum);
		}
	}

}
