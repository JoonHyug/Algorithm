package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p17406 {
	
	static boolean[] visited;
	static List<int[]> order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int y = 0; y < arr.length; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < arr[y].length; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] rcs = new int[K][3];
		for (int i = 0; i < rcs.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < rcs[i].length; j++) {
				rcs[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = Integer.MAX_VALUE;

		visited = new boolean[K];
		order = new ArrayList<>();
		dfs(0, K, new int[K]);
		for(int i=0;i<order.size();i++) {
			int a = rotate(arr, rcs, order.get(i), N, M, K);
			result = Math.min(result, a);
		}
		System.out.println(result);

	}
	
	private static void dfs(int cnt, int K, int[] temp) {
		if(cnt == K) {
			order.add(temp.clone());
			return;
		}
		for(int i=0;i<K;i++) {
			if(!visited[i]) {
				visited[i] = true;
				temp[cnt] = i;
				dfs(cnt + 1, K, temp);
				visited[i] = false;
			}
		}
	}

	private static int rotate(int[][] arr, int[][] rcs, int[] order, int N, int M, int K) {
		int[][] temp;
		
		for (int i = 0; i < order.length; i++) {
			temp = new int[N][M];
			int idx = order[i];
			int r = rcs[idx][0] - 1; // y
			int c = rcs[idx][1] - 1; // x
			int s = rcs[idx][2]; // 범위
			for (int j = 1; j <= s; j++) {
//				if(j == 0) {
//					temp[r][c] = arr[r][c];
//					continue;
//				}
				if (0 <= r - j && r + j < N && 0 <= c - j && c + j < M) {
					// 좌
					for (int y = r - j; y < r + j; y++) {
						temp[y][c - j] = arr[y + 1][c - j];
					}
					// 상
					for (int x = c - j; x < c + j; x++) {
						temp[r - j][x + 1] = arr[r - j][x];
					}
					// 우
					for (int y = r - j; y < r + j; y++) {
						temp[y + 1][c + j] = arr[y][c + j];
					}
					// 하
					for (int x = c - j; x < c + j; x++) {
						temp[r + j][x] = arr[r + j][x + 1];
					}
				}
				
			}
			for(int y=0;y<temp.length;y++) {
				for(int x = 0;x<temp[y].length;x++) {
					if(temp[y][x] == 0) temp[y][x] = arr[y][x];
				}
			}
			arr = temp.clone();
			
//			print(arr);
		}
		return count(arr);
	}
	
	private static int count(int[][] arr) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int y=0;y<arr.length;y++) {
			sum = 0;
			for(int x=0;x<arr[y].length;x++) {
				sum += arr[y][x];
			}
			min = Math.min(min, sum);
//			System.out.println(min);
		}
		return min;
	}
	
	private static void print(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
