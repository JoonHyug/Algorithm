import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	final static int INF = Integer.MAX_VALUE;
	
	static int V, E;
	static List<Node>[] graph;
	
	static class Node{
		int node, weight;

		public Node(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new List[V];
		
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, w));
			graph[b].add(new Node(a, w));
		}
		MST();
		
	}
	
	static class Vertex implements Comparable<Vertex>{
		int node;
		int weight;
		public Vertex(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
	}
	
	private static void MST() {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V];
		long cost = 0;
		int cnt = 0;
		int[] distance = distance = new int[V];
		Arrays.fill(distance, INF);
		distance[0] = 0;
		pq.add(new Vertex(0, 0));
		while(true) {
			Vertex v = pq.poll();
			if(visited[v.node]) continue;
			visited[v.node] = true;
			cnt++;
			cost += distance[v.node];			
			if(cnt == V) break;
			
			for(Node n : graph[v.node]) {
				if(!visited[n.node]) {
					distance[n.node] = Math.min(distance[n.node], n.weight);
					pq.add(new Vertex(n.node, distance[n.node]));
				}
			}
		}
		System.out.println(cost);
	}

}