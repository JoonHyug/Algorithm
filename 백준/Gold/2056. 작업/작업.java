import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] indegree;
	static int[] weight;
	static List<Integer>[] graph;
	static int[] result;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		graph = new List[N+1];
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		indegree = new int[N+1];
		weight = new int[N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			weight[i] = w;
			for(int j=0;j<n;j++) {
				int next = Integer.parseInt(st.nextToken());
				graph[next].add(i);
				indegree[i]++;
			}
		}
		topologySort();
	
	}
	private static void topologySort() {
		Queue<Integer> queue = new ArrayDeque<>();
		result = new int[N+1];
		for(int i=1;i<indegree.length;i++) {
			if(indegree[i] == 0) {
				result[i] = weight[i];
				answer = Math.max(answer, weight[i]);
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int temp = 0;
			int now = queue.poll();
			for(int i=0;i<graph[now].size();i++) {
				int next = graph[now].get(i);
				result[next] = Math.max(result[next], result[now] + weight[next]);
				if(--indegree[next] == 0) {
					answer = Math.max(answer, result[next]);
					queue.add(next);
				}
			}
		}
		System.out.println(answer);
	}

}