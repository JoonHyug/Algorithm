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

public class BJ_Main_1260_DFS와BFS_황준혁 {

	static int N;
	static int M;
	static int[] result;
	static boolean[] dfs_visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()) + 1;
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		for(int i=0;i<list.length;i++) {
			list[i] = new ArrayList<>();			
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=0;i<list.length;i++) {
			Collections.sort(list[i]);
		}
		result = new int[N];
		dfs_visited = new boolean[N];
		dfs(V);
		System.out.println();
		bfs(V);
	}

	private static void dfs(int node) {
		dfs_visited[node] = true;
		System.out.print(node + " ");
		for (int i = 0; i < list[node].size(); i++) {
			if (!dfs_visited[list[node].get(i)]) {
				
				dfs(list[node].get(i));
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
			for (int i = 0; i < list[now].size(); i++) {
				if (!visited[list[now].get(i)]) {
					visited[list[now].get(i)] = true;
					queue.offer(list[now].get(i));
				}
			}
		}
	}

}
