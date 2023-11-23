package offline.day230210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution_2001_파리퇴치_황준혁 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] temp = new int[N+1][N+1];
			int[][] dp = new int[N+1][N+1];
			for(int i=1;i<temp.length;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1;j<temp[i].length;j++) {
					temp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0;
			for(int i=1;i<dp.length;i++) {
				for(int j=1;j<dp[i].length;j++) {
					dp[i][j] = temp[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
				}
			}
			for(int i=1;i<dp.length;i++) {
				for(int j=1;j<dp[i].length;j++) {
					if(i-M >= 0 && j-M >= 0) {
						result = Math.max(result, dp[i][j] + dp[i-M][j-M] - dp[i-M][j] - dp[i][j-M]);						
					}
				}
			}
			for(int i=0;i<dp.length;i++) {
				for(int j=0;j<dp[i].length;j++) {
					System.out.print(dp[i][j]+" ");
				}
				System.out.println();
			}
			
			System.out.printf("#%d %d\n", tc, result);
			
		}
	}

}
