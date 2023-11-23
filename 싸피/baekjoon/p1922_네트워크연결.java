package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class p1922_네트워크연결 {

	static class Node implements Comparable<Node>{
		int A, B, weight;

		public Node(int a, int b, int weight) {
			super();
			A = a;
			B = b;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
	}
	
	static int N, M;
	static List<Node> list;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Node(a, b, w));
		}
		Collections.sort(list);
		MST();
	}

	private static void makeUnion() {
		parent = new int[N+1];
		for(int i=1; i<N;i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) {
			return false;
		}
		parent[rootB] = rootA;
		return true;
	}
	
	private static void MST() {
		makeUnion();
		int cnt = 0;
		int hap = 0;
		for(int i=0;i<list.size();i++) {
			Node node = list.get(i);
			if(union(node.A, node.B)) {
				hap += node.weight;
				cnt++;
			}
			if(cnt == N-1) {
				break;
			}
		}
		System.out.println(hap);
		
	}

}
