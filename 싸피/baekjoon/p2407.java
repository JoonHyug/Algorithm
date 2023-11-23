package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2407 {

	static long totalCount;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dfs(0, 0);
		System.out.println(totalCount);

	}
	
	private static void dfs(int cnt, int start) {
		if(cnt == M) {
			totalCount++;
			return;
		}
		for(int i=start;i<N;i++) {
			dfs(cnt+1, i+1);
		}
	}

}
