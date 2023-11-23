package offline.day230303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_Main_7576_토마토_황준혁 {

	static int N, M;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<map.length;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<map[i].length;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		List<Node> temp = new ArrayList<>();
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(map[i][j] == 1) {
					temp.add(new Node(j, i));
//					bfs(new Node(j, i));
				}
			}
		}
		
		bfs(temp);
		
		int max = Integer.MIN_VALUE;
		boolean isZero = false;
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(map[i][j] == 0) isZero = true;
				max = Math.max(max, map[i][j]);
			}
		}
		if(isZero) {
			System.out.println("-1");
		} else {
			System.out.println(max - 1);
		}
		
		
	}
	
	private static void bfs(List<Node> start) {
		Queue<Node> queue = new ArrayDeque<>();
		for(int i=0;i<start.size();i++) {
			queue.add(start.get(i));			
		}
		boolean[][] visited = new boolean[N][M];
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int d=0;d<4;d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];
				if(0<=nx && nx < M && 0<=ny && ny < N && !visited[ny][nx] && map[ny][nx] == 0) {
					visited[ny][nx] = true;
					map[ny][nx] = map[node.y][node.x] + 1;
//					for(int i=0;i<map.length;i++) {
//						for(int j=0;j<map[i].length;j++) {
//							System.out.print(map[i][j]+" ");
//						}
//						System.out.println();
//					}
//					System.out.println("========================");
					queue.add(new Node(nx, ny));
				}
			}
		}
	}

}
