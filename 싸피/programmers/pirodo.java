package programmers;

import java.util.ArrayList;

public class pirodo {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static boolean[] visited;
	
	public static void dfs(int[][] a, int k, int m) {
		for(int i=0;i<a.length;i++) {
			if(!visited[i] && a[i][0] <= k) {
				visited[i] = true;
				dfs(a, k - a[i][1], m+1);
				visited[i] = false;
			}
		}
		list.add(m);
	}
	
	public static int solution (int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		dfs(dungeons, k, 0);
		int max = 0;
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
			max = Math.max(max, list.get(i));
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] dungeons1 = {{80, 20}, {50, 40}, {30, 10}};
		System.out.println(solution(80, dungeons1));

	}

}
