package offline.day230210;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	static int N;
	static int[] array;
	static int R;
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = i * i;
		}

		visited = new boolean[N];
		result = new int[R];
		// N개중 R개 뽑아 나열하는 모든 경우의 수 출력(순열)
		test1(0);
		// N개 중 R개 뽑는 모든 경우의 수 출력 (조합)
		System.out.println("=================================");
		test2(0, 0);
		// N개의 요소로 만들 수 있는 모든 부분집합 출력(부분 집합)
		System.out.println("=================================");
		visited = new boolean[N];
		test3(0);
//		for(int i=0;i<N;i++) {
//			test3(0, 0, i);
//		}
	}

	private static void test1(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < N; i++) {
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
		for (int i = start; i < N; i++) {
			result[cnt] = array[i];
			test2(cnt + 1, i + 1);
		}
	}

	private static void test3(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					System.out.print(array[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		visited[cnt] = true;
		test3(cnt + 1);
		visited[cnt] = false;
		test3(cnt + 1);

	}

//	private static void test3(int cnt, int start, int end) {
//		if (cnt == end) {
//			System.out.println(Arrays.toString(result));
//			return;
//		}
//		for (int i = start; i < N; i++) {
//			result[cnt] = array[i];
//			test3(cnt + 1, i + 1, end);
//		}
//	}

}
