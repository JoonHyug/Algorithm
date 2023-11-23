package offline.day230216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_4012_요리사_황준혁 {

	static int N;
	static int[][] arr;
	static ArrayList<Integer> comb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
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
			comb = new ArrayList<>();
			for(int y=0;y<N;y++) {
				for(int x=0;x<N;x++) {
					
				}
			}
			dfs(0, 0);
			System.out.println(comb);
			System.out.printf("#%d %d", tc, 0);
		}
	}
	private static void dfs(int cnt, int start) {
		if(cnt == N) {
			return;
		}
		for(int i=start;i<N;i++) {
			if(cnt != i) {
				System.out.println(cnt+" : "+arr[cnt][i] +", "+ arr[i][cnt]);
				comb.add(arr[cnt][i] + arr[i][cnt]);
				dfs(cnt + 1, i+1);				
			}
		}
	}

}
