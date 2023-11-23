/**
 * 1. 가장 높은 봉우리에서 시작
 * 2. 반드시 높은 지형에서 낮은 지형으로 가로 or 세로로 연결
 * 	-> 높이가 같은 곳 혹은 낮은 지형 X
 * 	-> 대각선 X(4방 탐색)
 * 3. 등산로 중 딱 한곳을 최대 K 깊이만큼 깎을 수 있음
 * 4. 필요한 경우 지형을 깎아 높이를 1보다 작게 만드는 것도 가능
 * 5. 가장 높은 봉우리는 최대 5개
 * 
 * 한번에 낮아지는 높이는 신경 쓸 필요 없음
 * 	-> 무조건 낮아지기만 하면 됨
 * 
 * 길 탐색
 *  -> bfs?
 *  	-> bfs를 단계별로 1씩 더해줘서 배열 전체에서 가장 큰 값을 출력하면 가장 긴 길이
 *  
 *  bfs를 돌다가 아래 조건에 만족하는 경우 다른 탐색 방법을 사용?
 * 
 * K만큼 낮아지는 경우를 탐색하는 방법
 *  -> 사방탐색을 하다가 같은 높이 이거나 높이-K가 현재 높이보다 낮을 경우
 *  	-> K만큼 빼고 끝까지 진행 해보고 총 길이를 구하고 길 경우 갱신?(백트래킹?)
 *  
 *  bfs가 아니라 dfs를 이용한 경로탐색을 하는데 1번 높이를 낮출 수 있다는 것을 이용하여 조건을 하나 더 만들어
 *  깎고 진행한 경우와 그대로 진행하다가 깎는경우 와 같이 모든 경우를 탐색하고 그 중에서 가장 긴 길이를 출력하면 된다.
 */
package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1949_등산로조정 {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;
	static int N;
	static int K;
	static int[][] map;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			List<int[]> high = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			max = 0;
			int h = 0;
			map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					h = Math.max(h, map[i][j]);
				}
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == h) {
						high.add(new int[] { j, i });
					}
				}
			}
			visited = new boolean[N][N];
			for (int i = 0; i < high.size(); i++) {
//				System.out.println(i+1+"번째");
				int x = high.get(i)[0];
				int y = high.get(i)[1];
				//시작 지점을 방문처리 하지 않으면 Fig. 2 를 예로보면 9 -> 8 -> 4 -> 3 -> 1이 아닌
				//만약 9 -> 8 -> 1 -> 7(배열에 보이는 위치)의 순서로 값이 이동한다면 출발점이 방문처리가 되어있지 않을경우 
				//시작지점의 땅을 깎고 지나갈 수 있기 때문에 방문처리를 해줘야 한다.
				visited[y][x] = true;
				dfs(x, y, false, 1);
				visited[y][x] = false;
			}
			sb.append("#" + tc + " ");
			sb.append(max);
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void dfs(int x, int y, boolean flag, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[ny][nx]) {
				visited[ny][nx] = true;
				if(map[y][x] > map[ny][nx]) {
//					System.out.println(map[y][x]+", "+map[ny][nx]);
//					System.out.println(flag+" : "+cnt);
					dfs(nx, ny, flag, cnt + 1);
					
				} else if (!flag && map[y][x] > map[ny][nx] - K) {
//					System.out.println("감소");
//					System.out.println(map[y][x]+", "+(map[ny][nx] - K));
					//최대로 깎을 수 있을 만큼 제거하는 것이 아닌 최소인 1로 깎아야 한다.
					//이 처리를 해주지 않으면 그림의 예와 같이 제일 오른쪽 9에서 출발했는데 바로 왼쪽 9가 8로 바뀌어야지 그 왼쪽인 8로 이동하지 않는데 -1해주지 않으면 자기자신(9)보다 작기 때문에 원래라면 탐색하면 안되는 구간을 탐색하게 된다.
					//이동이 가능하다면 현재 위치보다 1만 낮아져도 이동이 가능해지는 거라 다음 칸이 몇이던지 이동이 가능하다.
					//그 다음칸에서 탐색을 할 때도 그 다음칸 기준 -1은 이전칸과 값이 같아질 수 있으므로 현재 칸의 값을 기준으로 해야한다.
					//애초에 K만큼 뺀 값보다 작으면 이동하기 때문에 현재 값을 기준으로 -1을 해도 똑같다.
					int temp = map[ny][nx];
					map[ny][nx] = map[y][x] - 1;
					dfs(nx, ny, true, cnt + 1);
					map[ny][nx] = temp;
				}
				visited[ny][nx] = false;
			}
		}
		max = Math.max(max, cnt);
//		System.out.println("=======================");
	}

}