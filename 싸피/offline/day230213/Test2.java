package offline.day230213;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
	
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static int[] value;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		value = new int[N];
		for(int i=0;i<value.length;i++) {
			value[i] = sc.nextInt();
		}
		arr = new int[M];
		visited = new boolean[N];
		test1(0);
		System.out.println("========================");
		test2(0, 0);
		System.out.println("========================");
		test3(0);
	}
	private static void test1(int cnt) {
		if(cnt == M) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[cnt] = (int) Math.pow(value[i], 2);
				test1(cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	private static void test2(int cnt, int start) {
		if(cnt == M) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i=start;i<N;i++) {
			arr[cnt] = (int) Math.pow(value[i], 2);
			test2(cnt + 1, i);
		}
	}
	private static void test3(int cnt) {
		if(cnt == N) {
			for(int i=0;i<visited.length;i++) {
				if(visited[i]) {
					System.out.print((int) Math.pow(value[i], 2) + " ");
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
	

}
