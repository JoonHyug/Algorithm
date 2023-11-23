package offline.day230302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_Main_1753_최단경로_황준혁 {

	static int V;
	static int E;
	static List<Node>[] list;
	static int[] distance;
	final static int INF = Integer.MAX_VALUE;
	
	static class Node{
		int node;
		int weight;
		public Node(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine()) - 1;
		
		list = new ArrayList[V];
		for(int i=0;i<list.length;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
		}
		
		distance = new int[V];
		Arrays.fill(distance, INF);
		dijkstra(start);
		for(int i=0;i<distance.length;i++) {
			sb.append(distance[i] == INF? "INF":distance[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static class Vertex implements Comparable<Vertex>{
		int no;
		int weight;
		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
		
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		distance[start] = 0;
		pq.add(new Vertex(start, 0));
//		boolean[] visited = new boolean[V];
		while(!pq.isEmpty()) {
			Vertex v = pq.poll();
			for(Node node : list[v.no]) {
//				if(!visited[node.node]) {
//					visited[node.node] = true;
					if(distance[node.node] > v.weight+node.weight) {
						distance[node.node] = v.weight+node.weight;
						pq.add(new Vertex(node.node, distance[node.node]));
					}
//				}
			}
		}
	}

}
