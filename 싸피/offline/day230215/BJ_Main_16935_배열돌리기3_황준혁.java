package offline.day230215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Main_16935_배열돌리기3_황준혁 {

	static int N; // 세로
	static int M; // 가로
	static int R;
	static int[][] temp;
	static int[] C;
	static int[][] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		temp = new int[N][M];
		result = new int[N][M];
		for (int y = 0; y < temp.length; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < temp[y].length; x++) {
				temp[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		C = new int[R];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C.length; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}

		for (int k = 0; k < C.length; k++) {
			switch (C[k]) {
			case 1:
				case1();
				break;
			case 2:
				case2();
				break;
			case 3:
				case3();
				break;
			case 4:
				case4();
				break;
			case 5:
				case5();
				break;
			case 6:
				case6();
				break;
			}
			temp = result.clone();
			result = new int[N][M];
//            for(int i=0;i<result.length;i++) {
//            	for(int j=0;j<result[i].length;j++) {
//            		System.out.print(result[i][j]+" ");
//            	}
//            	System.out.println();
//            }
//            System.out.println("=====================");
		}
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				sb.append(temp[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	// 상하 반전
	private static void case1() {
		for (int y = 0; y < temp.length; y++) {
			for (int x = 0; x < temp[y].length; x++) {
				int value = result[N - 1 - y][x];
				result[N - 1 - y][x] = temp[y][x];
				temp[y][x] = value;
			}
		}

	}

	// 좌우 반전
	private static void case2() {
		for (int y = 0; y < temp.length; y++) {
			for (int x = 0; x < temp[y].length; x++) {
				int value = result[y][M - 1 - x];
				result[y][M - 1 - x] = temp[y][x];
				temp[y][x] = value;
			}
		}
	}

	private static int[][] swap() {
		N = result[0].length;
		M = result.length;
		return new int[N][M];
	}

	// 오른쪽 90도 회전
	private static void case3() {
		result = swap();
		for (int a = 0; a < Math.min(N, M) / 2; a++) {
			// 상단 -> 오른쪽
			for (int x = a; x < N - 1 - a; x++) {
				result[x][M - 1 - a] = temp[a][x];
			}
			// 오른쪽 -> 하단
			for (int y = a; y < M - 1 - a; y++) {
				result[N - 1 - a][M - 1 - y] = temp[y][N - 1 - a];
			}
			// 하단 -> 왼쪽
			for (int x = a; x < N - 1 - a; x++) {
				result[x + 1][a] = temp[M - 1 - a][x + 1];
			}
			// 왼쪽 -> 상단
			for (int y = a; y < M - 1 - a; y++) {
				result[a][M - 1 - y - 1] = temp[y + 1][a];
			}
		}
	}

	// 왼쪽 90도 회전
	private static void case4() {
		result = swap();
		for (int a = 0; a < Math.min(N, M) / 2; a++) {
			// 상단 -> 왼쪽
			for (int x = a; x < N - 1 - a; x++) {
				result[N - 1 - x][a] = temp[a][x];
			}
			// 왼쪽 -> 하단
			for (int y = 1 + a; y < M - 1 - a; y++) {
				result[N - 1 - a][y] = temp[y][a];
			}
			// 하단 -> 오른쪽
			for (int x = a; x < N - a; x++) {
				result[N - 1 - x][M - 1 - a] = temp[M - 1 - a][x];
			}
			// 오른쪽 -> 상단
			for (int y = a; y < M - 1 - a; y++) {
				result[a][y] = temp[y][N - 1 - a];
			}
		}

	}

	// 1 2
	// 4 3
	// 4등분 후 1->2, 2->3, 3->4, 4->1
	// (0 ~ N/2, 0 ~ M/2), (N/2 ~ N, 0 ~ M/2)
	// (0 ~ N/2, M/2 ~ M), (N/2 ~ N, M/2 ~ M)
	private static void case5() {
//        int[][] p1 = new int[N/2][M/2];
//        int[][] p2 = new int[N/2][M/2];
//        int[][] p3 = new int[N/2][M/2];
//        int[][] p4 = new int[N/2][M/2];
		// 1 -> 2
		for (int y = 0; y < N / 2; y++) {
			for (int x = 0; x < M / 2; x++) {
				result[y][x + M / 2] = temp[y][x];
			}
		}
		// 2 -> 3
		for (int y = 0; y < N / 2; y++) {
			for (int x = M / 2; x < M; x++) {
				result[y + N / 2][x] = temp[y][x];
			}
		}
		// 3 -> 4
		for (int y = N / 2; y < N; y++) {
			for (int x = M / 2; x < M; x++) {
				result[y][x - M / 2] = temp[y][x];
			}
		}
		// 4 -> 1
		for (int y = N / 2; y < N; y++) {
			for (int x = 0; x < M / 2; x++) {
				result[y - N / 2][x] = temp[y][x];
			}
		}
	}

	// 4등분 후 1->4, 4->3, 3->2, 2->1
	private static void case6() {
		// 1 -> 4
		for (int y = 0; y < N / 2; y++) {
			for (int x = 0; x < M / 2; x++) {
				result[y + N / 2][x] = temp[y][x];
			}
		}
		// 4 -> 3
		for (int y = N / 2; y < N; y++) {
			for (int x = 0; x < M / 2; x++) {
				result[y][x + M / 2] = temp[y][x];
			}
		}
		// 3 -> 2
		for (int y = N / 2; y < N; y++) {
			for (int x = M / 2; x < M; x++) {
				result[y - N / 2][x] = temp[y][x];
			}
		}
		// 2 -> 1
		for (int y = 0; y < N / 2; y++) {
			for (int x = M / 2; x < M; x++) {
				result[y][x - M / 2] = temp[y][x];
			}
		}
	}
}
