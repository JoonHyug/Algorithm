package offline.day230208;

import java.util.Arrays;
import java.util.Scanner;

public class Perm {

	static int N;
	static int[] numbers;
	static int[] result;
	static boolean[] visited;
	public static void main(String[] args) {
		//{1, 2, 3, 4, 5}
		//5개 중 3개를 뽑아서 나열하는 모든 경우의 수 출력
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[] {1, 2, 3, 4, 5};
		result = new int[3];
		visited = new boolean[N];
		test(0);
	}
	
	private static void test(int cnt) {
		if(cnt == 3) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[cnt] = numbers[i];
				test(cnt + 1);
				visited[i] = false;
			}
		}
	}

}
