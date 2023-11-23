package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1766_문제집 {
	
	static int N, M;
	static List<Integer>[] graph;
	static int[] degree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new List[N+1];
		degree = new int[N+1];
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			degree[b]++;
		}
//		for(int i=0;i<graph.length;i++) {
//			System.out.println(graph[i]);
//		}
//		System.out.println(Arrays.toString(degree));
		topologySort();
	}
	
	private static void topologySort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1;i<degree.length;i++) {
			if(degree[i] == 0) {
				pq.add(i);
			}
		}
		while(!pq.isEmpty()) {
			int now = pq.poll();
			System.out.print(now+" ");
			for(int i=0;i<graph[now].size();i++) {
				degree[graph[now].get(i)]--;
				if(degree[graph[now].get(i)] == 0) {
					pq.add(graph[now].get(i));
				}
			}
		}
	}

}
