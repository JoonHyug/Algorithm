package offline.day230214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_Main_2798_블랙잭_황준혁 {

	static int N;
	static int M;
	static int[] temp;
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		temp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<temp.length;i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N];
		dfs(0, 0);
		System.out.println(result);
	}
	
	private static void dfs(int cnt, int sum) {
		if(cnt == 3) {
			if(sum <= M) {
				result = Math.max(result, sum);				
			}
			return;
		}
		for(int i=0;i<temp.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt + 1, sum + temp[i]);
				visited[i] = false;
			}
		}
	}

}
