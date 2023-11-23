package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3040 {

	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[9];
		visited = new boolean[9];
		sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0, 0);
		System.out.println(sb.toString());
	}

	private static void dfs(int cnt, int start, int sum) {
		if (cnt == 7) {
			if(sum == 100) {
				for(int i=0;i<visited.length;i++) {
					if(visited[i]) {
						sb.append(arr[i]+"\n");
					}
				}
			}
			return;
		}
		for(int i=start;i<arr.length;i++) {
			visited[i] = true;
			dfs(cnt + 1, i + 1, sum + arr[i]);
			visited[i] = false;
		}
	}

}
