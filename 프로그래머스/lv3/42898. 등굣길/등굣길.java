import java.util.Arrays;

public class Solution {
	
	//이동한 칸 수가 아니라 현재 칸까지 이동 가능한 경우의 합을 구해야 한다.
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<puddles.length;i++) {
        	int[] xy = puddles[i];
        	dp[xy[1]][xy[0]] = -1;
        }
        dp[1][1] = 1;
        for(int r=0;r<=n;r++) {
        	for(int c=0;c<=m;c++) {
        		if(r == 0 || c == 0) {
        			dp[r][c] = -1;
        		}
        		if(dp[r][c] != -1) {
        			if(dp[r-1][c] != -1) dp[r][c] += dp[r-1][c] %1000000007;
        			if(dp[r][c-1] != -1) dp[r][c] += dp[r][c-1] %1000000007;
//        			dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]) + 1;        			
        		}
        	}
        }
        // for(int i=0;i<dp.length;i++) {
        // 	System.out.println(Arrays.toString(dp[i]));
        // }
        answer = dp[n][m];
        return answer%1000000007;
    }

	// public static void main(String[] args) {
	// 	int[][] puddles = {{2, 2}};
	// 	System.out.println(solution(4, 3, puddles));
	// }

}
