/**
 * 적록 색양
 * - R, G를 같은 색으로 판단
 * - RGB가 있고 4방에 같은 글자인 경우, 같은 구역으로 판단
 * 
 * 문제 해석
 * - 적록색약이 아닌 사람과 적록색약인 사라밍 보았을 때의 구역의 개수를 구하기
 * 
 * 문제 접근
 * - BFS, DFS 기본적으로 완탐
 * 	- 이 때, 각 정점에서 이동할 수 있는 정점은 사방에 있는 정점
 * 		=> 2차원배열의 모든 좌표를 탐색
 * 	- 이 때, BFS or DFS 탐색의 시작점의 색과 같은 경우에만 탐색을 이어간다는 조건을 추가
 * 		=> 같은 색인 구역을 하나 탐색을 완료
 *  - 남은 구역 중 방문하지 않은 좌표하나를 골라 BFS or DFS 탐색을 하면 시작점의 색의 구역을 하나 탐색 완료
 *  - 위의 과정을 반복하며 DFS or BFS 탐색을 몇번 했냐가 구역의 개수가 됨.
 *  - 적록색약인 사람의 경우
 *  	=> 탐색의 시작점이 R, G인 경우, 탐색을 이어나가는 조건을 R 또는 G로 설정하여 탐색
 *  
 *  1. 방문하지 않은 정점 찾기
 *  2. 해당 정점을 기준으로 BFS or DFS 탐색
 *  	=> 구역의 수를 cnt
 *  	=> 사방탐색, 경계를 벗어나면 X, 방문 X, 시작점의 색과 일치
 */
package offline.day230224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_Main_10026_적록색약_황준혁_교수님 {
	
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
