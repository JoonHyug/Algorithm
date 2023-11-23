package offline.day230209;

import java.util.Arrays;
import java.util.Scanner;

public class Training {

	static int N; // 전체 요소 개수
	static int R; // 뽑을 요소 개수

	static int[] array; // 전체 요소

	static int[] result;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = i + 1;
		}
		result = new int[R];
		visited = new boolean[N];
		// N개 중 R개를 뽑아 나열하는 모든 경우 출력(순열)
		test1(0);
		System.out.println("=====================================");
		// N개 중 R개를 뽑는 모든 경우 출력(조합)
		test2(0, 0);
	}

	private static void test1(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < array.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[cnt] = array[i];
				test1(cnt + 1);
				visited[i] = false;
			}
		}
	}

	private static void test2(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = start; i < array.length; i++) {
			result[cnt] = array[i];
			test2(cnt + 1, i + 1);
		}
	}

}
