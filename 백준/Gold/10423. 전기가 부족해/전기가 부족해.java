import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[] elecCity;
	static List<Node> list;
	static int[] parent;

	static class Node implements Comparable<Node> {
		int a, b;
		int weight;

		public Node(int a, int b, int weight) {
			super();
			this.a = a;
			this.b = b;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		elecCity = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < elecCity.length; i++) {
			elecCity[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Node(a, b, w));
		}
		Collections.sort(list);
		makeSet();
		kruskal();
	}

	private static void makeSet() {
		parent = new int[N + 1];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	private static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB) {
			return false;
		}
		parent[rootB] = rootA;
		return true;
	}

	private static void kruskal() {
		boolean[] visited = new boolean[N + 1];
		int cnt = 0;
		int cost = 0;
		for (int e = 0; e < elecCity.length; e++) {
			parent[elecCity[e]] = 0;
		}
		for (Node node : list) {
			if (union(node.a, node.b)) {
				cnt++;
//				System.out.println(node.a+", "+node.b+" : "+node.weight);
				cost += node.weight;
				if (cnt == N - 1) {
					break;
				}
			}
		}
		System.out.println(cost);
	}

}