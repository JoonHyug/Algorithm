package offline.day230214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Main_16926_배열돌리기1_황준혁 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] temp = new int[N][M];
		for (int y = 0; y < temp.length; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < temp[y].length; x++) {
				temp[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] result = new int[N][M];
		for (int c = 0; c < R; c++) {
			for (int a = 0; a < Math.min(N, M) / 2; a++) {
				//왼쪽
				for (int i = a; i < N - 1-a; i++) {
					result[i + 1][a] = temp[i][a];
				}
				//아래
				for (int i = a; i < M - 1-a; i++) {
					result[N - 1 - a][i + 1] = temp[N - 1 - a][i];
				}
				//오른쪽
				for (int i = 1+a; i < N-a; i++) {
					result[i - 1][M - 1 - a] = temp[i][M - 1 - a];
				}
				//위
				for (int i = 1+a; i < M-a; i++) {
					result[a][i - 1] = temp[a][i];
				}
			}
			for (int y = 0; y < result.length; y++) {
				for (int x = 0; x < result[y].length; x++) {
					temp[y][x] = result[y][x];
				}
			}
		}
		for (int y = 0; y < result.length; y++) {
			for (int x = 0; x < result[y].length; x++) {
				sb.append(result[y][x]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
