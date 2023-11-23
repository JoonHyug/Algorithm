package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		for(int i=0;i<dp.length;i++) {
			dp[i] = 1;
		}
		int result = 0;
		for(int i=0;i<dp.length;i++) {
			//i보다 이전을 탐색
			for(int j=0;j<i;j++) {
				//arr[i]보다 작으면서, dp[i]보다 큰 값이 존재하면 dp[i]값을 그 값으로 갱신
				//30 > (10, 20, 10) && 1 < (2, 3, 2)
				//                          2로 갱신
				//                             3으로 갱신
				//해당 조건을 만족한다면 현재 보다 아래 있는 수열이기 때문에 dp[j](이전 최대 길이 수열)에 1을 더해줘야 한다. 
				if(arr[i] > arr[j] && dp[i] < dp[j]+1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		for(int i=0;i<dp.length;i++) {
			result = Math.max(result, dp[i]);			
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(result);

		
		
	}

}
