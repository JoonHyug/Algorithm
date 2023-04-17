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

	static int N;
	static List<Node>[] graph;
	static int longest;
	static int result;
	static class Node {
		int node;
		int weight;
		public Node(int next, int weight) {
			super();
			this.node = next;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		graph = new List[N+1];
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		longest = 0;
		dijkstra(1);
		dijkstra(longest);
		System.out.println(result);
	}
	
	private static void dijkstra(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		queue.add(start);
		visited[start] = true;
		int[] distance = new int[N+1];
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0;i<graph[now].size();i++) {
				Node next = graph[now].get(i);
				if(!visited[next.node]) {
					visited[next.node] = true;
					distance[next.node] = Math.max(distance[next.node], distance[now]+ next.weight);
					queue.add(next.node);
				}
			}
		}
		int max = 0;
		for(int i=1;i<distance.length;i++) {
			if(max < distance[i]) {
				max = distance[i];
				longest = i;
			}
		}
//		System.out.println(Arrays.toString(distance));
//		System.out.println(longest);
		result = distance[longest];
	}

}