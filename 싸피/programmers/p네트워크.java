package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class p네트워크 {

	static boolean[] visited;
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n];
		for (int i = 0; i < computers.length; i++) {
			if(bfs(n, i, computers)) answer++;
		}
		return answer;
	}

	private static boolean bfs(int n, int start, int[][] computers) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		if(visited[start]) return false;
		visited[start] = true;
		while (!queue.isEmpty()) {
			// node는 0번째 노드를 가리키는 인덱스
			int node = queue.poll();
			//노드와 연결된 인덱스를 순회(자기자신 제외)
			for (int j = 0; j < computers[node].length; j++) {
				if(node == j) continue;
				if (computers[node][j] == 1) {
					if (!visited[j]) {
						visited[j] = true;
						queue.add(j);
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] temp = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int[][] temp2 = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		System.out.println(solution(3, temp));
		System.out.println(solution(3, temp2));
	}

}
