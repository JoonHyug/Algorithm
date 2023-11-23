/**
 * 문제 해석
 * - 그래프 문제
 * 	=> 무향 그래프, 양방향 그래프
 * 	- 번호가 그래프의 정점
 * 	- 주어지는 정보(친구 관계) 간선
 * - 각 정점이 있을 때, 임의의 정점부터 간선을 따라 5개의 정점을 방문할 수 있다면 1을 출력
 * 	=> 방문할 수 없다면 0을 출력
 * - BFS로는 올바른 결과 X
 * 	=> DFS 탐색
 * 
 * 문제 해결 프로세스
 * 1. 모든 정점에서 DFS 탐색
 * 2. 시작점을 포함 5개의 정점을 방문하면 1을 출력하고 종료
 * 
 */

package offline.day230224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_Main_13023_ABCDE_황준혁_교수님 {

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
