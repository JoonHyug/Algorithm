package offline.day230215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방_황준혁 {

	static int N;
	static int[][] arr;
	static int max;
	static PriorityQueue<int[]> value;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=T;tc++) {
			value = new PriorityQueue<int[]>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0] == o2[0]) return o1[1] - o2[1];
					return o2[0] - o1[0];
				}
				
			});
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i=0;i<arr.length;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<arr.length;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[i].length;j++) {
					bfs(i, j);
				}
			}
			int result = Integer.MAX_VALUE;
//			for(int[] i : value) {
//				System.out.println(i[0] +", "+i[1]);
////				result = Math.min(result, i);
//			}
//			System.out.println(value.peek()[1]+", "+value.peek()[0]);
			System.out.printf("#%d %d %d\n", tc, value.peek()[1], value.peek()[0]);
		}
	}
	
	private static void bfs(int x, int y) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> arr[o1[0]][o1[1]] - arr[o2[0]][o2[1]]);
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		boolean[][] visited = new boolean[N][N];
		
		pq.add(new int[] {x, y});
		int cnt = 0;
		while(!pq.isEmpty()) {
			int[] position = pq.poll();
			for(int i=0;i<4;i++) {
				int nx = dx[i] + position[0];
				int ny = dy[i] + position[1];
				if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
					if(arr[nx][ny] == arr[position[0]][position[1]] + 1) {
						visited[nx][ny] = true;
						pq.add(new int[] {nx, ny});						
					}
				}
			}
			cnt++;
//			if(cnt >= max) {
//				max = cnt;				
//				System.out.println(arr[x][y]+" : "+cnt);
//			}
		}
		if(cnt >= max) {
			max = cnt;
			value.add(new int[] {max, arr[x][y]});
//				System.out.println(value);
			
		}
		
	}

}
