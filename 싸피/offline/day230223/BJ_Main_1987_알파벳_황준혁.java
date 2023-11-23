package offline.day230223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_Main_1987_알파벳_황준혁 {

	static int R, C;
	static char[][] arr;
	static boolean[] alpha;
	static boolean[][] visited;
	static int max;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		alpha = new boolean[26];
		visited = new boolean[R][C];
		max = 0;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	private static void dfs(int x, int y, int cnt) {
		if(cnt == 10) {
			
		}
		max = Math.max(max, cnt);
		System.out.println(x + ", " + y + ", " + cnt);
		System.out.println(arr[y][x]);
		visited[y][x] = true;
		alpha[arr[y][x] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= ny && ny < R && 0 <= nx && nx < C && !visited[ny][nx]) {
				if (!alpha[arr[ny][nx] - 'A']) {
//					System.out.println(arr[ny][nx]);
					dfs(nx, ny, cnt + 1);
//					visited[y][x] = false;
//					alpha[arr[y][x] - 'A'] = false;
				}
//				visited[ny][nx] = true;
//				count++;
			}
		}
		visited[y][x] = false;
		alpha[arr[y][x] - 'A'] = false;

		return;
	}
}
