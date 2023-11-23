package offline.day230221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_Main_3109_빵집_황준혁 {

	static int R, C;
	static int[] dr = {-1, 0, 1};
	static char[][] map;
	static int resultCnt;
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		resultCnt = 0;
		for(int i=0;i<R;i++) {
			check = false;
			dfs(i, 0);			
		}
		System.out.println(resultCnt);
	}
	private static void dfs(int r, int c) {
		if(c == C-1) {
			resultCnt++;
			check = true;
			return;
		}
		for(int i=0;i<dr.length;i++) {
			int nr = r + dr[i];
			int nc = c + 1;
			if(0 <= nr && nr < R && nc < C && map[nr][nc] == '.') {
				if(!check) {
					map[nr][nc] = '-';
					dfs(nr, nc);					
				}
			}
		}
	}
	private static void print() {
		for(int i=0;i<map.length;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

}
