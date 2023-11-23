package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	static int N;
	static int[][] arr;
	static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int y=0;y<arr.length;y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=0;x<arr[y].length;x++) {
					arr[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			temp = new int[N/2];
			dfs(0, 0);

			System.out.printf("#%d %d", tc, 0);
		}
	}
	private static void dfs(int cnt, int start) {
		if(cnt == N/2) {
			return;
		}
		for(int i=start;i<N;i++) {
			dfs(cnt + 1, i + 1);
		}
	}

}
