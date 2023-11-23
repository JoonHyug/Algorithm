package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2252_줄세우기 {

	static int N, M;
	static List<Integer>[] list;
	static int[] degree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new List[N + 1];
		degree = new int[N + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
			degree[B]++;
		}
//		System.out.println(Arrays.toString(degree));
		topologySort();
	}

	private static void topologySort() {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i < degree.length; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int now = queue.poll();
			visited[now] = true;
			System.out.print(now + " ");
			for (int i = 0; i < list[now].size(); i++) {
				degree[list[now].get(i)]--;
				if (degree[list[now].get(i)] == 0) {
					if (!visited[list[now].get(i)]) {
						visited[list[now].get(i)] = true;
						queue.add(list[now].get(i));
					}
				}
			}
		}
	}

}
