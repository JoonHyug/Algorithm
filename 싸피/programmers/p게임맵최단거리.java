package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class p게임맵최단거리 {

	static int n;
	static int m;

	public static int solution(int[][] maps) {
		int answer = 0;
		n = maps.length; // y
		m = maps[0].length; // x
		answer = bfs(new int[] { 0, 0 }, maps);
		return answer;
	}

	private static int bfs(int[] value, int[][] maps) {
		Queue<int[]> queue = new LinkedList<>();
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		boolean[][] visited = new boolean[n][m];
		queue.add(value);
//		int cnt = 0;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			if (x == m - 1 && y == n - 1) {
				return maps[n - 1][m - 1];
			}
			// visited 위치에 따른 반복 비교
//			visited[y][x] = true;
//			for (int i = 0; i < visited.length; i++) {
//				for (int j = 0; j < visited[i].length; j++) {
//					System.out.print(visited[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("========================="+cnt++);
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= ny && ny < n && 0 <= nx && nx < m && !visited[ny][nx] && maps[ny][nx] != 0) {
					//외부에서 방문처리 하는거랑 내부에서 하는거랑 차이점?
                    //외부에서 하면 이미 방문했던 사방탐색 하면서 방문해본 곳을 이동해서 다시 
                    //방문하는거기 때문에 방문 횟수가 커짐
					visited[ny][nx] = true;
					maps[ny][nx] = maps[y][x] + 1;
					queue.add(new int[] { nx, ny });
				}
			}
		}
//    	for(int i=0;i<maps.length;i++) {
//    		for(int j=0;j<maps[i].length;j++) {
//    			System.out.print(maps[i][j]+" ");
//    		}
//    		System.out.println();
//    	}
		return -1;
	}

	public static void main(String[] args) {
		int[][] arr1 = { 
				{ 1, 0, 1, 1, 1 }, 
				{ 1, 0, 1, 0, 1 }, 
				{ 1, 0, 1, 1, 1 }, 
				{ 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };
		int[][] arr2 = { 
				{ 1, 0, 1, 1, 1 }, 
				{ 1, 0, 1, 0, 1 }, 
				{ 1, 0, 1, 1, 1 }, 
				{ 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1 } };
		int[][] arr3 = { 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1 } };

		System.out.println(solution(arr1));
		System.out.println(solution(arr2));
		System.out.println(solution(arr3));
	}

}
