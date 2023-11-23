package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2206_벽부수고이동하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0;i<map.length;i++) {
			String s = br.readLine();
			for(int j=0;j<map[i].length;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		dfs(0, 0, new boolean[N][M]);
		
	}
	
	private static void dfs(int x, int y, boolean[][] visited) {
		
	}

}
