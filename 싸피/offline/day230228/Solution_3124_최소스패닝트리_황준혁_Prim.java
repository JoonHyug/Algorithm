package offline.day230228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리_황준혁_Prim {

	static int V, E;
	static int[] parents;
	static List<Node>[] list;

	static class Node {
		int node;
		int weight;

		public Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			list = new ArrayList[V];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken()) - 1;
				int B = Integer.parseInt(st.nextToken()) - 1;
				int weight = Integer.parseInt(st.nextToken());
				list[A].add(new Node(B, weight));
				list[B].add(new Node(A, weight));
			}

			parents = new int[V];
			sb.append("#" + tc + " ");
			sb.append(MST());
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static class Vertex implements Comparable<Vertex> {
		int no;
		int weight;

		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
	}

	private static long MST() {

		int cnt = 0;
		long cost = 0;

		int[] minEdge = new int[V];
		Arrays.fill(minEdge, Integer.MAX_VALUE);

		boolean[] isInTree = new boolean[V];
		minEdge[0] = 0;

		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(0, 0));

		while (true) {
			Vertex v = pq.poll();
			int minVertex = v.no;
			if (isInTree[minVertex])
				continue;

			isInTree[minVertex] = true;
			cnt++;
			cost += minEdge[minVertex];
			if (cnt == V)
				break;

//			for (int i = 0; i < list[minVertex].size(); i++) {
//				Node next = list[minVertex].get(i);
			for(Node next : list[minVertex]) {
				if (!isInTree[next.node]) {
					minEdge[next.node] = Math.min(minEdge[next.node], next.weight);
//					System.out.println(Arrays.toString(minEdge.clone()));
					pq.add(new Vertex(next.node, minEdge[next.node]));

				}
			}
//			System.out.println("=====================");
		}

		return cost;
	}

}
