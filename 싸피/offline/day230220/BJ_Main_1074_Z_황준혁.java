package offline.day230220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Main_1074_Z_황준혁 {

	static int r;
	static int c;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		cut(c, r, (int) Math.pow(2, N));
		System.out.println(result);
	}

	private static void cut(int x, int y, int size) {
		int half = size / 2;
		if(size == 1) {
			return;
		}
		//왼쪽 위
		if (0 <= x && x < half && 0 <= y && y < half) {
			cut(x, y, half);
		//오른쪽 위
		} else if (half <= x && x <= size && 0 <= y && y < half) {
			result += ((size * size) / 4) * 1;
			cut(x - half, y, half);
		//왼쪽 아래
		} else if (0 <= x && x < half && half <= y && y < size) {
			result += ((size * size) / 4) * 2;
			cut(x, y - half, half);
		//오른쪽 아래
		} else if (half <= x && x <= size && half <= y && y < size) {
			result += ((size * size) / 4) * 3;
			cut(x - half, y - half, half);
		}
	}

}
