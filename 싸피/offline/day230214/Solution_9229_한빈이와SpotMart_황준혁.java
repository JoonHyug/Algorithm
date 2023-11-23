package offline.day230214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart_황준혁 {
	
	static int N;
	static int M;
	static int[] arr;
	static int max;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<arr.length;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			visited = new boolean[N];
			max = 0;
			dfs(0, 0);
			System.out.printf("#%d %d\n", tc, max == 0? -1:max);
		}
	}
	private static void dfs(int cnt, int sum) {
		if(cnt == 2) {
			if(sum <= M) {
				max = Math.max(max, sum);
			}
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt + 1, sum + arr[i]);
				visited[i] = false;
			}
		}
	}
}
