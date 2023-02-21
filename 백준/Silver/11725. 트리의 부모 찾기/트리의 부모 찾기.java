import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int[] result;
	public static void dfs(int node, int parent) {
		for(int j=0;j<tree[node].size();j++) {
			if(tree[node].get(j) == parent) {
				continue;
			}
			if(!visited[node]) {
				visited[node] = true;
				result[tree[node].get(j)] = node;
				dfs(tree[node].get(j), node);
				visited[node] = false;
			}
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		result = new int[N+1];
		for(int i=0;i<tree.length;i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		dfs(1, 0);
		for(int i=2;i<result.length;i++) {
			sb.append(result[i]+"\n");
		}
		System.out.println(sb);
		
	}

}
