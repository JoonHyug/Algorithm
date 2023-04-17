import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int result;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Node {
		int x, y, count;
		boolean flag;

		public Node(int x, int y, int count, boolean flag) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.flag = flag;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		result = -1;
		bfs(0, 0);
		System.out.println(result);
//		if(result == Integer.MAX_VALUE) {
//			System.out.println(-1);
//		} else {
//			System.out.println(result);
//		}
	}

	private static void bfs(int x, int y) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(x, y, 1, false));
		boolean[][][] visited = new boolean[N][M][2];
		visited[y][x][1] = true;
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (now.x == M - 1 && now.y == N - 1) {
				result = now.count;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if (0 <= nx && nx < M && 0 <= ny && ny < N) {

					if (map[ny][nx] == 1) {
						if (!now.flag) {
							visited[ny][nx][1] = true;
							queue.add(new Node(nx, ny, now.count + 1, true));
						}
					} else if (map[ny][nx] == 0) {
						if (!now.flag && !visited[ny][nx][0]) {
							visited[ny][nx][0] = true;
							queue.add(new Node(nx, ny, now.count + 1, now.flag));
						} else if (now.flag && !visited[ny][nx][1]) {
							visited[ny][nx][1] = true;
							queue.add(new Node(nx, ny, now.count + 1, true));
						}
					}
				}
			}
		}
	}

}