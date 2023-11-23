package offline.day230224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_Main_10026_적록색약_황준혁 {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int nCount;
	static int lCount;
	static int N;
	static char[][] temp;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		temp = new char[N][N];
		for(int i=0;i<temp.length;i++) {
			temp[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[N][N];
		
		for(int i=0;i<temp.length;i++) {
			for(int j=0;j<temp[i].length;j++) {
				if(!visited[i][j]) {
					bfs(temp[i][j], new int[] {i, j});
				}
			}
		}
		visited = new boolean[N][N];
		for(int i=0;i<temp.length;i++) {
			for(int j=0;j<temp[i].length;j++) {
				if(temp[i][j] == 'G') {
					temp[i][j] = 'R';
				}
			}
		}
		for(int i=0;i<temp.length;i++) {
			for(int j=0;j<temp[i].length;j++) {
				if(!visited[i][j]) {
					bfs2(temp[i][j], new int[] {i, j});
				}
			}
		}
		System.out.println(nCount+" "+lCount);
	}

	
	private static void bfs(char color, int[] position) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(position);
		int x = position[0];
		int y = position[1];
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];
				if(0<=nx && nx < N && 0<= ny && ny < N && !visited[nx][ny] && temp[nx][ny] == color) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		nCount++;
	}
	
	private static void bfs2(char color, int[] position) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(position);
		int x = position[0];
		int y = position[1];
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];
				if(0<=nx && nx < N && 0<= ny && ny < N && !visited[nx][ny] && temp[nx][ny] == color) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		lCount++;
	}
}
