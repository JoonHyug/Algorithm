package offline.day230224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_Main_13023_ABCDE_황준혁 {

	static int N;
	static int M;
	static List<Integer>[] list;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		for(int i=0;i<list.length;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
//		System.out.println(Arrays.toString(list));
		answer = 0;
		for(int i=0;i<N;i++) {
			dfs(1, i, new boolean[N]);
			if(answer == 1) break;
		}
		System.out.println(answer);
	}
	
	private static void dfs(int cnt, int node, boolean[] visited) {
		if(cnt == 5) {
			answer = 1;
			return;
		}
		for(int i=0;i<list[node].size();i++) {
			if(!visited[list[node].get(i)]) {
				visited[list[node].get(i)] = true;
				dfs(cnt + 1, list[node].get(i), visited);
				visited[list[node].get(i)] = false;
			}
		}
	}

}
