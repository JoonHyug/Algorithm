package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1647_도시분할계획 {

	static class Node implements Comparable<Node>{
		int node;
		int weight;
		public Node(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static int N, M;
	static List<Node>[] graph;
	static int[] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new List[N+1];
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, w));
			graph[b].add(new Node(a, w));
		}
		MST();
	}
	
	static void MST() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		pq.add(new Node(1, 0));
		int cnt = 0;
		int max = 0;
		int hap = 0;
		distance[1] = 0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			max = Math.max(max, distance[n.node]);
			if(visited[n.node]) continue;
			else visited[n.node] = true;
			if(cnt == N-1) {
				break;
			}
			cnt++;
			for(int i=0;i<graph[n.node].size();i++) {
				Node node = graph[n.node].get(i);
				if(!visited[node.node]) {
					distance[node.node] = Math.min(distance[node.node], node.weight);
					pq.add(new Node(node.node, node.weight));
				}
			}
		}
//		System.out.println(Arrays.toString(distance));
		for(int i=1;i<distance.length;i++) {
			hap += distance[i];
		}
		System.out.println(hap - max);
		
	}

}
