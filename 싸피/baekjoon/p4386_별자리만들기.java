package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p4386_별자리만들기 {

	static int N;
	static List<Node>[] graph;
	static float[][] coord;

	static class Node implements Comparable<Node> {
		int idx;
		float weight;

		public Node(int idx, float dist) {
			super();
			this.idx = idx;
			this.weight = dist;
		}

		@Override
		public int compareTo(Node o) {
			return Float.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new List[N];
		coord = new float[N][2];
		for (int i = 0; i < coord.length; i++) {
			st = new StringTokenizer(br.readLine());
			coord[i][0] = Float.parseFloat(st.nextToken());
			coord[i][1] = Float.parseFloat(st.nextToken());
		}
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		// 모든 경우를 탐색하기 때문에 양방향 그래프가 만들어진다.
		for (int i = 0; i < coord.length; i++) {
			for (int j = 0; j < coord.length; j++) {
				if (i == j)
					continue;
				float dist = (float) Math
						.sqrt((Math.pow(coord[i][0] - coord[j][0], 2) + Math.pow(coord[i][1] - coord[j][1], 2)));
				graph[i].add(new Node(j, dist));
//				System.out.println(i + ", " + j + " : " + dist);
			}
		}
		MST();
	}

	private static void MST() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N];
		pq.add(new Node(0, 0));
		float[] distance = new float[N];
		Arrays.fill(distance, Float.MAX_VALUE);
		distance[0] = 0;
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			visited[n.idx] = true;
			for (Node node : graph[n.idx]) {
				if (!visited[node.idx]) {
					distance[node.idx] = Math.min(distance[node.idx], node.weight);
					pq.add(new Node(node.idx, distance[node.idx]));
				}
			}
		}
		float hap = 0;
		for(int i=0;i<distance.length;i++) {
			hap += distance[i];
		}
//		System.out.println(hap);
		System.out.printf("%.2f\n", hap);
//		System.out.println(Arrays.toString(distance));
	}

}
