import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

	static int[] dx = { 0, 1, 0, -1, -1, 1, -1, 1};
	static int[] dy = { 1, 0, -1, 0, -1, -1, 1, 1 };
	static int min;

	private static void dfs(boolean[][] map, int itemX, int itemY, int cnt, int x, int y, boolean[][] visited) {
		if (x == itemX && y == itemY) {
			min = Math.min(min, cnt);
			return;
		}
		System.out.println(y + ", " + x + " : " + cnt);
		int nx = 0, ny = 0;
		int zeroCnt = 0;
		for (int d = 0; d < 8; d++) {
			nx = x + dx[d];
			ny = y + dy[d];
			if (!map[ny][nx]) {
				zeroCnt++;
			}
		}

		visited[y][x] = true;
		for (int d = 0; d < 8; d++) {
			nx = x + dx[d];
			ny = y + dy[d];
			if (map[ny][nx] == true && !visited[ny][nx]) {
				// 8방향 중 을 하나라도 포함하고 있어야지 테두리
				if (zeroCnt >= 1) {
					dfs(map, itemX, itemY, cnt + 1, nx, ny, visited);
				}
			}
		}

	}
	
	private static void bfs(boolean[][] map, int maxSize, int characterX, int characterY, int itemX, int itemY) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[maxSize][maxSize];
		visited[characterY][characterX] = true;
		queue.add(new int[] {characterX, characterY, 1});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			int count = now[2];
//			System.out.println(y + ", " + x + " : " + count);
			if(x == itemX && y == itemY) {
				min = Math.min(min, count);
			}
			int zeroCnt = 0;
			for(int d=0;d<8;d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(!map[ny][nx]) {
					zeroCnt++;
				}
			}
			for(int d=0;d<4;d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(map[ny][nx] == true && !visited[ny][nx]) {
					if(zeroCnt >= 1) {
						visited[ny][nx] = true;
						queue.add(new int[] {nx, ny, count+1});
					}
				}
			}
		}
	}

	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int maxSize = 0;
		for (int i = 0; i < rectangle.length; i++) {
			for (int j = 0; j < rectangle[i].length; j++) {
				maxSize = Math.max(maxSize, rectangle[i][j]);
			}
		}
		boolean[][] map = new boolean[(maxSize+1)*2][(maxSize+1)*2];
		for (int i = 0; i < rectangle.length; i++) {
			for (int y = rectangle[i][1]*2; y <= rectangle[i][3]*2; y++) {
				for (int x = rectangle[i][0]*2; x <= rectangle[i][2]*2; x++) {
					map[y][x] = true;
				}
			}
		}
//		System.out.printf("%2d ", 0);
//		for(int a=0;a<map.length;a++) {
//			System.out.printf("%2d ", a);
//		}
//		System.out.println();
//		for (int a = 0; a < map.length; a++) {
//			System.out.printf("%2d ", a);
//			for (int j = 0; j < map[a].length; j++) {
//				System.out.printf("%2d ", map[a][j] ? 1 : 0);
//			}
//			System.out.println();
//		}
//		System.out.println("======================");
		
		min = Integer.MAX_VALUE;
//		dfs(map, itemX*2, itemY*2, 1, characterX*2, characterY*2, new boolean[(maxSize+1)*2][(maxSize+1)*2]);
		bfs(map, (maxSize+1)*2, characterX*2, characterY*2, itemX*2, itemY*2);
		return min/2;
	}

	 // public static void main(String[] args) {
	 // 	int[][] rectangle1 = { { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } };
	 // 	int[][] rectangle2 = { { 1, 1, 8, 4 }, { 2, 2, 4, 9 }, { 3, 6, 9, 8 }, { 6, 3, 7, 7 } };
	 // 	int[][] rectangle3 = { { 1, 1, 5, 7 } };
	 // 	int[][] rectangle4 = { { 2, 1, 7, 5 }, { 6, 4, 10, 10 } };
	 // 	int[][] rectangle5 = { { 2, 2, 5, 5 }, { 1, 3, 6, 4 }, { 3, 1, 4, 6 } };
	 // 	System.out.println(solution(rectangle1, 1, 3, 7, 8));
	 // 	System.out.println(solution(rectangle2, 9, 7, 6, 1));
	 // 	System.out.println(solution(rectangle3, 1, 1, 4, 7));
	 // 	System.out.println(solution(rectangle4, 3, 1, 7, 10));
	 // 	System.out.println(solution(rectangle5, 1, 4, 6, 3));
	 // }

}
