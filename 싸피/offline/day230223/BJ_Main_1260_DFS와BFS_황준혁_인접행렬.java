package offline.day230223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_Main_1260_DFS와BFS_황준혁_인접행렬 {

	static int N;
	static int M;
	static int[][] arr;
	static boolean[] dfs_visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()) + 1;
		M = Integer.parseInt(st.nextToken()) + 1;
		int V = Integer.parseInt(st.nextToken());
		
		int lng = Math.max(N, M);
		
		arr = new int[N][N];
		for (int i = 1; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		dfs_visited = new boolean[N];
		dfs(V);
		System.out.println();
		bfs(V);
	}

	private static void dfs(int node) {
		dfs_visited[node] = true;
		System.out.print(node + " ");
		for (int i = 0; i < arr[node].length; i++) {
			if (arr[node][i] == 1 && !dfs_visited[i]) {
				dfs(i);
			}
		}
		return;
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		queue.offer(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for (int i = 0; i < arr[now].length; i++) {
				if (arr[now][i] == 1 &&!visited[i]) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}

}
