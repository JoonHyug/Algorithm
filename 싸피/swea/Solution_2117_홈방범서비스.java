package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2117_홈방범서비스 {

	static int N, M;
	static int[][] map;
	static int max;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Node {
		int x, y;
		int length;

		public Node(int x, int y, int length) {
			super();
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					for (int n = 1; n <= N + 1; n++) {
						bfs(new Node(j, i, 1), n);
					}
				}
			}
			sb.append("#" + tc + " ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(Node start, int K) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(start);
		boolean[][] visited = new boolean[N][N];
		visited[start.y][start.x] = true;
		int cnt = 0;
		int cost = (K * K) + ((K - 1) * (K - 1));
		if (map[start.y][start.x] == 1)
			cnt++;
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[ny][nx] && now.length + 1 <= K) {
					if (map[ny][nx] == 1) {
						cnt++;
					}
					visited[ny][nx] = true;
					queue.add(new Node(nx, ny, now.length + 1));
				}
			}
		}
		int result = (cnt * M) - cost;
//		System.out.println("��� : " + cost + ", " + " �� �� : " + cnt + " ��� : " + result + " ������ġ(x, y) : " + start.x+ ", " + start.y);
		if (result >= 0) {
			max = Math.max(max, cnt);
		}
	}
}
