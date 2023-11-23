package offline.day230220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_Main_1992_쿼드트리_황준혁 {

	static int[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < arr.length; i++) {
			String st = br.readLine();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = st.charAt(j) - '0';
			}
		}
		cut(0, 0, N);
		System.out.println(sb.toString());
	}

	private static void cut(int x, int y, int size) {
		int sum = 0;
		for (int i = y, yMax = y + size; i < yMax; i++) {
			for (int j = x, xMax = x + size; j < xMax; j++) {
				sum += arr[i][j];
			}
		}
		// 1로 가득찬 경우
		if (sum == size * size) {
			sb.append(1);
			// 0으로 가득찬 경우
		} else if (sum == 0) {
			sb.append(0);
		} else {
			int half = size / 2;
			sb.append("(");
			cut(x, y, half);
			cut(x + half, y, half);
			cut(x, y + half, half);
			cut(x + half, y + half, half);
			sb.append(")");
		}
	}

}
