package offline.day230216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트_황준혁 {

	static int N;
	static int L;
	static int[][] arr;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][2];
			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			dfs(0, L, 0, 0);

			System.out.printf("#%d %s\n", tc, max);
		}
	}

	private static void dfs(int start, int cnt, int sum, int prev) {
		if (cnt < 0) {
			max = Math.max(max, sum - prev);
			return;
		}
		max = Math.max(max, sum);
		for (int i = start; i < arr.length; i++) {
			dfs(i + 1, cnt - arr[i][1], sum + arr[i][0], arr[i][0]);
		}
	}
}
