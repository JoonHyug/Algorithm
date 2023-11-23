/**
 * 특정 정점하나로부터 다른 모든 정점까지의 최단거리를 구하는 알고리즘
 */

package offline.day230302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra {

	static int V; // 정점의 개수
	static int start; // 최단거리를 구할 기준 정점
	static int end; // 최단거리를 구할 끝 정점

	static int[][] adjMatrix; // 인접 행렬

	// 모든 정점들을 경유지로 고려했을 때 각 정점까지의 최단거리
	static int[] distance; // 기준 정점으로 부터 각 정점까지의 최단 거리

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());

		V = Integer.parseInt(st.nextToken()); // 정점 갯수

		st = new StringTokenizer(in.readLine().trim());

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken()); // 도착점 인덱스

		adjMatrix = new int[V][V];
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(in.readLine().trim());
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dijkstra();
		System.out.println(Arrays.toString(distance));

	}

	private static void dijkstra() {
		distance = new int[V];

		// 최단 거리를 구할 때, 해당 정점을 경유지로 고려했는지 여부
		boolean[] visited = new boolean[V];

		// 어떠한 정점도 고려하지 않았을 때 최단거리는 모두 무한대
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[start] = 0;
		
		int cnt = 0;//경유지로 고려한 정점의 개수
		while(true) {
			// step 01. 경유지로 고려되지 않은 정점 중 최단거리인 정점 찾기
			// 여기서 찾은 정점은 최소비용이 확정.
			int minDistance = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int v = 0; v < V; v++) {
				if (!visited[v] && minDistance > distance[v]) {
					minDistance = distance[v];
					minVertex = v;
				}
			}
			
			// start에서 더 이상 갈 수 있는 정점이 없음.
			if (minVertex == -1)
				break;
			
			//end 정점까지의 최단거리만 구하면 되는 경우
//			if(minVertex == end) break;
			
			// step 02. 해당 정점을 경유지로 고려할 정점으로 선택
			visited[minVertex] = true;
			cnt++;
			
			//모든 정점을 경유지로 고려했다면 종료
			if(cnt == V) break;
			
			// step 03. minVertex를 경유지로 고려했을 때 최소비용(distance) 갱신
			for (int to = 0; to < V; to++) {
				//최소비용이 확정되지 않았고(방문한적 없음) 이동가능한 정점 중
				if(!visited[to] && adjMatrix[minVertex][to] != 0) {
					//minBertex 정점을 경유하지 않았을 때 to정점으로 가는 최소 비용
					//minBertex를 경유했을 때 to정점으로가는 최소비용 중 작은 값으로 갱신
					
					distance[to] = Math.min(distance[to], distance[minVertex] + adjMatrix[minVertex][to]);
				}
			}
			
		}

	}

}
