package offline.day230228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리_황준혁_Kruskal {
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	
	static int V, E;
	static Edge[] edgeList;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[E];
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken()) - 1; 
				int B = Integer.parseInt(st.nextToken()) - 1; 
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(A, B, weight);
			}
			parents = new int[V];
			sb.append("#"+tc+" ");
			sb.append(MST());
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static long MST() {
		makeSet();
		
		Arrays.sort(edgeList);
		
		
		int cnt = 0;
		long cost = 0;
		for(Edge edge : edgeList) {
			int A = edge.from;
			int B = edge.to;
			int weight = edge.weight;
			if(union(A, B)) {
				cnt++;
				cost += weight;
				if(cnt == V-1) break;
				
			}
		}
		
		return cost;
	}

	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parents[rootB] = rootA;
		return true;
	}

	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	private static void makeSet() {
		for(int i=0;i<parents.length;i++) {
			parents[i] = i;
		}
	}

}
