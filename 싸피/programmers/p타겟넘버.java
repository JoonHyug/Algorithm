package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class p타겟넘버 {
	
	static int answer;
	static int[] cal = {-1, 1};
	
	public static int solution(int[] numbers, int target) {
		answer = 0;
		dfs(target, numbers, 0, 0, 0);
		return answer;
	}

	private static void dfs(int target, int[] arr, int cnt, int start, int sum) {
		if (cnt == arr.length) {
			if (sum == target) {
				answer++;
			}
			return;
		}
//		for(int i=start; i<arr.length;i++) {
			for(int c : cal) {
				dfs(target, arr, cnt + 1, start + 1, sum + (c * arr[start]));				
			}
//		}
	}

	public static void main(String[] args) {
		int[] num1 = { 1, 1, 1, 1, 1 };
		int[] num2 = {4, 1, 2, 1};
		System.out.println(solution(num1, 3));
		System.out.println("===================");
		System.out.println(solution(num2, 4));
	}

}
