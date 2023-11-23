package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p12865 {
	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] bag = new int[N+1][2];
		for(int i=1;i<bag.length;i++) {
			st = new StringTokenizer(br.readLine());
			bag[i][0] = Integer.parseInt(st.nextToken());
			bag[i][1] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N+1][K+1];
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				dp[i][j] = dp[i-1][j];
				if(j-bag[i][0] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-bag[i][0]]+bag[i][1]);					
				}
			}
		}
		System.out.println(dp[N][K]);	
	}

}
