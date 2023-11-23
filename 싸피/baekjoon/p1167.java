package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1167 {

	static int[] distance;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine());
		List<int[]>[] graph = new ArrayList[V + 1];
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			graph[a] = new ArrayList<>();
			while (true) {
				int b = Integer.parseInt(st.nextToken());
				if (b == -1)
					break;
				int c = Integer.parseInt(st.nextToken());
				graph[a].add(new int[] { b, c });
			}
		}
		distance = new int[V+1];
		bfs(graph, V, 1);
		int idx = 0;
		for(int i=1;i<distance.length;i++) {
			if(distance[idx] < distance[i]) {
				idx = i;
			}
		}
		
		distance = new int[V+1];
		bfs(graph, V, idx);

		Arrays.sort(distance);
		System.out.println(distance[distance.length-1]);
//		for (int i = 1; i < graph.length; i++) {
//			for (int j = 0; j < graph[i].size(); j++) {
//				System.out.println(i + " : " + Arrays.toString(graph[i].get(j)));
//			}
//		}
	}

	private static void bfs(List<int[]>[] graph, int V, int start) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[V + 1];

		queue.add(new int[] { start, 0 });
		int sum = 0;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			visited[temp[0]] = true;
			for (int j = 0; j < graph[temp[0]].size(); j++) {
				if (!visited[graph[temp[0]].get(j)[0]]) {
					queue.add(graph[temp[0]].get(j));
					distance[graph[temp[0]].get(j)[0]] = distance[temp[0]] + graph[temp[0]].get(j)[1];
				}
			}
		}
	}

}
