package offline.day230228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact_황준혁 {
	
	static List<Integer>[] list;
	static int num = 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			list = new ArrayList[num + 1];
			for(int i=0;i<list.length;i++) {
				list[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N/2;i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
			}
			bfs(start, tc);
		}
	}
	
	private static void bfs(int start, int tc) {
		Queue<Integer> queue = new ArrayDeque<>();
		int[] visited = new int[num + 1];
		queue.add(start);
		visited[start] = 1;
		int max = 0;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0;i<list[now].size();i++) {
				if(visited[list[now].get(i)] == 0) {
					visited[list[now].get(i)] = visited[now] + 1;
					max = Math.max(max, visited[list[now].get(i)]);
					queue.add(list[now].get(i));
				}
			}
		}
		List<Integer> arr = new ArrayList<>();
		int result = 0;
		for(int i=0;i<visited.length;i++) {
			if(visited[i] == max) {
				arr.add(i);
				result = Math.max(result, i);
			}
		}
		System.out.printf("#%d %d\n", tc, result);
	}

}
