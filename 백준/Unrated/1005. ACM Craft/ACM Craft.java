import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static List<Integer>[] graph;
	static int[] time;
	static int[] inDegree;
	static int W;
	static Node[] node;
	
	static class Node{
		int time, degree;
		public Node(int time, int degree) {
			super();
			this.time = time;
			this.degree = degree;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			time = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<time.length;i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			node = new Node[N+1];
			for(int i=1;i<node.length;i++) {
				node[i] = new Node(time[i], 1);
			}
			
			graph = new List[N+1];
			for(int i=0;i<graph.length;i++) {
				graph[i] = new ArrayList<>();
			}
			inDegree = new int[N+1];
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				inDegree[b]++;
			}
			W = Integer.parseInt(br.readLine());
			topologySort();
		}
	}
	
	private static void topologySort() {
		Queue<Integer> queue = new ArrayDeque<>();
		int[] cost = new int[N+1];
		for(int i=1;i<inDegree.length;i++) {
			if(inDegree[i] == 0) {
				cost[i] = time[i];
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0;i<graph[now].size();i++) {
				cost[graph[now].get(i)] = Math.max(cost[graph[now].get(i)], cost[now] + time[graph[now].get(i)]);
				node[graph[now].get(i)].degree++;
				if(--inDegree[graph[now].get(i)] == 0) {
					queue.add(graph[now].get(i));
				}
			}
		}
//		System.out.println(Arrays.toString(cost));
		System.out.println(cost[W]);
	}

}